package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupCommonTipsEvent(
    @ProtoNumber(4) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(5) val uniqueTitleChangeDetail: List<GroupUniqueTitleChangeDetail>? = null,
    @ProtoNumber(11) val recallDetails: GroupRecallDetails? = null,
    @ProtoNumber(26) val baseTips: List<GroupBaseTips>? = null,
    @ProtoNumber(33) val essenceMsgInfo: List<EssenceMsgInfo>? = null,
    @ProtoNumber(37) val msgSeq: ULong = ULong.MIN_VALUE,
)

@Serializable
data class EssenceMsgInfo(
    @ProtoNumber(4) val type: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5) val sender: ULong = ULong.MIN_VALUE,
    @ProtoNumber(6) val operator: ULong = ULong.MIN_VALUE,
)

@Serializable
data class GroupBaseTips(
    @ProtoNumber(2) val type: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val params: List<PokeParam>? = null
)
