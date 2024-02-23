package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.MessageDetail
import moe.fuqiuluo.shamrock.remote.service.data.MessageSender
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.toSegments
import moe.fuqiuluo.qqinterface.servlet.msg.toListMap
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_message", ["get_msg"])
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
                msg.senderUin, msg.sendNickName
                    .ifEmpty { msg.sendMemberName }
                    .ifEmpty { msg.sendRemarkName }
                    .ifEmpty { msg.peerName }, "unknown",
                0,
                msg.senderUid,
                msg.senderUid
            ),
            message = msg.elements.toSegments(
                msg.chatType,
                if (msg.chatType == MsgConstant.KCHATTYPEGUILD) msg.guildId else msg.peerUin.toString(),
                msg.channelId ?: msg.peerUin.toString()
            ).toListMap(),
            peerId = msg.peerUin,
            groupId = if (msg.chatType == MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0,
            targetId = if (msg.chatType != MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("message_id")
}