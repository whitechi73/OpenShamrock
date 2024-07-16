package qq.service.msg

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.troop.api.ITroopMemberNameService
import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo
import com.tencent.qqnt.msg.api.IMsgService
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.jsonObject
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.EmptyJsonArray
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.tools.asInt
import moe.fuqiuluo.shamrock.tools.asJsonArrayOrNull
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asLong
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.asStringOrNull
import moe.fuqiuluo.shamrock.tools.decodeToOidb
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.message.longmsg.LongMsgAction
import protobuf.message.longmsg.LongMsgPayload
import protobuf.message.longmsg.LongMsgReq
import protobuf.message.longmsg.LongMsgRsp
import protobuf.message.longmsg.LongMsgSettings
import protobuf.message.longmsg.LongMsgUid
import protobuf.message.longmsg.RecvLongMsgInfo
import protobuf.oidb.cmd0x9082.Oidb0x9082
import qq.service.QQInterfaces
import qq.service.contact.ContactHelper
import qq.service.internals.msgService
import qq.service.ticket.TicketHelper
import tencent.im.oidb.cmd0xeac.oidb_0xeac
import tencent.im.oidb.oidb_sso
import kotlin.coroutines.resume

typealias MessageId = Long

internal object MessageHelper: QQInterfaces() {
    suspend fun getEssenceMessageList(groupId: Long, page: Int = 0, pageSize: Int = 20): Result<List<EssenceMessage>>{
        val cookie = TicketHelper.getCookie("qun.qq.com")
        val bkn = TicketHelper.getBkn(TicketHelper.getRealSkey(TicketHelper.getUin()))
        val url = "https://qun.qq.com/cgi-bin/group_digest/digest_list?bkn=${bkn}&group_code=${groupId}&page_start=${page}&page_limit=${pageSize}"
        val response = GlobalClient.get(url) {
            header("Cookie", cookie)
        }
        val body = Json.decodeFromStream<JsonElement>(response.body())
        if (body.jsonObject["retcode"].asInt == 0) {
            val data = body.jsonObject["data"].asJsonObject
            val list = data["msg_list"].asJsonArrayOrNull
                ?: // is_end
                return Result.success(ArrayList())
            return Result.success(list.map {
                val obj = it.jsonObject
                val msgSeq = obj["msg_seq"].asLong
                EssenceMessage(
                    senderId = obj["sender_uin"].asString.toLong(),
                    senderNick = obj["sender_nick"].asString,
                    senderTime = obj["sender_time"].asLong,
                    operatorId = obj["add_digest_uin"].asString.toLong(),
                    operatorNick = obj["add_digest_nick"].asString,
                    operatorTime = obj["add_digest_time"].asLong,
                    messageSeq = msgSeq,
                    messageContent = obj["msg_content"] ?: EmptyJsonArray
                )
            })
        } else {
            return Result.failure(Exception(body.jsonObject["retmsg"].asStringOrNull))
        }
    }

    fun setGroupMessageCommentFace(peer: Long, msgSeq: ULong, faceIndex: String, isSet: Boolean) {
        val serviceId = if (isSet) 1 else 2
        sendOidb("OidbSvcTrpcTcp.0x9082_$serviceId", 36994, serviceId, Oidb0x9082(
            peer = peer.toULong(),
            msgSeq = msgSeq,
            faceIndex = faceIndex,
            flag = 1u,
            u1 = 0u,
            u2 = 0u
        ).toByteArray())
    }

    suspend fun setEssenceMessage(groupId: Long, seq: Long, rand: Long): String? {
        val fromServiceMsg = sendOidbAW("OidbSvc.0xeac_1", 3756, 1, oidb_0xeac.ReqBody().apply {
            group_code.set(groupId)
            msg_seq.set(seq.toInt())
            msg_random.set(rand.toInt())
        }.toByteArray())
        if (fromServiceMsg?.wupBuffer == null) {
            return "no response"
        }
        val body = fromServiceMsg.decodeToOidb()
        val result = oidb_0xeac.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return if (result.wording.has()) {
            LogCenter.log("设置群精华失败: ${result.wording.get()}", Level.WARN)
            "设置群精华失败: ${result.wording.get()}"
        } else {
            LogCenter.log("设置群精华 -> $groupId: $seq")
            null
        }
    }

