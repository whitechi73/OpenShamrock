@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.message

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MessageBody(
    @ProtoNumber(1) val msgHead: MessageHead? = null,
    @ProtoNumber(2) val contentHead: MessageContentHead? = null,
    @ProtoNumber(3) val richMsg: RichMessage? = null,
)

@Serializable
data class RichMessage(
    @ProtoNumber(1) val elements: MessageElementList? = null,
    @ProtoNumber(2) val rawBuffer: ByteArray? = null,
)

@Serializable
data class MessageElementList(
    @ProtoNumber(2) val elements: List<MessageElement>? = null
)

@Serializable
data class MessageElement(
    @ProtoNumber(51) val json: JsonElement? = null,
)

@Serializable
data class JsonElement(
    @ProtoNumber(1) val data: ByteArray? = null,
)

@Serializable
data class MessageHead(
    @ProtoNumber(1) val peer: Long = Long.MIN_VALUE,
    @ProtoNumber(2) val peerUid: String? = null,
    @ProtoNumber(3) val flag: Int = Int.MIN_VALUE,
    @ProtoNumber(5) val receiver: Long? = null,
    @ProtoNumber(6) val receiverUid: String? = null,
)

@Serializable
data class MessageContentHead(
    @ProtoNumber(1) val msgType: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val msgSubType: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val u1: Long = Long.MIN_VALUE,
    @ProtoNumber(5) val msgSeq: Long = Long.MIN_VALUE,
    @ProtoNumber(6) val msgTime: Long? = null,
    @ProtoNumber(7) val u2: Int? = null,
    @ProtoNumber(11) val u3: Long? = null,
    @ProtoNumber(12) val msgRandom: Long = Long.MIN_VALUE,
    @ProtoNumber(14) val u4: Long? = null,
    @ProtoNumber(28) val u5: Long? = null,
)