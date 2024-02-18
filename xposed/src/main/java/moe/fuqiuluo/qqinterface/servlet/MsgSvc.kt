@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.troop.api.ITroopMemberNameService
import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernel.nativeinterface.*
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.msg.convert.toSegments
import moe.fuqiuluo.shamrock.helper.ContactHelper
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.MessageHelper.messageArrayToMessageElements
import moe.fuqiuluo.shamrock.remote.structures.SendMsgResult
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.shamrock.xposed.helper.msgService
import protobuf.message.*
import protobuf.message.longmsg.*
import tencent.mobileim.structmsg.structmsg.SystemMsg
import java.util.UUID
import kotlin.collections.slice
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random
import kotlin.random.nextLong

internal object MsgSvc : BaseSvc() {
    suspend fun prepareTempChatFromGroup(
        groupId: String,
        peerId: String
    ): Result<Unit> {
        LogCenter.log("主动临时消息，创建临时会话。", Level.INFO)
        val msgService = app.getRuntimeService(IKernelService::class.java, "all").msgService
            ?: return Result.failure(Exception("获取消息服务失败"))
        msgService.prepareTempChat(
            TempChatPrepareInfo(
                MsgConstant.KCHATTYPETEMPC2CFROMGROUP,
                ContactHelper.getUidByUinAsync(peerId = peerId.toLong()),
                app.getRuntimeService(ITroopMemberNameService::class.java, "all")
                    .getTroopMemberNameRemarkFirst(groupId, peerId),
                groupId,
                EMPTY_BYTE_ARRAY,
                app.currentUid,
                "",
                TempChatGameSession()
            )
        ) { code, reason ->
            if (code != 0) {
                LogCenter.log("临时会话创建失败: $code, $reason", Level.ERROR)
            }
        }
        return Result.success(Unit)
    }

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

    /**
     * 正常获取
     */
    suspend fun getMsg(hash: Int): Result<MsgRecord> {
        val mapping = MessageHelper.getMsgMappingByHash(hash)
            ?: return Result.failure(Exception("没有对应消息映射，消息获取失败"))

        val peerId = mapping.peerId
        val contact = MessageHelper.generateContact(mapping.chatType, peerId, mapping.subPeerId)

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
        qqMsgId: Long,
        subPeerId: String = ""
    ): Result<MsgRecord> {
        val contact = MessageHelper.generateContact(chatType, peerId, subPeerId)
        val service = QRoute.api(IMsgService::class.java)

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

        val contact = MessageHelper.generateContact(mapping.chatType, mapping.peerId, mapping.subPeerId)

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
        fromId: String = peedId,
        retryCnt: Int
    ): Result<SendMsgResult> {
        // 主动临时消息
        when (chatType) {
            MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> {
                prepareTempChatFromGroup(fromId, peedId).onFailure {
                    LogCenter.log("主动临时消息，创建临时会话失败。", Level.ERROR)
                    return Result.failure(Exception("主动临时消息，创建临时会话失败。"))
                }
            }
        }
        val result =
            MessageHelper.sendMessageWithoutMsgId(chatType, peedId, message, fromId, MessageCallback(peedId, 0))
        if (result.isFailure) {
            LogCenter.log("sendToAio: " + result.exceptionOrNull()?.stackTraceToString(), Level.ERROR)
            return result
        }
        val sendResult = result.getOrThrow()
        return if (sendResult.isTimeout) {
            // 发送失败，可能网络问题出现红色感叹号，重试
            // 例如 rich media transfer failed
            delay(100)
            MessageHelper.resendMsg(chatType, peedId, fromId, sendResult.qqMsgId, retryCnt, sendResult.msgHashId)
        } else {
            result
        }
    }

    suspend fun sendMultiMsg(
        uid: String,
        groupUin: String?,
        messages: List<PushMsgBody>,
    ): Result<String> {
        val payload = LongMsgPayload(
            action = LongMsgAction(
                command = "MultiMsg",
                data = LongMsgContent(
                    messages
                )
            )
        )

        val req = LongMsgReq(
            sendInfo = SendLongMsgInfo(
                type = if (groupUin == null) 1 else 3,
                uid = LongMsgUid(groupUin ?: uid),
                groupUin = groupUin?.toInt(),
                payload = DeflateTools.gzip(ProtoBuf.encodeToByteArray(payload))
            ),
            setting = LongMsgSettings(
                field1 = 4,
                field2 = 2,
                field3 = 9,
                field4 = 0
            )
        )
        val buffer = sendBufferAW(
            "trpc.group.long_msg_interface.MsgService.SsoSendLongMsg",
            true,
            ProtoBuf.encodeToByteArray(req)
        ) ?: return Result.failure(Exception("unable to upload multi message"))
        val rsp = ProtoBuf.decodeFromByteArray<LongMsgRsp>(buffer.slice(4))
        return rsp.sendResult?.resId?.let { Result.success(it) } ?: Result.failure(Exception("unable to upload multi message"))
    }

    suspend fun getMultiMsg(resId: String): Result<List<MsgRecord>> {
        // trpc.group.long_msg_interface.MsgService.SsoRecvLongMsg
        // 00 00 00 70 0A 60 0A 1A 12 18 75 5F 35 5A 5A 53 6F 38 63 4D 71 70 49 79 63 75 57 5F 78 43 4C 48 6E 77 12 40 4D 6F 61 44 38 77 2B 55 74 43 42 55 45 4C 4F 66 7A 61 72 69 43 7A 4F 5A 44 57 4B 43 6D 68 45 74 4F 65 54 6C 46 66 44 70 2F 73 61 56 77 50 2F 44 52 37 72 4A 2B 4B 4B 47 30 65 71 2B 6C 4B 58 34 18 03 7A 08 08 02 10 02 18 09 20 00

        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val msgService = sessionService.msgService
        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, TicketSvc.getUin())

        val content =
            "{\"app\":\"com.tencent.multimsg\",\"config\":{\"autosize\":1,\"forward\":1,\"round\":1,\"type\":\"normal\",\"width\":300},\"desc\":\"[聊天记录]\",\"extra\":\"\",\"meta\":{\"detail\":{\"news\":[{\"text\":\"Shamrock: 这是条假消息！\"}],\"resid\":\"$resId\",\"source\":\"聊天记录\",\"summary\":\"转发消息\",\"uniseq\":\"${UUID.randomUUID()}\"}},\"prompt\":\"[聊天记录]\",\"ver\":\"0.0.0.5\",\"view\":\"contact\"}"
        val msgId = PacketSvc.fakeSelfRecvJsonMsg(msgService, content)
        if (msgId < 0) {
            return Result.failure(Exception("获取合并转发消息ID失败"))
        }
        val msgList = withTimeoutOrNull(5000L) {
            suspendCancellableCoroutine<ArrayList<MsgRecord>> {
                val job = GlobalScope.launch {
                    var hasResult = false
                    while (!hasResult) {
                        msgService.getMultiMsg(contact, msgId, msgId) { code, why, msgList ->
                            if (code == 0) {
                                it.resume(msgList)
                                hasResult = true
                            } else {
                                LogCenter.log("获取合并转发消息失败: $code($why): $msgId", Level.ERROR)
                            }
                        }
                        delay(200)
                    }
                }
                it.invokeOnCancellation {
                    job.cancel()
                }
            }
        } ?: return Result.failure(Exception("获取合并转发消息失败"))

        //msgService.deleteMsg(contact, arrayListOf(msgId), null)

        return Result.success(msgList)
    }

    class MessageCallback(
        private val peerId: String,
        var msgHash: Int
    ) : IOperateCallback {
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