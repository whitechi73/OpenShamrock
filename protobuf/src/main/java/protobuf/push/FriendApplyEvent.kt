package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class FriendApplyEvent(
    @ProtoNumber(1) val head: FriendApplyHead? = null,
)


@Serializable
data class FriendApplyHead(
    @ProtoNumber(2) val applierUid: String = "",
    @ProtoNumber(7) val srcId: Int = Int.MIN_VALUE,
    @ProtoNumber(8) val subSrc: Int = Int.MIN_VALUE,
    @ProtoNumber(10) val applyMsg: String? = null,
    @ProtoNumber(11) val source: String? = null,
)