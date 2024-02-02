package moe.fuqiuluo.shamrock.remote.service.data.push

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
internal enum class MsgSubType {
    /**
     * 群聊子类型
     */
    @SerialName("normal") NORMAL,
    @SerialName("anonymous") ANONYMOUS,
    @SerialName("notice") NOTICE,
    @SerialName("group_self") GroupSelf,

    /**
     * 私聊子类型
     */
    @SerialName("group") GroupLess,
    @SerialName("friend") Friend,
    @SerialName("other") Other,

    @SerialName("channel") Channel
}

@Serializable
internal enum class MsgType {
    @SerialName("group") Group,
    @SerialName("private") Private,
    @SerialName("guild") Guild
}

@Serializable
internal enum class PostType {
    @SerialName("meta_event") Meta,
    @SerialName("notice") Notice,
    @SerialName("request") Request,
    @SerialName("message") Msg,
    @SerialName("message_sent") MsgSent,
}

/**
 * 不要使用继承的方式实现通用字段，那样会很难维护！
 */
@Serializable
internal data class MessageEvent (
    @SerialName("time") val time: Long,
    @SerialName("self_id") val selfId: Long,
    @SerialName("post_type") val postType: PostType,
    @SerialName("message_type") val messageType: MsgType,
    @SerialName("sub_type") val subType: MsgSubType,
    @SerialName("message_id") val messageId: Int,
    @SerialName("group_id") val groupId: Long = 0,
    @SerialName("target_id") val targetId: Long = 0,
    @SerialName("peer_id") val peerId: Long,
    @SerialName("user_id") val userId: Long,
    @SerialName("anonymous") val anonymous: Anonymous? = null,
    @SerialName("message") val message: JsonElement,
    @SerialName("raw_message") val rawMessage: String,
    @SerialName("font") val font: Int,
    @SerialName("sender") val sender: Sender,
    @SerialName("temp_source") val tmpSource: Int = -1
)

enum class MessageTempSource(val id: Int) {
    Group(0),
    Consultation(1),
    Seek(2),
    QQMovie(3),
    HotChat(4),
    VerifyMsg(6),
    Discussion(7),
    Dating(8),
    Contact(9),
    Unknown(-1),
}

@Serializable
internal data class Anonymous(
    @SerialName("name") val name: String
)

@Serializable
internal enum class MemberRole {
    @SerialName("owner") Owner,
    @SerialName("admin") Admin,
    @SerialName("member") Member
}

@Serializable
internal data class Sender(
    @SerialName("user_id") val userId: Long,
    @SerialName("nickname") val nickname: String,
    @SerialName("card") val card: String,
    @SerialName("role") val role: MemberRole?,
    @SerialName("title") val title: String,
    @SerialName("level") val level: String,
    @SerialName("tiny_id") val tinyId: String = "0",
)