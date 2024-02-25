package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.jsonArray
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_private_msg", ["send_private_message", "send_friend_msg"])
internal object SendPrivateMessage : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id").let {
            if (it == "self") TicketSvc.getUin() else it
        }
        val groupId = session.getLongOrNull("group_id")
        val chatType = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP
        val retryCnt = session.getIntOrNull("retry_cnt")
        val recallDuration = session.getLongOrNull("recall_duration")
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            SendMessage(
                chatType = chatType,
                peerId = userId,
                message = message,
                autoEscape = autoEscape,
                echo = session.echo,
                fromId = groupId?.toString() ?: userId,
                retryCnt = retryCnt ?: 5,
                recallDuration = recallDuration
            )
        } else {
            SendMessage(
                chatType = chatType,
                peerId = userId,
                message = if (session.isArray("message")) session.getArray("message") else listOf(session.getObject("message")).jsonArray,
                echo = session.echo,
                fromId = groupId?.toString() ?: userId,
                retryCnt = retryCnt ?: 5,
                recallDuration = recallDuration
            )
        }
    }

    override val requiredParams: Array<String> = arrayOf("message", "user_id")
}