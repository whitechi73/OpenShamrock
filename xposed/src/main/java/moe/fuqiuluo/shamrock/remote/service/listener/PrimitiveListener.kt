@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service.listener

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.coroutines.DelicateCoroutinesApi
import moe.fuqiuluo.shamrock.helper.ContactHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.io.core.readBytes
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.proto.*
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
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.xposed.helper.PacketHandler

internal object PrimitiveListener {
    fun registerListener() {
        PacketHandler.register("trpc.msg.olpush.OlPushService.MsgPush") { _, buffer ->
            GlobalScope.launch {
                try {
                    onMsgPush(ProtoUtils.decodeFromByteArray(buffer.slice(4)))
                } catch (e: Exception) {
                    LogCenter.log(e.stackTraceToString(), Level.WARN)
                }
            }
        }
    }

    private suspend fun onMsgPush(pb: ProtoMap) {
        if (
            !pb.has(1, 3)
            || !pb.has(1, 2)
            || !pb.has(1, 2, 6)
        ) return
        val msgType = pb[1, 2, 1].asInt
        var subType = 0
        if (pb.has(1, 2, 3) && pb.has(1, 2, 2)) {
            subType = pb[1, 2, 2].asInt
        }
        val msgTime = pb[1, 2, 6].asLong
        try {
            when (msgType) {
                33 -> onGroupMemIncreased(msgTime, pb)
                34 -> onGroupMemberDecreased(msgTime, pb)
                44 -> onGroupAdminChange(msgTime, pb)
                84 -> onGroupApply(msgTime, pb)
                87 -> onInviteGroup(msgTime, pb)
                528 -> when (subType) {
                    35 -> onFriendApply(msgTime, pb)
                    39 -> onCardChange(msgTime, pb)
                    // invite
                    68 -> onGroupApply(msgTime, pb)
                    138 -> onC2CRecall(msgTime, pb)
                    290 -> onC2cPoke(msgTime, pb)
                }

                732 -> when (subType) {
                    12 -> onGroupBan(msgTime, pb)
                    16 -> onGroupTitleChange(msgTime, pb)
                    17 -> onGroupRecall(msgTime, pb)
                    20 -> onGroupPokeAndGroupSign(msgTime, pb)
                    21 -> onEssenceMessage(msgTime, pb)
                }
            }
        } catch (e: Exception) {
            LogCenter.log("onMsgPush(msgType: $msgType, subType: $subType): "+e.stackTraceToString(), Level.WARN)
        }
    }

    private suspend fun onC2cPoke(msgTime: Long, pb: ProtoMap) {
        val detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            error("不支持该私聊戳一戳解析: ${(detail as ProtoByteString).toByteArray().toHexString()}")
        }

        lateinit var target: String
        lateinit var operation: String
        var suffix: String? = null
        var actionImg: String? = null
        var action: String? = null
        detail[7]
            .asList
            .value
            .forEach {
                val value = it[2].asUtf8String
                when (it[1].asUtf8String) {
                    "uin_str1" -> operation = value
                    "uin_str2" -> target = value
                    "action_str" -> action = value
                    "alt_str1" -> action = value
                    "suffix_str" -> suffix = value
                    "action_img_url" -> actionImg = value
                }
            }

        LogCenter.log("私聊戳一戳: $operation $action $target $suffix")

