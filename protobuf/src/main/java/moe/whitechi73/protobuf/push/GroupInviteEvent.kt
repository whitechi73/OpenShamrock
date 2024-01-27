package moe.whitechi73.protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupInviteEvent(
    @ProtoNumber(1) val groupCode: Long,
    @ProtoNumber(5) val inviterUid: String,
)
