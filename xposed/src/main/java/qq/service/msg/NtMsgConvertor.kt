package qq.service.msg

import android.graphics.BitmapFactory
import androidx.exifinterface.media.ExifInterface
import com.tencent.mobileqq.emoticon.QQSysFaceUtil
import com.tencent.mobileqq.pb.ByteStringMicro
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qphone.base.remote.ToServiceMsg
import com.tencent.qqnt.aio.adapter.api.IAIOPttApi
import com.tencent.qqnt.kernel.nativeinterface.*
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.FaceElement
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement
import com.tencent.qqnt.kernel.nativeinterface.TextElement
import com.tencent.qqnt.msg.api.IMsgService
import io.kritor.common.*
import io.kritor.common.Element.ElementType
import io.kritor.common.ImageElement.ImageType
import io.kritor.common.MusicElement.MusicPlatform
import io.kritor.common.VideoElement
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.config.EnableOldBDH
import moe.fuqiuluo.shamrock.config.get
import moe.fuqiuluo.shamrock.helper.ActionMsgException
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.LogicException
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.utils.AudioUtils
import moe.fuqiuluo.shamrock.utils.DownloadUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MediaType
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import mqq.app.MobileQQ
import qq.service.QQInterfaces.Companion.app
import qq.service.bdh.FileTransfer
import qq.service.bdh.PictureResource
import qq.service.bdh.Private
import qq.service.bdh.Transfer
import qq.service.bdh.Troop
import qq.service.bdh.VideoResource
import qq.service.bdh.VoiceResource
import qq.service.bdh.trans
import qq.service.bdh.with
import qq.service.contact.ContactHelper
import qq.service.contact.longPeer
import qq.service.group.GroupHelper
import qq.service.internals.NTServiceFetcher
import qq.service.internals.msgService
import qq.service.lightapp.ArkAppInfo
import qq.service.lightapp.ArkMsgHelper
import qq.service.lightapp.LbsHelper
import qq.service.lightapp.MusicHelper
import qq.service.lightapp.WeatherHelper
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2
import tencent.im.oidb.oidb_sso
import java.io.ByteArrayInputStream
import java.io.File
import kotlin.coroutines.resume
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * 将请求消息（io.kritor.message）转成NT消息（com.tencent.qqnt.*）发送
 */


typealias Messages = Collection<Element>
private typealias NtConvertor = suspend (Contact, Long, Element) -> Result<MsgElement>

object NtMsgConvertor {
    private val ntConvertors = mapOf<ElementType, NtConvertor>(
        ElementType.TEXT to ::textConvertor,
        ElementType.AT to ::atConvertor,
        ElementType.FACE to ::faceConvertor,
        ElementType.BUBBLE_FACE to ::bubbleFaceConvertor,
        ElementType.REPLY to ::replyConvertor,
        ElementType.IMAGE to ::imageConvertor,
        ElementType.VOICE to ::voiceConvertor,
        ElementType.VIDEO to ::videoConvertor,
        ElementType.BASKETBALL to ::basketballConvertor,
        ElementType.DICE to ::diceConvertor,
        ElementType.RPS to ::rpsConvertor,
        ElementType.POKE to ::pokeConvertor,
        ElementType.MUSIC to ::musicConvertor,
        ElementType.WEATHER to ::weatherConvertor,
        ElementType.LOCATION to ::locationConvertor,
        ElementType.SHARE to ::shareConvertor,
        ElementType.CONTACT to ::contactConvertor,
        ElementType.JSON to ::jsonConvertor,
        ElementType.FORWARD to ::forwardConvertor,
        ElementType.MARKDOWN to ::markdownConvertor,
        ElementType.KEYBOARD to ::buttonConvertor,
    )

    suspend fun convertToNtMsgs(contact: Contact, msgId: Long, msgs: Messages): ArrayList<MsgElement> {
        val ntMsgs = ArrayList<MsgElement>()
        msgs.forEach {
            val convertor = ntConvertors[it.type]
            if (convertor == null) {
                LogCenter.log("未知的消息类型: ${it.type}", Level.WARN)
            } else {
                try {
                    ntMsgs.add(convertor(contact, msgId, it).getOrThrow())
                } catch (e: Throwable) {
                    if (e !is ActionMsgException) {
                        LogCenter.log("消息转换失败: ${it.type}", Level.WARN)
                    }
                }
            }
        }
        return ntMsgs
    }

