package moe.fuqiuluo.shamrock.remote.action.handlers;

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_private_forward_msg")
internal object SendPrivateForwardMessage : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id")
        return if (session.isArray("messages")) {
            val messages = session.getArray("messages")
            SendForwardMessage(MsgConstant.KCHATTYPEC2C, userId, messages, echo = session.echo)
        } else {
            logic("未知格式合并转发消息", session.echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("messages", "user_id")
}