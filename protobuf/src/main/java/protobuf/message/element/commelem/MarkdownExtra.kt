package protobuf.message.element.commelem

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class MarkdownExtra(
    @ProtoNumber(1) val content: String? = null,
) : Protobuf<MarkdownExtra>
