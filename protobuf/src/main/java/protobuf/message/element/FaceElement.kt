package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class FaceElement(
    @ProtoNumber(1) val id: Int? = null,
)