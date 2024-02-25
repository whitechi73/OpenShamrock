package moe.fuqiuluo.qqinterface.servlet

import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.ktor.utils.io.core.BytePacketBuilder
import io.ktor.utils.io.core.readBytes
import io.ktor.utils.io.core.writeFully
import io.ktor.utils.io.core.writeInt
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.qqinterface.servlet.msg.MessageTempHandler

import moe.fuqiuluo.shamrock.remote.action.handlers.GetHistoryMsg
import moe.fuqiuluo.shamrock.remote.service.listener.AioListener
import moe.fuqiuluo.shamrock.tools.broadcast
import moe.fuqiuluo.shamrock.utils.DeflateTools
import protobuf.message.element.LightAppElem
import protobuf.message.PushMsgBody
import protobuf.message.ContentHead
import protobuf.message.Elem
import protobuf.message.RichText
import protobuf.message.ResponseHead
import protobuf.message.MsgBody
import protobuf.push.MessagePush
import mqq.app.MobileQQ
import protobuf.auto.toByteArray
import kotlin.coroutines.resume

internal object PacketSvc: BaseSvc() {
    /**
     * 伪造收到Json卡片消息
     */
    suspend fun fakeSelfRecvJsonMsg(msgService: IKernelMsgService, content: String): Long {
        return fakeReceiveSelfMsg(msgService) {
            listOf(
                Elem(
                    lightApp = LightAppElem((byteArrayOf(1) + DeflateTools.compress(content.toByteArray())))
            )
            )
        }
    }

    private suspend fun fakeReceiveSelfMsg(msgService: IKernelMsgService, builder: () -> List<Elem>): Long {
        val latestMsg = withTimeoutOrNull(3000) {
            suspendCancellableCoroutine {
                msgService.getMsgs(Contact(MsgConstant.KCHATTYPEC2C, app.currentUid, ""), 0L, 1, true) { code, why, msgs ->
                    it.resume(GetHistoryMsg.GetMsgResult(code, why, msgs))
                }
            }
        }?.data?.firstOrNull()
        val msgSeq = (latestMsg?.msgSeq ?: 0) + 1

        val msgPush = MessagePush(
            msgBody = PushMsgBody(
                msgHead = ResponseHead(
                    peer = app.longAccountUin,
                    peerUid = app.currentUid,
                    flag = 1001,
                    receiver = app.longAccountUin,
                    receiverUid = app.currentUid
                ),
                contentHead = ContentHead(
                    msgType = 166,
                    msgSubType = 11,
                    msgSeq = msgSeq,
                    msgViaRandom = msgSeq,
                    msgTime = System.currentTimeMillis() / 1000,
                    u2 = 1,
                    sequence = msgSeq,
                    msgRandom = msgService.getMsgUniqueId(System.currentTimeMillis()),
                    u4 = msgSeq - 2,
                    u5 = msgSeq
                ),
                body = MsgBody(RichText(
                    elements = builder()
                ))
            )
        )

        fakeReceive("trpc.msg.olpush.OlPushService.MsgPush", 10000, msgPush.toByteArray())
        return withTimeoutOrNull(5000L) {
            suspendCancellableCoroutine {
                MessageTempHandler.registerTemporaryMsgListener(msgSeq) {
                    it.resume(this.msgId)
                }
                it.invokeOnCancellation {
                    MessageTempHandler.unregisterTemporaryMsgListener(msgSeq)
                }
            }
        } ?: -1L
    }

    /**
     * 伪造QQ收到某个包
     */
    private fun fakeReceive(cmd: String, seq: Int, buffer: ByteArray) {
        MobileQQ.getContext().broadcast("msf") {
            putExtra("__cmd", "fake_packet")
            putExtra("package_cmd", cmd)
            putExtra("package_uin", app.currentUin)
            putExtra("package_seq", seq)
            val wupBuffer = BytePacketBuilder().apply {
                writeInt(buffer.size + 4)
                writeFully(buffer)
            }.build()
            putExtra("package_buffer", wupBuffer.readBytes())
            wupBuffer.release()
        }
    }
}