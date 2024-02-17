@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.message

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class RichMessage(
    @ProtoNumber(1) val font: Font? = null,
    @ProtoNumber(2) val elements: List<MessageElement>? = null
)

@Serializable
data class Font(
    @ProtoNumber(9) val fontName: String? = null
)