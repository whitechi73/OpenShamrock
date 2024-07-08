@file:OptIn(DelicateCoroutinesApi::class)
package qq.service.internals

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qphone.base.remote.FromServiceMsg
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.msg.api.IMsgService
import io.kritor.event.GroupMemberDecreasedNotice.GroupMemberDecreasedType
import io.kritor.event.GroupMemberIncreasedNotice.GroupMemberIncreasedType
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.io.core.readBytes
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.readBuf32Long
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.message.ContentHead
import protobuf.message.MsgBody
import protobuf.message.ResponseHead
import protobuf.push.C2CCommonTipsEvent
import protobuf.push.C2CRecallEvent
import protobuf.push.FriendApplyEvent
import protobuf.push.GroupAdminChangeEvent
import protobuf.push.GroupApplyEvent
import protobuf.push.GroupBanEvent
import protobuf.push.GroupCommonTipsEvent
import protobuf.push.GroupInviteEvent
import protobuf.push.GroupInvitedApplyEvent
import protobuf.push.GroupListChangeEvent
import protobuf.push.MessagePush
import protobuf.push.MessagePushClientInfo
import qq.service.QQInterfaces
import qq.service.contact.ContactHelper
import qq.service.friend.FriendHelper.requestFriendSystemMsgNew
import qq.service.group.GroupHelper
import qq.service.group.GroupHelper.requestGroupSystemMsgNew
import qq.service.msg.MessageHelper
import kotlin.coroutines.resume

internal object PrimitiveListener {

    fun onPush(fromServiceMsg: FromServiceMsg) {
        if (fromServiceMsg.wupBuffer == null) return
        try {
            val push = fromServiceMsg.wupBuffer.slice(4)
                .decodeProtobuf<MessagePush>()
            GlobalScope.launch {
                onMsgPush(push)
            }
        } catch (e: Exception) {
            LogCenter.log(e.stackTraceToString(), Level.WARN)
        }
    }

    private suspend fun onMsgPush(push: MessagePush) {
        if (
            push.msgBody == null ||
            push.msgBody!!.contentHead == null ||
            push.msgBody!!.body == null ||
            push.msgBody!!.contentHead!!.msgTime == null
        ) return
        val msgBody = push.msgBody!!
        val contentHead = msgBody.contentHead!!
        val msgType = contentHead.msgType
        val subType = contentHead.msgSubType
        val msgTime = contentHead.msgTime!!
        val body = msgBody.body!!
        try {
            when (msgType) {
                33 -> onGroupMemIncreased(msgTime, body)
                34 -> onGroupMemberDecreased(msgTime, body)
                44 -> onGroupAdminChange(msgTime, body)
                82 -> onGroupMessage(msgTime, body)
                84 -> onGroupApply(msgTime, contentHead, body)
                87 -> onInviteGroup(msgTime, msgBody.msgHead!!, body)
                528 -> when (subType) {
                    35 -> onFriendApply(msgTime, push.clientInfo!!, body)
                    39 -> onCardChange(msgTime, body)
                    68 -> onGroupApply(msgTime, contentHead, body)
                    138 -> onC2CRecall(msgTime, body)
                    290 -> onC2CPoke(msgTime, body)
                }

                732 -> when (subType) {
                    12 -> onGroupBan(msgTime, body)
                    16 -> onGroupUniqueTitleChange(msgTime, body)
                    17 -> onGroupRecall(msgTime, body)
                    20 -> onGroupCommonTips(msgTime, body)
                    21 -> onEssenceMessage(msgTime, push.clientInfo, body)
                }
            }
        } catch (e: Exception) {
            LogCenter.log("onMsgPush(msgType: $msgType, subType: $subType): " + e.stackTraceToString(), Level.WARN)
        }
    }

    private fun onGroupMessage(msgTime: Long, body: MsgBody) {

    }

