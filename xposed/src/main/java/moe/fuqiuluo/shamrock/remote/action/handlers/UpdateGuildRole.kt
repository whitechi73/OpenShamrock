package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("update_guild_role")
internal object UpdateGuildRole: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val roleId = session.getString("role_id").toULong()
        val name = session.getString("name")
        val color = session.getLong("color")
        return invoke(guildId, roleId, name, color, session.echo)
    }

    suspend operator fun invoke(guildId: ULong, roleId: ULong, name: String, color: Long, echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.updateGuildRole(guildId, roleId, name, color).onFailure {
            return error(it.message ?: "Unknown error", echo)
        }
        return ok("success", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("role_id", "guild_id", "name", "color")
}