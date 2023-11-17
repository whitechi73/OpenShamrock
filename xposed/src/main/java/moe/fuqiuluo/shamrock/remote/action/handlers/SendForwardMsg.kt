@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.toSegments
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.tools.EmptyJsonObject
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.asInt
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.asStringOrNull
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * 合并转发消息节点数据类
 */
sealed interface ForwardMsgNode {
    class MessageIdNode(
        val id: Int
    ): ForwardMsgNode

    open class MessageNode(
        val name: String,
        val content: JsonElement?
    ): ForwardMsgNode

    object EmptyNode: MessageNode("", null)
}

/**
 * 私聊合并转发
 */
internal object SendPrivateForwardMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("user_id")
        if (session.isArray("messages")) {
            val messages = session.getArray("messages")
            return invoke(messages, groupId,  session.echo)
        }
        return logic("未知格式合并转发消息", session.echo)
    }

    suspend operator fun invoke(
        message: JsonArray,
        userId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        kotlin.runCatching {
            val kernelService = NTServiceFetcher.kernelService
            val sessionService = kernelService.wrapperSession
            val msgService = sessionService.msgService
            val selfUin = TicketSvc.getUin()

            val msgs = message.map {
                if (it.asJsonObject["type"].asStringOrNull != "node") return@map ForwardMsgNode.EmptyNode // 过滤非node类型消息段
                it.asJsonObject["data"].asJsonObject.let { data ->
                    if (data.containsKey("content"))
                        ForwardMsgNode.MessageNode(
                            name = data["name"].asStringOrNull ?: "",
                            content = data["content"]
                        )
                    else ForwardMsgNode.MessageIdNode(data["id"].asInt)
                }
            }.map {
                if (it is ForwardMsgNode.MessageIdNode) {
                    val recordResult = MsgSvc.getMsg(it.id)
                    if (recordResult.isFailure) {
                        ForwardMsgNode.EmptyNode
                    } else {
                        val record = recordResult.getOrThrow()
                        ForwardMsgNode.MessageNode(
                            name = record.sendMemberName
                                .ifBlank { record.sendNickName }
                                .ifBlank { record.sendRemarkName }
                                .ifBlank { record.peerName },
                            content = record.toSegments().map { segment ->
                                segment.toJson()
                            }.json
                        )
                    }
                } else {
                    it as ForwardMsgNode.MessageNode
                }
            }.filter {
                it.content != null
            }

            val multiNodes = msgs.map { node ->
                suspendCoroutine {
                    GlobalScope.launch {
                        var msgId: Long = 0
                        msgId = MessageHelper.sendMessageWithMsgId(MsgConstant.KCHATTYPEC2C, selfUin, node.content!!.let { msg ->
                            if (msg is JsonArray) msg else MessageHelper.decodeCQCode(msg.asString)
                        }, { code, why ->
                            if (code != 0) {
                                LogCenter.log("合并转发消息节点消息发送失败：$code($why)", Level.WARN)
                            }
                            it.resume(node.name to msgId)
                        }).first
                    }
                }
            }

            val from = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, selfUin)
            val to = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, userId)
            msgService.multiForwardMsg(ArrayList<MultiMsgInfo>().apply {
                multiNodes.forEach { add(MultiMsgInfo(it.second, it.first)) }
            }.also { it.reverse() }, from, to) { code, why ->
                if (code != 0)
                    LogCenter.log("合并转发消息：$code($why)", Level.WARN)
            }
            return ok(data = EmptyJsonObject, echo = echo)
        }.onFailure {
            return error("error: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id")

    override fun path(): String = "send_private_forward_msg"
}

/**
 * 群聊合并转发
 */
internal object SendGroupForwardMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        if (session.isArray("messages")) {
            val messages = session.getArray("messages")
            return invoke(messages, groupId,  session.echo)
        }
        return logic("未知格式合并转发消息", session.echo)
    }

    suspend operator fun invoke(
        message: JsonArray,
        groupId: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        kotlin.runCatching {
            val kernelService = NTServiceFetcher.kernelService
            val sessionService = kernelService.wrapperSession
            val msgService = sessionService.msgService
            val selfUin = TicketSvc.getUin()

            val msgs = message.map {
                if (it.asJsonObject["type"].asStringOrNull != "node") return@map ForwardMsgNode.EmptyNode // 过滤非node类型消息段
                it.asJsonObject["data"].asJsonObject.let { data ->
                    if (data.containsKey("content"))
                        ForwardMsgNode.MessageNode(
                            name = data["name"].asStringOrNull ?: "",
                            content = data["content"]
                        )
                    else ForwardMsgNode.MessageIdNode(data["id"].asInt)
                }
            }.map {
                if (it is ForwardMsgNode.MessageIdNode) {
                    val recordResult = MsgSvc.getMsg(it.id)
                    if (recordResult.isFailure) {
                        ForwardMsgNode.EmptyNode
                    } else {
                        val record = recordResult.getOrThrow()
                        ForwardMsgNode.MessageNode(
                            name = record.sendMemberName
                                .ifBlank { record.sendNickName }
                                .ifBlank { record.sendRemarkName }
                                .ifBlank { record.peerName },
                            content = record.toSegments().map { segment ->
                                segment.toJson()
                            }.json
                        )
                    }
                } else {
                    it as ForwardMsgNode.MessageNode
                }
            }.filter {
                it.content != null
            }

            val multiNodes = msgs.map { node ->
                suspendCoroutine {
                    GlobalScope.launch {
                        var msgId: Long = 0
                        msgId = MessageHelper.sendMessageWithMsgId(MsgConstant.KCHATTYPEC2C, selfUin, node.content!!.let { msg ->
                            if (msg is JsonArray) msg else MessageHelper.decodeCQCode(msg.asString)
                        }, { code, why ->
                            if (code != 0) {
                                LogCenter.log("合并转发消息节点消息发送失败：$code($why)", Level.WARN)
                            }
                            it.resume(node.name to msgId)
                        }).first
                    }
                }
            }

            val from = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, selfUin)
            val to = MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, groupId)
            msgService.multiForwardMsg(ArrayList<MultiMsgInfo>().apply {
                multiNodes.forEach { add(MultiMsgInfo(it.second, it.first)) }
            }.also { it.reverse() }, from, to) { code, why ->
                if (code != 0)
                    LogCenter.log("合并转发消息：$code($why)", Level.WARN)
            }
            return ok(data = EmptyJsonObject, echo = echo)
        }.onFailure {
            return error("error: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")

    override fun path(): String = "send_group_forward_msg"
}