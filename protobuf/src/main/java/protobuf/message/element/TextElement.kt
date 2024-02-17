package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class TextElement(
    @ProtoNumber(1) val text: String? = null,
)