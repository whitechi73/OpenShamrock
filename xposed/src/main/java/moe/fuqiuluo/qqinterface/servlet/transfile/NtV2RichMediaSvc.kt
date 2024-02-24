package moe.fuqiuluo.qqinterface.servlet.transfile

import kotlinx.atomicfu.atomic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.slice
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
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.random.nextULong

internal object NtV2RichMediaSvc: BaseSvc() {
    private val requestIdSeq = atomic(2L)

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

    @Serializable
    data class TryUpPicData(
        @SerialName("ukey") val uKey: ByteArray,
        @SerialName("exist") val exist: Boolean,
        @SerialName("file_id") val fileId: ULong,
        @SerialName("up_ip") var upIp: ArrayList<Long>? = null,
        @SerialName("up_port") var upPort: ArrayList<Int>? = null,
    )
}