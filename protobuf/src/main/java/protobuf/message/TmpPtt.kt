package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class TmpPtt(
    @ProtoNumber(1) var fileType: UInt? = null,
    @ProtoNumber(2) var fileUuid: ByteArray? = null,
    @ProtoNumber(3) var fileMd5: ByteArray? = null,
    @ProtoNumber(4) var fileName: ByteArray? = null,
    @ProtoNumber(5) var fileSize: UInt? = null,
    @ProtoNumber(6) var pttTimes: UInt? = null,
    @ProtoNumber(7) var userType: UInt? = null,
    @ProtoNumber(8) var ptttransFlag: UInt? = null,
    @ProtoNumber(9) var busiType: UInt? = null,
    @ProtoNumber(10) var msgId: ULong? = null,
    @ProtoNumber(30) var pbReserve: ByteArray? = null,
    @ProtoNumber(31) var pttEncodeData: ByteArray? = null,
)