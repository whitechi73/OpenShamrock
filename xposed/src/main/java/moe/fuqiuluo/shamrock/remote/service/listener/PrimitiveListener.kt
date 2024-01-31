@file:OptIn(DelicateCoroutinesApi::class, ExperimentalSerializationApi::class)

package moe.fuqiuluo.shamrock.remote.service.listener

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.coroutines.DelicateCoroutinesApi
import moe.fuqiuluo.shamrock.helper.ContactHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.io.core.readBytes
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.FriendSvc.requestFriendSystemMsgNew
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc.requestGroupSystemMsgNew
import moe.fuqiuluo.qqinterface.servlet.TicketSvc.getLongUin
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeType
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter
import moe.fuqiuluo.shamrock.remote.service.data.push.RequestSubType
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.readBuf32Long
import moe.fuqiuluo.shamrock.xposed.helper.PacketHandler
import moe.whitechi73.protobuf.message.*
import moe.whitechi73.protobuf.push.*

internal object PrimitiveListener {
    fun registerListener() {
        PacketHandler.register("trpc.msg.olpush.OlPushService.MsgPush") { _, buffer ->
            GlobalScope.launch {
                try {
                    val push = ProtoBuf.decodeFromByteArray<MessagePush>(buffer.slice(4))
                    onMsgPush(push)
                } catch (e: Exception) {
                    LogCenter.log(e.stackTraceToString(), Level.WARN)
                }
            }
        }
    }

    private suspend fun onMsgPush(push: MessagePush) {
        if (
            push.msgBody == null ||
            push.msgBody!!.contentHead == null ||
            push.msgBody!!.richMsg == null ||
            push.msgBody!!.contentHead!!.msgTime == null
        ) return
        val msgBody = push.msgBody!!
        val contentHead = msgBody.contentHead!!
        val msgType = contentHead.msgType
        val subType = contentHead.msgSubType
        val msgTime = contentHead.msgTime!!
        val richMsg = msgBody.richMsg!!
        try {
            when (msgType) {
                33 -> onGroupMemIncreased(msgTime, richMsg)
                34 -> onGroupMemberDecreased(msgTime, richMsg)
                44 -> onGroupAdminChange(msgTime, richMsg)
                84 -> onGroupApply(msgTime, contentHead, richMsg)
                87 -> onInviteGroup(msgTime, msgBody.msgHead!!, richMsg)
                528 -> when (subType) {
                    35 -> onFriendApply(msgTime, push.clientInfo!!, richMsg)
                    39 -> onCardChange(msgTime, richMsg)
                    // invite
                    68 -> onGroupApply(msgTime, contentHead, richMsg)
                    138 -> onC2CRecall(msgTime, richMsg)
                    290 -> onC2CPoke(msgTime, richMsg)
                }

                732 -> when (subType) {
                    12 -> onGroupBan(msgTime, richMsg)
                    16 -> onGroupUniqueTitleChange(msgTime, richMsg)
                    17 -> onGroupRecall(msgTime, richMsg)
                    20 -> onGroupPokeAndGroupSign(msgTime, richMsg)
                    21 -> onEssenceMessage(msgTime, push.clientInfo, richMsg)
                }
            }
        } catch (e: Exception) {
            LogCenter.log("onMsgPush(msgType: $msgType, subType: $subType): "+e.stackTraceToString(), Level.WARN)
        }
    }

