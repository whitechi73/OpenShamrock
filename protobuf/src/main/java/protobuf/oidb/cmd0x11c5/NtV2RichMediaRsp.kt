@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.oidb.cmd0x11c5

import com.google.protobuf.Internal.EMPTY_BYTE_ARRAY
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class NtV2RichMediaRsp(
    @ProtoNumber(1) val head: RspHead,
    @ProtoNumber(2) val upload: UploadRsp?,
    @ProtoNumber(3) val download: DownloadRsp?,
    @ProtoNumber(4) val downloadRkeyRsp: DownloadRkeyRsp?,
    @ProtoNumber(5) val delete: DeleteRsp?,
    @ProtoNumber(6) val uploadCompleted: UploadCompletedRsp?,
    @ProtoNumber(7) val msgInfoAuth: MsgInfoAuthRsp?,
    @ProtoNumber(8) val uploadKeyRenew: UploadKeyRenewalRsp?,
    @ProtoNumber(9) val downloadSafe: DownloadSafeRsp?,
    @ProtoNumber(99) val extension: ByteArray? = null,
): Protobuf<NtV2RichMediaRsp>

@Serializable
class DownloadSafeRsp

@Serializable
data class UploadKeyRenewalRsp(
    @ProtoNumber(1) val ukey: String?,
    @ProtoNumber(2) val ukeyTtlSec: ULong?,
)

@Serializable
data class MsgInfoAuthRsp(
    @ProtoNumber(1) val authCode: UInt = 0u,
    @ProtoNumber(2) val msg: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoNumber(3) val resultTime: ULong = 0u,
)

@Serializable
data class UploadCompletedRsp(
    @ProtoNumber(1) val msgSeq: ULong?
)

@Serializable
class DeleteRsp

@Serializable
data class DownloadRkeyRsp(
    @ProtoNumber(1) val rkeys: List<RKeyInfo>?
)

@Serializable
data class RKeyInfo(
    @ProtoNumber(1) val rkey: String?,
    @ProtoNumber(2) val rkeyTtlSec: ULong?,
    @ProtoNumber(3) val storeId: UInt = 0u,
    @ProtoNumber(4) val rkeyCreateTime: UInt?,
    @ProtoNumber(4) val type: UInt?,
)

@Serializable
data class DownloadRsp(
    @ProtoNumber(1) val rkeyParam: String?,
    @ProtoNumber(2) val rkeyTtlSec: ULong?,
    @ProtoNumber(3) val downloadInfo: DownloadInfo?,
    @ProtoNumber(4) val rkeyCreateTime: UInt?
)

@Serializable
data class DownloadInfo(
    @ProtoNumber(1) val domain: String,
    @ProtoNumber(2) val urlPath: String? = null,
    @ProtoNumber(3) val httpsPort: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val ipv4: List<Ipv4>,
    @ProtoNumber(5) val ipv6: List<Ipv6>,
    @ProtoNumber(6) val picUrlExtInfo: PicUrlExtInfo?,
    @ProtoNumber(7) val videoExtInfo: VideoExtInfo? = null,
)

@Serializable
data class VideoExtInfo(
    @ProtoNumber(1) val videoCodecFormat: UInt? = null,
)

@Serializable
data class UploadRsp(
    @ProtoNumber(1) val ukey: String?,
    @ProtoNumber(2) val ukeyTtlSec: ULong?,
    @ProtoNumber(3) val ipv4: List<Ipv4>?,
    @ProtoNumber(4) val ipv6: List<Ipv6>?,
    @ProtoNumber(5) val msgSeq: ULong?,
    @ProtoNumber(6) val msgInfo: MsgInfo? = null,
    @ProtoNumber(7) val ext: List<RichmediaStorageTransInfo>? = null,
    @ProtoNumber(8) val compatQMsg: ByteArray? = null,
    @ProtoNumber(10) val subFileInfos: List<SubFileInfo>? = null,
)

@Serializable
data class SubFileInfo(
    @ProtoNumber(1) val subType: UInt?,
    @ProtoNumber(2) val ukey: String?,
    @ProtoNumber(3) val ukeyTTLSec: ULong?,
    @ProtoNumber(4) val ipv4: List<Ipv4>?,
    @ProtoNumber(5) val ipv6: List<Ipv6>?,
)

@Serializable
data class RichmediaStorageTransInfo(
    @ProtoNumber(1) val subType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val extType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val extValue: ByteArray? = null,
)

@Serializable
data class Ipv4(
    @ProtoNumber(1) val outIp: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val outPort: Int = Int.MIN_VALUE,
    @ProtoNumber(3) val inIp: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val inPort: Int = Int.MIN_VALUE,
    @ProtoNumber(5) val ipType: Int = Int.MIN_VALUE,
)

@Serializable
data class Ipv6(
    @ProtoNumber(1) val outIp: ByteArray? = null,
    @ProtoNumber(2) val outPort: Int = Int.MIN_VALUE,
    @ProtoNumber(3) val inIp: ByteArray? = null,
    @ProtoNumber(4) val inPort: Int = Int.MIN_VALUE,
    @ProtoNumber(5) val ipType: Int = Int.MIN_VALUE,
)

@Serializable
data class RspHead(
    @ProtoNumber(1) val commonHead: CommonHead?,
    @ProtoNumber(2) val retCode: UInt = 0u,
    @ProtoNumber(3) val msg: String?
)

