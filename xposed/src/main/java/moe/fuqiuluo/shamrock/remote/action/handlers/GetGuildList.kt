package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.qqinterface.servlet.structures.GuildInfo
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonArray
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.symbols.OneBotHandler
import mqq.app.MobileQQ

@OneBotHandler("get_guild_list")
internal object GetGuildList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val oldSdk = session.getBooleanOrDefault("old_sdk", false)
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))
        return invoke(refresh, oldSdk, echo = session.echo)
    }

    operator fun invoke(refresh: Boolean = true, oldSdk: Boolean, echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.getGuildList(refresh, oldSdk)
        return ok(GuildListResult(result), echo, "success")
    }

    @Serializable
    data class GuildListResult(
        @SerialName("guild_list") var guildList: List<GuildInfo> = arrayListOf()
    )
}