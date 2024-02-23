package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class GroupApplyEvent(
    @ProtoNumber(1) val groupCode: Long = Long.MIN_VALUE,
    @ProtoNumber(3) val applierUid: String = "",
    @ProtoNumber(5) val applyMsg: String? = null,
): Protobuf<GroupApplyEvent>
