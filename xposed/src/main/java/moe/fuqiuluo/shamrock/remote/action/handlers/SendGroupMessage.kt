package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler

internal object SendGroupMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, message, autoEscape, echo = session.echo)
        } else {
            val message = session.getArray("message")
            SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, message, session.echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("message", "group_id")

    override fun path(): String = "send_group_message"

    override val alias: Array<String>
        get() = arrayOf("send_group_msg")
}