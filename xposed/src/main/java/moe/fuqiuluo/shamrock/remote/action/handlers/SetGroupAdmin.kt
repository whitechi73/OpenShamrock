package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_admin")
internal object SetGroupAdmin: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val userId = session.getLong("user_id")
        val enable = session.getBoolean("enable")
        return invoke(groupId, userId, enable, session.echo)
    }

    operator fun invoke(groupId: Long, userId: Long, enable: Boolean, echo: JsonElement = EmptyJsonString): String {
        if (!GroupSvc.isOwner(groupId.toString())) {
            return logic("you are not owner", echo)
        }
        GroupSvc.setGroupAdmin(groupId, userId, enable)
        return ok("成功", echo)
    }
}