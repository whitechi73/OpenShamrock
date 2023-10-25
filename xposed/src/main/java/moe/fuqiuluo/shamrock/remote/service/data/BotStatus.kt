package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BotStatus(
    val self: Self,
    val online: Boolean,
    val good: Boolean,
    @SerialName("qq.status")
    val status: String
)

@Serializable
data class Self(
    val platform: String,
    @SerialName("user_id")
    val userId: Long
)

@Serializable
data class UserDetail(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userName: String,
    @SerialName("user_displayname")
    val userDisplayName: String
)