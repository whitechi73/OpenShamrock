package protobuf.message.routing

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class C2C(
    @ProtoNumber(1) val uin: UInt? = null,
    @ProtoNumber(2) val uid: String? = null,
    @ProtoNumber(3) val field3: UInt? = null,
    @ProtoNumber(4) val sig: UInt? = null,
    @ProtoNumber(5) val receiverUin: UInt? = null,
    @ProtoNumber(6) val receiverUid: String? = null
)