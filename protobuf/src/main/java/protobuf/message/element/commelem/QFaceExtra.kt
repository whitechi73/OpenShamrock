package protobuf.message.element.commelem

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class QFaceExtra(
    @ProtoNumber(1) val packId: String? = null,
    @ProtoNumber(2) val stickerId: String? = null,
    @ProtoNumber(3) val faceId: Int? = null,
    @ProtoNumber(4) val field4: Int? = null,
    @ProtoNumber(5) val field5: Int? = null,
    @ProtoNumber(6) val result: String? = null,
    @ProtoNumber(7) val faceText: String? = null,
    @ProtoNumber(9) val field9: Int? = null
) : Protobuf<QFaceExtra>
