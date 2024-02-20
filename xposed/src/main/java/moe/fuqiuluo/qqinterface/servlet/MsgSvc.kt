@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.troop.api.ITroopMemberNameService
import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernel.nativeinterface.*
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.msg.messageelement.toSegments
import moe.fuqiuluo.qqinterface.servlet.msg.toListMap
import moe.fuqiuluo.shamrock.helper.ContactHelper
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.service.data.MessageDetail
import moe.fuqiuluo.shamrock.remote.service.data.MessageSender
import moe.fuqiuluo.shamrock.remote.structures.SendMsgResult
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.shamrock.xposed.helper.msgService
import protobuf.message.longmsg.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

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
            action = listOf(
                LongMsgAction(
                    command = "MultiMsg",
                    data = LongMsgContent(
                        body = messages
                    )
                )
            )
        )
        LogCenter.log(ProtoBuf.encodeToByteArray(payload).toHexString(), Level.DEBUG)

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
        return rsp.sendResult?.resId?.let { Result.success(it) }
            ?: Result.failure(Exception("unable to upload multi message"))
    }

    suspend fun getMultiMsg(resId: String): Result<List<MessageDetail>> {
        val req = LongMsgReq(
            recvInfo = RecvLongMsgInfo(
                uid = LongMsgUid(TicketSvc.getUid()),
                resId = resId,
                u1 = 3
            ),
            setting = LongMsgSettings(
                field1 = 2,
                field2 = 2,
                field3 = 9,
                field4 = 0
            )
        )
        val buffer = sendBufferAW(
            "trpc.group.long_msg_interface.MsgService.SsoRecvLongMsg",
            true,
            ProtoBuf.encodeToByteArray(req)
        ) ?: return Result.failure(Exception("unable to get multi message"))
        val rsp = ProtoBuf.decodeFromByteArray<LongMsgRsp>(buffer.slice(4))
        val zippedPayload = DeflateTools.ungzip(
            rsp.recvResult?.payload ?: return Result.failure(Exception("unable to get multi message"))
        )
        LogCenter.log(zippedPayload.toHexString(), Level.DEBUG)
        val payload = ProtoBuf.decodeFromByteArray<LongMsgPayload>(zippedPayload)
        payload.action?.forEach {
            if (it.command == "MultiMsg") {
                return Result.success(it.data?.body?.map { msg ->
                    val chatType =
                        if (msg.content!!.msgType == 82) MsgConstant.KCHATTYPEGROUP else MsgConstant.KCHATTYPEC2C
                    MessageDetail(
                        time = msg.content?.msgTime?.toInt() ?: 0,
                        msgType = MessageHelper.obtainDetailTypeByMsgType(chatType),
                        msgId = 0, // MessageHelper.generateMsgIdHash(chatType, msg.content!!.msgViaRandom), msgViaRandom 为空
                        realId = msg.content!!.msgSeq.toInt(),
                        sender = MessageSender(
                            msg.head?.peer ?: 0,
                            msg.head?.groupInfo?.memberCard?.ifEmpty { msg.head?.forward?.friendName } ?: "",
                            "unknown",
                            0,
                            msg.head?.peerUid ?: "u_",
                            msg.head?.peerUid?: "u_"
                        ),
                        message = msg.body?.rich?.elements?.toSegments(chatType, msg.head?.peer.toString(), "0")
                            ?.toListMap() ?: emptyList(),
                        peerId = msg.head?.peer ?: 0,
                        groupId = if (chatType == MsgConstant.KCHATTYPEGROUP) msg.head?.groupInfo?.groupCode?.toLong()
                            ?: 0 else 0,
                        targetId = if (chatType != MsgConstant.KCHATTYPEGROUP) msg.head?.peer ?: 0 else 0
                    )
                }
                    ?: return Result.failure(Exception("Msg is empty")))
            }
        }
        return Result.failure(Exception("Can't find msg"))
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