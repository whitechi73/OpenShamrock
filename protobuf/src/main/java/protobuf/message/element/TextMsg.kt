package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class TextMsg(
    @ProtoNumber(1) val str: String? = null,
    @ProtoNumber(2) val link: String? = null,
    @ProtoNumber(3) val attr6Buf: ByteArray? = null,
    @ProtoNumber(4) val attr7Buf: ByteArray? = null,
    @ProtoNumber(11) val buf: ByteArray? = null,
    @ProtoNumber(12) val pbReserve: ByteArray? = null,
)