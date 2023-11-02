package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.JsonArray
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal object MsgSvc: BaseSvc() {
    fun uploadForwardMsg(): Result<String> {
        return Result.failure(Exception("Not implemented"))
    }

    /**
     * 正常获取
     */
    suspend fun getMsg(hash: Int): Result<MsgRecord> {
        val mapping = MessageHelper.getMsgMappingByHash(hash)
            ?: return Result.failure(Exception("没有对应消息映射，消息获取失败"))

        val peerId = mapping.peerId
        val contact = MessageHelper.generateContact(mapping.chatType, peerId)

        val msg = withTimeoutOrNull(5000) {
            val service = QRoute.api(IMsgService::class.java)
            suspendCancellableCoroutine { continuation ->
                service.getMsgsByMsgId(contact, arrayListOf(mapping.qqMsgId)) { code, _, msgRecords ->
                    if (code == 0 && msgRecords.isNotEmpty()) {
                        continuation.resume(msgRecords.first())
                    } else {
                        continuation.resume(null)
                    }
                }
                continuation.invokeOnCancellation {
                    continuation.resume(null)
                } // 貌似不会被取消，写了也没什么鸟用啊？
            }
        }

        return if (msg != null) {
            Result.success(msg)
        } else {
            Result.failure(Exception("获取消息失败"))
        }
    }

    suspend fun getMsgByQMsgId(
        chatType: Int,
        peerId: String,
        qqMsgId: Long
    ): Result<MsgRecord> {
        val contact = MessageHelper.generateContact(chatType, peerId)
        val service = QRoute.api(IMsgService::class.java) ?:
            return Result.failure(Exception("获取消息服务"))

        val msg = withTimeoutOrNull(5000) {
            suspendCoroutine { continuation ->
                service.getMsgsByMsgId(contact, arrayListOf(qqMsgId)) { code, _, msgRecords ->
                    if (code == 0 && msgRecords.isNotEmpty()) {
                        continuation.resume(msgRecords.first())
                    } else {
                        continuation.resume(null)
                    }
                }
            }
        }

        return if (msg != null) {
            Result.success(msg)
        } else {
            Result.failure(Exception("获取消息失败"))
        }
    }

    /**
     * 什么鸟屎都获取不到
     */
    suspend fun getMsgBySeq(
        chatType: Int,
        peerId: String,
        seq: Long
    ): Result<MsgRecord> {
        val contact = MessageHelper.generateContact(chatType, peerId)
        val msg = withTimeoutOrNull(1000) {
            val service = QRoute.api(IMsgService::class.java)
            suspendCancellableCoroutine { continuation ->
                service.getMsgsBySeqs(contact, arrayListOf(seq)) { code, _, msgRecords ->
                    continuation.resume(msgRecords?.firstOrNull())
                }
                continuation.invokeOnCancellation {
                    continuation.resume(null)
                }
            }
        }
        return if (msg != null) {
            Result.success(msg)
        } else {
            Result.failure(Exception("获取消息失败"))
        }
    }

    /**
     * 撤回消息 同步 HTTP API
     */
    suspend fun recallMsg(msgHash: Int): Pair<Int, String> {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val msgService = sessionService.msgService

        val mapping = MessageHelper.getMsgMappingByHash(msgHash)
            ?: return -1 to "无法找到消息映射"

        val contact = MessageHelper.generateContact(mapping.chatType, mapping.peerId)

        return suspendCancellableCoroutine { continuation ->
            msgService.recallMsg(contact, arrayListOf(mapping.qqMsgId)) { code, why ->
                continuation.resume(code to why)
            }
        }
    }

    /**
     * 发送消息
     *
     * Aio 腾讯内部命名 All In One
     */
    suspend fun sendToAio(
        chatType: Int,
        peedId: String,
        message: JsonArray,
        fromId: String = peedId
    ): Pair<Long, Int> {
        //LogCenter.log(message.toString(), Level.ERROR)
        //callback.msgHash = result.second 什么垃圾代码，万一cb比你快，你不就寄了？
        return MessageHelper.sendMessageWithoutMsgId(chatType, peedId, message, MessageCallback(peedId, 0), fromId)
    }

    class MessageCallback(
        private val peerId: String,
        var msgHash: Int
    ): IOperateCallback {
        override fun onResult(code: Int, reason: String?) {
            if (code != 0 && msgHash != 0) {
                MessageHelper.removeMsgByHashCode(msgHash)
            }
            when (code) {
                110 -> LogCenter.log("消息发送: $peerId, 无该联系人无法发送。")
                120 -> LogCenter.log("消息发送: $peerId, 禁言状态无法发送。")
                5 -> LogCenter.log("消息发送: $peerId, 当前不支持该消息类型。")
                else -> LogCenter.log("消息发送: $peerId, code: $code $reason")
            }
        }
    }
}