    private suspend fun onC2CPoke(msgTime: Long, richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<C2CCommonTipsEvent>(richMsg.rawBuffer!!)
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
                .transPrivatePoke(msgTime, operation.toLong(), target.toLong(), action, suffix, actionImg)
        ) {
            LogCenter.log("私聊戳一戳推送失败！", Level.WARN)
        }
    }

    private suspend fun onFriendApply(
        msgTime: Long,
        clientInfo: MessagePushClientInfo,
        richMsg: RichMessage
    ) {
        val event = ProtoBuf.decodeFromByteArray<FriendApplyEvent>(richMsg.rawBuffer!!)
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
                .transFriendApp(msgTime, applier, msg, flag)
        ) {
            LogCenter.log("好友申请推送失败！", Level.WARN)
        }
    }


    private suspend fun onCardChange(msgTime: Long, richMsg: RichMessage) {
        LogCenter.log("群名片事件异常，请尝试提交issue！", Level.WARN)
        /*try {
            val readPacket = ByteReadPacket(richMsg.rawBuffer!!)
            if(readPacket.readBuf32Long() ==
            readPacket.discardExact(1)
            detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
            readPacket.release()
        } catch (e: Exception) {
            LogCenter.log("onCardChange error: ${e.stackTraceToString()}", Level.WARN)
        }

        var detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {

        }

        val targetId = detail[1, 13, 2].asUtf8String
        val newCardList = detail[1, 13, 3].asList
        var newCard = ""
        newCardList
            .value
            .forEach {
                if (it[1].asInt == 1) {
                    newCard = it[2].asUtf8String
                }
            }
        val groupId = detail[1, 13, 4].asLong
        var oldCard = ""
        val targetQQ = ContactHelper.getUinByUidAsync(targetId).toLong()
        LogCenter.log("群组[$groupId]成员$targetQQ 群名片变动 -> $newCard")
        // oldCard暂时获取不到
//        GroupSvc.getTroopMemberInfoByUin(groupId.toString(), targetQQ.toString()).onSuccess {
//            oldCard = it.troopnick
//        }.onFailure {
//            LogCenter.log("获取群成员信息失败！", Level.WARN)
//        }
        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transCardChange(msgTime, targetQQ, oldCard, newCard, groupId)
        ) {
            LogCenter.log("群名片变动推送失败！", Level.WARN)
        }*/
    }

    private suspend fun onGroupUniqueTitleChange(msgTime: Long, richMsg: RichMessage) {
        val event = runCatching {
            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(richMsg.rawBuffer!!)
        }.getOrElse {
            val readPacket = ByteReadPacket(richMsg.rawBuffer!!)
            readPacket.readBuf32Long()
            readPacket.discardExact(1)

            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            })
        }
        val groupId = event.groupCode.toLong()
        val detail = event.uniqueTitleChangeDetail!!.first()

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
        richMsg: RichMessage
    ) {
        if (clientInfo == null) return
        val event = runCatching {
            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(richMsg.rawBuffer!!)
        }.getOrElse {
            val readPacket = ByteReadPacket(richMsg.rawBuffer!!)
            readPacket.readBuf32Long()
            readPacket.discardExact(1)

            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            })
        }
        val groupId = event.groupCode.toLong()
        val detail = event.essenceMsgInfo!!.first()

        val megSeq = event.msgSeq.toInt()
        val senderUin = detail.sender.toLong()
        val operatorUin = detail.operator.toLong()
        val msgHashId = MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEGROUP, groupId.toString(), megSeq).also {
            if (it == null) {
                LogCenter.log("精华消息变动推送失败！找不到消息映射关系！", Level.WARN)
                return
            }
        }!!.msgHashId

        val subType = when (val type = detail.type) {
            1u -> {
                LogCenter.log("群设精消息(groupId=$groupId, sender=$senderUin, msgId=$msgHashId, operator=$operatorUin)")
                NoticeSubType.Add
            }

            2u -> {
                LogCenter.log("群撤精消息(groupId=$groupId, sender=$senderUin, msgId=$msgHashId, operator=$operatorUin)")
                NoticeSubType.Delete
            }

            else -> error("onEssenceMessage unknown type: $type")
        }

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transEssenceChange(msgTime, senderUin, operatorUin, msgHashId, groupId, subType)
        ) {
            LogCenter.log("精华消息变动推送失败！", Level.WARN)
        }
    }


    private suspend fun onGroupPokeAndGroupSign(time: Long, richMsg: RichMessage) {
        val event = runCatching {
            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(richMsg.rawBuffer!!)
        }.getOrElse {
            val readPacket = ByteReadPacket(richMsg.rawBuffer!!)
            readPacket.discardExact(4)
            readPacket.discardExact(1)

            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            })
        }
        val groupId = event.groupCode.toLong()
        val detail = event.baseTips!!.first()

        val params = detail.params!!.associate {
            it.key to it.value
        }

        val target = params["uin_str2"] ?: params["mqq_uin"] ?: return
        val operation = params["uin_str1"] ?: return
        val suffix = params["suffix_str"] ?: ""
        val actionImg = params["action_img_url"] ?: ""
        val action = params["alt_str1"]
            ?: params["action_str"]
            ?: params["user_sign"]
            ?: ""
        val rankImg = params["rank_img"] ?: ""

        when (detail.type) {
            1061u -> {
                LogCenter.log("群戳一戳($groupId): $operation $action $target $suffix")
                if (!GlobalEventTransmitter.GroupNoticeTransmitter
                        .transGroupPoke(time, operation.toLong(), target.toLong(), action, suffix, actionImg, groupId)
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

    private suspend fun onC2CRecall(time: Long, richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<C2CRecallEvent>(richMsg.rawBuffer!!)
        val head = event.head!!

        val operationUid = head.operator!!
        val operator = ContactHelper.getUinByUidAsync(operationUid).toLong()

        val msgSeq = head.msgSeq
        val tipText = head.wording?.wording ?: ""

        val mapping = MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEC2C, operator.toString(), msgSeq.toInt())
        if (mapping == null) {
            LogCenter.log("由于缺失消息映射关系，消息撤回事件无法推送！", Level.WARN)
            return
        }

        LogCenter.log("私聊消息撤回: $operator, seq = $msgSeq, hash = ${mapping.msgHashId}, tip = $tipText")

        if (!GlobalEventTransmitter.PrivateNoticeTransmitter
                .transPrivateRecall(time, operator, mapping.msgHashId, tipText)
        ) {
            LogCenter.log("私聊消息撤回推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemIncreased(time: Long, richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<GroupListChangeEvent>(richMsg.rawBuffer!!)
        val groupCode = event.groupCode
        val targetUid = event.memberUid
        val type = event.type

        GroupSvc.getGroupMemberList(groupCode.toString(), true).onFailure {
            LogCenter.log("新成员加入刷新群成员列表失败: $groupCode", Level.WARN)
        }.onSuccess {
            LogCenter.log("新成员加入刷新群成员列表成功，群成员数量: ${it.size}", Level.INFO)
        }

        val operatorUid = event.operatorUid
        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群成员增加($groupCode): $target, type = $type")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMemberNumChanged(
                    time, target, targetUid, groupCode, operator, operatorUid, NoticeType.GroupMemIncrease, when (type) {
                        130 -> NoticeSubType.Approve
                        131 -> NoticeSubType.Invite
                        else -> NoticeSubType.Approve
                    }
                )
        ) {
            LogCenter.log("群成员增加推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemberDecreased(time: Long, richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<GroupListChangeEvent>(richMsg.rawBuffer!!)
        val groupCode = event.groupCode
        val targetUid = event.memberUid
        val type = event.type
        val operatorUid = event.operatorUid

        GroupSvc.getGroupMemberList(groupCode.toString(), true).onFailure {
            LogCenter.log("新成员加入刷新群成员列表失败: $groupCode", Level.WARN)
        }.onSuccess {
            LogCenter.log("新成员加入刷新群成员列表成功，群成员数量: ${it.size}", Level.INFO)
        }

        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        val subtype = when (type) {
            130 -> NoticeSubType.Leave
            131 -> NoticeSubType.Kick
            3 -> NoticeSubType.KickMe
            else -> {
                NoticeSubType.Kick
            }
        }

        LogCenter.log("群成员减少($groupCode): $target, type = $subtype ($type)")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMemberNumChanged(time, target, targetUid, groupCode, operator, operatorUid, NoticeType.GroupMemDecrease, subtype)
        ) {
            LogCenter.log("群成员减少推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupAdminChange(msgTime: Long, richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<GroupAdminChangeEvent>(richMsg.rawBuffer!!)
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

    private suspend fun onGroupBan(msgTime: Long, richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<GroupBanEvent>(richMsg.rawBuffer!!)
        val groupCode = event.groupCode.toLong()
        val operatorUid = event.operatorUid
        val wholeBan = event.target?.target?.targetUid == null
        val targetUid = event.target?.target?.targetUid ?: ""
        val rawDuration = event.target?.target?.rawDuration?.toInt() ?: 0

        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val duration = if (wholeBan) -1 else rawDuration
        val target = if (wholeBan) 0 else ContactHelper.getUinByUidAsync(targetUid).toLong()
        val subType = if (rawDuration == 0) NoticeSubType.LiftBan else NoticeSubType.Ban

        if (wholeBan) {
            LogCenter.log("群全员禁言($groupCode): $operator -> ${if (subType == NoticeSubType.Ban) "开启" else "关闭"}")
        } else {
            LogCenter.log("群禁言($groupCode): $operator -> $target, 时长 = ${duration}s")
        }
        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupBan(msgTime, subType, operator, operatorUid, target, targetUid, groupCode, duration)
        ) {
            LogCenter.log("群禁言推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupRecall(time: Long, richMsg: RichMessage) {
        val event = runCatching {
            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(richMsg.rawBuffer!!)
        }.getOrElse {
            val readPacket = ByteReadPacket(richMsg.rawBuffer!!)
            readPacket.discardExact(4)
            readPacket.discardExact(1)
            ProtoBuf.decodeFromByteArray<GroupCommonTipsEvent>(readPacket.readBytes(readPacket.readShort().toInt()).also {
                readPacket.release()
            })
        }
        val groupCode = event.groupCode.toLong()
        val detail = event.recallDetails!!
        val operatorUid = detail.operatorUid
        val targetUid = detail.msgInfo!!.senderUid
        val msgSeq = detail.msgInfo!!.msgSeq.toLong()
        val tipText = detail.wording?.wording ?: ""
        val mapping = MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEGROUP, groupCode.toString(), msgSeq.toInt())
        if (mapping == null) {
            LogCenter.log("由于缺失消息映射关系(seq = $msgSeq)，消息撤回事件无法推送！", Level.WARN)
            return
        }
        val msgHash = mapping.msgHashId
        val operator = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群消息撤回($groupCode): $operator -> $target, seq = $msgSeq, hash = $msgHash, tip = $tipText")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMsgRecall(time, operator, target, groupCode, msgHash, tipText)
        ) {
            LogCenter.log("群消息撤回推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupApply(time: Long, contentHead: MessageContentHead, richMsg: RichMessage) {
        when (contentHead.msgType) {
            84 -> {
                val event = ProtoBuf.decodeFromByteArray<GroupApplyEvent>(richMsg.rawBuffer!!)
                val groupCode = event.groupCode
                val applierUid = event.applierUid
                val reason = event.applyMsg ?: ""
                val applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
                if (applier == getLongUin()) {
                    return
                }
                val msgSeq = contentHead.msgSeq
                LogCenter.log("入群申请($groupCode) $applier: \"$reason\", seq: $msgSeq")
                val flag = try {
                    var reqs = requestGroupSystemMsgNew(10, 1)
                    val riskReqs = requestGroupSystemMsgNew(5, 2)
                    reqs = reqs + riskReqs
                    val req = reqs.firstOrNull {
                        it.msg_time.get() == time && it.msg?.group_code?.get() == groupCode
                    }
                    val seq = req?.msg_seq?.get() ?: time
                    "$seq;$groupCode;$applier"
                } catch (err: Throwable) {
                    "$time;$groupCode;$applier"
                }
                if (!GlobalEventTransmitter.RequestTransmitter
                        .transGroupApply(time, applier, applierUid, reason, groupCode, flag, RequestSubType.Add)
                ) {
                    LogCenter.log("入群申请推送失败！", Level.WARN)
                }
            }
            528 -> {
                val event = ProtoBuf.decodeFromByteArray<GroupInvitedApplyEvent>(richMsg.rawBuffer!!)
                val groupCode = event.applyInfo?.groupCode ?: return
                val applierUid = event.applyInfo?.applierUid ?: return
                val applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
                if (applier == getLongUin()) {
                    return
                }
                if ((event.applyInfo?.type ?: return) < 3) {
                    // todo
                    return
                }
                LogCenter.log("邀请入群申请($groupCode): $applier")
                val flag = try {
                    var reqs = requestGroupSystemMsgNew(10, 1)
                    val riskReqs = requestGroupSystemMsgNew(5, 2)
                    reqs = reqs + riskReqs
                    val req = reqs.firstOrNull() {
                        it.msg_time.get() == time
                    }
                    val seq = req?.msg_seq?.get() ?: time
                    "$seq;$groupCode;$applier"
                } catch (err: Throwable) {
                    "$time;$groupCode;$applier"
                }
                if (!GlobalEventTransmitter.RequestTransmitter
                        .transGroupApply(time, applier, applierUid, "", groupCode, flag, RequestSubType.Add)
                ) {
                    LogCenter.log("邀请入群申请推送失败！", Level.WARN)
                }
            }
        }
    }

    private suspend fun onInviteGroup(time: Long, msgHead: MessageHead,richMsg: RichMessage) {
        val event = ProtoBuf.decodeFromByteArray<GroupInviteEvent>(richMsg.rawBuffer!!)
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
                .transGroupApply(time, invitor,  invitorUid, "", groupCode, flag, RequestSubType.Invite)
        ) {
            LogCenter.log("邀请入群推送失败！", Level.WARN)
        }
    }

}
