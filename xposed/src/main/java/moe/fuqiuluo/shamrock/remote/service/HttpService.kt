@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.shamrock.remote.service

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.helper.MessageHelper
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import moe.fuqiuluo.qqinterface.servlet.msg.*
import moe.fuqiuluo.shamrock.remote.service.api.HttpTransmitServlet
import moe.fuqiuluo.shamrock.remote.service.data.push.*
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.service.api.GlobalEventTransmitter

internal object HttpService: HttpTransmitServlet() {
    private val actionMsgTypes = arrayOf(
        "record", "voice", "video", "markdown"
    )

    private val jobList = arrayListOf<Job>()

    override fun submitFlowJob(job: Job) {
        // HTTP 回调不会触发断连，无需释放之前的JOB
        jobList.add(job)
    }

    override fun cancelFlowJobs() {
        jobList.removeIf {
            it.cancel()
            return@removeIf true
        }
    }

    override fun initTransmitter() {
        if (jobList.isNotEmpty()) return
        submitFlowJob(GlobalScope.launch {
            GlobalEventTransmitter.onMessageEvent { (record, event) ->
                val respond = pushTo(event) ?: return@onMessageEvent
                handleQuicklyReply(record, event.messageId, respond.bodyAsText())
            }
        })
        submitFlowJob(GlobalScope.launch {
            GlobalEventTransmitter.onNoticeEvent { event ->
                pushTo(event)
            }
        })
        LogCenter.log("HttpService: 初始化服务", Level.WARN)
    }

    private suspend fun handleQuicklyReply(record: MsgRecord, msgHash: Int, jsonText: String) {
        try {
            val data = Json.parseToJsonElement(jsonText).asJsonObject
            if (data.containsKey("reply")) {
                LogCenter.log({ "quickly reply successfully" }, Level.DEBUG)
                val autoEscape = data["auto_escape"].asBooleanOrNull ?: false
                val atSender = data["at_sender"].asBooleanOrNull ?: false
                val autoReply = data["auto_reply"].asBooleanOrNull ?: true
                val message = data["reply"]
                if (message is JsonPrimitive) {
                    if (autoEscape) {
                        val msgList = mutableSetOf<JsonElement>()
                        msgList.add(mapOf(
                            "type" to "text",
                            "data" to mapOf(
                                "text" to message.asString
                            )
                        ).json)
                        quicklyReply(
                            record,
                            msgList.jsonArray,
                            msgHash,
                            atSender,
                            autoReply
                        )
                    } else {
                        val messageArray = MessageHelper.decodeCQCode(message.asString)
                        quicklyReply(
                            record,
                            messageArray,
                            msgHash,
                            atSender,
                            autoReply
                        )
                    }
                } else if (message is JsonArray) {
                    quicklyReply(
                        record,
                        message,
                        msgHash,
                        atSender,
                        autoReply
                    )
                }
            }
            if (MsgConstant.KCHATTYPEGROUP == record.chatType && data.containsKey("delete") && data["delete"].asBoolean) {
                MsgSvc.recallMsg(msgHash)
            }
            if (MsgConstant.KCHATTYPEGROUP == record.chatType && data.containsKey("kick") && data["kick"].asBoolean) {
                GroupSvc.kickMember(record.peerUin, false, record.senderUin)
            }
            if (MsgConstant.KCHATTYPEGROUP == record.chatType && data.containsKey("ban") && data["ban"].asBoolean) {
                val banTime = data["ban_duration"].asIntOrNull ?: (30 * 60)
                if (banTime <= 0) return
                GroupSvc.banMember(record.peerUin, record.senderUin, banTime)
            }
        } catch (e: Throwable) {
            LogCenter.log("处理快速操作错误: $e", Level.WARN)
        }
    }

    private suspend fun quicklyReply(
        record: MsgRecord,
        message: JsonArray,
        msgHash: Int,
        atSender: Boolean,
        autoReply: Boolean
    ) {
        val messageList = mutableListOf<JsonElement>()
        message.filter {
            it.asJsonObject["type"]?.asString in actionMsgTypes
        }.let {
            if (it.isNotEmpty()) {
                it.map { listOf(it) }.forEach {
                    MsgSvc.sendToAio(record.chatType, record.peerUin.toString(), it.jsonArray)
                }
                return
            }
        }

        if (autoReply) messageList.add(mapOf(
            "type" to "reply",
            "data" to mapOf(
                "id" to msgHash
            )
        ).json) // 添加回复
        if (MsgConstant.KCHATTYPEGROUP == record.chatType && atSender) {
            messageList.add(mapOf(
                "type" to "at",
                "data" to mapOf(
                    "qq" to record.senderUin
                )
            ).json) // 添加@发送者
        }
        messageList.addAll(message)
        MsgSvc.sendToAio(record.chatType, record.peerUin.toString(), JsonArray(messageList))
    }
}