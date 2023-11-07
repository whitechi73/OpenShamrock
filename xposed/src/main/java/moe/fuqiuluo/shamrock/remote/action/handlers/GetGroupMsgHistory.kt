package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler

internal object GetGroupMsgHistory: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val cnt = session.getIntOrNull("count") ?: 20
        return GetHistoryMsg("group", groupId, cnt, session.echo)
    }

    override val requiredParams: Array<String>
        get() = arrayOf("group_id")

    override fun path(): String = "get_group_msg_history"
}