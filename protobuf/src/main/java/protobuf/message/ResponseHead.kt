@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.message

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class ResponseHead(
    @ProtoNumber(1) val peer: Long = Long.MIN_VALUE,
    @ProtoNumber(2) val peerUid: String? = null,
    @ProtoNumber(3) val flag: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val appId: Int = Int.MIN_VALUE,
    @ProtoNumber(5) val receiver: Long? = null,
    @ProtoNumber(6) val receiverUid: String? = null,
    @ProtoNumber(7) val forward: ResponseForward? = null,
    @ProtoNumber(8) val responseGrp: ResponseGrp? = null,
)

@Serializable
data class ResponseForward(
    @ProtoNumber(6) val friendName: String? = null,
    @ProtoNumber(11) val u1: Int? = null,
)

@Serializable
data class ResponseGrp(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val memberCard: String? = null,
    @ProtoNumber(5) val u1: Int? = null,
    @ProtoNumber(7) val groupName: String? = null,
    @ProtoNumber(10) val u2: Int? = null,
)