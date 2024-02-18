@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.message.longmsg

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import protobuf.message.MessageBody
import protobuf.message.MessageContent
import protobuf.message.MessageHead

@Serializable
data class PushMsgBody(
    @ProtoNumber(1) val head: MessageHead? = null,
    @ProtoNumber(2) val content: MessageContent? = null,
    @ProtoNumber(3) val body: MessageBody? = null
)

@Serializable
data class LongMsgContent(
    @ProtoNumber(1) val body: List<PushMsgBody>? = null
)

@Serializable
data class LongMsgAction(
    @ProtoNumber(1) val command: String? = null,
    @ProtoNumber(2) val data: LongMsgContent? = null
)
@Serializable
data class LongMsgPayload(
    @ProtoNumber(2) val action: LongMsgAction? = null
)