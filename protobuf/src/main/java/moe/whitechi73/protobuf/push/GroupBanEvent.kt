package moe.whitechi73.protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupBanEvent(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val operatorUid: String = "",
    @ProtoNumber(5) val target: GroupBanTarget? = null,
)

@Serializable
data class GroupBanTarget(
    @ProtoNumber(3) val target: GroupBanInfo? = null,
)

@Serializable
data class GroupBanInfo(
    @ProtoNumber(1) val targetUid: String? = null,
    @ProtoNumber(2) val rawDuration: UInt = UInt.MIN_VALUE,
)