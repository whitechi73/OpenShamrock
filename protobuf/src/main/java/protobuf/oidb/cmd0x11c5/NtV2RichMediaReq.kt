@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.oidb.cmd0x11c5

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class NtV2RichMediaReq(
    @ProtoNumber(1) val head: MultiMediaReqHead,
    @ProtoNumber(2) val upload: UploadReq? = null, // 100
    @ProtoNumber(3) val download: DownloadReq? = null,
    @ProtoNumber(4) val downloadRkey: DownloadRkeyReq? = null,
    @ProtoNumber(5) val delete: DeleteReq? = null,
    @ProtoNumber(6) val uploadCompleted: UploadCompletedReq? = null,
    @ProtoNumber(7) val msgInfoAuth: MsgInfoAuthReq? = null,
    @ProtoNumber(8) val uploadKeyRenewal: UploadKeyRenewalReq? = null,
    @ProtoNumber(9) val downloadSafe: DownloadSafeReq? = null,
    @ProtoNumber(99) val extension: ByteArray? = null,
): Protobuf<NtV2RichMediaReq>

@Serializable
data class DownloadSafeReq(
    @ProtoNumber(1) val index: IndexNode,
)

@Serializable
data class UploadKeyRenewalReq(
    @ProtoNumber(1) val oldUkey: String,
    @ProtoNumber(2) val subType: UInt,
)

@Serializable
data class MsgInfoAuthReq(
    @ProtoNumber(1) val msg: ByteArray,
    @ProtoNumber(2) val authTime: ULong,
)

@Serializable
data class UploadCompletedReq(
    @ProtoNumber(1) val srvSendMsg: Boolean,
    @ProtoNumber(2) val clientRandomId: ULong,
    @ProtoNumber(3) val msgInfo: MsgInfo,
    @ProtoNumber(4) val clientSeq: UInt,
)

@Serializable
data class MsgInfo(
    @ProtoNumber(1) val msgInfoBody: List<MsgInfoBody>,
    @ProtoNumber(2) val extBizInfo: ExtBizInfo?,
): Protobuf<MsgInfo>

@Serializable
data class MsgInfoBody(
    @ProtoNumber(1) val index: IndexNode? = null,
    @ProtoNumber(2) val picture: PictureInfo? = null,
    @ProtoNumber(3) val video: VideoInfo? = null,
    @ProtoNumber(4) val audio: AudioInfo? = null,
    @ProtoNumber(5) val fileExist: Boolean? = null,
    @ProtoNumber(6) val hashSum: ByteArray? = null,
)

@Serializable
class VideoInfo

@Serializable
class AudioInfo


@Serializable
data class PictureInfo(
    @ProtoNumber(1) val urlPath: String,
    @ProtoNumber(2) val ext: PicUrlExtInfo? = null,
    @ProtoNumber(3) val domain: String? = null
)

@Serializable
data class PicUrlExtInfo(
    @ProtoNumber(1) val originalParameter: String? = null,
    @ProtoNumber(2) val bigParameter: String? = null,
    @ProtoNumber(3) val thumbParameter: String? = null
)

@Serializable
data class DeleteReq(
    @ProtoNumber(1) val index: List<IndexNode>,
    @ProtoNumber(2) val needRecallMsg: Boolean? = null,
    @ProtoNumber(3) val msgSeq: ULong? = null,
    @ProtoNumber(4) val msgRandom: ULong? = null,
    @ProtoNumber(5) val msgTime: ULong? = null,
)

@Serializable
data class DownloadRkeyReq(
    @ProtoNumber(1) val types: List<Int>
)

@Serializable
data class UploadReq(
    @ProtoNumber(1) val uploadInfo: List<UploadInfo>,
    @ProtoNumber(2) val tryFastUploadCompleted: Boolean? = null,
    @ProtoNumber(3) val srvSendMsg: Boolean? = null,
    @ProtoNumber(4) val clientRandomId: ULong = ULong.MIN_VALUE,
    @ProtoNumber(5) val compatQMsgSceneType: UInt? = null,
    @ProtoNumber(6) val extBizInfo: ExtBizInfo? = null,
    @ProtoNumber(7) val clientSeq: UInt? = null,
    @ProtoNumber(8) val noNeedCompatMsg: Boolean? = null,
)

@Serializable
data class ExtBizInfo(
    @ProtoNumber(1) val pic: PicExtBizInfo? = null,
    @ProtoNumber(2) val video: VideoExtBizInfo? = null,
    @ProtoNumber(3) val ptt: PttExtBizInfo? = null,
    @ProtoNumber(10) val busiType: UInt?,
)

@Serializable
data class PttExtBizInfo(
    @ProtoNumber(1) val srcUin: ULong,
    @ProtoNumber(2) val pttScene: UInt,
    @ProtoNumber(3) val pttType: UInt,
    @ProtoNumber(4) val changeVoice: UInt,
    @ProtoNumber(5) val waveform: ByteArray? = null,
    @ProtoNumber(6) val autoConvertText: UInt? = null,
    @ProtoNumber(11) val bytesReserve: ByteArray? = null,
    @ProtoNumber(12) val bytesPbReserve: ByteArray? = null,
    @ProtoNumber(13) val bytesGeneralFlags: ByteArray? = null,
)

