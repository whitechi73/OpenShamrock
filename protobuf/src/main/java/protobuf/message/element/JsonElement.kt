package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class JsonElement(
    @ProtoNumber(1) val data: ByteArray? = null,
)