@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.internals

import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import io.kritor.event.GroupApplyType
import io.kritor.event.GroupMemberBanType
import io.kritor.event.GroupMemberDecreasedType
import io.kritor.event.GroupMemberIncreasedType
import io.kritor.event.MessageEvent
import io.kritor.event.NoticeEvent
import io.kritor.event.NoticeType
import io.kritor.event.RequestType
import io.kritor.event.RequestsEvent
import io.kritor.event.Scene
import io.kritor.event.contact
import io.kritor.event.essenceMessageNotice
import io.kritor.event.friendApplyRequest
import io.kritor.event.friendFileComeNotice
import io.kritor.event.friendPokeNotice
import io.kritor.event.friendRecallNotice
import io.kritor.event.groupAdminChangedNotice
import io.kritor.event.groupApplyRequest
import io.kritor.event.groupFileComeNotice
import io.kritor.event.groupMemberBannedNotice
import io.kritor.event.groupMemberDecreasedNotice
import io.kritor.event.groupMemberIncreasedNotice
import io.kritor.event.groupPokeNotice
import io.kritor.event.groupRecallNotice
import io.kritor.event.groupSignNotice
import io.kritor.event.groupUniqueTitleChangedNotice
import io.kritor.event.groupWholeBanNotice
import io.kritor.event.messageEvent
import io.kritor.event.noticeEvent
import io.kritor.event.requestsEvent
import io.kritor.event.sender
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import qq.service.QQInterfaces
import qq.service.msg.toKritorEventMessages

internal object GlobalEventTransmitter: QQInterfaces() {
    private val messageEventFlow by lazy {
        MutableSharedFlow<Pair<MsgRecord, MessageEvent>>()
    }
    private val noticeEventFlow by lazy {
        MutableSharedFlow<NoticeEvent>()
    }
    private val requestEventFlow by lazy {
        MutableSharedFlow<RequestsEvent>()
    }

    private suspend fun pushNotice(noticeEvent: NoticeEvent) = noticeEventFlow.emit(noticeEvent)

    private suspend fun pushRequest(requestEvent: RequestsEvent) = requestEventFlow.emit(requestEvent)

    private suspend fun transMessageEvent(record: MsgRecord, message: MessageEvent) = messageEventFlow.emit(record to message)

    object MessageTransmitter {
        suspend fun transGroupMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
        ): Boolean {
            transMessageEvent(record, messageEvent {
                this.time = record.msgTime.toInt()
                this.scene = Scene.GROUP
                this.messageId = record.msgId
                this.messageSeq = record.msgSeq
                this.contact = contact {
                    this.scene = scene
                    this.peer = record.peerUin.toString()
                    this.subPeer = record.peerUid
                }
                this.sender = sender {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }
                this.elements.addAll(elements.toKritorEventMessages(record))
            })
            return true
        }

