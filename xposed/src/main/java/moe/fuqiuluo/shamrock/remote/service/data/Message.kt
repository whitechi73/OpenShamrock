package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
internal data class MessageResult(
    @SerialName("message_id") val msgId: Int,
    @SerialName("time") val time: Double
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
)