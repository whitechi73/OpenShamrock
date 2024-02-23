package protobuf.message.routing

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WPATmp (
    @ProtoNumber(1) val toUin: Int? = null,
    @ProtoNumber(2) val sig: ByteArray? = null,
)