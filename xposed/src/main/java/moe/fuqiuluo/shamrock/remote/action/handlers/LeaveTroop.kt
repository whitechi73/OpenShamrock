package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("leave_group", ["set_group_leave"])
internal object LeaveTroop: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        return invoke(groupId, session.echo)
    }

    operator fun invoke(groupId: Long, echo: JsonElement = EmptyJsonString): String {
        if (GroupSvc.isOwner(groupId)) {
            return error("you are the owner of this group", echo)
        }
        GroupSvc.resignTroop(groupId)
        return ok("成功", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")
}