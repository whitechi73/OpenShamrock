package moe.fuqiuluo.shamrock.remote.service.api

import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.toSegments
import moe.fuqiuluo.shamrock.remote.service.HttpService
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.remote.service.data.push.GroupFileMsg
import moe.fuqiuluo.shamrock.remote.service.data.push.MemberRole
import moe.fuqiuluo.shamrock.remote.service.data.push.MsgSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.MsgType
import moe.fuqiuluo.shamrock.remote.service.data.push.PostType
import moe.fuqiuluo.shamrock.remote.service.data.push.MessageEvent
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeEvent
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeType
import moe.fuqiuluo.shamrock.remote.service.data.push.PrivateFileMsg
import moe.fuqiuluo.shamrock.remote.service.data.push.Sender
import moe.fuqiuluo.shamrock.tools.ShamrockDsl
import moe.fuqiuluo.shamrock.tools.json
import java.util.ArrayList

internal object GlobalEventTransmitter: BaseSvc() {
    private val messageEventFlow by lazy {
        MutableSharedFlow<Pair<MsgRecord, MessageEvent>>()
    }
    private val noticeEventFlow by lazy {
        MutableSharedFlow<NoticeEvent>()
    }

    private fun pushNotice(noticeEvent: NoticeEvent) = noticeEventFlow.tryEmit(noticeEvent)

    private fun transMessageEvent(record: MsgRecord, message: MessageEvent) = messageEventFlow.tryEmit(record to message)

    /**
     * 消息 手淫器
     */
    object MessageTransmitter {
        /**
         * 推送群聊消息
         */
        suspend fun transGroupMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
            rawMsg: String,
            msgHash: Int,
            postType: PostType = PostType.Msg
        ): Boolean {
            val uin = app.longAccountUin
            return transMessageEvent(record,
                MessageEvent(
                    time = record.msgTime,
                    selfId = uin,
                    postType = postType,
                    messageType = MsgType.Group,
                    subType = MsgSubType.NORMAL,
                    messageId = msgHash,
                    groupId = record.peerUin,
                    peerId = uin,
                    userId = record.senderUin,
                    message = if(ShamrockConfig.useCQ()) rawMsg.json
                    else elements.toSegments(record.chatType, record.peerUin.toString()).map {
                        it.toJson()
                    }.json,
                    rawMessage = rawMsg,
                    font = 0,
                    sender = Sender(
                        userId = record.senderUin,
                        nickname = record.sendNickName,
                        card = record.sendMemberName,
                        role = when (record.senderUin) {
                            GroupSvc.getOwner(record.peerUin.toString()) -> MemberRole.Owner
                            in GroupSvc.getAdminList(record.peerUin.toString()) -> MemberRole.Admin
                            else -> MemberRole.Member
                        },
                        title = "",
                        level = "",
                    )
                )
            )
        }

