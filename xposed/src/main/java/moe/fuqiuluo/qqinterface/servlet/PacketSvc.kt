package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.msf.core.MsfCore
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.ktor.utils.io.core.BytePacketBuilder
import io.ktor.utils.io.core.readBytes
import io.ktor.utils.io.core.writeFully
import io.ktor.utils.io.core.writeInt
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.proto.protobufOf
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.handlers.GetHistoryMsg
import moe.fuqiuluo.shamrock.remote.service.listener.AioListener
import moe.fuqiuluo.shamrock.tools.broadcast
import moe.fuqiuluo.shamrock.utils.DeflateTools
import mqq.app.MobileQQ
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

internal object PacketSvc: BaseSvc() {
    /**
     * 伪造收到Json卡片消息
     */
    suspend fun fakeSelfRecvJsonMsg(msgService: IKernelMsgService, content: String): Long {
        return fakeReceiveSelfMsg(msgService) { arrayOf(
            mapOf(
                51 to 1 to (byteArrayOf(1) + DeflateTools.compress(content.toByteArray()))
            )
        ) }
    }

    private suspend fun fakeReceiveSelfMsg(msgService: IKernelMsgService, builder: () -> Array<Map<*, *>>): Long {
        val latestMsg = withTimeoutOrNull(3000) {
            suspendCancellableCoroutine {
                msgService.getMsgs(Contact(MsgConstant.KCHATTYPEC2C, app.currentUid, ""), 0L, 1, true) { code, why, msgs ->
                    it.resume(GetHistoryMsg.GetMsgResult(code, why, msgs))
                }
            }
        }?.data?.firstOrNull()
        val msgSeq = (latestMsg?.msgSeq ?: 0) + 1
        fakeReceive("trpc.msg.olpush.OlPushService.MsgPush", 10000, protobufOf(
            1 to mapOf(
                1 to mapOf(
                    1 to app.currentUin.toLong(),
                    2 to app.currentUid,
                    3 to 1001,
                    5 to app.currentUin.toLong(),
                    6 to app.currentUid
                ),
                2 to mapOf(
                    1 to 166,
                    3 to 11,
                    4 to msgSeq,
                    5 to msgSeq,
                    6 to (System.currentTimeMillis() / 1000).toInt(),
                    7 to 1,
                    11 to msgSeq,
                    12 to msgService.getMsgUniqueId(System.currentTimeMillis()),
                    14 to msgSeq - 2,
                    28 to msgSeq
                ),
                3 to 1 to 2 to builder()
            )
        ).toByteArray())
        return withTimeoutOrNull(5000L) {
            suspendCancellableCoroutine {
                AioListener.messageLessListenerMap[msgSeq] = {
                    it.resume(this.msgId)
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