package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler

internal object SendPrivateMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id")
        val groupId = session.getStringOrNull("group_id")
        val chatTYpe = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            SendMessage(chatTYpe, userId, message, autoEscape, echo = session.echo, fromId = groupId ?: userId)
        } else {
            val message = session.getArray("message")
            SendMessage(chatTYpe, userId, message, session.echo, fromId = groupId ?: userId)
        }
    }

    override val requiredParams: Array<String> = arrayOf("message", "user_id")

    override fun path(): String = "send_private_message"

    override val alias: Array<String>
        get() = arrayOf("send_private_msg")
}