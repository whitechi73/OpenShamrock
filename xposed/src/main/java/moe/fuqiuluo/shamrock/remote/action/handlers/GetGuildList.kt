package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonArray
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_list")
internal object GetGuildList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(echo = session.echo)
    }

    operator fun invoke(refresh: Boolean = true, echo: JsonElement = EmptyJsonString): String {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        if (refresh) {
            kernelGProService.refreshGuildList(true)
        }
        val result = arrayListOf<GuildInfo>()
        kernelGProService.guildListFromCache.forEach {
            if (it.result != 0) return@forEach
            val guildInfo = it.guildInfo
            result.add(
                GuildInfo(
                guildId = it.guildId,
                guildName = guildInfo.guildName ?: "",
                guildDisplayId = guildInfo.guildNumber ?: "",
                profile = guildInfo.profile ?: "",
                status = GuildStatus(
                    isEnable = guildInfo.guildStatus?.isEnable == 1,
                    isBanned = guildInfo.guildStatus?.isBanned == 1,
                    isFrozen = guildInfo.guildStatus?.isFrozen == 1
                ),
                ownerId = guildInfo.ownerTinyid,
                shutUpTime = guildInfo.shutupExpireTime
            ))
        }
        return ok(GuildListResult(
            result
        ), echo, "success")
    }

    @Serializable
    data class GuildListResult(
        @SerialName("guild_list") var guildList: List<GuildInfo> = arrayListOf()
    )

    @Serializable
    data class GuildInfo(
        @SerialName("guild_id") var guildId: Long,
        @SerialName("guild_name") var guildName: String,
        @SerialName("guild_display_id") var guildDisplayId: String,
        @SerialName("profile") var profile: String,
        @SerialName("status") var status: GuildStatus,
        @SerialName("owner_id") var ownerId: Long,
        @SerialName("shutup_expire_time") var shutUpTime: Long,
    )

    @Serializable
    data class GuildStatus(
        @SerialName("is_enable") var isEnable: Boolean,
        @SerialName("is_banned") var isBanned: Boolean,
        @SerialName("is_frozen") var isFrozen: Boolean
    )
}