    private suspend fun onC2CPoke(msgTime: Long, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<C2CCommonTipsEvent>()
        if (event.params == null) return

        val params = event.params!!.associate {
            it.key to it.value
        }

        val target = params["uin_str2"] ?: return
        val operation = params["uin_str1"] ?: return
        val suffix = params["suffix_str"] ?: ""
        val actionImg = params["action_img_url"] ?: ""
        val action = params["alt_str1"] ?: ""

        LogCenter.log("私聊戳一戳: $operation $action $target $suffix")

        if (!GlobalEventTransmitter.PrivateNoticeTransmitter
                .transPrivatePoke(msgTime, operation.toLong(), action, suffix, actionImg)
        ) {
            LogCenter.log("私聊戳一戳推送失败！", Level.WARN)
        }
    }

    private suspend fun onFriendApply(
        msgTime: Long,
        clientInfo: MessagePushClientInfo,
        body: MsgBody
    ) {
        val event = body.msgContent!!.decodeProtobuf<FriendApplyEvent>()
        if (event.head == null) return
        val head = event.head!!
        val applierUid = head.applierUid
        val msg = head.applyMsg ?: ""
        val source = head.source ?: ""
        var applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
        if (applier == 0L) {
            applier = clientInfo.liteHead?.sender?.toLong() ?: 0
        }
        val src = head.srcId
        val subSrc = head.subSrc
        val flag: String = try {
            val reqs = requestFriendSystemMsgNew(20, 0, 0)
            val req = reqs?.first {
                it.msg_time.get() == msgTime
            }
            val seq = req?.msg_seq?.get()
            "$seq;$src;$subSrc;$applier"
        } catch (err: Throwable) {
            "$msgTime;$src;$subSrc;$applier"
        }
        LogCenter.log("来自$applier 的好友申请：$msg ($source)")
        if (!GlobalEventTransmitter.RequestTransmitter
                .transFriendApp(msgTime, applierUid, applier, msg, flag)
        ) {
            LogCenter.log("好友申请推送失败！", Level.WARN)
        }
    }


    private suspend fun onCardChange(msgTime: Long, body: MsgBody) {
//        val event = runCatching {
//            body.msgContent!!.decodeProtobuf<GroupCardChangeEvent>()
//        }.getOrElse {
//            val readPacket = ByteReadPacket(body.msgContent!!)
//            readPacket.readBuf32Long()
//            readPacket.discardExact(1)
//
//            readPacket.readBytes(readPacket.readShort().toInt()).also {
//                readPacket.release()
//            }.decodeProtobuf<GroupCommonTipsEvent>()
//        }
//
//        val targetId = detail[1, 13, 2].asUtf8String
//        val newCardList = detail[1, 13, 3].asList
//        var newCard = ""
//        newCardList
//            .value
//            .forEach {
//                if (it[1].asInt == 1) {
//                    newCard = it[2].asUtf8String
//                }
//            }
//        val groupId = detail[1, 13, 4].asLong
//        var oldCard = ""
//        val targetQQ = ContactHelper.getUinByUidAsync(targetId).toLong()
//        LogCenter.log("群组[$groupId]成员$targetQQ 群名片变动 -> $newCard")
//        // oldCard暂时获取不到
//        if (!GlobalEventTransmitter.GroupNoticeTransmitter
//                .transCardChange(msgTime, targetQQ, oldCard, newCard, groupId)
//        ) {
//            LogCenter.log("群名片变动推送失败！", Level.WARN)
//        }
    }

    private suspend fun onGroupUniqueTitleChange(msgTime: Long, body: MsgBody) {
        val event = runCatching {
            body.msgContent!!.decodeProtobuf<GroupCommonTipsEvent>()
        }.getOrElse {
            val readPacket = ByteReadPacket(body.msgContent!!)
            readPacket.readBuf32Long()
            readPacket.discardExact(1)

            readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            }.decodeProtobuf<GroupCommonTipsEvent>()
        }
        val groupId = event.groupCode.toLong()
        if (event.uniqueTitleChangeDetail == null) {
            return
        }
        val detail = event.uniqueTitleChangeDetail!!.first()

        // todo 贴表情也走的 732 16 这里

