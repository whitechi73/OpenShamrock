package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Trans211TmpMsg(
    @ProtoNumber(1) var msgBody: ByteArray? = null,
    @ProtoNumber(2) var c2cCmd: UInt? = null,
)