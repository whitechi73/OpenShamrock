package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler

internal object SendPrivateMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id")
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            SendMessage(MsgConstant.KCHATTYPEC2C, userId, message, autoEscape, session.echo)
        } else {
            val message = session.getArray("message")
            SendMessage(MsgConstant.KCHATTYPEC2C, userId, message, session.echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("message", "user_id")

    override fun path(): String = "send_private_message"

    override val alias: Array<String>
        get() = arrayOf("send_private_msg")
}