package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class CommonElement(
    @ProtoNumber(1) val type: Int? = null,
    @ProtoNumber(2) val data: ByteArray? = null,
    @ProtoNumber(3) val u1: Int? = null,
)