package protobuf.message.routing

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GrpTmp (
    @ProtoNumber(1) var groupCode: UInt? = null,
    @ProtoNumber(2) var ToUin: UInt? = null,
)