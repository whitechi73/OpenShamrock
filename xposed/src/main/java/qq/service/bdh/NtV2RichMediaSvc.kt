package qq.service.bdh

import android.graphics.BitmapFactory
import androidx.exifinterface.media.ExifInterface
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.aio.adapter.api.IAIOPttApi
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.PicElement
import com.tencent.qqnt.kernel.nativeinterface.PttElement
import com.tencent.qqnt.kernel.nativeinterface.QQNTWrapperUtil
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo
import com.tencent.qqnt.kernel.nativeinterface.VideoElement
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.config.ResourceGroup
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.AudioUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MediaType
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.oidb.TrpcOidb
import protobuf.oidb.cmd0x11c5.ClientMeta
import protobuf.oidb.cmd0x11c5.CodecConfigReq
import protobuf.oidb.cmd0x11c5.CommonHead
import protobuf.oidb.cmd0x11c5.DownloadExt
import protobuf.oidb.cmd0x11c5.DownloadReq
import protobuf.oidb.cmd0x11c5.FileInfo
import protobuf.oidb.cmd0x11c5.FileType
import protobuf.oidb.cmd0x11c5.IndexNode
import protobuf.oidb.cmd0x11c5.MultiMediaReqHead
import protobuf.oidb.cmd0x11c5.NtV2RichMediaReq
import protobuf.oidb.cmd0x11c5.NtV2RichMediaRsp
import protobuf.oidb.cmd0x11c5.SceneInfo
import protobuf.oidb.cmd0x11c5.UploadInfo
import protobuf.oidb.cmd0x11c5.UploadReq
import protobuf.oidb.cmd0x11c5.UploadRsp
import protobuf.oidb.cmd0x11c5.VideoDownloadExt
import protobuf.oidb.cmd0x388.Cmd0x388ReqBody
import protobuf.oidb.cmd0x388.Cmd0x388RspBody
import protobuf.oidb.cmd0x388.TryUpImgReq
import qq.service.QQInterfaces
import qq.service.internals.NTServiceFetcher
import qq.service.internals.msgService
import qq.service.kernel.SimpleKernelMsgListener
import qq.service.msg.MessageHelper
import java.io.File
import kotlin.coroutines.resume
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.random.nextULong
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

internal object NtV2RichMediaSvc: QQInterfaces() {
    private val requestIdSeq = atomic(1L)

    fun fetchGroupResUploadTo(): String {
        return ShamrockConfig[ResourceGroup].ifNullOrEmpty { "100000000" }!!
    }

    suspend fun tryUploadResourceByNt(
        chatType: Int,
        elementType: Int,
        resources: ArrayList<File>,
        timeout: Duration,
        retryCnt: Int = 5
    ): Result<MutableList<CommonFileInfo>> {
        return internalTryUploadResourceByNt(chatType, elementType, resources, timeout).onFailure {
            if (retryCnt > 0) {
                return tryUploadResourceByNt(chatType, elementType, resources, timeout, retryCnt - 1)
            }
        }
    }

