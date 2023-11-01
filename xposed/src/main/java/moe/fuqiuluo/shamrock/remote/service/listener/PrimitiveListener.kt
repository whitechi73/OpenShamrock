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
import kotlinx.io.core.readUInt
import moe.fuqiuluo.proto.ProtoByteString
import moe.fuqiuluo.proto.ProtoMap
import moe.fuqiuluo.proto.asInt
import moe.fuqiuluo.proto.asLong
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asByteArray
import moe.fuqiuluo.proto.asList
import moe.fuqiuluo.proto.asULong
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeType
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter
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
            || !pb.has(1, 2, 2)
            || !pb.has(1, 2, 6)
        ) return
        val msgType = pb[1, 2, 1].asInt
        val subType = pb[1, 2, 2].asInt
        val msgTime = pb[1, 2, 6].asLong
        when(msgType) {
            33 -> onGroupMemIncreased(msgTime, pb)
            34 -> onGroupMemberDecreased(msgTime, pb)
            44 -> onGroupAdminChange(msgTime, pb)
            528 -> when(subType) {
                138 -> onC2CRecall(msgTime, pb)
                290 -> onC2cPoke(msgTime, pb)
            }
            732 -> when(subType) {
                12 -> onGroupBan(msgTime, pb)
                17 -> onGroupRecall(msgTime, pb)
                20 -> onGroupPoke(msgTime, pb)
            }
        }
    }

    private suspend fun onC2cPoke(msgTime: Long, pb: ProtoMap) {
        val detail = pb[1, 3, 2]
        if (detail !is ProtoMap) {
            error("不支持该私聊戳一戳解析: ${(detail as ProtoByteString).toByteArray().toHexString()}")
        }

        lateinit var target: String
        lateinit var operation: String
        detail[7]
            .asList
            .value
            .forEach {
                val value = it[2].asUtf8String
                when(it[1].asUtf8String) {
                    "uin_str1" -> operation = value
                    "uin_str2" -> target = value
                }
            }
        LogCenter.log("私聊戳一戳: $operation -> $target")

        if(!GlobalEventTransmitter.PrivateNoticeTransmitter
            .transPrivatePoke(msgTime, operation.toLong(), target.toLong())) {
            LogCenter.log("私聊戳一戳推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupPoke(time: Long, pb: ProtoMap) {
        val groupCode1 = pb[1, 1, 1].asULong

        var groupCode: Long = groupCode1

        val readPacket = ByteReadPacket( pb[1, 3, 2].asByteArray )
        val groupCode2 = readPacket.readBuf32Long()

        var detail = if (groupCode2 == groupCode1) {
            groupCode = groupCode2
            readPacket.discardExact(1)
            ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
        } else pb[1, 3, 2]
        if (detail !is ProtoMap) {
            groupCode = groupCode2
            readPacket.discardExact(1)
            detail = ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
        }
        readPacket.release()

        lateinit var target: String
        lateinit var operation: String
        detail[26][7]
            .asList
            .value
            .forEach {
            val value = it[2].asUtf8String
            when(it[1].asUtf8String) {
                "uin_str1" -> operation = value
                "uin_str2" -> target = value
            }
        }
        LogCenter.log("群戳一戳($groupCode): $operation -> $target")

        if(!GlobalEventTransmitter.GroupNoticeTransmitter
            .transGroupPoke(time, operation.toLong(), target.toLong(), groupCode)) {
            LogCenter.log("群戳一戳推送失败！", Level.WARN)
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

        if(!GlobalEventTransmitter.PrivateNoticeTransmitter
            .transPrivateRecall(time, operation, mapping.msgHashId, tipText)) {
            LogCenter.log("私聊消息撤回推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemIncreased(time: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        val targetUid = pb[1, 3, 2, 3].asUtf8String
        val type = pb[1, 3, 2, 4].asInt
        val operation = ContactHelper.getUinByUidAsync(pb[1, 3, 2, 5].asUtf8String).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()

        LogCenter.log("群成员增加($groupCode): $target, type = $type")

        if(!GlobalEventTransmitter.GroupNoticeTransmitter
            .transGroupMemberNumChanged(time, target, groupCode, operation, NoticeType.GroupMemIncrease, when(type) {
                130 -> NoticeSubType.Approve
                131 -> NoticeSubType.Invite
                else -> NoticeSubType.Approve
            })) {
            LogCenter.log("群成员增加推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupMemberDecreased(time: Long, pb: ProtoMap) {
        val groupCode = pb[1, 3, 2, 1].asULong
        val targetUid = pb[1, 3, 2, 3].asUtf8String
        val type = pb[1, 3, 2, 4].asInt
        val operation = ContactHelper.getUinByUidAsync(pb[1, 3, 2, 5].asUtf8String).toLong()
        // 131 passive | 130 active | 3 kick_self

        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群成员减少($groupCode): $target, type = $type")

        if(!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMemberNumChanged(time, target, groupCode, operation, NoticeType.GroupMemDecrease, when(type) {
                    130 -> NoticeSubType.Kick
                    131 -> NoticeSubType.Leave
                    3 -> NoticeSubType.KickMe
                    else -> NoticeSubType.Kick
                })) {
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

        if(!GlobalEventTransmitter.GroupNoticeTransmitter
            .transGroupAdminChanged(msgTime, target, groupCode, isSetAdmin)) {
            LogCenter.log("群管理员变动推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupBan(msgTime: Long, pb: ProtoMap) {
        val groupCode = pb[1, 1, 1].asULong
        val operatorUid = pb[1, 3, 2, 4].asUtf8String
        val targetUid = pb[1, 3, 2, 5, 3, 1].asUtf8String
        val duration = pb[1, 3, 2, 5, 3, 2].asInt
        val operation = ContactHelper.getUinByUidAsync(operatorUid).toLong()
        val target = ContactHelper.getUinByUidAsync(targetUid).toLong()
        LogCenter.log("群禁言($groupCode): $operation -> $target, 时长 = ${duration}s")

        if(!GlobalEventTransmitter.GroupNoticeTransmitter
            .transGroupBan(msgTime, operation, target, groupCode, duration)) {
            LogCenter.log("群禁言推送失败！", Level.WARN)
        }
    }

    private suspend fun onGroupRecall(time: Long, pb: ProtoMap) {
        val groupCode = pb[1, 1, 1].asULong
        val readPacket = ByteReadPacket( pb[1, 3, 2].asByteArray )
        try {
            /**
             * 真是不理解这个傻呗设计，有些群是正常的Protobuf，有些群要去掉7字节
             */
            val detail = if (readPacket.readUInt().toLong() == groupCode) {
                readPacket.discardExact(1)
                ProtoUtils.decodeFromByteArray(readPacket.readBytes(readPacket.readShort().toInt()))
            } else pb[1, 3, 2]

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

            if(!GlobalEventTransmitter.GroupNoticeTransmitter
                .transGroupMsgRecall(time, operator, target, groupCode, msgHash, tipText)) {
                LogCenter.log("群消息撤回推送失败！", Level.WARN)
            }
        } finally {
            readPacket.release()
        }
    }
}