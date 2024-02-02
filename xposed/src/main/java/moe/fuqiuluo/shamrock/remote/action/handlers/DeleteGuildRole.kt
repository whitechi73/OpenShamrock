package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("delete_guild_role")
internal object DeleteGuildRole: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val roleId = session.getString("role_id").toULong()
        return invoke(guildId, roleId, session.echo)
    }

    operator fun invoke(guildId: ULong, roleId: ULong, echo: JsonElement = EmptyJsonString): String {
        GProSvc.deleteGuildRole(guildId, roleId)
        return ok("success", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id", "role_id")
}