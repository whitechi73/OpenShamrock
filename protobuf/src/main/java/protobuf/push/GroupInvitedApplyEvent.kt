package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupInvitedApplyEvent(
    @ProtoNumber(2) val applyInfo: GroupInvitedApplyInfo? = null,
)

@Serializable
data class GroupInvitedApplyInfo(
    @ProtoNumber(1) val type: Int = Int.MIN_VALUE,
    @ProtoNumber(3) val groupCode: Long = Long.MIN_VALUE,
    @ProtoNumber(5) val applierUid: String = "",
)