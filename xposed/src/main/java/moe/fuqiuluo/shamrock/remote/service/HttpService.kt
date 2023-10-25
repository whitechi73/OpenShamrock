@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.shamrock.remote.service

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.helper.MessageHelper
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.msg.*
import moe.fuqiuluo.shamrock.remote.service.api.HttpPushServlet
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.remote.service.data.push.*
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter

internal object HttpService: HttpPushServlet() {
    private val actionMsgTypes = arrayOf(
        "record", "voice", "video", "markdown"
    )

    override fun pushSelfPrivateSentMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    ) {
        pushMsg(
            record,
            elements,
            raw,
            msgHash,
            MsgType.Private,
            MsgSubType.Friend,
            postType = PostType.MsgSent
        )
    }

    override fun pushSelfGroupSentMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    ) {
        pushMsg(
            record,
            elements,
            raw,
            msgHash,
            MsgType.Group,
            MsgSubType.NORMAL,
            postType = PostType.MsgSent
        )
    }

    override fun pushPrivateMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    ) {
        pushMsg(
            record,
            elements,
            raw,
            msgHash,
            MsgType.Private,
            MsgSubType.Friend
        )
    }

    override fun pushGroupMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    ) {
        pushMsg(
            record, elements, raw, msgHash, MsgType.Group, MsgSubType.NORMAL,
            role = when (record.senderUin) {
                GroupSvc.getOwner(record.peerUin.toString()) -> MemberRole.Owner
                in GroupSvc.getAdminList(record.peerUin.toString()) -> MemberRole.Admin
                else -> MemberRole.Member
            }
        )
    }

    override fun pushGroupPoke(time: Long, operation: Long, userId: Long, groupId: Long) {
        pushNotice(
            time = time,
            type = NoticeType.Notify,
            subType = NoticeSubType.Poke,
            operation = operation,
            userId = operation,
            groupId = groupId,
            target = userId,
        )
    }

    override fun pushPrivateMsgRecall(time: Long, operation: Long, msgHash: Int, tip: String) {
        pushNotice(
            time = time,
            type = NoticeType.FriendRecall,
            operation = operation,
            userId = operation,
            msgHash = msgHash,
            tip = tip
        )
    }

    override fun pushGroupMsgRecall(
        time: Long,
        operation: Long,
        userId: Long,
        groupId: Long,
        msgHash: Int,
        tip: String
    ) {
        pushNotice(
            time = time,
            type = NoticeType.GroupRecall,
            operation = operation,
            userId = userId,
            groupId = groupId,
            msgHash = msgHash,
            tip = tip
        )
    }

    override fun pushGroupBan(
        time: Long,
        operation: Long,
        userId: Long,
        groupId: Long,
        duration: Int
    ) {
        pushNotice(
            time,
            NoticeType.GroupBan,
            if (duration == 0) NoticeSubType.LiftBan else NoticeSubType.Ban,
            operation,
            userId,
            groupId,
            duration
        )
    }

    override fun pushGroupMemberDecreased(
        time: Long,
        target: Long,
        groupId: Long,
        operation: Long,
        type: NoticeType,
        subType: NoticeSubType
    ) {
        pushNotice(
            time,
            type,
            subType,
            operation,
            target,
            groupId
        )
    }

    override fun pushGroupAdminChange(time: Long, target: Long, groupId: Long, setAdmin: Boolean) {
        pushNotice(
            time,
            NoticeType.GroupAdminChange,
            if (setAdmin) NoticeSubType.Set else NoticeSubType.UnSet,
            0,
            target,
            groupId
        )
    }

    override fun pushGroupFileCome(
        time: Long,
        userId: Long,
        groupId: Long,
        fileId: String,
        fileName: String,
        fileSize: Long,
        bizId: Int,
        url: String
    ) {
        pushNotice(
            time = time,
            type = NoticeType.GroupUpload,
            groupId = groupId,
            operation = userId,
            userId = userId,
            groupFileMsg = GroupFileMsg(
                id = fileId,
                name = fileName,
                size = fileSize,
                busid = bizId.toLong(),
                url = url
            )
        )
    }

    override fun pushC2CPoke(time: Long, userId: Long, targetId: Long) {
        pushNotice(
            time = time,
            type = NoticeType.Notify,
            subType = NoticeSubType.Poke,
            operation = userId,
            userId = userId,
            target = targetId,
            sender = userId
        )
    }

    override fun pushC2CFileCome(
        time: Long,
        sender: Long,
        fileId: String,
        fileSubId: String,
        fileName: String,
        fileSize: Long,
        expireTime: Long,
        url: String
    ) {
        pushNotice(
            time = time,
            type = NoticeType.PrivateUpload,
            operation = sender,
            userId = sender,
            sender = sender,
            privateFileMsg = PrivateFileMsg(
                id = fileId,
                name = fileName,
                size = fileSize,
                url = url,
                subId = fileSubId,
                expire = expireTime
            )
        )
    }

    private fun pushNotice(
        time: Long,
        type: NoticeType,
        subType: NoticeSubType = NoticeSubType.None,
        operation: Long,
        userId: Long,
        groupId: Long = 0,
        duration: Int = 0,
        msgHash: Int = 0,
        target: Long = 0,
        sender: Long = 0,
        tip: String = "",
        groupFileMsg: GroupFileMsg? = null,
        privateFileMsg: PrivateFileMsg? = null
    ) {
        GlobalScope.launch {
            pushTo(PushNotice(
                time = time,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = type,
                subType = subType,
                operatorId = operation,
                userId = userId,
                groupId = groupId,
                duration = duration,
                target = target,
                msgId = msgHash,
                tip = tip,
                file = groupFileMsg,
                senderId = sender,
                privateFile = privateFileMsg
            ))
        }
    }

    private fun pushMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int,
        msgType: MsgType,
        subType: MsgSubType,
        role: MemberRole = MemberRole.Member,
        postType: PostType = PostType.Msg
    ) {
        val uin = TicketSvc.getUin().toLong()
        GlobalScope.launch {
            val respond = pushTo(PushMessage(
                time = record.msgTime,
                selfId = app.longAccountUin,
                postType = postType,
                messageType = msgType,
                subType = subType,
                messageId = msgHash,
                groupId = if(msgType == MsgType.Private) 0 else record.peerUin,
                targetId = if(msgType != MsgType.Private) 0 else record.peerUin,
                peerId = if (record.senderUin == uin) record.peerUin else uin,
                userId = record.senderUin,
                message = if(ShamrockConfig.useCQ()) raw.json else elements.toSegment(record.chatType, record.peerUin.toString()).json,
                rawMessage = raw,
                font = 0,
                sender = Sender(
                    userId = record.senderUin,
                    nickname = record.sendNickName,
                    card = record.sendMemberName,
                    role = role,
                    title = "",
                    level = "",
                )
            )) ?: return@launch
            handleQuicklyReply(
                record,
                msgHash,
                respond.bodyAsText()
            )
        }
    }

    private suspend fun handleQuicklyReply(record: MsgRecord, msgHash: Int, jsonText: String) {
        try {
            val data = Json.parseToJsonElement(jsonText).asJsonObject
            if (data.containsKey("reply")) {
                LogCenter.log({ "quickly reply successfully" }, Level.DEBUG)
                val autoEscape = data["auto_escape"].asBooleanOrNull ?: false
                val atSender = data["at_sender"].asBooleanOrNull ?: false
                val autoReply = data["auto_reply"].asBooleanOrNull ?: true
                val message = data["reply"]
                if (message is JsonPrimitive) {
                    if (autoEscape) {
                        val msgList = mutableSetOf<JsonElement>()
                        msgList.add(mapOf(
                            "type" to "text",
                            "data" to mapOf(
                                "text" to message.asString
                            )
                        ).json)
                        quicklyReply(
                            record,
                            msgList.jsonArray,
                            msgHash,
                            atSender,
                            autoReply
                        )
                    } else {
                        val messageArray = MessageHelper.decodeCQCode(message.asString)
                        quicklyReply(
                            record,
                            messageArray,
                            msgHash,
                            atSender,
                            autoReply
                        )
                    }
                } else if (message is JsonArray) {
                    quicklyReply(
                        record,
                        message,
                        msgHash,
                        atSender,
                        autoReply
                    )
                }
            }
            if (MsgConstant.KCHATTYPEGROUP == record.chatType && data.containsKey("delete") && data["delete"].asBoolean) {
                MsgSvc.recallMsg(msgHash)
            }
            if (MsgConstant.KCHATTYPEGROUP == record.chatType && data.containsKey("kick") && data["kick"].asBoolean) {
                GroupSvc.kickMember(record.peerUin, false, record.senderUin)
            }
            if (MsgConstant.KCHATTYPEGROUP == record.chatType && data.containsKey("ban") && data["ban"].asBoolean) {
                val banTime = data["ban_duration"].asIntOrNull ?: (30 * 60)
                if (banTime <= 0) return
                GroupSvc.banMember(record.peerUin, record.senderUin, banTime)
            }
        } catch (e: Throwable) {
            LogCenter.log("处理快速操作错误: $e", Level.WARN)
        }
    }

    private suspend fun quicklyReply(
        record: MsgRecord,
        message: JsonArray,
        msgHash: Int,
        atSender: Boolean,
        autoReply: Boolean
    ) {
        val messageList = mutableListOf<JsonElement>()
        message.filter {
            it.asJsonObject["type"]?.asString in actionMsgTypes
        }.let {
            if (it.isNotEmpty()) {
                it.map { listOf(it) }.forEach {
                    MsgSvc.sendToAio(record.chatType, record.peerUin.toString(), it.jsonArray)
                }
                return
            }
        }

        if (autoReply) messageList.add(mapOf(
            "type" to "reply",
            "data" to mapOf(
                "id" to msgHash
            )
        ).json) // 添加回复
        if (MsgConstant.KCHATTYPEGROUP == record.chatType && atSender) {
            messageList.add(mapOf(
                "type" to "at",
                "data" to mapOf(
                    "qq" to record.senderUin
                )
            ).json) // 添加@发送者
        }
        messageList.addAll(message)
        MsgSvc.sendToAio(record.chatType, record.peerUin.toString(), JsonArray(messageList))
    }
}