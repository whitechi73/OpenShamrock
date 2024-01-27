package moe.whitechi73.protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupRecallDetails(
    @ProtoNumber(1) val operatorUid: String = "",
    @ProtoNumber(3) val msgInfo: RecalledMessageInfo? = null,
    @ProtoNumber(9) val wording: RecallWording? = null
)

@Serializable
data class RecalledMessageInfo(
    @ProtoNumber(1) val msgSeq: ULong,
    @ProtoNumber(2) val msgTime: ULong,
    @ProtoNumber(6) val senderUid: String,
)