    suspend fun deleteEssenceMessage(groupId: Long, seq: Long, rand: Long): String? {
        val fromServiceMsg = sendOidbAW("OidbSvc.0xeac_2", 3756, 2, oidb_0xeac.ReqBody().apply {
            group_code.set(groupId)
            msg_seq.set(seq.toInt())
            msg_random.set(rand.toInt())
        }.toByteArray())
        if (fromServiceMsg?.wupBuffer == null) {
            return "no response"
        }
        val body = fromServiceMsg.decodeToOidb()
        val result = oidb_0xeac.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return if (result.wording.has()) {
            LogCenter.log("移除群精华失败: ${result.wording.get()}", Level.WARN)
            "移除群精华失败: ${result.wording.get()}"
        } else {
            LogCenter.log("移除群精华 -> $groupId: $seq")
            null
        }
    }

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

    suspend fun sendMessage(contact: Contact, msgs: ArrayList<MsgElement>, retry: Int, uniseq: Long): Result<MessageId> {
        if (contact.chatType == MsgConstant.KCHATTYPETEMPC2CFROMGROUP) {
            prepareTempChatFromGroup(contact.guildId, contact.peerUid).getOrThrow()
        }
        return withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                QRoute.api(IMsgService::class.java).sendMsg(contact, uniseq, msgs) { code: Int, msg: String ->
                    if (code == 0) {
                        it.resume(uniseq)
                    } else {
                        LogCenter.log("消息发送失败: $code:$msg", Level.WARN)
                        it.resume(null)
                    }
                }
            }
        }?.let { Result.success(it) } ?: resendMsg(contact, uniseq, retry)
    }

    private suspend fun resendMsg(contact: Contact, msgId: MessageId, retry: Int): Result<MessageId> {
        if (retry > 0) {
            return withTimeoutOrNull(5000) {
                suspendCancellableCoroutine {
                    QRoute.api(IMsgService::class.java).resendMsg(contact, msgId) { code, msg ->
                        if (code == 0) {
                            it.resume(msgId)
                        } else {
                            LogCenter.log("消息重发失败: $code:$msg", Level.WARN)
                            it.resume(null)
                        }
                    }
                }
            }?.let { Result.success(it) } ?: resendMsg(contact, msgId, retry - 1)
        } else {
            return Result.failure(Exception("消息发送失败：重试已达上限"))
        }
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

    suspend fun getMultiMsg(resId: String): Result<List<LongMsgAction>> {
        val req = LongMsgReq(
            recvInfo = RecvLongMsgInfo(
                uid = LongMsgUid(app.currentUid),
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
        val fromServiceMsg = sendBufferAW(
            "trpc.group.long_msg_interface.MsgService.SsoRecvLongMsg",
            true,
            req.toByteArray()
        ) ?: return Result.failure(Exception("unable to get multi message"))
        val rsp = fromServiceMsg.wupBuffer.slice(4).decodeProtobuf<LongMsgRsp>()
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
                    val chatType = if (msg.contentHead!!.msgType == 82) MsgConstant.KCHATTYPEGROUP else MsgConstant.KCHATTYPEC2C
                    MessageDetail(
                        time = msg.contentHead?.msgTime?.toInt() ?: 0,
                        msgType = chatType,
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
                        message = msg.body?.richText,
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


    fun generateMsgId(chatType: Int): Long {
        return createMessageUniseq(chatType, System.currentTimeMillis())
    }

    external fun createMessageUniseq(chatType: Int, time: Long): Long
}