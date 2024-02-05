package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.qqinterface.servlet.structures.GProChannelInfo
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_channel_list")
internal object GetGProChannelList: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id")
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))
        return invoke(guildId.toULong(), refresh, echo = session.echo)
    }

    suspend operator fun invoke(guildId: ULong, refresh: Boolean, echo: JsonElement = EmptyJsonString): String {
        val result = withTimeoutOrNull(5000) {
            GProSvc.getChannelList(guildId, refresh)
        } ?: return error("timeout", echo)
        result.onFailure {
            return error(it.message ?: "unable to fetch channel list", echo)
        }
        return ok(GuildChannelListResult(result.getOrThrow()), echo, "success")
    }

    override val requiredParams: Array<String> = arrayOf("guild_id")

    @Serializable
    data class GuildChannelListResult(
        @SerialName("channel_list") val channelList: List<GProChannelInfo>
    )
}