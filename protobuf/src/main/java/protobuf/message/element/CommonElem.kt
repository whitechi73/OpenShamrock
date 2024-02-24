package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class CommonElem(
    @ProtoNumber(1) val serviceType: Int? = null,
    @ProtoNumber(2) val elem: ByteArray? = null,
    @ProtoNumber(3) val businessType: Int? = null,
)