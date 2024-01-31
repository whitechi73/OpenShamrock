package moe.fuqiuluo.qqinterface.servlet.structures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildInfo(
    @SerialName("guild_id") var guildId: Long,
    @SerialName("guild_name") var guildName: String,
    @SerialName("guild_display_id") var guildDisplayId: String,
    @SerialName("profile") var profile: String,
    @SerialName("status") var status: GuildStatus,
    @SerialName("owner_id") var ownerId: Long,
    @SerialName("shutup_expire_time") var shutUpTime: Long,
    @SerialName("allow_search") var allowSearch: Boolean
)

@Serializable
data class GuildStatus(
    @SerialName("is_enable") var isEnable: Boolean,
    @SerialName("is_banned") var isBanned: Boolean,
    @SerialName("is_frozen") var isFrozen: Boolean
)