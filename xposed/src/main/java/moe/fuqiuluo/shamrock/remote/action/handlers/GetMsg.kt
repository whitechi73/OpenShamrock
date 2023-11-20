package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.MessageDetail
import moe.fuqiuluo.shamrock.remote.service.data.MessageSender
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.MessageConvert
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val hashCode = session.getIntOrNull("message_id")
            ?: session.getInt("msg_id")
        return invoke(hashCode, session.echo)
    }

    suspend operator fun invoke(msgHash: Int, echo: JsonElement = EmptyJsonString): String {
        val msg = MsgSvc.getMsg(msgHash).onFailure {
            return logic("Obtain msg failed, please check your msg_id.", echo)
        }.getOrThrow()
        val seq = msg.msgSeq.toInt()
        return ok(MessageDetail(
            time = msg.msgTime.toInt(),
            msgType = MessageHelper.obtainDetailTypeByMsgType(msg.chatType),
            msgId = msgHash,
            realId = seq,
            sender = MessageSender(
                msg.senderUin, msg.sendNickName, "unknown", 0, msg.senderUid
            ),
            message = MessageConvert.convertMessageRecordToMsgSegment(msg).map {
                it.toJson()
            },
            peerId = msg.peerUin,
            groupId = if (msg.chatType == MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0,
            targetId = if (msg.chatType != MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("message_id")

    override val alias: Array<String> = arrayOf("get_message")

    override fun path(): String = "get_msg"
}