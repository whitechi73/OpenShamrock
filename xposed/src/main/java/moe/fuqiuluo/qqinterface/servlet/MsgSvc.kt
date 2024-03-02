package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.troop.api.ITroopMemberNameService
import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernel.nativeinterface.*
import com.tencent.qqnt.msg.api.IMsgService
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.qqinterface.servlet.msg.MessageSegment
import moe.fuqiuluo.qqinterface.servlet.msg.toJson
import moe.fuqiuluo.qqinterface.servlet.msg.toListMap
import moe.fuqiuluo.qqinterface.servlet.msg.toSegments
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
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.message.*
import protobuf.message.longmsg.*
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random

internal object MsgSvc : BaseSvc() {
    private suspend fun prepareTempChatFromGroup(
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
                }
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
                .getOrElse { return Result.failure(it) }
        return if (result.isTimeout) {
            // 发送失败，可能网络问题出现红色感叹号，重试
            // 例如 rich media transfer failed
            delay(100)
            MessageHelper.resendMsg(chatType, peedId, fromId, result.qqMsgId, retryCnt, result.msgHashId)
        } else {
            Result.success(result)
        }
    }

    suspend fun uploadMultiMsg(
        chatType: Int,
        peerId: String,
        fromId: String = peerId,
        messages: JsonArray,
        retryCnt: Int
    ): Result<MessageSegment> {
        return uploadMultiMsg(chatType, peerId, fromId, messages).onFailure {
            if (retryCnt > 0) {
                return uploadMultiMsg(chatType, peerId, fromId, messages, retryCnt - 1)
            }
        }
    }

    private suspend fun uploadMultiMsg(
        chatType: Int,
        peerId: String,
        fromId: String = peerId,
        messages: JsonArray,
    ): Result<MessageSegment> {
        var i = -1
        val desc = MutableList(messages.size) { "" }
        val forwardMsg = mutableMapOf<String, String>()

        val msgs = messages.mapNotNull { msg ->
            kotlin.runCatching {
                val data = msg.asJsonObject["data"].asJsonObject
                if (data.containsKey("id")) {
                    val msgId = data["id"].asInt
                    val record = getMsg(msgId).onFailure {
                        error("合并转发消息节点消息(id = ${data["id"].asInt})获取失败：$it")
                    }.getOrThrow()
                    PushMsgBody(
                        msgHead = ResponseHead(
                            peerUid = record.senderUid,
                            receiverUid = record.peerUid,
                            forward = ResponseForward(
                                friendName = record.sendNickName
                            ),
                            responseGrp = if (record.chatType == MsgConstant.KCHATTYPEGROUP) ResponseGrp(
                                groupCode = record.peerUin.toULong(),
                                memberCard = record.sendMemberName,
                                u1 = 2
                            ) else null
                        ),
                        contentHead = ContentHead(
                            msgType = when (record.chatType) {
                                MsgConstant.KCHATTYPEC2C -> 9
                                MsgConstant.KCHATTYPEGROUP -> 82
                                else -> throw UnsupportedOperationException("Unsupported chatType: $chatType")
                            },
                            msgSubType = if (record.chatType == MsgConstant.KCHATTYPEC2C) 175 else null,
                            divSeq = if (record.chatType == MsgConstant.KCHATTYPEC2C) 175 else null,
                            msgViaRandom = record.msgId,
                            sequence = record.msgSeq, // idk what this is(i++)
                            msgTime = record.msgTime,
                            u2 = 1,
                            u6 = 0,
                            u7 = 0,
                            msgSeq = if (record.chatType == MsgConstant.KCHATTYPEC2C) record.msgSeq else null, // seq for dm
                            forwardHead = ForwardHead(
                                u1 = 0,
                                u2 = 0,
                                u3 = 0,
                                ub641 = "",
                                avatar = ""
                            )
                        ),
                        body = MsgBody(
                            richText = MessageHelper.messageArrayToRichText(
                                record.chatType,
                                record.msgId,
                                record.peerUin.toString(),
                                record.elements.toSegments(
                                    record.chatType,
                                    record.peerUin.toString(),
                                    "0"
                                ).onEach { segment ->
                                    if (segment.type == "forward") {
                                        forwardMsg[segment.data["filename"] as String] =
                                            segment.data["id"] as String
                                    }
                                }.toJson()
                            ).onFailure {
                                error("消息合成失败: ${it.stackTraceToString()}")
                            }.onSuccess {
                                desc[++i] = record.sendMemberName.ifEmpty { record.sendNickName } + ": " + it.first
                            }.getOrThrow().second
                        )
                    )
                } else if (data.containsKey("content")) {
                    PushMsgBody(
                        msgHead = ResponseHead(
                            peer = data["uin"]?.asLong ?: TicketSvc.getUin().toLong(),
                            peerUid = data["uid"]?.asString ?: TicketSvc.getUid(),
                            receiverUid = TicketSvc.getUid(),
                            forward = ResponseForward(
                                friendName = data["name"]?.asStringOrNull ?: TicketSvc.getNickname()
                            )
                        ),
                        contentHead = ContentHead(
                            msgType = 9,
                            msgSubType = 175,
                            divSeq = 175,
                            msgViaRandom = Random.nextLong(),
                            sequence = data["seq"]?.asLong ?: Random.nextLong(),
                            msgTime = data["time"]?.asLong ?: (System.currentTimeMillis() / 1000),
                            u2 = 1,
                            u6 = 0,
                            u7 = 0,
                            msgSeq = data["seq"]?.asLong ?: Random.nextLong(),
                            forwardHead = ForwardHead(
                                u1 = 0,
                                u2 = 0,
                                u3 = 2,
                                ub641 = "",
                                avatar = ""
                            )
                        ),
                        body = MsgBody(
                            richText = MessageHelper.messageArrayToRichText(
                                chatType = chatType,
                                msgId = Random.nextLong(),
                                peerId = data["uin"]?.asString ?: TicketSvc.getUin(),
                                messageList = when (data["content"]) {
                                    is JsonObject -> listOf(data["content"] as JsonObject).json
                                    is JsonArray -> data["content"] as JsonArray
                                    else -> MessageHelper.decodeCQCode(data["content"].asString)
                                }.onEach { element ->
                                    val elementData = element.asJsonObject["data"].asJsonObject
                                    if (element.asJsonObject["type"].asString == "forward") {
                                        forwardMsg[elementData["filename"].asString] =
                                            elementData["id"].asString
                                    }
                                }
                            ).onSuccess {
                                desc[++i] = (data["name"].asStringOrNull ?: data["uin"].asStringOrNull
                                ?: TicketSvc.getNickname()) + ": " + it.first
                            }.onFailure {
                                error("消息合成失败: ${it.stackTraceToString()}")
                            }.getOrThrow().second
                        )
                    )
                } else error("消息节点缺少id或content字段")
            }.onFailure {
                LogCenter.log("消息节点解析失败：${it.stackTraceToString()}", Level.WARN)
            }.getOrNull()
        }.ifEmpty {
            return Result.failure(Exception("消息节点为空"))
        }

        val payload = LongMsgPayload(
            action = mutableListOf(
                LongMsgAction(
                    command = "MultiMsg",
                    data = LongMsgContent(
                        body = msgs
                    )
                )
            ).apply {
                forwardMsg.map { msg ->
                    addAll(getMultiMsg(msg.value).getOrElse { return Result.failure(Exception("无法获取嵌套转发消息: $it")) }
                        .map { action ->
                            if (action.command == "MultiMsg") LongMsgAction(
                                command = msg.key,
                                data = action.data
                            ) else action
                        })
                }
            }
        )
        LogCenter.log({ payload.toByteArray().toHexString() }, Level.DEBUG)

        val req = LongMsgReq(
            sendInfo = when (chatType) {
                MsgConstant.KCHATTYPEC2C -> SendLongMsgInfo(
                    type = 1,
                    uid = LongMsgUid(if(peerId.startsWith("u_")) peerId else ContactHelper.getUidByUinAsync(peerId.toLong()) ),
                    payload = DeflateTools.gzip(payload.toByteArray())
                )
                MsgConstant.KCHATTYPEGROUP -> SendLongMsgInfo(
                    type = 3,
                    uid = LongMsgUid(fromId),
                    groupUin = fromId.toULong(),
                    payload = DeflateTools.gzip(payload.toByteArray())
                )
                else -> throw UnsupportedOperationException("Unsupported chatType: $chatType")
            },
            setting = LongMsgSettings(
                field1 = 4,
                field2 = 2,
                field3 = 9,
                field4 = 0
            )
        ).toByteArray()

        val buffer = sendBufferAW("trpc.group.long_msg_interface.MsgService.SsoSendLongMsg", true, req, timeout = 30_000)
            ?: return Result.failure(Exception("unable to upload multi message, response timeout"))
        val rsp = runCatching {
            buffer.slice(4).decodeProtobuf<LongMsgRsp>()
        }.getOrElse {
            buffer.decodeProtobuf<LongMsgRsp>()
        }
        val resId = rsp.sendResult?.resId ?: return Result.failure(Exception("unable to upload multi message"))
        return Result.success(MessageSegment(
            type = "forward",
            data = mapOf(
                "id" to resId,
                "filename" to UUID.randomUUID().toString(),
                "summary" to "查看${desc.size}条转发消息",
                "desc" to desc.slice(0..if (i < 3) i else 3).joinToString("\n")
            )
        ))
    }

    suspend fun getMultiMsg(resId: String): Result<List<LongMsgAction>> {
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
            req.toByteArray()
        ) ?: return Result.failure(Exception("unable to get multi message"))
        val rsp = buffer.slice(4).decodeProtobuf<LongMsgRsp>()
        val zippedPayload = DeflateTools.ungzip(
            rsp.recvResult?.payload ?: return Result.failure(Exception("payload is empty"))
        )
        LogCenter.log(zippedPayload.toHexString(), Level.DEBUG)
        return Result.success(
            zippedPayload.decodeProtobuf<LongMsgPayload>().action
                ?: return Result.failure(Exception("action is empty"))
        )
    }

    suspend fun getForwardMsg(resId: String): Result<List<MessageDetail>> {
        val result = getMultiMsg(resId).getOrElse { return Result.failure(it) }
        result.forEach {
            if (it.command == "MultiMsg") {
                return Result.success(it.data?.body?.map { msg ->
                    val chatType =
                        if (msg.contentHead!!.msgType == 82) MsgConstant.KCHATTYPEGROUP else MsgConstant.KCHATTYPEC2C
                    MessageDetail(
                        time = msg.contentHead?.msgTime?.toInt() ?: 0,
                        msgType = MessageHelper.obtainDetailTypeByMsgType(chatType),
                        msgId = 0, // msgViaRandom为空 tx不给
                        qqMsgId = 0,
                        msgSeq = msg.contentHead!!.msgSeq ?: 0,
                        realId = msg.contentHead!!.msgSeq ?: 0,
                        sender = MessageSender(
                            msg.msgHead?.peer ?: 0,
                            msg.msgHead?.responseGrp?.memberCard ?: msg.msgHead?.forward?.friendName ?: "",
                            "unknown",
                            0,
                            msg.msgHead?.peerUid ?: "",
                            msg.msgHead?.peerUid ?: ""
                        ),
                        message = msg.body?.richText?.toSegments(
                            chatType,
                            msg.msgHead?.peer.toString(),
                            "0"
                        )?.toListMap() ?: emptyList(),
                        peerId = msg.msgHead?.peer ?: 0,
                        groupId = if (chatType == MsgConstant.KCHATTYPEGROUP) msg.msgHead?.responseGrp?.groupCode?.toLong()
                            ?: 0 else 0,
                        targetId = if (chatType != MsgConstant.KCHATTYPEGROUP) msg.msgHead?.peer ?: 0 else 0
                    )
                } ?: return Result.failure(Exception("Msg is empty")))
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