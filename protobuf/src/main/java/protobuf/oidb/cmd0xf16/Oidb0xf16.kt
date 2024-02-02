package protobuf.oidb.cmd0xf16

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Oidb0xf16(
    @ProtoNumber(1) var setGroupRemarkReq: SetGroupRemarkReq? = null,
)

@Serializable
data class SetGroupRemarkReq(
    @ProtoNumber(1) var groupCode: ULong,
    @ProtoNumber(2) var groupUin: ULong,
    @ProtoNumber(3) var groupRemark: String
)