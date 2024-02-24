package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class FaceMsg(
    @ProtoNumber(1) val index: Int? = null,
    @ProtoNumber(2) var old: ByteArray? = null,
    @ProtoNumber(11) var buf: ByteArray? = null,

    )