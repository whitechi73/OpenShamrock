package qq.service.msg

import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import qq.service.QQInterfaces
import qq.service.contact.ContactHelper
import qq.service.internals.msgService
import kotlin.coroutines.resume

internal object MessageHelper: QQInterfaces() {
    suspend fun getTempChatInfo(chatType: Int, uid: String): Result<TempChatInfo> {
        val msgService = app.getRuntimeService(IKernelService::class.java, "all").msgService
            ?: return Result.failure(Exception("获取消息服务失败"))
        val info: TempChatInfo = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                msgService.getTempChatInfo(chatType, uid) { code, msg, tempChatInfo ->
                    if (code == 0) {
                        it.resume(tempChatInfo)
                    } else {
                        LogCenter.log("获取临时会话信息失败: $code:$msg", Level.ERROR)
                        it.resume(null)
                    }
                }
            }
        } ?: return Result.failure(Exception("获取临时会话信息失败"))
        return Result.success(info)
    }

    suspend fun generateContact(record: MsgRecord): Contact {
        val peerId = when (record.chatType) {
            MsgConstant.KCHATTYPEC2C, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> record.senderUid
            MsgConstant.KCHATTYPEGUILD -> record.channelId
            else -> record.peerUin.toString()
        }
        return Contact(record.chatType, peerId, if (record.chatType == MsgConstant.KCHATTYPEGUILD) {
            record.guildId
        } else if(record.chatType == MsgConstant.KCHATTYPETEMPC2CFROMGROUP) {
            val tempInfo = getTempChatInfo(record.chatType, peerId).getOrThrow()
            tempInfo.groupCode
        } else {
            null
        })
    }

    suspend fun generateContact(chatType: Int, id: String, subId: String = ""): Contact {
        val peerId = when (chatType) {
            MsgConstant.KCHATTYPEC2C, MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> {
                if (id.startsWith("u_")) id
                else ContactHelper.getUidByUinAsync(id.toLong())
            }
            else -> id
        }
        return if (chatType == MsgConstant.KCHATTYPEGUILD) {
            Contact(chatType, subId, peerId)
        } else {
            Contact(chatType, peerId, subId)
        }
    }

    fun generateMsgId(chatType: Int): Long {
        return createMessageUniseq(chatType, System.currentTimeMillis())
    }

    external fun createMessageUniseq(chatType: Int, time: Long): Long
}