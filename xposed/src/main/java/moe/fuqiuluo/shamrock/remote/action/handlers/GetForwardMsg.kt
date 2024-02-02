package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.MessageConvert
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.MessageDetail
import moe.fuqiuluo.shamrock.remote.service.data.MessageSender
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_forward_msg")
internal object GetForwardMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val id = session.getString("id")
        return invoke(id, session.echo)
    }

    suspend operator fun invoke(
        resId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        val result = MsgSvc.getMultiMsg(resId)
        if (result.isFailure) {
            return logic(result.exceptionOrNull().toString(), echo)
        }

        return ok(data = GetForwardMsgResult(result.getOrThrow().map { msg ->
            val msgHash = MessageHelper.generateMsgIdHash(msg.chatType, msg.msgId)
            MessageDetail(
                time = msg.msgTime.toInt(),
                msgType = MessageHelper.obtainDetailTypeByMsgType(msg.chatType),
                msgId = msgHash,
                realId = msg.msgSeq.toInt(),
                sender = MessageSender(
                    msg.senderUin, msg.sendNickName
                        .ifEmpty { msg.sendMemberName }
                        .ifEmpty { msg.sendRemarkName }
                        .ifEmpty { msg.peerName }, "unknown", 0, msg.senderUid, msg.senderUid
                ),
                message = MessageConvert.convertMessageRecordToMsgSegment(msg).map {
                    it.toJson()
                },
                peerId = msg.peerUin,
                groupId = if (msg.chatType == MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0,
                targetId = if (msg.chatType != MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0
            )
        }), echo = echo)
    }

    @Serializable
    data class GetForwardMsgResult(
        @SerialName("messages") val msgs: List<MessageDetail>
    )

    override val requiredParams: Array<String> = arrayOf("id")
}