package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class C2CCommonTipsEvent(
    @ProtoNumber(7) val params: List<PokeParam>? = null,
    @ProtoNumber(8) val xmlTips: String? = null,
): Protobuf<C2CCommonTipsEvent>

@Serializable
data class PokeParam(
    @ProtoNumber(1) val key: String = "",
    @ProtoNumber(2) val value: String = "",
)