package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_msg_history", ["get_group_message_history"])
internal object GetGroupMsgHistory: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val cnt = session.getIntOrNull("count") ?: 20
        val startId = session.getIntOrNull("message_id")?.let {
            if (it == 0) return@let 0L
            MessageDB.getInstance()
                .messageMappingDao()
                .queryByMsgHashId(it)?.qqMsgId
        } ?: session.getIntOrNull("message_seq")?.let {
            if (it == 0) return@let 0L
            MessageDB.getInstance()
                .messageMappingDao()
                .queryByMsgSeq(MsgConstant.KCHATTYPEGROUP, groupId.toString(), it)?.qqMsgId
        } ?: 0L
        return GetHistoryMsg("group", groupId.toString(), cnt, startId, session.echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")
}