    private suspend fun textConvertor(contact: Contact, msgId: Long, text: Element): Result<MsgElement> {
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPETEXT
        elem.textElement = TextElement()
        elem.textElement.content = text.text.text
        return Result.success(elem)
    }

    private suspend fun atConvertor(contact: Contact, msgId: Long, sourceAt: Element): Result<MsgElement> {
        if (contact.chatType != MsgConstant.KCHATTYPEGROUP) {
            LogCenter.log("暂不支持非群聊的@元素", Level.WARN)
            return Result.failure(ActionMsgException)
        }

        val elem = MsgElement()
        val at = TextElement()
        val uid = sourceAt.at.uid
        if (uid == "all" || uid == "0") {
            at.content = "@全体成员"
            at.atType = MsgConstant.ATTYPEALL
            at.atNtUid = "0"
        } else {
            val uin = ContactHelper.getUinByUidAsync(uid)
            val info = GroupHelper.getTroopMemberInfoByUinV2(contact.peerUid, uin, true).onFailure {
                LogCenter.log("无法获取群成员信息: contact=$contact, id=${uin}", Level.WARN)
            }.getOrNull()
            at.content = "@${
                info?.troopnick.ifNullOrEmpty { info?.friendnick }
                    ?: uin
            }"
            at.atType = MsgConstant.ATTYPEONE
            at.atNtUid = uid
        }
        elem.textElement = at
        elem.elementType = MsgConstant.KELEMTYPETEXT
        return Result.success(elem)
    }

    private suspend fun faceConvertor(contact: Contact, msgId: Long, sourceFace: Element): Result<MsgElement> {
        val serverId = sourceFace.face.id
        val big = sourceFace.face.isBig || serverId == 394

        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEFACE
        val face = FaceElement()

        // 1 old face
        // 2 normal face
        // 3 super face
        // 4 is market face
        // 5 is vas poke
        face.faceType = if (big) 3 else 2
        face.faceIndex = serverId
        face.faceText = QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(serverId))
        if (serverId == 394) {
            face.stickerId = "40"
            face.packId = "1"
            face.sourceType = 1
            face.stickerType = 3
            face.randomType = 1
            face.resultId = Random.nextInt(1..5).toString()
        } else if (big) {
            face.imageType = 0
            face.stickerId = "30"
            face.packId = "1"
            face.sourceType = 1
            face.stickerType = 1
            face.randomType = 1
        } else {
            face.imageType = 0
            face.packId = "0"
        }
        elem.faceElement = face

        return Result.success(elem)
    }

    private suspend fun bubbleFaceConvertor(
        contact: Contact,
        msgId: Long,
        sourceBubbleFace: Element
    ): Result<MsgElement> {
        val faceId = sourceBubbleFace.bubbleFace.id
        val local = QQSysFaceUtil.convertToLocal(faceId)
        val name = QQSysFaceUtil.getFaceDescription(local)
        val count = sourceBubbleFace.bubbleFace.count
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEFACEBUBBLE
        val face = FaceBubbleElement()
        face.faceType = 13
        face.faceCount = count
        face.faceSummary = QQSysFaceUtil.getPrueFaceDescription(name)
        val smallYellowFaceInfo = SmallYellowFaceInfo()
        smallYellowFaceInfo.index = faceId
        smallYellowFaceInfo.compatibleText = face.faceSummary
        smallYellowFaceInfo.text = face.faceSummary
        face.yellowFaceInfo = smallYellowFaceInfo
        face.faceFlag = 0
        face.content = "[${face.faceSummary}]x$count"
        elem.faceBubbleElement = face
        return Result.success(elem)
    }

    private suspend fun replyConvertor(contact: Contact, msgId: Long, sourceReply: Element): Result<MsgElement> {
        val element = MsgElement()
        element.elementType = MsgConstant.KELEMTYPEREPLY
        val reply = ReplyElement()

        reply.replayMsgId = sourceReply.reply.messageId.toLong()
        reply.sourceMsgIdInRecords = reply.replayMsgId

        if (reply.replayMsgId == 0L) {
            LogCenter.log("无法获取被回复消息", Level.ERROR)
        }

        withTimeoutOrNull(3000) {
            suspendCancellableCoroutine {
                QRoute.api(IMsgService::class.java)
                    .getMsgsByMsgId(contact, arrayListOf(reply.replayMsgId)) { _, _, records ->
                        it.resume(records)
                    }
            }
        }?.firstOrNull()?.let {
            reply.replayMsgSeq = it.msgSeq
            //reply.sourceMsgText = it.elements.firstOrNull { it.elementType == MsgConstant.KELEMTYPETEXT }?.textElement?.content
            reply.replyMsgTime = it.msgTime
            reply.senderUidStr = it.senderUid
            reply.senderUid = it.senderUin
        }

        element.replyElement = reply
        return Result.success(element)
    }

    private suspend fun imageConvertor(contact: Contact, msgId: Long, sourceImage: Element): Result<MsgElement> {
        val isOriginal = sourceImage.image.fileType == ImageType.ORIGIN
        val isFlash = sourceImage.image.fileType == ImageType.FLASH
        val file = when (sourceImage.image.dataCase!!) {
            ImageElement.DataCase.FILE_NAME -> {
                val fileMd5 = sourceImage.image.fileName.replace(regex = "[{}\\-]".toRegex(), replacement = "")
                    .split(".")[0].lowercase()
                FileUtils.getFileByMd5(fileMd5)
            }

            ImageElement.DataCase.FILE_PATH -> {
                val filePath = sourceImage.image.filePath
                File(filePath).inputStream().use {
                    FileUtils.saveFileToCache(it)
                }
            }

            ImageElement.DataCase.FILE -> {
                FileUtils.saveFileToCache(
                    ByteArrayInputStream(
                        sourceImage.image.file.toByteArray()
                    )
                )
            }

            ImageElement.DataCase.FILE_URL -> {
                val tmp = FileUtils.getTmpFile()
                if (DownloadUtils.download(sourceImage.image.fileUrl, tmp)) {
                    tmp.inputStream().use {
                        FileUtils.saveFileToCache(it)
                    }.also {
                        tmp.delete()
                    }
                } else {
                    tmp.delete()
                    return Result.failure(LogicException("图片资源下载失败: ${sourceImage.image.fileUrl}"))
                }
            }

            ImageElement.DataCase.DATA_NOT_SET -> return Result.failure(IllegalArgumentException("ImageElement data is not set"))
        }

        if (EnableOldBDH.get()) {
            Transfer with when (contact.chatType) {
                MsgConstant.KCHATTYPEGROUP -> Troop(contact.peerUid)
                MsgConstant.KCHATTYPETEMPC2CFROMGROUP, MsgConstant.KCHATTYPEC2C -> Private(
                    contact.longPeer().toString()
                )

                MsgConstant.KCHATTYPEGUILD -> Troop(contact.peerUid)
                else -> return Result.failure(Exception("Not supported chatType(${contact.chatType}) for PictureMsg"))
            } trans PictureResource(file)
        }

        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEPIC
        val pic = PicElement()
        pic.md5HexStr = QQNTWrapperUtil.CppProxy.genFileMd5Hex(file.absolutePath)

        val msgService = NTServiceFetcher.kernelService.msgService!!
        val originalPath = msgService.getRichMediaFilePathForMobileQQSend(
            RichMediaFilePathInfo(
                2, 0, pic.md5HexStr, file.name, 1, 0, null, "", true
            )
        )
        if (!QQNTWrapperUtil.CppProxy.fileIsExist(originalPath) || QQNTWrapperUtil.CppProxy.getFileSize(originalPath) != file.length()) {
            val thumbPath = msgService.getRichMediaFilePathForMobileQQSend(
                RichMediaFilePathInfo(
                    2, 0, pic.md5HexStr, file.name, 2, 720, null, "", true
                )
            )
            QQNTWrapperUtil.CppProxy.copyFile(file.absolutePath, originalPath)
            QQNTWrapperUtil.CppProxy.copyFile(file.absolutePath, thumbPath)
        }

        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(file.absolutePath, options)
        val exifInterface = ExifInterface(file.absolutePath)
        val orientation = exifInterface.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_UNDEFINED
        )
        if (orientation != ExifInterface.ORIENTATION_ROTATE_90 && orientation != ExifInterface.ORIENTATION_ROTATE_270) {
            pic.picWidth = options.outWidth
            pic.picHeight = options.outHeight
        } else {
            pic.picWidth = options.outHeight
            pic.picHeight = options.outWidth
        }
        pic.sourcePath = file.absolutePath
        pic.fileSize = QQNTWrapperUtil.CppProxy.getFileSize(file.absolutePath)
        pic.original = isOriginal
        pic.picType = FileUtils.getPicType(file)
        pic.picSubType = 0
        pic.isFlashPic = isFlash

        elem.picElement = pic

        return Result.success(elem)
    }

    private suspend fun voiceConvertor(contact: Contact, msgId: Long, sourceVoice: Element): Result<MsgElement> {
        var file = when (sourceVoice.voice.dataCase!!) {
            VoiceElement.DataCase.FILE_NAME -> {
                val fileMd5 = sourceVoice.voice.fileName.replace(regex = "[{}\\-]".toRegex(), replacement = "")
                    .split(".")[0].lowercase()
                FileUtils.getFileByMd5(fileMd5)
            }

            VoiceElement.DataCase.FILE_PATH -> {
                val filePath = sourceVoice.voice.filePath
                File(filePath).inputStream().use {
                    FileUtils.saveFileToCache(it)
                }
            }

            VoiceElement.DataCase.FILE -> {
                FileUtils.saveFileToCache(
                    sourceVoice.voice.file.toByteArray().inputStream()
                )
            }

            VoiceElement.DataCase.FILE_URL -> {
                val tmp = FileUtils.getTmpFile()
                if (DownloadUtils.download(sourceVoice.voice.fileUrl, tmp)) {
                    tmp.inputStream().use {
                        FileUtils.saveFileToCache(it)
                    }.also {
                        tmp.delete()
                    }
                } else {
                    tmp.delete()
                    return Result.failure(LogicException("音频资源下载失败: ${sourceVoice.voice.fileUrl}"))
                }
            }

            VoiceElement.DataCase.DATA_NOT_SET -> return Result.failure(IllegalArgumentException("VoiceElement data is not set"))
        }

        val isMagic = sourceVoice.voice.magic

        val ptt = PttElement()

        when (AudioUtils.getMediaType(file)) {
            MediaType.Silk -> {
                LogCenter.log({ "Silk: $file" }, Level.DEBUG)
                ptt.formatType = MsgConstant.KPTTFORMATTYPESILK
                ptt.duration = QRoute.api(IAIOPttApi::class.java)
                    .getPttFileDuration(file.absolutePath)
            }

            MediaType.Amr -> {
                LogCenter.log({ "Amr: $file" }, Level.DEBUG)
                ptt.duration = AudioUtils.getDurationSec(file)
                ptt.formatType = MsgConstant.KPTTFORMATTYPEAMR
            }

            MediaType.Pcm -> {
                LogCenter.log({ "Pcm To Silk: $file" }, Level.DEBUG)
                val result = AudioUtils.pcmToSilk(file)
                ptt.duration = (result.second * 0.001).roundToInt()
                file = result.first
                ptt.formatType = MsgConstant.KPTTFORMATTYPESILK
            }

            else -> {
                LogCenter.log({ "Audio To SILK: $file" }, Level.DEBUG)
                val result = AudioUtils.audioToSilk(file)
                ptt.duration = runCatching {
                    QRoute.api(IAIOPttApi::class.java)
                        .getPttFileDuration(result.second.absolutePath)
                }.getOrElse {
                    result.first
                }
                file = result.second
                ptt.formatType = MsgConstant.KPTTFORMATTYPESILK
            }
        }

        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEPTT
        ptt.md5HexStr = QQNTWrapperUtil.CppProxy.genFileMd5Hex(file.absolutePath)

        if (EnableOldBDH.get()) {
            if (!(Transfer with when (contact.chatType) {
                    MsgConstant.KCHATTYPEGROUP -> Troop(contact.peerUid)
                    MsgConstant.KCHATTYPETEMPC2CFROMGROUP, MsgConstant.KCHATTYPEC2C -> Private(
                        contact.longPeer().toString()
                    )

                    MsgConstant.KCHATTYPEGUILD -> Troop(contact.peerUid)
                    else -> return Result.failure(Exception("Not supported chatType(${contact.chatType}) for VoiceMsg"))
                } trans VoiceResource(file))
            ) {
                return Result.failure(RuntimeException("上传语音失败: $file"))
            }
            ptt.filePath = file.absolutePath
        } else {
            val msgService = NTServiceFetcher.kernelService.msgService!!

            val originalPath = msgService.getRichMediaFilePathForMobileQQSend(
                RichMediaFilePathInfo(
                    MsgConstant.KELEMTYPEPTT, 0, ptt.md5HexStr, file.name, 1, 0, null, "", true
                )
            )
            if (!QQNTWrapperUtil.CppProxy.fileIsExist(originalPath) || QQNTWrapperUtil.CppProxy.getFileSize(originalPath) != file.length()) {
                QQNTWrapperUtil.CppProxy.copyFile(file.absolutePath, originalPath)
            }
            if (originalPath != null) {
                ptt.filePath = originalPath
            } else {
                ptt.filePath = file.absolutePath
            }
        }

        ptt.canConvert2Text = true
        ptt.fileId = 0
        ptt.fileUuid = ""
        ptt.text = ""

        if (!isMagic) {
            ptt.voiceType = MsgConstant.KPTTVOICETYPESOUNDRECORD
            ptt.voiceChangeType = MsgConstant.KPTTVOICECHANGETYPENONE
        } else {
            ptt.voiceType = MsgConstant.KPTTVOICETYPEVOICECHANGE
            ptt.voiceChangeType = MsgConstant.KPTTVOICECHANGETYPEECHO
        }

        elem.pttElement = ptt

        return Result.success(elem)
    }

    private suspend fun videoConvertor(contact: Contact, msgId: Long, sourceVideo: Element): Result<MsgElement> {
        val elem = MsgElement()
        val video = com.tencent.qqnt.kernel.nativeinterface.VideoElement()

        val file = when (sourceVideo.video.dataCase!!) {
            VideoElement.DataCase.FILE -> {
                FileUtils.saveFileToCache(
                    sourceVideo.video.file.toByteArray().inputStream()
                )
            }

            VideoElement.DataCase.FILE_NAME -> {
                val fileMd5 = sourceVideo.video.fileName.replace(regex = "[{}\\-]".toRegex(), replacement = "")
                    .split(".")[0].lowercase()
                FileUtils.getFileByMd5(fileMd5)
            }

            VideoElement.DataCase.FILE_PATH -> {
                val filePath = sourceVideo.video.filePath
                File(filePath).inputStream().use {
                    FileUtils.saveFileToCache(it)
                }
            }

            VideoElement.DataCase.FILE_URL -> {
                val tmp = FileUtils.getTmpFile()
                if (DownloadUtils.download(sourceVideo.video.fileUrl, tmp)) {
                    tmp.inputStream().use {
                        FileUtils.saveFileToCache(it)
                    }.also {
                        tmp.delete()
                    }
                } else {
                    tmp.delete()
                    return Result.failure(LogicException("视频资源下载失败: ${sourceVideo.video.fileUrl}"))
                }
            }

            VideoElement.DataCase.DATA_NOT_SET -> return Result.failure(IllegalArgumentException("VideoElement data is not set"))
        }

        video.videoMd5 = QQNTWrapperUtil.CppProxy.genFileMd5Hex(file.absolutePath)

        val msgService = NTServiceFetcher.kernelService.msgService!!
        val originalPath = msgService.getRichMediaFilePathForMobileQQSend(
            RichMediaFilePathInfo(
                5, 2, video.videoMd5, file.name, 1, 0, null, "", true
            )
        )
        val thumbPath = msgService.getRichMediaFilePathForMobileQQSend(
            RichMediaFilePathInfo(
                5, 1, video.videoMd5, file.name, 2, 0, null, "", true
            )
        )
        if (!QQNTWrapperUtil.CppProxy.fileIsExist(originalPath) || QQNTWrapperUtil.CppProxy.getFileSize(
                originalPath
            ) != file.length()
        ) {
            QQNTWrapperUtil.CppProxy.copyFile(file.absolutePath, originalPath)
            AudioUtils.obtainVideoCover(file.absolutePath, thumbPath!!)
        }

        if (EnableOldBDH.get()) {
            Transfer with when (contact.chatType) {
                MsgConstant.KCHATTYPEGROUP -> Troop(contact.peerUid)
                MsgConstant.KCHATTYPETEMPC2CFROMGROUP, MsgConstant.KCHATTYPEC2C -> Private(
                    contact.longPeer().toString()
                )

                MsgConstant.KCHATTYPEGUILD -> Troop(contact.peerUid)
                else -> return Result.failure(Exception("Not supported chatType(${contact.chatType}) for VideoMsg"))
            } trans VideoResource(file, File(thumbPath.toString()))
        }

        video.fileTime = AudioUtils.getVideoTime(file)
        video.fileSize = file.length()
        video.fileName = file.name
        video.fileFormat = FileTransfer.VIDEO_FORMAT_MP4
        video.thumbSize = QQNTWrapperUtil.CppProxy.getFileSize(thumbPath).toInt()
        val options = BitmapFactory.Options()
        BitmapFactory.decodeFile(thumbPath, options)
        video.thumbWidth = options.outWidth
        video.thumbHeight = options.outHeight
        video.thumbMd5 = QQNTWrapperUtil.CppProxy.genFileMd5Hex(thumbPath)
        video.thumbPath = hashMapOf(0 to thumbPath)

        elem.videoElement = video
        elem.elementType = MsgConstant.KELEMTYPEVIDEO

        return Result.success(elem)
    }

    private suspend fun basketballConvertor(
        contact: Contact,
        msgId: Long,
        sourceBasketball: Element
    ): Result<MsgElement> {
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEFACE
        val face = FaceElement()
        face.faceIndex = 114
        face.faceText = "/篮球"
        face.faceType = 3
        face.packId = "1"
        face.stickerId = "13"
        face.sourceType = 1
        face.stickerType = 2
        face.resultId = Random.nextInt(1..5).toString()
        face.surpriseId = ""
        face.randomType = 1
        elem.faceElement = face
        return Result.success(elem)
    }

    private suspend fun diceConvertor(contact: Contact, msgId: Long, sourceDice: Element): Result<MsgElement> {
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEMARKETFACE
        val market = MarketFaceElement(
            6, 1, 11464, 3, 0, 200, 200,
            "[骰子]", "4823d3adb15df08014ce5d6796b76ee1", "409e2a69b16918f9",
            null, null, 0, 0, 0, 1, 0,
            null, null, null, // jumpurl
            "", null, null,
            null, null, arrayListOf(MarketFaceSupportSize(200, 200)), null
        )
        elem.marketFaceElement = market
        return Result.success(elem)
    }

    private suspend fun rpsConvertor(contact: Contact, msgId: Long, sourceRps: Element): Result<MsgElement> {
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEMARKETFACE
        val market = MarketFaceElement(
            6, 1, 11415, 3, 0, 200, 200,
            "[猜拳]", "83C8A293AE65CA140F348120A77448EE", "7de39febcf45e6db",
            null, null, 0, 0, 0, 1, 0,
            null, null, null,
            "", null, null,
            null, null, arrayListOf(MarketFaceSupportSize(200, 200)), null
        )
        elem.marketFaceElement = market
        return Result.success(elem)
    }

    private suspend fun pokeConvertor(contact: Contact, msgId: Long, sourcePoke: Element): Result<MsgElement> {
        val elem = MsgElement()
        val face = FaceElement()
        face.faceIndex = 0
        face.faceText = ""
        face.faceType = 5
        face.packId = null
        face.pokeType = sourcePoke.poke.pokeType
        face.spokeSummary = ""
        face.doubleHit = 0
        face.vaspokeId = sourcePoke.poke.id
        face.vaspokeName = ""
        face.vaspokeMinver = ""
        face.pokeStrength = sourcePoke.poke.strength
        face.msgType = 0
        face.faceBubbleCount = 0
        face.oldVersionStr = "[截一戳]请使用最新版手机QQ体验新功能。"
        face.pokeFlag = 0
        elem.elementType = MsgConstant.KELEMTYPEFACE
        elem.faceElement = face
        return Result.success(elem)
    }

    private suspend fun musicConvertor(contact: Contact, msgId: Long, sourceMusic: Element): Result<MsgElement> {
        when (val type = sourceMusic.music.platform) {
            MusicPlatform.QQ -> {
                val id = sourceMusic.music.id
                if (!MusicHelper.tryShareQQMusicById(contact, msgId, id)) {
                    LogCenter.log("无法发送QQ音乐分享", Level.ERROR)
                }
            }

            MusicPlatform.NETEASE -> {
                val id = sourceMusic.music.id
                if (!MusicHelper.tryShare163MusicById(contact, msgId, id)) {
                    LogCenter.log("无法发送网易云音乐分享", Level.ERROR)
                }
            }

            MusicPlatform.CUSTOM -> {
                val data = sourceMusic.music.custom
                ArkMsgHelper.tryShareMusic(
                    contact,
                    msgId,
                    ArkAppInfo.QQMusic,
                    data.title,
                    data.author,
                    data.url,
                    data.pic,
                    data.audio
                )
            }

            else -> LogCenter.log("不支持的音乐分享类型: $type", Level.ERROR)
        }

        return Result.failure(ActionMsgException)
    }

    private suspend fun weatherConvertor(contact: Contact, msgId: Long, sourceWeather: Element): Result<MsgElement> {
        val code = if (sourceWeather.weather.code.isNullOrEmpty()) {
            val city = sourceWeather.weather.city
            WeatherHelper.searchCity(city).onFailure {
                LogCenter.log("无法获取城市天气: $city", Level.ERROR)
            }.getOrThrow().first().adcode
        } else sourceWeather.weather.code.toInt()
        WeatherHelper.fetchWeatherCard(code).onSuccess {
            val element = MsgElement()
            element.elementType = MsgConstant.KELEMTYPEARKSTRUCT
            val share = it["weekStore"]
                .asJsonObject["share"]
                .asJsonObject["data"].toString()
            element.arkElement =
                ArkElement(share, null, MsgConstant.ARKSTRUCTELEMENTSUBTYPEUNKNOWN)
            return Result.success(element)
        }.onFailure {
            return Result.failure(it)
        }
        return Result.failure(ActionMsgException)
    }

    private suspend fun locationConvertor(contact: Contact, msgId: Long, sourceLocation: Element): Result<MsgElement> {
        LbsHelper.tryShareLocation(
            contact,
            sourceLocation.location.lat.toDouble(),
            sourceLocation.location.lon.toDouble()
        ).onFailure {
            LogCenter.log("无法发送位置分享", Level.ERROR)
        }
        return Result.failure(ActionMsgException)
    }

    private suspend fun shareConvertor(contact: Contact, msgId: Long, sourceShare: Element): Result<MsgElement> {
        val url = sourceShare.share.url
        val image = sourceShare.share.image.ifNullOrEmpty {
            val startWithPrefix = url.startsWith("http://") || url.startsWith("https://")
            val endWithPrefix = url.startsWith("/")
            "http://" + url.split("/")[if (startWithPrefix) 2 else 0] + if (!endWithPrefix) {
                "/favicon.ico"
            } else {
                "favicon.ico"
            }
        }!!
        val title = sourceShare.share.title
        val content = sourceShare.share.content

        val reqBody = oidb_cmd0xdc2.ReqBody()
        val info = oidb_cmd0xb77.ReqBody()
        info.appid.set(100446242L)
        info.app_type.set(1)
        info.msg_style.set(0)
        info.recv_uin.set(contact.longPeer())
        val clientInfo = oidb_cmd0xb77.ClientInfo()
        clientInfo.platform.set(1)
        info.client_info.set(clientInfo)
        val richMsgBody = oidb_cmd0xb77.RichMsgBody()
        richMsgBody.using_ark.set(true)
        richMsgBody.title.set(title)
        richMsgBody.summary.set(content ?: url)
        richMsgBody.brief.set("[分享] $title")
        richMsgBody.url.set(url)
        richMsgBody.picture_url.set(image)
        info.ext_info.set(oidb_cmd0xb77.ExtInfo().also {
            it.msg_seq.set(msgId)
        })
        info.rich_msg_body.set(richMsgBody)
        reqBody.msg_body.set(info)
        val sendTo = oidb_cmd0xdc2.BatchSendReq()
        when (contact.chatType) {
            MsgConstant.KCHATTYPEGROUP -> sendTo.send_type.set(1)
            MsgConstant.KCHATTYPEC2C -> sendTo.send_type.set(0)
            else -> return Result.failure(Exception("Not supported chatType(${contact.chatType}) for ShareMsg"))
        }
        sendTo.recv_uin.set(contact.peerUid.toLong())
        reqBody.batch_send_req.add(sendTo)
        val to = ToServiceMsg("mobileqq.service", app.currentAccountUin, "OidbSvc.0xdc2_34")
        val oidb = oidb_sso.OIDBSSOPkg()
        oidb.uint32_command.set(0xdc2)
        oidb.uint32_service_type.set(34)
        oidb.bytes_bodybuffer.set(ByteStringMicro.copyFrom(reqBody.toByteArray()))
        oidb.str_client_version.set(PlatformUtils.getClientVersion(MobileQQ.getContext()))
        to.putWupBuffer(oidb.toByteArray())
        to.addAttribute("req_pb_protocol_flag", true)
        app.sendToService(to)
        return Result.failure(ActionMsgException)
    }

    private suspend fun contactConvertor(contact: Contact, msgId: Long, sourceContact: Element): Result<MsgElement> {
        val elem = MsgElement()

        when (val scene = sourceContact.contact.scene) {
            Scene.FRIEND -> {
                val ark = ArkElement(ContactHelper.getSharePrivateArkMsg(contact.longPeer()), null, null)
                elem.arkElement = ark
            }

            Scene.GROUP -> {
                val ark = ArkElement(ContactHelper.getShareTroopArkMsg(contact.longPeer()), null, null)
                elem.arkElement = ark
            }

            else -> return Result.failure(LogicException("不支持的联系人分享类型: $scene"))
        }

        elem.elementType = MsgConstant.KELEMTYPEARKSTRUCT
        return Result.success(elem)
    }

    private suspend fun jsonConvertor(contact: Contact, msgId: Long, sourceJson: Element): Result<MsgElement> {
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEARKSTRUCT
        val ark = ArkElement(sourceJson.json.json, null, null)
        elem.arkElement = ark
        return Result.success(elem)
    }

    private suspend fun markdownConvertor(contact: Contact, msgId: Long, sourceMarkdown: Element): Result<MsgElement> {
        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEMARKDOWN
        val markdownElement = MarkdownElement(sourceMarkdown.markdown.markdown)
        elem.markdownElement = markdownElement
        return Result.success(elem)
    }

    private suspend fun buttonConvertor(contact: Contact, msgId: Long, sourceButton: Element): Result<MsgElement> {
        fun tryNewKeyboardButton(button: Button): InlineKeyboardButton {
            val renderData = button.renderData
            val action = button.action
            val permission = action.permission
            return runCatching {
                InlineKeyboardButton(
                    button.id, renderData.label, renderData.visitedLabel, renderData.style,
                    action.type, 0,
                    action.unsupportedTips,
                    action.data, false,
                    permission.type,
                    ArrayList(permission.roleIdsList),
                    ArrayList(permission.userIdsList),
                    false, 0, false, arrayListOf()
                )
            }.getOrElse {
                InlineKeyboardButton(
                    button.id, renderData.label, renderData.visitedLabel, renderData.style,
                    action.type, 0,
                    action.unsupportedTips,
                    action.data, false,
                    permission.type,
                    ArrayList(permission.roleIdsList),
                    ArrayList(permission.userIdsList)
                )
            }
        }

        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEINLINEKEYBOARD
        val rows = arrayListOf<InlineKeyboardRow>()

        val keyboard = sourceButton.keyboard
        keyboard.rowsList.forEach { row ->
            val buttons = arrayListOf<InlineKeyboardButton>()
            row.buttonsList.forEach { button ->
                buttons.add(tryNewKeyboardButton(button))
            }
            rows.add(InlineKeyboardRow(buttons))
        }
        elem.inlineKeyboardElement = InlineKeyboardElement(rows, 0)
        return Result.success(elem)
    }

    private suspend fun forwardConvertor(contact: Contact, msgId: Long, sourceForward: Element): Result<MsgElement> {
        val resId = sourceForward.forward.resId
        val filename = sourceForward.forward.uniseq
        var summary = sourceForward.forward.summary
        val descriptions = sourceForward.forward.description
        var news = descriptions?.split("\n")?.map { "text" to it }

        if (news == null || summary == null) {
            val forwardMsg = MessageHelper.getForwardMsg(resId).getOrElse { return Result.failure(it) }
            if (news == null) {
                news = forwardMsg.map {
                    "text" to it.sender.nickName + ": " + descriptions
                }
            }
            if (summary == null) {
                summary = "查看${forwardMsg.size}条转发消息"
            }
        }

        val json = mapOf(
            "app" to "com.tencent.multimsg",
            "config" to mapOf(
                "autosize" to 1,
                "forward" to 1,
                "round" to 1,
                "type" to "normal",
                "width" to 300
            ),
            "desc" to "[聊天记录]",
            "extra" to mapOf(
                "filename" to filename,
                "tsum" to 2
            ).json.toString(),
            "meta" to mapOf(
                "detail" to mapOf(
                    "news" to news,
                    "resid" to resId,
                    "source" to "群聊的聊天记录",
                    "summary" to summary,
                    "uniseq" to filename
                )
            ),
            "prompt" to "[聊天记录]",
            "ver" to "0.0.0.5",
            "view" to "contact"
        )

        val elem = MsgElement()
        elem.elementType = MsgConstant.KELEMTYPEARKSTRUCT
        val ark = ArkElement(json.json.toString(), null, null)
        elem.arkElement = ark
        return Result.success(elem)
    }
}