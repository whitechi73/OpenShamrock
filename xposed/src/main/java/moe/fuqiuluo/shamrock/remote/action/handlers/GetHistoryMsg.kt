package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.MessageConvert
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.MessageDetail
import moe.fuqiuluo.shamrock.remote.service.data.MessageSender
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import java.util.ArrayList
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal object GetHistoryMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val msgType = session.getString("message_type")
        val peerId = session.getString(if (msgType == "group") "group_id" else "user_id")
        val cnt = session.getIntOrNull("count") ?: 20

        val startId = session.getIntOrNull("message_seq")?.let {
            if (it == 0) return@let 0L
            MessageDB.getInstance()
                .messageMappingDao()
                .queryByMsgHashId(it)?.qqMsgId
        } ?: 0L

        return invoke(msgType, peerId, cnt, startId, echo = session.echo)
    }

    suspend operator fun invoke(
        msgType: String,
        peerId: String,
        cnt: Int,
        startMsgId: Long = 0,
        echo: JsonElement = EmptyJsonString
    ): String {
        val msgService = NTServiceFetcher.kernelService.wrapperSession.msgService
        val chatType = MessageHelper.obtainMessageTypeByDetailType(msgType)
        val contact = MessageHelper.generateContact(chatType, peerId)
        val result = suspendCoroutine {
            msgService.getMsgs(contact, startMsgId, cnt, true) { code, why, msgs ->
                it.resume(GetMsgResult(code, why, msgs))
            }
        }
        if (result.code != 0) {
            return logic(result.msg ?: "获取历史消息失败", echo = echo)
        }

        val msgList = ArrayList<MessageDetail>().apply {
            addAll(result.data!!.map { msg ->
                val msgHash = MessageHelper.generateMsgIdHash(msg.chatType, msg.msgId)
                MessageDetail(
                    time = msg.msgTime.toInt(),
                    msgType = MessageHelper.obtainDetailTypeByMsgType(msg.chatType),
                    msgId = msgHash,
                    realId = msg.msgSeq.toInt(),
                    sender = MessageSender(
                        msg.senderUin, msg.sendNickName, "unknown", 0, msg.senderUid
                    ),
                    message = MessageConvert.convertMessageRecordToMsgSegment(msg).map {
                        it.toJson()
                    },
                    peerId = msg.peerUin,
                    groupId = if (msg.chatType == MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0,
                    targetId = if (msg.chatType != MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0
                )
            })
            if (startMsgId != 0L) {
                val msg = MsgSvc.getMsgByQMsgId(chatType, peerId, startMsgId).onFailure {
                    return logic("Obtain msg failed, please check your msg_id.", echo)
                }.getOrThrow()
                val seq = msg.clientSeq.toInt()
                add(MessageDetail(
                    time = msg.msgTime.toInt(),
                    msgType = MessageHelper.obtainDetailTypeByMsgType(msg.chatType),
                    msgId = MessageHelper.generateMsgIdHash(msg.chatType, msg.msgId),
                    realId = seq,
                    sender = MessageSender(
                        msg.senderUin, msg.sendNickName
                            .ifBlank { msg.sendMemberName }
                            .ifBlank { msg.sendRemarkName }
                            .ifBlank { msg.peerName }, "unknown", 0, msg.senderUid
                    ),
                    message = MessageConvert.convertMessageRecordToMsgSegment(msg).map {
                        it.toJson()
                    },
                    peerId = msg.peerUin,
                    groupId = if (msg.chatType == MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0,
                    targetId = if (msg.chatType != MsgConstant.KCHATTYPEGROUP) msg.peerUin else 0
                ))
            }
        }

        return ok(data = GetHistoryMsgResult(msgList), echo = echo)
    }

    override val requiredParams: Array<String>
        get() = arrayOf("message_type")

    override fun path(): String = "get_history_msg"

    @Serializable
    data class GetHistoryMsgResult(
        @SerialName("messages") val msgs: List<MessageDetail>
    )

    data class GetMsgResult(
        val code: Int,
        val msg: String?,
        val data: ArrayList<MsgRecord>?
    )
}