        /**
         * 推送私聊消息
         */
        suspend fun transPrivateMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
            rawMsg: String,
            msgHash: Int,
            postType: PostType = PostType.Msg
        ): Boolean {
            val uin = app.longAccountUin
            return transMessageEvent(record,
                MessageEvent(
                    time = record.msgTime,
                    selfId = uin,
                    postType = postType,
                    messageType = MsgType.Private,
                    subType = MsgSubType.Friend,
                    messageId = msgHash,
                    targetId = record.peerUin,
                    peerId = uin,
                    userId = record.senderUin,
                    message = if(ShamrockConfig.useCQ()) rawMsg.json
                    else elements.toSegments(record.chatType, record.peerUin.toString()).map {
                        it.toJson()
                    }.json,
                    rawMessage = rawMsg,
                    font = 0,
                    sender = Sender(
                        userId = record.senderUin,
                        nickname = record.sendNickName,
                        card = record.sendMemberName,
                        role = when (record.senderUin) {
                            GroupSvc.getOwner(record.peerUin.toString()) -> MemberRole.Owner
                            in GroupSvc.getAdminList(record.peerUin.toString()) -> MemberRole.Admin
                            else -> MemberRole.Member
                        },
                        title = "",
                        level = "",
                    )
                )
            )
        }
    }

    /**
     * 文件通知 通知器
     */
    object FileNoticeTransmitter {
        /**
         * 推送私聊文件事件
         */
        fun transPrivateFileEvent(
            msgTime: Long,
            userId: Long,
            fileId: String,
            fileSubId: String,
            fileName: String,
            fileSize: Long,
            expireTime: Long,
            url: String
        ): Boolean {
            return pushNotice(NoticeEvent(
                time = msgTime,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.PrivateUpload,
                operatorId = userId,
                userId = userId,
                senderId = userId,
                privateFile = PrivateFileMsg(
                    id = fileId,
                    name = fileName,
                    size = fileSize,
                    url = url,
                    subId = fileSubId,
                    expire = expireTime
                )
            ))
        }

        /**
         * 推送私聊文件事件
         */
        fun transGroupFileEvent(
            msgTime: Long,
            userId: Long,
            groupId: Long,
            uuid: String,
            fileName: String,
            fileSize: Long,
            bizId: Int,
            url: String
        ): Boolean {
            return pushNotice(NoticeEvent(
                time = msgTime,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.GroupUpload,
                operatorId = userId,
                userId = userId,
                groupId = groupId,
                file = GroupFileMsg(
                    id = uuid,
                    name = fileName,
                    size = fileSize,
                    busid = bizId.toLong(),
                    url = url
                )
            ))
        }
    }

    /**
     * 群聊通知 通知器
     */
    object GroupNoticeTransmitter {
        fun transGroupPoke(time: Long, operation: Long, target: Long, groupCode: Long): Boolean {
            return pushNotice(NoticeEvent(
                time = time,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.Notify,
                subType = NoticeSubType.Poke,
                operatorId = operation,
                userId = operation,
                groupId = groupCode,
                target = target
            ))
        }

        fun transGroupMemberNumChanged(
            time: Long,
            target: Long,
            groupCode: Long,
            operation: Long,
            noticeType: NoticeType,
            noticeSubType: NoticeSubType
        ): Boolean {
            return pushNotice(NoticeEvent(
                time = time,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = noticeType,
                subType = noticeSubType,
                operatorId = operation,
                userId = operation,
                senderId = operation,
                target = target,
                groupId = groupCode
            ))
        }

        fun transGroupAdminChanged(
            msgTime: Long,
            target: Long,
            groupCode: Long,
            setAdmin: Boolean
        ): Boolean {
            return pushNotice(NoticeEvent(
                time = msgTime,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.GroupAdminChange,
                subType = if (setAdmin) NoticeSubType.Set else NoticeSubType.UnSet,
                operatorId = 0,
                target = target,
                groupId = groupCode
            ))
        }

        fun transGroupBan(
            msgTime: Long,
            operation: Long,
            target: Long,
            groupCode: Long,
            duration: Int
        ): Boolean {
            return pushNotice(NoticeEvent(
                time = msgTime,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.GroupBan,
                subType = if (duration == 0) NoticeSubType.LiftBan else NoticeSubType.Ban,
                operatorId = operation,
                userId = operation,
                senderId = operation,
                target = target,
                groupId = groupCode,
                duration = duration
            ))
        }

        fun transGroupMsgRecall(
            time: Long,
            operator: Long,
            target: Long,
            groupCode: Long,
            msgHash: Int,
            tipText: String
        ): Boolean {
            return pushNotice(NoticeEvent(
                time = time,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.GroupRecall,
                operatorId = operator,
                userId = target,
                msgId = msgHash,
                tip = tipText,
                groupId = groupCode
            ))
        }
    }

    /**
     * 私聊通知 通知器
     */
    object PrivateNoticeTransmitter {
        fun transPrivatePoke(msgTime: Long, operation: Long, target: Long): Boolean {
            return pushNotice(NoticeEvent(
                time = msgTime,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.Notify,
                subType = NoticeSubType.Poke,
                operatorId = operation,
                userId = operation,
                senderId = operation,
                target = target
            ))
        }

        fun transPrivateRecall(time: Long, operation: Long, msgHashId: Int, tipText: String): Boolean {
            return pushNotice(NoticeEvent(
                time = time,
                selfId = app.longAccountUin,
                postType = PostType.Notice,
                type = NoticeType.FriendRecall,
                subType = NoticeSubType.Poke,
                operatorId = operation,
                userId = operation,
                msgId = msgHashId,
                tip = tipText
            ))
        }
    }

    @ShamrockDsl
    suspend fun onMessageEvent(collector: FlowCollector<Pair<MsgRecord, MessageEvent>>) {
        messageEventFlow.collect(collector)
    }

    @ShamrockDsl
    suspend fun onNoticeEvent(collector: FlowCollector<NoticeEvent>) {
        noticeEventFlow.collect(collector)
    }
}



