package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class C2CRecallEvent(
    @ProtoNumber(1) val head: C2CRecallHead? = null,
): Protobuf<C2CRecallEvent>

@Serializable
data class C2CRecallHead(
    @ProtoNumber(1) val operator: String? = null,
    @ProtoNumber(13) val wording: RecallWording? = null,
    @ProtoNumber(20) val msgSeq: Long = Long.MIN_VALUE,
)

@Serializable
data class RecallWording(
    @ProtoNumber(2) val wording: String? = null
)