@Serializable
data class VideoExtBizInfo(
    @ProtoNumber(1) val fromScene: UInt?,
    @ProtoNumber(2) val toScene: UInt?,
    @ProtoNumber(3) val bytesPbReserve: ByteArray?,
)

@Serializable
data class PicExtBizInfo(
    @ProtoNumber(1) val bizType: UInt?,
    @ProtoNumber(2) val textSummary: String?,
    @ProtoNumber(11) val bytesPbReserveC2c: ByteArray? = null,
    @ProtoNumber(12) val bytesPbReserveTroop: ByteArray? = null,
    @ProtoNumber(1001) val fromScene: UInt? = null,
    @ProtoNumber(1002) val toScene: UInt? = null,
    @ProtoNumber(1003) val oldFileId: UInt? = null,
)

@Serializable
data class UploadInfo(
    @ProtoNumber(1) val fileInfo: FileInfo,
    @ProtoNumber(2) val subFileType: UInt
)

@Serializable
data class FileInfo(
    @ProtoNumber(1) val fileSize: ULong?,
    @ProtoNumber(2) val md5: String?,
    @ProtoNumber(3) val sha1: String?,
    @ProtoNumber(4) val name: String?,
    @ProtoNumber(5) val fileType: FileType?,
    @ProtoNumber(6) val width: UInt?,
    @ProtoNumber(7) val height: UInt?,
    @ProtoNumber(8) val time: UInt?,
    @ProtoNumber(9) val original: UInt?,
)

@Serializable
data class FileType(
    @ProtoNumber(1) val fileType: UInt = 0u,
    @ProtoNumber(2) val picFormat: UInt = 0u,
    @ProtoNumber(3) val videoFormat: UInt? = null,
    @ProtoNumber(4) val voiceFormat: UInt? = null,
)

@Serializable
data class DownloadReq(
    @ProtoNumber(1) val index: IndexNode,
    @ProtoNumber(2) val ext: DownloadExt,
)

@Serializable
data class DownloadExt(
    @ProtoNumber(1) val pic: PicDownloadExt? = null,
    @ProtoNumber(2) val video: VideoDownloadExt,
    @ProtoNumber(3) val voice: PttDownloadExt? = null,
)

@Serializable
class PicDownloadExt

@Serializable
class PttDownloadExt

@Serializable
data class VideoDownloadExt(
    @ProtoNumber(1) val busiType: UInt?,
    @ProtoNumber(2) val sceneType: UInt? = null,
    @ProtoNumber(3) val subBusiType: UInt?,
    @ProtoNumber(4) val msgCodecConfig: CodecConfigReq,
    @ProtoNumber(5) val flag: UInt?,
)

@Serializable
data class CodecConfigReq(
    @ProtoNumber(1) val platformChipinfo: String,
    @ProtoNumber(2) val osVer: String,
    @ProtoNumber(3) val deviceName: String,
)

@Serializable
data class IndexNode(
    @ProtoNumber(1) val fileInfo: FileInfo,
    @ProtoNumber(2) val fileUuid: String,
    @ProtoNumber(3) val storeId: UInt, // 0为旧服务器 1为nt服务器
    @ProtoNumber(4) val uploadTime: ULong,
    @ProtoNumber(5) val ttl: ULong,
    @ProtoNumber(6) val subType: UInt? = null,
    @ProtoNumber(7) val storeAppId: UInt? = null
)

@Serializable
data class MultiMediaReqHead(
    @ProtoNumber(1) val commonHead: CommonHead,
    @ProtoNumber(2) val sceneInfo: SceneInfo,
    @ProtoNumber(3) val clientMeta: ClientMeta
)

@Serializable
data class ClientMeta(
    @ProtoNumber(1) val agentType: UInt,
)

@Serializable
data class SceneInfo(
    @ProtoNumber(101) val requestType: UInt,
    @ProtoNumber(102) val businessType: UInt,
    @ProtoNumber(103) val appType: UInt? = null,
    @ProtoNumber(200) var sceneType: UInt? = null,
    @ProtoNumber(201) var c2c: C2CUserInfo? = null,
    @ProtoNumber(202) var grp: GroupUserInfo? = null,
    @ProtoNumber(203) var channel: ChannelUserInfo? = null,
    @ProtoNumber(205) val byteArr: ByteArray?= null
)

@Serializable
data class ChannelUserInfo(
    @ProtoNumber(1) val guildId: ULong,
    @ProtoNumber(2) val channelId: ULong,
    @ProtoNumber(3) val channelType: UInt,
)

@Serializable
data class GroupUserInfo(
    @ProtoNumber(1) val uin: ULong,
)

@Serializable
data class C2CUserInfo(
    @ProtoNumber(1) val accountType: UInt,
    @ProtoNumber(2) val uid: String,
    @ProtoNumber(3) val byteArr: ByteArray? = null
)

@Serializable
data class CommonHead(
    @ProtoNumber(1) val requestId: ULong,
    @ProtoNumber(2) val cmd: UInt,
    @ProtoNumber(3) val msg: String? = null
)
