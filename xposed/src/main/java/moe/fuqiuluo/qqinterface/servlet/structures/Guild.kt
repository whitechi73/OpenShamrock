package moe.fuqiuluo.qqinterface.servlet.structures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.fuqiuluo.symbols.Protobuf

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

@Serializable
data class GProChannelInfo(
    @SerialName("owner_guild_id") val ownerGuildId: ULong,
    @SerialName("channel_id") val channelId: Long,
    @SerialName("channel_uin") val channelUin: Long,
    @SerialName("guild_id") val guildId: String,
    @SerialName("channel_type") val channelType: Int,
    @SerialName("channel_name") val channelName: String,
    @SerialName("create_time") val createTime: Long,
    @SerialName("max_member_count") val maxMemberCount: Int,
    @SerialName("creator_tiny_id") val creatorTinyId: Long,
    @SerialName("talk_permission") val talkPermission: Int,
    @SerialName("visible_type") val visibleType: Int,
    @SerialName("current_slow_mode") val currentSlowMode: Int,
    @SerialName("slow_modes") val slowModes: List<SlowModeInfo>,
    @SerialName("icon_url") val appIconUrl: String? = null,
    @SerialName("jump_switch") val jumpSwitch: Int = Int.MIN_VALUE,
    @SerialName("jump_type") val jumpType: Int = Int.MIN_VALUE,
    @SerialName("jump_url") val jumpUrl: String? = null,
    @SerialName("category_id") val categoryId: Long = Long.MIN_VALUE,
    @SerialName("my_talk_permission") val myTalkPermission: Int = Int.MIN_VALUE,
)

@Serializable
data class SlowModeInfo(
    @SerialName("slow_mode_key") val slowModeKey: Int,
    @SerialName("slow_mode_text") val slowModeText: String,
    @SerialName("speak_frequency") val speakFrequency: Int,
    @SerialName("slow_mode_circle") val slowModeCircle: Int
)

@Serializable
data class GetGuildMemberListNextToken(
    @SerialName("start_index") val startIndex: Long,
    @SerialName("role_index") val roleIndex: Long,
    @SerialName("seq") val seq: Int,
    @SerialName("finish") val finish: Boolean
): Protobuf<GetGuildMemberListNextToken>

@Serializable
data class GuildMemberInfo(
    @SerialName("tiny_id") val tinyId: Long,
    @SerialName("title") val title: String,
    @SerialName("nickname") val nickname: String,
    @SerialName("role_id") val roleId: Long,
    @SerialName("role_name") val roleName: String,
    @SerialName("role_color") val roleColor: Long,
    @SerialName("join_time") val joinTime: Long,
    @SerialName("robot_type") val robotType: Int,
    @SerialName("type") val type: Int,
    @SerialName("in_black") val inBlack: Boolean,
    @SerialName("platform") val platform: Int,
)