        //detail = if (detail[5] is ProtoList) {
        //    (detail[5] as ProtoList).value[0]
        //} else {
        //    detail[5]
        // }

        val targetUin = detail.targetUin.toLong()

        // 恭喜<{\"cmd\":5,\"data\":\"qq\",\"text}\":\"nickname\"}>获得群主授予的<{\"cmd\":1,\"data\":\"https://qun.qq.com/qqweb/m/qun/medal/detail.html?_wv=16777223&bid=2504&gc=gid&isnew=1&medal=302&uin=uin\",\"text\":\"title\",\"url\":\"https://qun.qq.com/qqweb/m/qun/medal/detail.html?_wv=16777223&bid=2504&gc=gid&isnew=1&medal=302&uin=uin\"}>头衔
        val titleChangeInfo = detail.wording
        if (titleChangeInfo.indexOf("群主授予") == -1) {
            return
        }
        val titleJson = titleChangeInfo.split("获得群主授予的<")[1].replace(">头衔", "")
        val titleJsonObj = Json.decodeFromString<JsonElement>(titleJson).asJsonObject
        val title = titleJsonObj["text"].asString

        LogCenter.log("群组[$groupId]成员$targetUin 获得群头衔 -> $title")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transTitleChange(msgTime, targetUin, title, groupId)
        ) {
            LogCenter.log("群头衔变动推送失败！", Level.WARN)
        }
    }

    private suspend fun onEssenceMessage(
        msgTime: Long,
        clientInfo: MessagePushClientInfo?,
        body: MsgBody
    ) {
        if (clientInfo == null) return
        val event = runCatching {
            body.msgContent!!.decodeProtobuf<GroupCommonTipsEvent>()
        }.getOrElse {
            val readPacket = ByteReadPacket(body.msgContent!!)
            readPacket.readBuf32Long()
            readPacket.discardExact(1)

            readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            }.decodeProtobuf<GroupCommonTipsEvent>()
        }
        val groupId = event.groupCode.toLong()
        val detail = event.essenceMsgInfo!!.first()

        val msgSeq = event.msgSeq.toLong()
        val senderUin = detail.sender.toLong()
        val operatorUin = detail.operator.toLong()

        when (val type = detail.type) {
            1u -> {
                LogCenter.log("群设精消息(groupId=$groupId, sender=$senderUin, msgSeq=$msgSeq, operator=$operatorUin)")
            }
            2u -> {
                LogCenter.log("群撤精消息(groupId=$groupId, sender=$senderUin, msgId=$msgSeq, operator=$operatorUin)")
            }
            else -> error("onEssenceMessage unknown type: $type")
        }

        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, groupId.toString())
        val sourceRecord = withTimeoutOrNull(3000) {
            suspendCancellableCoroutine {
                QRoute.api(IMsgService::class.java).getMsgsBySeqAndCount(contact, msgSeq, 1, true) { _, _, records ->
                    it.resume(records)
                }
            }
        }?.firstOrNull()

        if (sourceRecord == null) {
            LogCenter.log("无法获取源消息记录，无法推送精华消息变动！", Level.WARN)
            return
        }

        val msgId  = sourceRecord.msgId
        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transEssenceChange(msgTime, senderUin, operatorUin, msgId, groupId, detail.type)
        ) {
            LogCenter.log("精华消息变动推送失败！", Level.WARN)
        }
    }


    private suspend fun onGroupCommonTips(time: Long, body: MsgBody) {
        val event = runCatching {
            body.msgContent!!.decodeProtobuf<GroupCommonTipsEvent>()
        }.getOrElse {
            val readPacket = ByteReadPacket(body.msgContent!!)
            readPacket.discardExact(4)
            readPacket.discardExact(1)

            readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            }.decodeProtobuf<GroupCommonTipsEvent>()
        }
        val groupId = event.groupCode.toLong()
        val detail = event.baseTips!!.first()

        val params = detail.params!!.associate {
            it.key to it.value
        }

        val target = params["uin_str2"] ?: params["mqq_uin"] ?: ""
        val operator = params["uin_str1"] ?: ""
        val suffix = params["suffix_str"] ?: ""
        val actionImg = params["action_img_url"] ?: ""
        val action = params["alt_str1"]
            ?: params["action_str"]
            ?: params["user_sign"]
            ?: ""
        val rankImg = params["rank_img"] ?: ""

        when (detail.type) {
            1061u -> {
                LogCenter.log("群戳一戳($groupId): $operator $action $target $suffix")
                if (!GlobalEventTransmitter.GroupNoticeTransmitter
                        .transGroupPoke(time, operator.toLong(), target.toLong(), action, suffix, actionImg, groupId)
                ) {
                    LogCenter.log("群戳一戳推送失败！", Level.WARN)
                }
            }

            1068u -> {
                LogCenter.log("群打卡($groupId): $action $target")
                if (!GlobalEventTransmitter.GroupNoticeTransmitter
                        .transGroupSign(time, target.toLong(), action, rankImg, groupId)
                ) {
                    LogCenter.log("群打卡推送失败！", Level.WARN)
                }
            }

            else -> {
                LogCenter.log("onGroupPokeAndGroupSign unknown type ${detail.type}", Level.WARN)
            }
        }
    }

    private suspend fun onC2CRecall(time: Long, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<C2CRecallEvent>()
        val head = event.head!!

        val operationUid = head.operator!!
        val operator = ContactHelper.getUinByUidAsync(operationUid).toLong()

        val msgSeq = head.msgSeq
        val tipText = head.wording?.wording ?: ""

        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, operationUid)
        val sourceRecord = withTimeoutOrNull(3000) {
            suspendCancellableCoroutine {
                QRoute.api(IMsgService::class.java).getMsgsBySeqAndCount(contact, msgSeq, 1, true) { _, _, records ->
                    it.resume(records)
                }
            }
        }?.firstOrNull()

        if (sourceRecord == null) {
            LogCenter.log("无法获取源消息记录，无法推送撤回消息！", Level.WARN)
            return
        }

        val msgId = sourceRecord.msgId

        LogCenter.log("私聊消息撤回: $operator, seq = $msgSeq, msgId = ${msgId}, tip = $tipText")

        if (!GlobalEventTransmitter.PrivateNoticeTransmitter
                .transPrivateRecall(time, operator, msgId, tipText)
        ) {
            LogCenter.log("私聊消息撤回推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemIncreased(time: Long, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<GroupListChangeEvent>()
        val groupCode = event.groupCode
        val targetUid = event.memberUid
        val type = event.type

        GroupHelper.getGroupMemberList(groupCode, true).onFailure {
            LogCenter.log("新成员加入刷新群成员列表失败: $groupCode", Level.WARN)
        }.onSuccess {
            LogCenter.log("新成员加入刷新群成员列表成功，群成员数量: ${it.size}", Level.INFO)
        }

        val operatorUid = event.operatorUid
        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群成员增加($groupCode): $target, type = $type")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMemberNumIncreased(
                    time,
                    target,
                    targetUid,
                    groupCode,
                    operator,
                    operatorUid,
                    when (type) {
                        130 -> GroupMemberIncreasedType.APPROVE
                        131 -> GroupMemberIncreasedType.INVITE
                        else -> GroupMemberIncreasedType.APPROVE
                    }
                )
        ) {
            LogCenter.log("群成员增加推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemberDecreased(time: Long, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<GroupListChangeEvent>()
        val groupCode = event.groupCode
        val targetUid = event.memberUid
        val type = event.type
        val operatorUid = event.operatorUid

        GroupHelper.getGroupMemberList(groupCode, true).onFailure {
            LogCenter.log("新成员加入刷新群成员列表失败: $groupCode", Level.WARN)
        }.onSuccess {
            LogCenter.log("新成员加入刷新群成员列表成功，群成员数量: ${it.size}", Level.INFO)
        }

        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        val subtype = when (type) {
            130 -> GroupMemberDecreasedType.LEAVE
            131 -> GroupMemberDecreasedType.KICK
            3 -> GroupMemberDecreasedType.KICK_ME
            else -> GroupMemberDecreasedType.KICK
        }

        LogCenter.log("群成员减少($groupCode): $target, type = $subtype ($type)")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMemberNumDecreased(
                    time,
                    target,
                    targetUid,
                    groupCode,
                    operator,
                    operatorUid,
                    subtype
                )
        ) {
            LogCenter.log("群成员减少推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupAdminChange(msgTime: Long, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<GroupAdminChangeEvent>()
        val groupCode = event.groupCode
        if (event.operation == null) return
        val operation = event.operation!!
        if (operation.setInfo == null && operation.unsetInfo == null) return

        val isSetAdmin: Boolean
        val targetUid: String
        if (operation.setInfo == null) {
            isSetAdmin = false
            targetUid = operation.unsetInfo!!.targetUid!!
        } else {
            isSetAdmin = true
            targetUid = operation.setInfo!!.targetUid!!
        }

        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群管理员变动($groupCode): $target, isSetAdmin = $isSetAdmin")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupAdminChanged(msgTime, target, targetUid, groupCode, isSetAdmin)
        ) {
            LogCenter.log("群管理员变动推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupBan(msgTime: Long, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<GroupBanEvent>()
        val groupCode = event.groupCode.toLong()
        val operatorUid = event.operatorUid
        val wholeBan = event.target?.target?.targetUid == null
        val targetUid = event.target?.target?.targetUid ?: ""
        val rawDuration = event.target?.target?.rawDuration?.toInt() ?: 0
        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val duration = if (wholeBan) -1 else rawDuration
        val target = if (wholeBan) 0 else ContactHelper.getUinByUidAsync(targetUid).toLong()

        if (wholeBan) {
            LogCenter.log("群全员禁言($groupCode): $operator -> ${if (rawDuration != 0) "开启" else "关闭"}")
            if (!GlobalEventTransmitter.GroupNoticeTransmitter
                    .transGroupWholeBan(msgTime, groupCode, operatorUid, operator, rawDuration != 0)
            ) {
                LogCenter.log("群禁言推送失败！", Level.WARN)
            }
        } else {
            LogCenter.log("群禁言($groupCode): $operator -> $target, 时长 = ${duration}s")
            if (!GlobalEventTransmitter.GroupNoticeTransmitter
                    .transGroupBan(msgTime, operator, operatorUid, target, targetUid, groupCode, duration)
            ) {
                LogCenter.log("群禁言推送失败！", Level.WARN)
            }
        }
    }

    private suspend fun onGroupRecall(time: Long, body: MsgBody) {
        val event = runCatching {
            body.msgContent!!.decodeProtobuf<GroupCommonTipsEvent>()
        }.getOrElse {
            val readPacket = ByteReadPacket(body.msgContent!!)
            readPacket.discardExact(4)
            readPacket.discardExact(1)
            readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            }.decodeProtobuf<GroupCommonTipsEvent>()
        }
        val groupCode = event.groupCode.toLong()
        val detail = event.recallDetails!!
        val operatorUid = detail.operatorUid
        val targetUid = detail.msgInfo!!.senderUid
        val msgSeq = detail.msgInfo!!.msgSeq.toLong()
        val tipText = detail.wording?.wording ?: ""

        val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, groupCode.toString())
        val sourceRecord = withTimeoutOrNull(3000) {
            suspendCancellableCoroutine {
                QRoute.api(IMsgService::class.java).getMsgsBySeqAndCount(contact, msgSeq, 1, true) { _, _, records ->
                    it.resume(records)
                }
            }
        }?.firstOrNull()

        if (sourceRecord == null) {
            LogCenter.log("无法获取源消息记录，无法推送撤回消息！", Level.WARN)
            return
        }

        val msgId = sourceRecord.msgId

        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群消息撤回($groupCode): $operator -> $target, seq = $msgSeq, id = $msgId, tip = $tipText")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMsgRecall(time, operator, operatorUid, target, targetUid, groupCode, msgId, tipText)
        ) {
            LogCenter.log("群消息撤回推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupApply(time: Long, contentHead: ContentHead, body: MsgBody) {
        when (contentHead.msgType) {
            84 -> {
                val event = body.msgContent!!.decodeProtobuf<GroupApplyEvent>()
                val groupCode = event.groupCode
                val applierUid = event.applierUid
                val reason = event.applyMsg ?: ""
                var applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
                if (applier == QQInterfaces.app.longAccountUin) {
                    return
                }
                val msgSeq = contentHead.msgSeq
                val flag = try {
                    var reqs = requestGroupSystemMsgNew(10, 1)
                    val riskReqs = requestGroupSystemMsgNew(5, 2)
                    reqs = reqs + riskReqs
                    val req = reqs.firstOrNull {
                        it.msg_time.get() == time && it.msg?.group_code?.get() == groupCode
                    }
                    val seq = req?.msg_seq?.get() ?: time
                    if (applier == 0L) {
                        applier = req?.req_uin?.get() ?: 0L
                    }
                    "$seq;$groupCode;$applier"
                } catch (err: Throwable) {
                    "$time;$groupCode;$applier"
                }
                LogCenter.log("入群申请($groupCode) $applier: \"$reason\", seq: $msgSeq")
                if (!GlobalEventTransmitter.RequestTransmitter
                        .transGroupApply(time, applier, applierUid, reason, groupCode, flag)
                ) {
                    LogCenter.log("入群申请推送失败！", Level.WARN)
                }
            }

            528 -> {
                val event = body.msgContent!!.decodeProtobuf<GroupInvitedApplyEvent>()
                val groupCode = event.applyInfo?.groupCode ?: return
                val applierUid = event.applyInfo?.applierUid ?: return
                var applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
                if (applier == QQInterfaces.app.longAccountUin) {
                    return
                }
                if ((event.applyInfo?.type ?: return) < 3) {
                    // todo
                    return
                }
                val flag = try {
                    var reqs = requestGroupSystemMsgNew(10, 1)
                    val riskReqs = requestGroupSystemMsgNew(5, 2)
                    reqs = reqs + riskReqs
                    val req = reqs.firstOrNull() {
                        it.msg_time.get() == time
                    }
                    val seq = req?.msg_seq?.get() ?: time
                    if (applier == 0L) {
                        applier = req?.req_uin?.get() ?: 0L
                    }
                    "$seq;$groupCode;$applier"
                } catch (err: Throwable) {
                    "$time;$groupCode;$applier"
                }
                LogCenter.log("邀请入群申请($groupCode): $applier")
                if (!GlobalEventTransmitter.RequestTransmitter
                        .transGroupApply(time, applier, applierUid, "", groupCode, flag)
                ) {
                    LogCenter.log("邀请入群申请推送失败！", Level.WARN)
                }
            }
        }
    }

    private suspend fun onInviteGroup(time: Long, msgHead: ResponseHead, body: MsgBody) {
        val event = body.msgContent!!.decodeProtobuf<GroupInviteEvent>()
        val groupCode = event.groupCode
        val invitorUid = event.inviterUid
        val invitor = ContactHelper.getUinByUidAsync(invitorUid).toLong()
        val uin = msgHead.receiver
        LogCenter.log("邀请入群: $groupCode, 邀请者: \"$invitor\"")
        val flag = try {
            var reqs = requestGroupSystemMsgNew(10, 1)
            val riskReqs = requestGroupSystemMsgNew(10, 2)
            reqs = reqs + riskReqs
            val req = reqs.firstOrNull {
                it.msg_time.get() == time
            }
            val seq = req?.msg_seq?.get() ?: time
            "$seq;$groupCode;$uin"
        } catch (err: Throwable) {
            "$time;$groupCode;$uin"
        }
        if (!GlobalEventTransmitter.RequestTransmitter
                .transGroupInvite(time, invitorUid, invitor, groupCode, flag)
        ) {
            LogCenter.log("邀请入群推送失败！", Level.WARN)
        }
    }


}