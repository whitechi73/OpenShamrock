@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.internals

import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import io.kritor.event.*
import io.kritor.common.PushMessageBody
import io.kritor.common.Contact
import io.kritor.common.Sender
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import qq.service.QQInterfaces
import qq.service.msg.toKritorEventMessages

internal object GlobalEventTransmitter : QQInterfaces() {
    private val MessageEventFlow by lazy {
        MutableSharedFlow<Pair<MsgRecord, PushMessageBody>>()
    }
    private val noticeEventFlow by lazy {
        MutableSharedFlow<NoticeEvent>()
    }
    private val requestEventFlow by lazy {
        MutableSharedFlow<RequestsEvent>()
    }

    private suspend fun pushNotice(noticeEvent: NoticeEvent) = noticeEventFlow.emit(noticeEvent)

    private suspend fun pushRequest(requestEvent: RequestsEvent) = requestEventFlow.emit(requestEvent)

    private suspend fun transMessageEvent(record: MsgRecord, message: PushMessageBody) =
        MessageEventFlow.emit(record to message)

    object MessageTransmitter {
        suspend fun transGroupMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
        ): Boolean {
            transMessageEvent(record, PushMessageBody.newBuilder().apply {
                this.time = record.msgTime.toInt()
                this.messageId = record.msgId.toString()
                this.messageSeq = record.msgSeq
                this.contact = Contact.newBuilder().apply {
                    this.scene = scene
                    this.peer = record.peerUin.toString()
                    this.subPeer = record.peerUid
                }.build()
                this.sender = Sender.newBuilder().apply {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }.build()
                this.addAllElements(elements.toKritorEventMessages(record))
            }.build())
            return true
        }

