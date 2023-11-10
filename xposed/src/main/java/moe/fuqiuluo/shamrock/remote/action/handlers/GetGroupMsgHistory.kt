package moe.fuqiuluo.shamrock.remote.action.handlers

import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler

internal object GetGroupMsgHistory: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val cnt = session.getIntOrNull("count") ?: 20
        val startId = session.getIntOrNull("message_seq")?.let {
            if (it == 0) return@let 0L
            MessageDB.getInstance()
                .messageMappingDao()
                .queryByMsgHashId(it)?.qqMsgId
        } ?: 0L
        return GetHistoryMsg("group", groupId, cnt, startId, session.echo)
    }

    override val requiredParams: Array<String>
        get() = arrayOf("group_id")

    override fun path(): String = "get_group_msg_history"
}