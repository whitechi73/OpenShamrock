package protobuf.message.element.commelem

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class PokeExtra(
    @ProtoNumber(1) val type: Int? = null,
    @ProtoNumber(7) val field7: Int? = null,
    @ProtoNumber(8) val field8: Int? = null
) : Protobuf<PokeExtra>