        suspend fun transPrivateMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
        ): Boolean {
            transMessageEvent(record, PushMessageBody.newBuilder().apply {
                this.time = record.msgTime.toInt()
                this.messageId = record.msgId.toString()
                this.messageSeq = record.msgSeq
                this.contact = Contact.newBuilder().apply {
                    this.scene = scene
                    this.peer = record.senderUin.toString()
                    this.subPeer = record.senderUid
                }.build()
                this.sender = Sender.newBuilder().apply {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }.build()
                this.addAllElements(elements.toKritorEventMessages(record))
            }.build())
            return true
        }

        suspend fun transTempMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
            groupCode: Long,
            fromNick: String,
        ): Boolean {
            transMessageEvent(record, PushMessageBody.newBuilder().apply {
                this.time = record.msgTime.toInt()
                this.messageId = record.msgId.toString()
                this.messageSeq = record.msgSeq
                this.contact = Contact.newBuilder().apply  {
                    this.scene = scene
                    this.peer = record.senderUin.toString()
                    this.subPeer = groupCode.toString()
                }.build()
                this.sender = Sender.newBuilder().apply {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }.build()
                this.addAllElements(elements.toKritorEventMessages(record))
            }.build())
            return true
        }

        suspend fun transGuildMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
        ): Boolean {
            transMessageEvent(record, PushMessageBody.newBuilder().apply {
                this.time = record.msgTime.toInt()
                this.messageId = record.msgId.toString()
                this.messageSeq = record.msgSeq
                this.contact = Contact.newBuilder().apply {
                    this.scene = scene
                    this.peer = record.guildId ?: ""
                    this.subPeer = record.channelId ?: ""
                }.build()
                this.sender = Sender.newBuilder().apply {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }.build()
                this.addAllElements(elements.toKritorEventMessages(record))
            }.build())
            return true
        }
    }

    /**
     * 文件通知 通知器
     **/
    object FileNoticeTransmitter {
        /**
         * 推送私聊文件事件
         */
        suspend fun transPrivateFileEvent(
            msgTime: Long,
            userId: Long,
            fileId: String,
            fileSubId: String,
            fileName: String,
            fileSize: Long,
            expireTime: Long,
            url: String
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.FRIEND_FILE_COME
                this.time = msgTime.toInt()
                this.friendFileUploaded = FriendFileUploadedNotice.newBuilder().apply {
                    this.fileId = fileId
                    this.fileName = fileName
                    this.operatorUin = userId
                    this.fileSize = fileSize
                    this.expireTime = expireTime.toInt()
                    this.fileSubId = fileSubId
                    this.url = url
                }.build()
            }.build())
            return true
        }

        /**
         * 推送私聊文件事件
         */
        suspend fun transGroupFileEvent(
            msgTime: Long,
            userId: Long,
            groupId: Long,
            uuid: String,
            fileName: String,
            fileSize: Long,
            bizId: Int,
            url: String
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_FILE_COME
                this.time = msgTime.toInt()
                this.groupFileUploaded = GroupFileUploadedNotice.newBuilder().apply {
                    this.groupId = groupId
                    this.operatorUin = userId
                    this.fileId = uuid
                    this.fileName = fileName
                    this.fileSize = fileSize
                    this.biz = bizId
                    this.url = url
                }.build()
            }.build())
            return true
        }
    }

    /**
     * 群聊通知 通知器
     */
    object GroupNoticeTransmitter {
        suspend fun transGroupSign(
            time: Long,
            target: Long,
            action: String?,
            rankImg: String?,
            groupCode: Long
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_SIGN
                this.time = time.toInt()
                this.groupSignIn = GroupSignInNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.targetUin = target
                    this.action = action ?: ""
                    this.suffix = ""
                    this.rankImage = rankImg ?: ""
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupPoke(
            time: Long,
            operator: Long,
            target: Long,
            action: String?,
            suffix: String?,
            actionImg: String?,
            groupCode: Long
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_POKE
                this.time = time.toInt()
                this.groupPoke = GroupPokeNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.action = action ?: ""
                    this.targetUin = target
                    this.operatorUin = operator
                    this.suffix = suffix ?: ""
                    this.actionImage = actionImg ?: ""
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupMemberNumIncreased(
            time: Long,
            target: Long,
            targetUid: String,
            groupCode: Long,
            operator: Long,
            operatorUid: String,
            type: GroupMemberIncreasedNotice.GroupMemberIncreasedType
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_MEMBER_INCREASE
                this.time = time.toInt()
                this.groupMemberIncrease = GroupMemberIncreasedNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.type = type
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupMemberNumDecreased(
            time: Long,
            target: Long,
            targetUid: String,
            groupCode: Long,
            operator: Long,
            operatorUid: String,
            type: GroupMemberDecreasedNotice.GroupMemberDecreasedType
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_MEMBER_INCREASE
                this.time = time.toInt()
                this.groupMemberDecrease = GroupMemberDecreasedNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.type = type
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupAdminChanged(
            msgTime: Long,
            target: Long,
            targetUid: String,
            groupCode: Long,
            setAdmin: Boolean
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_ADMIN_CHANGED
                this.time = msgTime.toInt()
                this.groupAdminChange = GroupAdminChangedNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.isAdmin = setAdmin
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupWholeBan(
            msgTime: Long,
            operator: Long,
            groupCode: Long,
            isOpen: Boolean
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_WHOLE_BAN
                this.time = msgTime.toInt()
                this.groupWholeBan = GroupWholeBanNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.isBan = isOpen
                    this.operatorUin = operator
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupBan(
            msgTime: Long,
            operator: Long,
            operatorUid: String,
            target: Long,
            targetUid: String,
            groupCode: Long,
            duration: Int
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_MEMBER_BANNED
                this.time = msgTime.toInt()
                this.groupMemberBan = GroupMemberBanNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.duration = duration
                    this.type = if (duration > 0) GroupMemberBanNotice.GroupMemberBanType.BAN
                    else GroupMemberBanNotice.GroupMemberBanType.LIFT_BAN
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupMsgRecall(
            time: Long,
            operator: Long,
            operatorUid: String,
            target: Long,
            targetUid: String,
            groupCode: Long,
            msgId: Long,
            tipText: String
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_RECALL
                this.time = time.toInt()
                this.groupRecall = GroupRecallNotice.newBuilder().apply {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.messageId = msgId.toString()
                    this.tipText = tipText
                }.build()
            }.build())
            return true
        }

        suspend fun transCardChange(
            time: Long,
            targetId: Long,
            newCard: String,
            groupId: Long
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_CARD_CHANGED
                this.time = time.toInt()
                this.groupCardChanged = GroupCardChangedNotice.newBuilder().apply {
                    this.groupId = groupId
                    this.targetUin = targetId
                    this.newCard = newCard
                }.build()
            }.build())
            return true
        }

        suspend fun transTitleChange(
            time: Long,
            targetId: Long,
            title: String,
            groupId: Long
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_MEMBER_UNIQUE_TITLE_CHANGED
                this.time = time.toInt()
                this.groupMemberUniqueTitleChanged = GroupUniqueTitleChangedNotice.newBuilder().apply {
                    this.groupId = groupId
                    this.target = targetId
                    this.title = title
                }.build()
            }.build())
            return true
        }

        suspend fun transEssenceChange(
            time: Long,
            senderUin: Long,
            operatorUin: Long,
            msgId: Long,
            groupId: Long,
            subType: UInt
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.GROUP_ESSENCE_CHANGED
                this.time = time.toInt()
                this.groupEssenceChanged = GroupEssenceMessageNotice.newBuilder().apply {
                    this.groupId = groupId
                    this.messageId = msgId.toString()
                    this.targetUin = senderUin
                    this.operatorUin = operatorUin
                    this.subType = subType.toInt()
                }.build()
            }.build())
            return true
        }
    }

    /**
     * 私聊通知 通知器
     */
    object PrivateNoticeTransmitter {
        suspend fun transPrivatePoke(
            msgTime: Long,
            operator: Long,
            target: Long,
            action: String?,
            suffix: String?,
            actionImg: String?
        ): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.FRIEND_POKE
                this.time = msgTime.toInt()
                this.friendPoke = FriendPokeNotice.newBuilder().apply {
                    this.action = action ?: ""
                    this.operatorUin = operator
                    this.suffix = suffix ?: ""
                    this.actionImage = actionImg ?: ""
                }.build()
            }.build())
            return true
        }

        suspend fun transPrivateRecall(time: Long, operator: Long, msgId: Long, tipText: String): Boolean {
            pushNotice(NoticeEvent.newBuilder().apply {
                this.type = NoticeEvent.NoticeType.FRIEND_RECALL
                this.time = time.toInt()
                this.friendRecall = FriendRecallNotice.newBuilder().apply {
                    this.operatorUin = operator
                    this.messageId = msgId.toString()
                    this.tipText = tipText
                }.build()
            }.build())
            return true
        }

    }

    /**
     * 请求 通知器
     */
    object RequestTransmitter {
        suspend fun transFriendApp(time: Long, operator: Long, tipText: String, flag: String): Boolean {
            pushRequest(RequestsEvent.newBuilder().apply {
                this.type = RequestsEvent.RequestType.FRIEND_APPLY
                this.time = time.toInt()
                this.friendApply = FriendApplyRequest.newBuilder().apply {
                    this.applierUin = operator
                    this.message = tipText
                    this.flag = flag
                }.build()
            }.build())
            return true
        }

        suspend fun transGroupApply(
            time: Long,
            applierUin: Long,
            applierUid: String,
            reason: String,
            groupCode: Long,
            flag: String
        ): Boolean {
            pushRequest(RequestsEvent.newBuilder().apply {
                this.type = RequestsEvent.RequestType.GROUP_APPLY
                this.time = time.toInt()
                this.groupApply = GroupApplyRequest.newBuilder().apply {
                    this.applierUid = applierUid
                    this.applierUin = applierUin
                    this.groupId = groupCode
                    this.reason = reason
                    this.flag = flag
                }.build()
            }.build())
            return true
        }
    }

    suspend inline fun onMessageEvent(collector: FlowCollector<Pair<MsgRecord, PushMessageBody>>) {
        MessageEventFlow.collect {
            GlobalScope.launch {
                collector.emit(it)
            }
        }
    }

    suspend inline fun onNoticeEvent(collector: FlowCollector<NoticeEvent>) {
        noticeEventFlow.collect {
            GlobalScope.launch {
                collector.emit(it)
            }
        }
    }

    suspend inline fun onRequestEvent(collector: FlowCollector<RequestsEvent>) {
        requestEventFlow.collect {
            GlobalScope.launch {
                collector.emit(it)
            }
        }
    }
}