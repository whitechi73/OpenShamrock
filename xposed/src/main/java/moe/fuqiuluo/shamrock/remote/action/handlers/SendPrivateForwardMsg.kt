package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo
import kotlinx.atomicfu.atomic
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
                it.asJsonObject["data"].asJsonObject.let { data ->
                    if (data.containsKey("content"))
                        MessageNode(
                            name = data["name"].asStringOrNull ?: "",
                            content = data["content"]
                        )
                    else MessageIdNode(data["id"].asInt)
                }
            }.map {
                if (it is MessageIdNode) {
                    val recordResult = MsgSvc.getMsg(it.id)
                    if (recordResult.isFailure) {
                        EmptyNode
                    } else {
                        val record = recordResult.getOrThrow()
                        MessageNode(
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
                    it as MessageNode
                }
            }.filter {
                it.content != null
            }

            lateinit var forwardMsgCallback: (() -> Unit)
            val availableMsgSize = atomic(0)
            val msgIds = msgs.map {
                it.name to MessageHelper.sendMessageWithMsgId(MsgConstant.KCHATTYPEC2C, selfUin, it.content!!.let { msg ->
                    if (msg is JsonArray) msg else MessageHelper.decodeCQCode(msg.asString)
                }, { code, why ->
                    if (code != 0) {
                        availableMsgSize.incrementAndGet()
                        LogCenter.log("合并转发消息节点消息发送失败：$code($why)", Level.WARN)
                    }
                    if (availableMsgSize.incrementAndGet() == msgs.size) {
                        forwardMsgCallback.invoke()
                    }
                }).first
            }

            val from = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, selfUin)
            val to = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, userId)
            forwardMsgCallback = {
                msgService.multiForwardMsg(ArrayList<MultiMsgInfo>().apply {
                    msgIds.forEach { add(MultiMsgInfo(it.second, it.first)) }
                }.also { it.reverse() }, from, to) { code, why ->
                    if (code != 0)
                        LogCenter.log("合并转发消息：$code($why)", Level.WARN)
                }
            }
            return ok(data = EmptyJsonObject, echo = echo)
        }.onFailure {
            return error("error: $it", echo)
        }
        return logic("合并转发消息失败(unknown error)", echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id")

    override fun path(): String = "send_private_forward_msg"

    class MessageIdNode(
        val id: Int
    ): Node
    open class MessageNode(
        val name: String,
        val content: JsonElement?
    ): Node
    object EmptyNode: MessageNode("", null)
    interface Node
}