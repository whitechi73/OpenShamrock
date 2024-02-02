package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
internal data class MessageResult(
    @SerialName("message_id") val msgId: Int,
    @SerialName("time") val time: Long
)
@Serializable
internal data class ForwardMessageResult(
    @SerialName("message_id") val msgId: Int,
    @SerialName("forward_id") val forwardId: String
)

@Serializable
internal data class MessageDetail(
    @SerialName("time") val time: Int,
    @SerialName("message_type") val msgType: String,
    @SerialName("message_id") val msgId: Int,
    @SerialName("real_id") val realId: Int,
    @SerialName("sender") val sender: MessageSender,
    @SerialName("message") val message: List<Map<String, JsonElement>>,
    @SerialName("group_id") val groupId: Long = 0,
    @SerialName("peer_id") val peerId: Long,
    @SerialName("target_id") val targetId: Long = 0,
)

@Serializable
internal data class MessageSender(
    @SerialName("user_id") val userId: Long,
    @SerialName("nickname") val nickName: String,
    @SerialName("sex") val sex: String,
    @SerialName("age") val age: Int,
    @SerialName("uid") val uid: String,
    @SerialName("tiny_id") val tinyId: String,
)

@Serializable
internal data class EssenceMessage(
    @SerialName("sender_id") val senderId: Long,
    @SerialName("sender_nick") val senderNick: String,
    @SerialName("sender_time") val senderTime: Long,
    @SerialName("operator_id") val operatorId: Long,
    @SerialName("operator_nick") val operatorNick: String,
    @SerialName("operator_time") val operatorTime: Long,
    @SerialName("message_id") var messageId: Int,
    @SerialName("message_seq") val messageSeq: Int,
    @SerialName("message_content") val messageContent: JsonElement,
)