    /**
     * 批量上传图片
     */
    private suspend fun internalTryUploadResourceByNt(
        chatType: Int,
        elementType: Int,
        resources: ArrayList<File>,
        timeout: Duration
    ): Result<MutableList<CommonFileInfo>> {
        require(resources.size in 1 .. 10) { "imageFiles.size() must be in 1 .. 10" }

        val messages = ArrayList(resources.map { file ->
            val elem = MsgElement()
            elem.elementType = elementType
            when(elementType) {
                MsgConstant.KELEMTYPEPIC -> {
                    val pic = PicElement()
                    pic.md5HexStr = QQNTWrapperUtil.CppProxy.genFileMd5Hex(file.absolutePath)
                    val msgService = NTServiceFetcher.kernelService.msgService!!
                    val originalPath = msgService.getRichMediaFilePathForMobileQQSend(
                        RichMediaFilePathInfo(
                            2, 0, pic.md5HexStr, file.name, 1, 0, null, "", true
                        )
                    )
                    if (!QQNTWrapperUtil.CppProxy.fileIsExist(originalPath) || QQNTWrapperUtil.CppProxy.getFileSize(
                            originalPath
                        ) != file.length()
                    ) {
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
                    pic.original = true
                    pic.picType = FileUtils.getPicType(file)
                    elem.picElement = pic
                }
                MsgConstant.KELEMTYPEPTT -> {
                    require(resources.size == 1) // 语音只能单个上传
                    var pttFile = file
                    val ptt = PttElement()
                    when (AudioUtils.getMediaType(pttFile)) {
                        MediaType.Silk -> {
                            ptt.formatType = MsgConstant.KPTTFORMATTYPESILK
                            ptt.duration = QRoute.api(IAIOPttApi::class.java)
                                .getPttFileDuration(pttFile.absolutePath)
                        }
                        MediaType.Amr -> {
                            ptt.duration = AudioUtils.getDurationSec(pttFile)
                            ptt.formatType = MsgConstant.KPTTFORMATTYPEAMR
                        }
                        MediaType.Pcm -> {
                            val result = AudioUtils.pcmToSilk(pttFile)
                            ptt.duration = (result.second * 0.001).roundToInt()
                            pttFile = result.first
                            ptt.formatType = MsgConstant.KPTTFORMATTYPESILK
                        }

                        else -> {
                            val result = AudioUtils.audioToSilk(pttFile)
                            ptt.duration = runCatching {
                                QRoute.api(IAIOPttApi::class.java)
                                    .getPttFileDuration(result.second.absolutePath)
                            }.getOrElse {
                                result.first
                            }
                            pttFile = result.second
                            ptt.formatType = MsgConstant.KPTTFORMATTYPESILK
                        }
                    }
                    ptt.md5HexStr = QQNTWrapperUtil.CppProxy.genFileMd5Hex(pttFile.absolutePath)
                    val msgService = NTServiceFetcher.kernelService.msgService!!
                    val originalPath = msgService.getRichMediaFilePathForMobileQQSend(
                        RichMediaFilePathInfo(
                            MsgConstant.KELEMTYPEPTT, 0, ptt.md5HexStr, file.name, 1, 0, null, "", true
                        )
                    )
                    if (!QQNTWrapperUtil.CppProxy.fileIsExist(originalPath) || QQNTWrapperUtil.CppProxy.getFileSize(originalPath) != pttFile.length()) {
                        QQNTWrapperUtil.CppProxy.copyFile(pttFile.absolutePath, originalPath)
                    }
                    if (originalPath != null) {
                        ptt.filePath = originalPath
                    } else {
                        ptt.filePath = pttFile.absolutePath
                    }
                    ptt.canConvert2Text = true
                    ptt.fileId = 0
                    ptt.fileUuid = ""
                    ptt.text = ""
                    ptt.voiceType = MsgConstant.KPTTVOICETYPESOUNDRECORD
                    ptt.voiceChangeType = MsgConstant.KPTTVOICECHANGETYPENONE
                    elem.pttElement = ptt
                }
                MsgConstant.KELEMTYPEVIDEO -> {
                    require(resources.size == 1) // 视频只能单个上传
                    val video = VideoElement()
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
                }
                else -> throw IllegalArgumentException("unsupported elementType: $elementType")
            }
            return@map elem
        })
        if (messages.isEmpty()) {
            return Result.failure(Exception("no valid image files"))
        }
        val contact = when(chatType) {
            MsgConstant.KCHATTYPEC2C -> MessageHelper.generateContact(chatType, app.currentAccountUin)
            else -> Contact(chatType, fetchGroupResUploadTo(), null)
        }
        val result = mutableListOf<CommonFileInfo>()
        val msgService = NTServiceFetcher.kernelService.msgService
            ?: return Result.failure(Exception("kernelService.msgService is null"))
        withTimeoutOrNull(timeout) {
            val uniseq = MessageHelper.generateMsgId(chatType)
            suspendCancellableCoroutine {
                val listener = object: SimpleKernelMsgListener() {
                    override fun onRichMediaUploadComplete(fileTransNotifyInfo: FileTransNotifyInfo) {
                        if (fileTransNotifyInfo.msgId == uniseq) {
                            result.add(fileTransNotifyInfo.commonFileInfo)
                        }
                        if (result.size == resources.size) {
                            msgService.removeMsgListener(this)
                            it.resume(true)
                        }
                    }
                }
                msgService.addMsgListener(listener)

                QRoute.api(IMsgService::class.java).sendMsg(contact, uniseq, messages) { _, _ ->
                    if (contact.chatType == MsgConstant.KCHATTYPEGROUP && contact.peerUid == "100000000") {
                        val kernelService = NTServiceFetcher.kernelService
                        val sessionService = kernelService.wrapperSession
                        val service = sessionService.msgService
                        service.deleteMsg(contact, arrayListOf(uniseq), null)
                    }
                }

                it.invokeOnCancellation {
                    msgService.removeMsgListener(listener)
                }
            }
        }

        if (result.isEmpty()) {
            return Result.failure(Exception("upload failed"))
        }

        return Result.success(result)
    }

    /**
     * 获取NT图片的RKEY
     */
    suspend fun getNtPicRKey(
        fileId: String,
        md5: String,
        sha: String,
        fileSize: ULong,
        width: UInt,
        height: UInt,
        sceneBuilder: suspend SceneInfo.() -> Unit
    ): Result<String> {
        runCatching {
            val req = NtV2RichMediaReq(
                head = MultiMediaReqHead(
                    commonHead = CommonHead(
                        requestId = requestIdSeq.incrementAndGet().toULong(),
                        cmd = 200u
                    ),
                    sceneInfo = SceneInfo(
                        requestType = 2u,
                        businessType = 1u,
                    ).apply {
                        sceneBuilder()
                    },
                    clientMeta = ClientMeta(2u)
                ),
                download = DownloadReq(
                    IndexNode(
                        FileInfo(
                            fileSize = fileSize,
                            md5 = md5.lowercase(),
                            sha1 = sha.lowercase(),
                            name = "${md5}.jpg",
                            fileType = FileType(
                                fileType = 1u,
                                picFormat = 1000u,
                                videoFormat = 0u,
                                voiceFormat = 0u
                            ),
                            width = width,
                            height = height,
                            time = 0u,
                            original = 1u
                        ),
                        fileUuid = fileId,
                        storeId = 1u,
                        uploadTime = 0u,
                        ttl = 0u,
                        subType = 0u,
                        storeAppId = 0u
                    ),
                    DownloadExt(
                        video = VideoDownloadExt(
                            busiType = 0u,
                            subBusiType = 0u,
                            msgCodecConfig = CodecConfigReq(
                                platformChipinfo = "",
                                osVer = "",
                                deviceName = ""
                            ),
                            flag = 1u
                        )
                    )
                )
            ).toByteArray()
            val fromServiceMsg = sendOidbAW("OidbSvcTrpcTcp.0x11c5_200", 4549, 200, req, true)
            if (fromServiceMsg == null || fromServiceMsg.wupBuffer == null) {
                return Result.failure(Exception("unable to get multimedia pic info: ${fromServiceMsg?.wupBuffer}"))
            }
            fromServiceMsg.wupBuffer.slice(4).decodeProtobuf<TrpcOidb>().buffer.decodeProtobuf<NtV2RichMediaRsp>().download?.rkeyParam?.let {
                return Result.success(it)
            }
        }.onFailure {
            return Result.failure(it)
        }
        return Result.failure(Exception("unable to get c2c nt pic"))
    }

    suspend fun requestUploadNtPic(
        file: File,
        md5: String,
        sha: String,
        name: String,
        width: UInt,
        height: UInt,
        retryCnt: Int,
        chatType: Int,
        sceneBuilder: suspend SceneInfo.() -> Unit
    ): Result<UploadRsp> {
        return runCatching {
            requestUploadNtPic(file, md5, sha, name, width, height, chatType, sceneBuilder).getOrThrow()
        }.onFailure {
            if (retryCnt > 0) {
                return requestUploadNtPic(file, md5, sha, name, width, height, retryCnt - 1, chatType, sceneBuilder)
            }
        }
    }

    private suspend fun requestUploadNtPic(
        file: File,
        md5: String,
        sha: String,
        name: String,
        width: UInt,
        height: UInt,
        chatType: Int,
        sceneBuilder: suspend SceneInfo.() -> Unit
    ): Result<UploadRsp> {
        val req = NtV2RichMediaReq(
            head = MultiMediaReqHead(
                commonHead = CommonHead(
                    requestId = requestIdSeq.incrementAndGet().toULong(),
                    cmd = 100u
                ),
                sceneInfo = SceneInfo(
                    requestType = 2u,
                    businessType = 1u,
                ).apply {
                    sceneBuilder()
                },
                clientMeta = ClientMeta(2u)
            ),
            upload = UploadReq(
                listOf(UploadInfo(
                    FileInfo(
                        fileSize = file.length().toULong(),
                        md5 = md5,
                        sha1 = sha,
                        name = name,
                        fileType = FileType(
                            fileType = 1u,
                            picFormat = 1000u,
                            videoFormat = 0u,
                            voiceFormat = 0u
                        ),
                        width = width,
                        height = height,
                        time = 0u,
                        original = 1u
                    ),
                    subFileType = 0u
                )),
                tryFastUploadCompleted = true,
                srvSendMsg = false,
                clientRandomId = Random.nextULong(),
                compatQMsgSceneType = 2u,
                clientSeq = Random.nextUInt(),
                noNeedCompatMsg = true
            )
        ).toByteArray()
        val fromServiceMsg = when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
                sendOidbAW("OidbSvcTrpcTcp.0x11c4_100", 4548, 100, req, true, timeout = 3.seconds)
            }
            MsgConstant.KCHATTYPEC2C -> {
                sendOidbAW("OidbSvcTrpcTcp.0x11c5_100", 4549, 100, req, true, timeout = 3.seconds)
            }
            else -> return Result.failure(Exception("unknown chat type: $chatType"))
        }
        if (fromServiceMsg == null || fromServiceMsg.wupBuffer == null) {
            return Result.failure(Exception("unable to request upload nt pic"))
        }
        val rspBuffer = fromServiceMsg.wupBuffer.slice(4).decodeProtobuf<TrpcOidb>().buffer
        val rsp = rspBuffer.decodeProtobuf<NtV2RichMediaRsp>()
        if (rsp.upload == null) {
            return Result.failure(Exception("unable to request upload nt pic: ${rsp.head}"))
        }
        return Result.success(rsp.upload!!)
    }

    /**
     * 使用OldBDH获取图片上传状态以及图片上传服务器
     */
    suspend fun requestUploadGroupPic(
        groupId: ULong,
        md5: String,
        fileSize: ULong,
        width: UInt,
        height: UInt,
    ): Result<TryUpPicData> {
        return runCatching {
            val fromServiceMsg = sendBufferAW("ImgStore.GroupPicUp", true, Cmd0x388ReqBody(
                netType = 3,
                subCmd = 1,
                msgTryUpImg = arrayListOf(
                    TryUpImgReq(
                        groupCode = groupId.toLong(),
                        srcUin = app.longAccountUin,
                        fileMd5 = md5.hex2ByteArray(),
                        fileSize = fileSize.toLong(),
                        fileName = "$md5.jpg",
                        srcTerm = 2,
                        platformType = 9,
                        buType = 212,
                        picWidth = width.toInt(),
                        picHeight = height.toInt(),
                        picType = 1000,
                        buildVer = "1.0.0",
                        originalPic = 1,
                        fileIndex = byteArrayOf(),
                        srvUpload = 0
                    )
                ),
            ).toByteArray())
            if (fromServiceMsg == null || fromServiceMsg.wupBuffer == null) {
                return Result.failure(Exception("unable to request upload group pic"))
            }
            val rsp = fromServiceMsg.wupBuffer.slice(4).decodeProtobuf<Cmd0x388RspBody>()
                .msgTryUpImgRsp!!.first()
            TryUpPicData(
                uKey = rsp.ukey,
                exist = rsp.fileExist,
                fileId = rsp.fileId.toULong(),
                upIp = rsp.upIp,
                upPort = rsp.upPort
            )
        }
    }
}