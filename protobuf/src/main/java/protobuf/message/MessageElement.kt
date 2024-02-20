package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import protobuf.message.element.*

@Serializable
data class MessageElement(
    @ProtoNumber(1) val text: TextElement? = null,
    @ProtoNumber(2) val face: FaceElement? = null,
    @ProtoNumber(51) val json: JsonElement? = null,
    @ProtoNumber(53) val commElem: CommonElement? = null,
)
