package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_kick", ["kick_group_member"])
internal object KickTroopMember: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val userId = session.getLong("user_id")
        val kickMsg = session.getStringOrNull("kick_msg") ?: ""
        val rejectAddRequest = session.getBooleanOrDefault("reject_add_request", false)

        return invoke(groupId, userId, rejectAddRequest, kickMsg, session.echo)
    }

    operator fun invoke(groupId: Long, userId: Long, rejectAddRequest: Boolean = false, kickMsg: String, echo: JsonElement = EmptyJsonString): String {
        GroupSvc.kickMember(groupId, rejectAddRequest, kickMsg, userId)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "user_id")
}