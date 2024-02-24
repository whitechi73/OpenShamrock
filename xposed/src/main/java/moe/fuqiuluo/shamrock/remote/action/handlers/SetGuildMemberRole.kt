package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_guild_member_role")
internal object SetGuildMemberRole: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val role = session.getString("role_id").toULong()
        val set = session.getBooleanOrDefault("set", false)
        return if (session.has("user_id")) {
            val userId = session.getLong("user_id").toULong()
            invoke(guildId, userId, role, set, echo = session.echo)
        } else if (session.isArray("users")) {
            invoke(guildId, session.getArray("users").map {
                it.asString.toULong()
            }, role, set, echo = session.echo)
        } else {
            logic("missing user_id or users", echo = session.echo)
        }
    }

    operator fun invoke(guildId: ULong, users: List<ULong>, roleId: ULong, set: Boolean, echo: JsonElement = EmptyJsonString): String {
        users.forEach {
            GProSvc.setMemberRole(guildId, it, roleId, set)
        }
        return ok("success", echo = echo)
    }

    operator fun invoke(guildId: ULong, user: ULong, roleId: ULong, set: Boolean, echo: JsonElement = EmptyJsonString): String {
        GProSvc.setMemberRole(guildId, user, roleId, set)
        return ok("success", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id", "role_id")
}