package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.jsonArray
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_group_message", ["send_group_msg"])
internal object SendGroupMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val retryCnt = session.getIntOrNull("retry_cnt")
        val recallDuration = session.getLongOrNull("recall_duration")
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, message, autoEscape, echo = session.echo, retryCnt = retryCnt ?: 3, recallDuration = recallDuration)
        } else if (session.isObject("message")) {
            val message = session.getObject("message")
            SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, listOf( message ).jsonArray, session.echo, retryCnt = retryCnt ?: 3, recallDuration = recallDuration)
        } else {
            val message = session.getArray("message")
            SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, message, session.echo, retryCnt = retryCnt ?: 3, recallDuration = recallDuration)
        }
    }

    override val requiredParams: Array<String> = arrayOf("message", "group_id")
}