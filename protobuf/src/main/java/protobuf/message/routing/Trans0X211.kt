package protobuf.message.routing

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Trans0X211(
    @ProtoNumber(1) val toUin: ULong? = null,
    @ProtoNumber(2) val ccCmd: UInt? = null,
    @ProtoNumber(8) val uid: String? = null
)
