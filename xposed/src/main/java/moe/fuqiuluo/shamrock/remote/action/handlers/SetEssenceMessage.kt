package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("set_essence_msg", ["set_essence_message"])
internal object SetEssenceMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val messageId = session.getInt("message_id")
        return invoke(messageId, session.echo)
    }

    suspend operator fun invoke(messageId: Int, echo: JsonElement = EmptyJsonString): String {
        val msg = MsgSvc.getMsg(messageId).onFailure {
            return logic("Obtain msg failed, please check your msg_id.", echo)
        }.getOrThrow()
        val (success, tip) = GroupSvc.setEssenceMessage(
            groupId = if (msg.chatType == MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0,
            seq = msg.msgSeq,
            rand = msg.msgRandom
        )
        return if (success) {
            ok("成功", echo)
        } else {
            logic(tip, echo)
        }
    }
}