        suspend fun transPrivateMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
        ): Boolean {
            transMessageEvent(record, messageEvent {
                this.time = record.msgTime.toInt()
                this.scene = Scene.FRIEND
                this.messageId = record.msgId
                this.messageSeq = record.msgSeq
                this.contact = contact {
                    this.scene = scene
                    this.peer = record.senderUin.toString()
                    this.subPeer = record.senderUid
                }
                this.sender = sender {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }
                this.elements.addAll(elements.toKritorEventMessages(record))
            })
            return true
        }

        suspend fun transTempMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
            groupCode: Long,
            fromNick: String,
        ): Boolean {
            transMessageEvent(record, messageEvent {
                this.time = record.msgTime.toInt()
                this.scene = Scene.FRIEND
                this.messageId = record.msgId
                this.messageSeq = record.msgSeq
                this.contact = contact {
                    this.scene = scene
                    this.peer = record.senderUin.toString()
                    this.subPeer = groupCode.toString()
                }
                this.sender = sender {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }
                this.elements.addAll(elements.toKritorEventMessages(record))
            })
            return true
        }

        suspend fun transGuildMessage(
            record: MsgRecord,
            elements: ArrayList<MsgElement>,
        ): Boolean {
            transMessageEvent(record, messageEvent {
                this.time = record.msgTime.toInt()
                this.scene = Scene.GUILD
                this.messageId = record.msgId
                this.messageSeq = record.msgSeq
                this.contact = contact {
                    this.scene = scene
                    this.peer = record.guildId ?: ""
                    this.subPeer = record.channelId ?: ""
                }
                this.sender = sender {
                    this.uin = record.senderUin
                    this.uid = record.senderUid
                    this.nick = record.sendNickName
                }
                this.elements.addAll(elements.toKritorEventMessages(record))
            })
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
            pushNotice(noticeEvent {
                this.type = NoticeType.FRIEND_FILE_COME
                this.time = msgTime.toInt()
                this.friendFileCome = friendFileComeNotice {
                    this.fileId = fileId
                    this.fileName = fileName
                    this.operator = userId
                    this.fileSize = fileSize
                    this.expireTime = expireTime.toInt()
                    this.fileSubId = fileSubId
                    this.url = url
                }
            })
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
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_FILE_COME
                this.time = msgTime.toInt()
                this.groupFileCome = groupFileComeNotice {
                    this.groupId = groupId
                    this.operator = userId
                    this.fileId = uuid
                    this.fileName = fileName
                    this.fileSize = fileSize
                    this.biz = bizId
                    this.url = url
                }
            })
            return true
        }
    }

    /**
     * 群聊通知 通知器
     */
    object GroupNoticeTransmitter {
        suspend fun transGroupSign(time: Long, target: Long, action: String?, rankImg: String?, groupCode: Long): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_SIGN
                this.time = time.toInt()
                this.groupSign = groupSignNotice {
                    this.groupId = groupCode
                    this.targetUin = target
                    this.action = action ?: ""
                    this.suffix = ""
                    this.rankImage = rankImg ?: ""
                }
            })
            return true
        }

        suspend fun transGroupPoke(time: Long, operator: Long, target: Long, action: String?, suffix: String?, actionImg: String?, groupCode: Long): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_POKE
                this.time = time.toInt()
                this.groupPoke = groupPokeNotice {
                    this.action = action ?: ""
                    this.target = target
                    this.operator = operator
                    this.suffix = suffix ?: ""
                    this.actionImage = actionImg ?: ""
                }
            })
            return true
        }

        suspend fun transGroupMemberNumIncreased(
            time: Long,
            target: Long,
            targetUid: String,
            groupCode: Long,
            operator: Long,
            operatorUid: String,
            type: GroupMemberIncreasedType
        ): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_MEMBER_INCREASE
                this.time = time.toInt()
                this.groupMemberIncrease = groupMemberIncreasedNotice {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.type = type
                }
            })
            return true
        }

        suspend fun transGroupMemberNumDecreased(
            time: Long,
            target: Long,
            targetUid: String,
            groupCode: Long,
            operator: Long,
            operatorUid: String,
            type: GroupMemberDecreasedType
        ): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_MEMBER_INCREASE
                this.time = time.toInt()
                this.groupMemberDecrease = groupMemberDecreasedNotice {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.type = type
                }
            })
            return true
        }

        suspend fun transGroupAdminChanged(
            msgTime: Long,
            target: Long,
            targetUid: String,
            groupCode: Long,
            setAdmin: Boolean
        ): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_ADMIN_CHANGED
                this.time = msgTime.toInt()
                this.groupAdminChanged = groupAdminChangedNotice {
                    this.groupId = groupCode
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.isAdmin = setAdmin
                }
            })
            return true
        }

        suspend fun transGroupWholeBan(
            msgTime: Long,
            operator: Long,
            groupCode: Long,
            isOpen: Boolean
        ): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_WHOLE_BAN
                this.time = msgTime.toInt()
                this.groupWholeBan = groupWholeBanNotice {
                    this.groupId = groupCode
                    this.isWholeBan = isOpen
                    this.operator = operator
                }
            })
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
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_MEMBER_BANNED
                this.time = msgTime.toInt()
                this.groupMemberBanned = groupMemberBannedNotice {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.duration = duration
                    this.type = if (duration > 0) GroupMemberBanType.BAN
                    else GroupMemberBanType.LIFT_BAN
                }
            })
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
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_RECALL
                this.time = time.toInt()
                this.groupRecall = groupRecallNotice {
                    this.groupId = groupCode
                    this.operatorUid = operatorUid
                    this.operatorUin = operator
                    this.targetUid = targetUid
                    this.targetUin = target
                    this.messageId = msgId
                    this.tipText = tipText
                }
            })
            return true
        }

        suspend fun transCardChange(
            time: Long,
            targetId: Long,
            oldCard: String,
            newCard: String,
            groupId: Long
        ): Boolean {

            return true
        }

        suspend fun transTitleChange(
            time: Long,
            targetId: Long,
            title: String,
            groupId: Long
        ): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_MEMBER_UNIQUE_TITLE_CHANGED
                this.time = time.toInt()
                this.groupMemberUniqueTitleChanged = groupUniqueTitleChangedNotice {
                    this.groupId = groupId
                    this.target = targetId
                    this.title = title
                }
            })
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
            pushNotice(noticeEvent {
                this.type = NoticeType.GROUP_ESSENCE_CHANGED
                this.time = time.toInt()
                this.groupEssenceChanged = essenceMessageNotice {
                    this.groupId = groupId
                    this.messageId = msgId
                    this.sender = senderUin
                    this.operator = operatorUin
                    this.subType = subType.toInt()
                }
            })
            return true
        }
    }

    /**
     * 私聊通知 通知器
     */
    object PrivateNoticeTransmitter {
        suspend fun transPrivatePoke(msgTime: Long, operator: Long, target: Long, action: String?, suffix: String?, actionImg: String?): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.FRIEND_POKE
                this.time = msgTime.toInt()
                this.friendPoke = friendPokeNotice {
                    this.action = action ?: ""
                    this.target = target
                    this.operator = operator
                    this.suffix = suffix ?: ""
                    this.actionImage = actionImg ?: ""
                }
            })
            return true
        }

        suspend fun transPrivateRecall(time: Long, operator: Long, msgId: Long, tipText: String): Boolean {
            pushNotice(noticeEvent {
                this.type = NoticeType.FRIEND_RECALL
                this.time = time.toInt()
                this.friendRecall = friendRecallNotice {
                    this.operator = operator
                    this.messageId = msgId
                    this.tipText = tipText
                }
            })
            return true
        }

    }

    /**
     * 请求 通知器
     */
    object RequestTransmitter {
        suspend fun transFriendApp(time: Long, operator: Long, tipText: String, flag: String): Boolean {
            pushRequest(requestsEvent {
                this.type = RequestType.FRIEND_APPLY
                this.time = time.toInt()
                this.friendApply = friendApplyRequest {
                    this.applierUin = operator
                    this.message = tipText
                    this.flag = flag
                }
            })
            return true
        }

        suspend fun transGroupApply(
            time: Long,
            applier: Long,
            applierUid: String,
            reason: String,
            groupCode: Long,
            flag: String,
            type: GroupApplyType
        ): Boolean {
            pushRequest(requestsEvent {
                this.type = RequestType.GROUP_APPLY
                this.time = time.toInt()
                this.groupApply = groupApplyRequest {
                    this.applierUid = applierUid
                    this.applierUin = applier
                    this.groupId = groupCode
                    this.reason = reason
                    this.flag = flag
                    this.type = type
                }
            })
            return true
        }
    }

    suspend inline fun onMessageEvent(collector: FlowCollector<Pair<MsgRecord, MessageEvent>>) {
        messageEventFlow.collect {
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