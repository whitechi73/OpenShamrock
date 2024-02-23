package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class NotOnlineFile(
    @ProtoNumber(1) var fileType: UInt? = null,
    @ProtoNumber(2) var sig: ByteArray? = null,
    @ProtoNumber(3) var fileUuid: ByteArray? = null,
    @ProtoNumber(4) var fileMd5: ByteArray? = null,
    @ProtoNumber(5) var fileName: ByteArray? = null,
    @ProtoNumber(6) var fileSize: ULong? = null,
    @ProtoNumber(7) var note: ByteArray? = null,
    @ProtoNumber(8) var reserved: UInt? = null,
    @ProtoNumber(9) var subcmd: UInt? = null,
    @ProtoNumber(10) var microCloud: UInt? = null,
    @ProtoNumber(11) var rptFileUrls: List<String>? = null,
    @ProtoNumber(12) var downloadFlag: UInt? = null,
    @ProtoNumber(50) var dangerEvel: UInt? = null,
    @ProtoNumber(51) var lifeTime: UInt? = null,
    @ProtoNumber(52) var uploadTime: UInt? = null,
    @ProtoNumber(53) var absFileType: UInt? = null,
    @ProtoNumber(54) var clientType: UInt? = null,
    @ProtoNumber(55) var expireTime: UInt? = null,
    @ProtoNumber(56) var pbReserve: ByteArray? = null,
    @ProtoNumber(57) var fileidcrcMedia: String? = null,
)