@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.message

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MessageHead(
    @ProtoNumber(1) val peer: Long = Long.MIN_VALUE,
    @ProtoNumber(2) val peerUid: String? = null,
    @ProtoNumber(3) val flag: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val appId: Int = Int.MIN_VALUE,
    @ProtoNumber(5) val receiver: Long? = null,
    @ProtoNumber(6) val receiverUid: String? = null,
    @ProtoNumber(7) val forward: MessageForward? = null,
    @ProtoNumber(8) val groupInfo: GroupInfo? = null,
)

@Serializable
data class MessageForward(
    @ProtoNumber(6) val friendName: String? = null,
)

@Serializable
data class GroupInfo(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val memberCard: String? = null,
    @ProtoNumber(5) val u1: Int? = null,
    @ProtoNumber(7) val groupName: String? = null,
)