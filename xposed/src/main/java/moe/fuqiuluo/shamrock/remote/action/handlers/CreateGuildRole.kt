@file:Suppress("UNCHECKED_CAST")

package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("create_guild_role")
internal object CreateGuildRole: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val name = session.getString("name")
        val color = session.getLong("color")
        val initialUsers = session.getArray("initial_users").map {
            it.asString.toULong()
        }
        return invoke(guildId, color, name, initialUsers, session.echo)
    }

    suspend operator fun invoke(guildId: ULong, color: Long, name: String, initialUsers: List<ULong>, echo: JsonElement = EmptyJsonString): String {
        val result = GProSvc.createGuildRole(guildId, name, color, initialUsers as ArrayList<Long>).onFailure {
            return error(it.message ?: "Unknown error", echo)
        }.getOrThrow()
        return ok(data = CreateGuildRoleResult(
            result.roleId.toULong()
        ), echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id", "color", "name", "initial_users")

    @Serializable
    data class CreateGuildRoleResult(
        @SerialName("role_id") val roleId: ULong
    )
}