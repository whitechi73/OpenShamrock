package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_guild_member_list")
internal object GetGuildMemberList: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id")
        return invoke(guildId.toULong(), session.echo)
    }

    suspend operator fun invoke(guildId: ULong, echo: JsonElement = EmptyJsonString): String {
        GProSvc.getGuildMemberList(guildId)
        return ""
    }

    override val requiredParams: Array<String> = arrayOf("guild_id")
}