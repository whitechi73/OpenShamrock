package moe.fuqiuluo.qqinterface.servlet.transfile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import androidx.exifinterface.media.ExifInterface
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.aio.adapter.api.IAIOPttApi
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.FileElement
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.PicElement
import com.tencent.qqnt.kernel.nativeinterface.PttElement
import com.tencent.qqnt.kernel.nativeinterface.QQNTWrapperUtil
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo
import com.tencent.qqnt.kernel.nativeinterface.VideoElement
import com.tencent.qqnt.msg.api.IMsgUtilApi
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.transfile.data.Private
import moe.fuqiuluo.qqinterface.servlet.transfile.data.Troop
import moe.fuqiuluo.qqinterface.servlet.transfile.data.TryUpPicData
import moe.fuqiuluo.qqinterface.servlet.transfile.data.VideoResource
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.TransfileHelper
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.AudioUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.shamrock.utils.MediaType
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.shamrock.xposed.helper.msgService
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
import protobuf.oidb.cmd0x11c5.VideoDownloadExt
import protobuf.oidb.cmd0x388.Cmd0x388ReqBody
import protobuf.oidb.cmd0x388.Cmd0x388RspBody
import protobuf.oidb.cmd0x388.TryUpImgReq
import java.io.File
import java.io.FileOutputStream
import kotlin.coroutines.resume
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.random.nextULong
import kotlin.time.Duration

internal object NtV2RichMediaSvc: BaseSvc() {
    private const val GROUP_PIC_UPLOAD_TO = "100000000"

    private val requestIdSeq = atomic(2L)

    /**
     * 批量上传图片
     */
    suspend fun tryUploadResourceByNt(
        chatType: Int,
        elementType: Int,
        resources: ArrayList<File>,
        timeout: Duration
    ): Result<MutableList<CommonFileInfo>> {
        require(resources.size in 1 .. 10) { "imageFiles.size() must be in 1 .. 10" }

        val messages = resources.map { file ->
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

                /*MsgConstant.KELEMTYPEFILE -> {
                    require(resources.size == 1) // 文件只能单个上传
                    val fileElement = FileElement()
                    fileElement.fileMd5 = ""
                    fileElement.fileName = file.name
                    fileElement.filePath = file.absolutePath
                    fileElement.fileSize = file.length()
                    fileElement.picWidth = 0
                    fileElement.picHeight = 0
                    fileElement.videoDuration = 0
                    fileElement.picThumbPath = HashMap()
                    fileElement.expireTime = 0L
                    fileElement.fileSha = ""
                    fileElement.fileSha3 = ""
                    fileElement.file10MMd5 = ""
                    when (TransfileHelper.getExtensionId(file.name)) {
                        0 -> {
                            val wh = QRoute.api(IMsgUtilApi::class.java)
                                .getPicSizeByPath(file.absolutePath)
                            fileElement.picWidth = wh.first
                            fileElement.picHeight = wh.second
                            fileElement.picThumbPath[750] = file.absolutePath
                        }
                        2 -> {
                            val thumbPic = FileUtils.getFileByMd5(MD5.genFileMd5Hex(file.absolutePath))
                            withContext(Dispatchers.IO) {
                                val fileOutputStream = FileOutputStream(thumbPic)
                                val retriever = MediaMetadataRetriever()
                                retriever.setDataSource(fileElement.filePath)
                                retriever.frameAtTime?.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream)
                                fileOutputStream.flush()
                                fileOutputStream.close()
                            }
                            val options = BitmapFactory.Options()
                            BitmapFactory.decodeFile(thumbPic.absolutePath, options)
                            fileElement.picHeight = options.outHeight
                            fileElement.picWidth = options.outWidth
                            fileElement.picThumbPath = hashMapOf(750 to thumbPic.absolutePath)
                        }
                    }
                    elem.fileElement = fileElement
                }*/
                else -> throw IllegalArgumentException("unsupported elementType: $elementType")
            }
            return@map elem
        }
        if (messages.isEmpty()) {
            return Result.failure(Exception("no valid image files"))
        }
        val contact = when(chatType) {
            MsgConstant.KCHATTYPEC2C -> MessageHelper.generateContact(chatType, TicketSvc.getUin())
            else -> Contact(chatType, GROUP_PIC_UPLOAD_TO, GROUP_PIC_UPLOAD_TO)
        }
        val result = mutableListOf<CommonFileInfo>()
        withTimeoutOrNull(timeout) {
            suspendCancellableCoroutine {
                val uniseq = MessageHelper.generateMsgId(chatType)
                RichMediaUploadHandler.registerListener(uniseq.qqMsgId) upload@{
                    if (uniseq.qqMsgId == msgId) {
                        result.add(commonFileInfo)
                    }
                    if (result.size == resources.size) {
                        it.resume(true)
                        return@upload true
                    }
                    return@upload false
                }
                MessageHelper.sendMessageWithMsgId(
                    contact = contact,
                    message = ArrayList(messages),
                    uniseq = uniseq.qqMsgId
                ) { _, _ -> }
                it.invokeOnCancellation {
                    RichMediaUploadHandler.removeListener(uniseq.qqMsgId)
                }
            }
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
            val buffer = sendOidbAW("OidbSvcTrpcTcp.0x11c5_200", 4549, 200, req, true)?.slice(4)
            buffer?.decodeProtobuf<TrpcOidb>()?.buffer?.decodeProtobuf<NtV2RichMediaRsp>()?.download?.rkeyParam?.let {
                return Result.success(it)
            }
        }.onFailure {
            return Result.failure(it)
        }
        return Result.failure(Exception("unable to get c2c nt pic"))
    }

    /**
     * 请求上传Nt图片
     */
    suspend fun requestUploadNtPic(
        file: File,
        md5: String,
        sha: String,
        name: String,
        width: UInt,
        height: UInt,
        sceneBuilder: suspend SceneInfo.() -> Unit
    ) {
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
                compatQMsgSceneType = 1u,
                clientSeq = Random.nextUInt(),
                noNeedCompatMsg = true
            )
        ).toByteArray()
        val buffer = sendOidbAW("OidbSvcTrpcTcp.0x11c5_100", 4549, 100, req, true)?.slice(4)
        val rsp = buffer?.decodeProtobuf<TrpcOidb>()?.buffer?.decodeProtobuf<NtV2RichMediaRsp>()
        LogCenter.log("requestUploadPic => rsp: $rsp")
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
            val rspBuffer = sendBufferAW("ImgStore.GroupPicUp", true, Cmd0x388ReqBody(
                netType = 3,
                subCmd = 1,
                msgTryUpImg = arrayListOf(
                    TryUpImgReq(
                        groupCode = groupId.toLong(),
                        srcUin = TicketSvc.getLongUin(),
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
            ).toByteArray())!!
            val rsp = rspBuffer.decodeProtobuf<Cmd0x388RspBody>()
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

