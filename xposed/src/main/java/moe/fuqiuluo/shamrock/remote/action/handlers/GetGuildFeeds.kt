package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler
import protobuf.guild.StFeed

@OneBotHandler("get_guild_feeds")
internal object GetGuildFeeds: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val channelId = session.getStringOrNull("channel_id")?.toULong() ?: 0uL
        val from = session.getIntOrNull("from") ?: 0
        return invoke(guildId, channelId, from, session.echo)
    }

    suspend operator fun invoke(guildId: ULong, channelId: ULong, startIndex: Int, echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.getGuildFeeds(guildId, channelId, startIndex).getOrElse {
            GProSvc.getGuildFeeds(guildId, 0uL, startIndex).onFailure {
                return error(it.message ?: "server error", echo)
            }.getOrThrow()
        }
        if (result.vecFeed == null) {
            return error("server error", echo)
        }
        return ok(GetGuildFeedsResult(result.isFinish == 1, result.vecFeed!!), echo = echo)
    }

    @Serializable
    data class GetGuildFeedsResult(
        val isFinish: Boolean,
        val feeds: List<StFeed>
    )
}