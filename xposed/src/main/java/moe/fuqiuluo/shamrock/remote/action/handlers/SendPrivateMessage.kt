package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.jsonArray

internal object SendPrivateMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id")
        val groupId = session.getStringOrNull("group_id")
        val chatType = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP
        val retryCnt = session.getIntOrNull("retry_cnt")
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            SendMessage.invoke(
                chatType = chatType,
                peerId = userId,
                message = message,
                autoEscape = autoEscape,
                echo = session.echo,
                fromId = groupId ?: userId,
                retryCnt = retryCnt ?: 3
            )
        } else if (session.isArray("message")) {
            val message = session.getArray("message")
            SendMessage(
                chatType = chatType,
                peerId = userId,
                message = message,
                echo = session.echo,
                fromId = groupId ?: userId,
                retryCnt = retryCnt ?: 3
            )
        } else {
            val message = session.getObject("message")
            SendMessage(
                chatType = chatType,
                peerId = userId,
                message = listOf( message ).jsonArray,
                echo = session.echo,
                fromId = groupId ?: userId,
                retryCnt = retryCnt ?: 3
            )
        }
    }

    override val requiredParams: Array<String> = arrayOf("message", "user_id")

    override fun path(): String = "send_private_message"

    override val alias: Array<String>
        get() = arrayOf("send_private_msg")
}