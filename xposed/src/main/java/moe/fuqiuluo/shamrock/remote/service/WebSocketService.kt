@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service

import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.msg.toSegment
import moe.fuqiuluo.shamrock.helper.ErrorTokenException
import moe.fuqiuluo.shamrock.remote.service.api.WebSocketPushServlet
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.remote.service.data.BotStatus
import moe.fuqiuluo.shamrock.remote.service.data.Self
import moe.fuqiuluo.shamrock.remote.service.data.push.*
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import java.net.URI

internal class WebSocketService(port: Int): WebSocketPushServlet(port) {
    fun pushMetaLifecycle() {
        GlobalScope.launch {
            val runtime = AppRuntimeFetcher.appRuntime
            val curUin = runtime.currentAccountUin
            pushTo(PushMetaEvent(
                time = System.currentTimeMillis() / 1000,
                selfId = app.longAccountUin,
                postType = PostType.Meta,
                type = MetaEventType.LifeCycle,
                subType = MetaSubType.Connect,
                status = BotStatus(
                    Self("qq", curUin.toLong()), runtime.isLogin, status = "正常", good = true
                ),
                interval = 15000
            ))
        }
    }

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
        pushMsg(record, elements, raw, msgHash, MsgType.Private, MsgSubType.Friend)
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
            target = userId
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
            groupId =  groupId,
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
        pushNotice(time, NoticeType.GroupBan, if (duration == 0) NoticeSubType.LiftBan else NoticeSubType.Ban, operation, userId, groupId, duration)
    }

    override fun pushGroupMemberDecreased(
        time: Long,
        target: Long,
        groupId: Long,
        operation: Long,
        type: NoticeType,
        subType: NoticeSubType
    ) {
        pushNotice(time, type, subType, operation, target, groupId)
    }

    override fun pushGroupAdminChange(time: Long, target: Long, groupId: Long, setAdmin: Boolean) {
        pushNotice(time, NoticeType.GroupAdminChange, if (setAdmin) NoticeSubType.Set else NoticeSubType.UnSet, 0, target, groupId)
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
            pushTo(
                PushNotice(
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
                )
            )
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
            pushTo(PushMessage(
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
                message = if (ShamrockConfig.useCQ()) raw.json else elements.toSegment(record.chatType, record.peerUin.toString()).json,
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
            ))
        }
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        val token = ShamrockConfig.getToken()
        if (token.isNotBlank()) {
            var accessToken = handshake.getFieldValue("access_token")
                .ifNullOrEmpty(handshake.getFieldValue("ticket"))
                .ifNullOrEmpty(handshake.getFieldValue("Authorization"))
                ?: throw ErrorTokenException
            if (accessToken.startsWith("Bearer ")) {
                accessToken = accessToken.substring(7)
            }
            if (token != accessToken) {
                conn.close()
                LogCenter.log({ "WSServer连接错误(${conn.remoteSocketAddress.address.hostAddress}:${conn.remoteSocketAddress.port}) 没有提供正确的token, $accessToken。" }, Level.ERROR)
                return
            }
        }
        val path = URI.create(handshake.resourceDescriptor).path
        if (path != "/api") {
            pushMetaLifecycle()
            eventReceivers.add(conn)
        }
        LogCenter.log({ "WSServer连接(${conn.remoteSocketAddress.address.hostAddress}:${conn.remoteSocketAddress.port}$path)" }, Level.DEBUG)
    }
}