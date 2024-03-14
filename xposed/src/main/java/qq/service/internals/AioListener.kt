@file:OptIn(DelicateCoroutinesApi::class)

package qq.service.internals

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter
import qq.service.kernel.SimpleKernelMsgListener
import qq.service.msg.MessageHelper

object AioListener: SimpleKernelMsgListener() {
    override fun onRecvMsg(records: ArrayList<MsgRecord>) {
        records.forEach {
            GlobalScope.launch {
                try {
                    onMsg(it)
                } catch (e: Exception) {
                    LogCenter.log("OnMessage: " + e.stackTraceToString(), Level.WARN)
                }
            }
        }
    }

    private suspend fun onMsg(record: MsgRecord) {
        when (record.chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
                LogCenter.log("群消息(group = ${record.peerName}(${record.peerUin}), uin = ${record.senderUin}, id = ${record.msgId})")

                if (!GlobalEventTransmitter.MessageTransmitter.transGroupMessage(record, record.elements)) {
                    LogCenter.log("群消息推送失败 -> 推送目标可能不存在", Level.WARN)
                }
            }

            MsgConstant.KCHATTYPEC2C -> {
                LogCenter.log("私聊消息(private = ${record.senderUin}, id = [${record.msgId} | ${record.msgSeq}])")

                if (!GlobalEventTransmitter.MessageTransmitter.transPrivateMessage(
                        record, record.elements
                    )
                ) {
                    LogCenter.log("私聊消息推送失败 -> MessageTransmitter", Level.WARN)
                }
            }

            MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> {
                var groupCode = 0L
                var fromNick = ""
                MessageHelper.getTempChatInfo(record.chatType, record.senderUid).onSuccess {
                    groupCode = it.groupCode.toLong()
                    fromNick = it.fromNick
                }

                LogCenter.log("私聊临时消息(private = ${record.senderUin}, groupId=$groupCode)")

                if (!GlobalEventTransmitter.MessageTransmitter.transTempMessage(record, record.elements, groupCode, fromNick)
                ) {
                    LogCenter.log("私聊临时消息推送失败 -> MessageTransmitter", Level.WARN)
                }
            }

            MsgConstant.KCHATTYPEGUILD -> {
                LogCenter.log("频道消息(guildId = ${record.guildId}, sender = ${record.senderUid}, id = [${record.msgId}])")
                if (!GlobalEventTransmitter.MessageTransmitter
                        .transGuildMessage(record, record.elements)
                ) {
                    LogCenter.log("频道消息推送失败 -> MessageTransmitter", Level.WARN)
                }
            }

            else -> LogCenter.log("不支持PUSH事件: ${record.chatType}")
        }
    }
}