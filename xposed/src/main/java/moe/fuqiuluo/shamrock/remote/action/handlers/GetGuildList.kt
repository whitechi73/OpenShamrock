package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonArray
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetGuildList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(echo = session.echo)
    }

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        // TODO: get_guild_list
        return ok(EmptyJsonArray, echo, "此功能尚未实现")
    }

    override fun path(): String = "get_guild_list"
}