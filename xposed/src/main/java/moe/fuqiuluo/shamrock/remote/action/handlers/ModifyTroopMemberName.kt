package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_group_card")
internal object ModifyTroopMemberName: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val userId = session.getLong("user_id")
        val name = session.getStringOrNull("card") ?: ""
        return invoke(groupId, userId, name, session.echo)
    }

    operator fun invoke(groupId: Long, userId: Long, card: String, echo: JsonElement = EmptyJsonString): String {
        if (!GroupSvc.isAdmin(groupId) && userId != TicketSvc.getUin().toLong()) {
            return logic("you are not admin", echo)
        }
        return if(GroupSvc.modifyGroupMemberCard(groupId, userId, card))
            ok("成功", echo)
        else error("check if member or group exist", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "user_id")
}