        if (!GlobalEventTransmitter.PrivateNoticeTransmitter
                .transPrivatePoke(msgTime, operation.toLong(), target.toLong(), action, suffix, actionImg)
        ) {
            LogCenter.log("私聊戳一戳推送失败！", Level.WARN)
        }
    }

    private suspend fun onFriendApply(msgTime: Long, pb: ProtoMap) {
        val applierUid = pb[1, 3, 2, 1, 2].asUtf8String
        val msg = pb[1, 3, 2, 1, 10].asUtf8String
        val source = pb[1, 3, 2, 1, 11].asUtf8String
        var applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
        if (applier == 0L) {
            applier = pb[4, 3, 8].asLong
        }
        val src = pb[1, 3, 2, 1, 7].asInt
        val subSrc = pb[1, 3, 2, 1, 8].asInt
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


    private suspend fun onCardChange(msgTime: Long, pb: ProtoMap) {
        var detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            try {
                val readPacket = ByteReadPacket(detail.asByteArray)
                readPacket.readBuf32Long()
                readPacket.discardExact(1)
                detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
                readPacket.release()
            } catch (e: Exception) {
                LogCenter.log("onCardChange error: ${e.stackTraceToString()}", Level.WARN)
            }
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
        }
    }

    private suspend fun onGroupTitleChange(msgTime: Long, pb: ProtoMap) {
        var detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            try {
                val readPacket = ByteReadPacket(detail.asByteArray)
                readPacket.readBuf32Long()
                readPacket.discardExact(1)
                detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
                readPacket.release()
            } catch (e: Exception) {
                LogCenter.log("onGroupTitleChange error: ${e.stackTraceToString()}", Level.WARN)
            }
        }
        var groupId:Long
        try {
            groupId = detail[4].asULong
        }catch (e: ClassCastException){
            groupId = detail[4].asList.value[0].asULong
        }

        detail = if (detail[5] is ProtoList) {
            (detail[5] as ProtoList).value[0]
        } else {
            detail[5]
        }

        val targetUin = detail[5].asLong

        // 恭喜<{\"cmd\":5,\"data\":\"qq\",\"text}\":\"nickname\"}>获得群主授予的<{\"cmd\":1,\"data\":\"https://qun.qq.com/qqweb/m/qun/medal/detail.html?_wv=16777223&bid=2504&gc=gid&isnew=1&medal=302&uin=uin\",\"text\":\"title\",\"url\":\"https://qun.qq.com/qqweb/m/qun/medal/detail.html?_wv=16777223&bid=2504&gc=gid&isnew=1&medal=302&uin=uin\"}>头衔
        val titleChangeInfo = detail[2].asUtf8String
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

    private suspend fun onEssenceMessage(msgTime: Long, pb: ProtoMap) {
        var detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            try {
                val readPacket = ByteReadPacket(detail.asByteArray)
                readPacket.readBuf32Long()
                readPacket.discardExact(1)
                detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
                readPacket.release()
            } catch (e: Exception) {
                LogCenter.log("onEssenceMessage error: ${e.stackTraceToString()}", Level.WARN)
            }
        }

        var groupId:Long
        try {
            groupId = detail[4].asULong
        }catch (e: ClassCastException){
            groupId = detail[4].asList.value[0].asULong
        }
        val mesSeq = detail[37].asInt
        val senderUin = detail[33, 5].asLong
        val operatorUin = detail[33, 6].asLong
        var msgId = 0
        MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEGROUP, mesSeq).also {
            if (it != null) {
                msgId = it.msgHashId
            }
        }
        val subType = when (val type = detail[33, 4].asInt) {
            1 -> {
                // add essence
                LogCenter.log("群设精消息($groupId): $senderUin $msgId $operatorUin")
                NoticeSubType.Add
            }

            2 -> {
                // remove essence
                LogCenter.log("群取精消息($groupId): $senderUin $msgId $operatorUin")
                NoticeSubType.Delete
            }

            else -> error("onEssenceMessage unknown type: $type")
        }

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transEssenceChange(msgTime, senderUin, operatorUin, msgId, groupId, subType)
        ) {
            LogCenter.log("精华消息变动推送失败！", Level.WARN)
        }
    }


    private suspend fun onGroupPokeAndGroupSign(time: Long, pb: ProtoMap) {
        var detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            try {
                val readPacket = ByteReadPacket(detail.asByteArray)
                readPacket.discardExact(4)
                readPacket.discardExact(1)
                detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
                readPacket.release()
            } catch (e: Exception) {
                LogCenter.log("onGroupPokeAndGroupSign error: ${e.stackTraceToString()}", Level.WARN)
            }
        }
        val groupId = try {
            detail[4].asULong
        }catch (e: ClassCastException){
            detail[4].asList.value[0].asULong
        }

        detail = if (detail[26] is ProtoList) {
            (detail[26] as ProtoList).value[0]
        } else {
            detail[26]
        }

        lateinit var target: String
        lateinit var operation: String
        var action: String? = null
        var suffix: String? = null
        var actionImg: String? = null
        var rankImg: String? = null
        detail[7]
            .asList
            .value
            .forEach {
                val value = it[2].asUtf8String
                when (it[1].asUtf8String) {
                    "uin_str1" -> operation = value
                    "uin_str2" -> target = value
                    // "nick_str1" -> operation_nick = value
                    // "nick_str2" -> operation_nick = value
                    "action_str" -> action = value
                    "alt_str1" -> action = value
                    "suffix_str" -> suffix = value
                    "action_img_url" -> actionImg = value

                    "mqq_uin" -> target = value
                    // "mqq_nick" -> operation_nick = value
                    "user_sign" -> action = value
                    "rank_img" -> rankImg = value
                    // "sign_word" ->  我也要打卡
                }
            }
        when (detail[2].asInt) {
            1061 -> {
                LogCenter.log("群戳一戳($groupId): $operation $action $target $suffix")
                if (!GlobalEventTransmitter.GroupNoticeTransmitter
                        .transGroupPoke(time, operation.toLong(), target.toLong(), action, suffix, actionImg, groupId)
                ) {
                    LogCenter.log("群戳一戳推送失败！", Level.WARN)
                }
            }

            1068 -> {
                LogCenter.log("群打卡($groupId): $action $target")
                if (!GlobalEventTransmitter.GroupNoticeTransmitter
                        .transGroupSign(time, target.toLong(), action, rankImg, groupId)
                ) {
                    LogCenter.log("群打卡推送失败！", Level.WARN)
                }
            }

            else -> {
                LogCenter.log("onGroupPokeAndGroupSign unknown type ${detail[2].asInt}", Level.WARN)
            }
        }
    }

    private suspend fun onC2CRecall(time: Long, pb: ProtoMap) {
        val operationUid = pb[1, 3, 2, 1, 1].asUtf8String
        val msgSeq = pb[1, 3, 2, 1, 20].asLong
        val tipText = if (pb.has(1, 3, 2, 1, 13)) pb[1, 3, 2, 1, 13, 2].asUtf8String else ""
        val mapping = MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEC2C, msgSeq.toInt())
        if (mapping == null) {
            LogCenter.log("由于缺失消息映射关系，消息撤回事件无法推送！", Level.WARN)
            return
        }
        val operation = ContactHelper.getUinByUidAsync(operationUid).toLong()

        LogCenter.log("私聊消息撤回: $operation, seq = $msgSeq, hash = ${mapping.msgHashId}, tip = $tipText")

        if (!GlobalEventTransmitter.PrivateNoticeTransmitter
                .transPrivateRecall(time, operation, mapping.msgHashId, tipText)
        ) {
            LogCenter.log("私聊消息撤回推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemIncreased(time: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        val targetUid = pb[1, 3, 2, 3].asUtf8String
        val type = pb[1, 3, 2, 4].asInt

        GroupSvc.getGroupMemberList(groupCode.toString(), true).onFailure {
            LogCenter.log("新成员加入刷新群成员列表失败: $groupCode", Level.WARN)
        }.onSuccess {
            LogCenter.log("新成员加入刷新群成员列表成功，群成员数量: ${it.size}", Level.INFO)
        }

        val operatorUid = pb[1, 3, 2, 5].asUtf8String
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

    private suspend fun onGroupMemberDecreased(time: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        val targetUid = pb[1, 3, 2, 3].asUtf8String
        val type = pb[1, 3, 2, 4].asInt
        val operatorUid = try {
            pb[1, 3, 2, 5, 1, 1].asUtf8String
        } catch (e: Throwable) {
            pb[1, 3, 2, 5].asUtf8String
        }

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

    private suspend fun onGroupAdminChange(msgTime: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        lateinit var targetUid: String
        val isSetAdmin: Boolean
        if (pb.has(1, 3, 2, 4, 1)) {
            targetUid = pb[1, 3, 2, 4, 1, 1].asUtf8String
            isSetAdmin = pb[1, 3, 2, 4, 1, 2].asInt == 1
        } else {
            targetUid = pb[1, 3, 2, 4, 2, 1].asUtf8String
            isSetAdmin = pb[1, 3, 2, 4, 2, 2].asInt == 1
        }
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群管理员变动($groupCode): $target, isSetAdmin = $isSetAdmin")

        if (!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupAdminChanged(msgTime, target, targetUid, groupCode, isSetAdmin)
        ) {
            LogCenter.log("群管理员变动推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupBan(msgTime: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        val operatorUid = pb[1, 3, 2, 4].asUtf8String
        val wholeBan = !pb.has(1, 3, 2, 5, 3, 1)
        val targetUid = if (wholeBan) "" else pb[1, 3, 2, 5, 3, 1].asUtf8String
        val rawDuration = pb[1, 3, 2, 5, 3, 2].asInt

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

    private suspend fun onGroupRecall(time: Long, pb: ProtoMap) {
        var detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            try {
                val readPacket = ByteReadPacket(detail.asByteArray)
                readPacket.discardExact(4)
                readPacket.discardExact(1)
                detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
                readPacket.release()
            } catch (e: Exception) {
                LogCenter.log("onGroupRecall error: ${e.stackTraceToString()}", Level.WARN)
            }
        }
        val groupCode:Long = try {
            detail[4].asULong
        }catch (e: ClassCastException){
            detail[4].asList.value[0].asULong
        }
        val operatorUid = detail[11, 1].asUtf8String
        val targetUid = detail[11, 3, 6].asUtf8String
        val msgSeq = detail[11, 3, 1].asLong
        val tipText = if (detail.has(11, 9)) detail[11, 9, 2].asUtf8String else ""
        val mapping = MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEGROUP, msgSeq.toInt())
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

    private suspend fun onGroupApply(time: Long, pb: ProtoMap) {
        when (pb[1, 2, 1].asInt) {
            84 -> {
                val groupCode = pb[1, 3, 2, 1].asULong
                val applierUid = pb[1, 3, 2, 3].asUtf8String
                val reason = pb[1, 3, 2, 5].asUtf8String
                val applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
                if (applier == getLongUin()) {
                    return
                }
                LogCenter.log("入群申请($groupCode) $applier: \"$reason\"")
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
                        .transGroupApply(time, applier, applierUid, reason, groupCode, flag, RequestSubType.Add)
                ) {
                    LogCenter.log("入群申请推送失败！", Level.WARN)
                }
            }

            528 -> {
                val groupCode = pb[1, 3, 2, 2, 3].asULong
                val applierUid = pb[1, 3, 2, 2, 5].asUtf8String
                val applier = ContactHelper.getUinByUidAsync(applierUid).toLong()
                if (applier == getLongUin()) {
                    return
                }
                if (pb[1, 3, 2, 2, 1].asInt < 3) {
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

    private suspend fun onInviteGroup(time: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        val invitorUid = pb[1, 3, 2, 5].asUtf8String
        val invitor = ContactHelper.getUinByUidAsync(invitorUid).toLong()
        val uin = pb[1, 1, 5].asLong
        LogCenter.log("邀请入群$groupCode 邀请者: \"$invitor\"")
        val flag = try {
            var reqs = requestGroupSystemMsgNew(10, 1)
            val riskReqs = requestGroupSystemMsgNew(10, 2)
            reqs = reqs + riskReqs
            val req = reqs.firstOrNull() {
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
