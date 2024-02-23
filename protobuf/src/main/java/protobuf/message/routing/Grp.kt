package protobuf.message.routing

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Grp (
    @ProtoNumber(1) var groupCode: UInt? = null,
)