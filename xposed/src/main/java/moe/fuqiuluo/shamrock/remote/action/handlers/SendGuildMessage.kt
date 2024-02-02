package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonArray
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.MessageResult
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.jsonArray
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("send_guild_message", ["send_guild_msg", "send_guild_channel_msg"])
internal object SendGuildMessage: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val guildId = session.getString("guild_id").toULong()
        val channelId = session.getString("channel_id").toULong()
        val retryCnt = session.getIntOrNull("retry_cnt") ?: 3
        val recallDuration = session.getLongOrNull("recall_duration")
        return if (session.isString("message")) {
            val autoEscape = session.getBooleanOrDefault("auto_escape", false)
            val message = session.getString("message")
            return invoke(guildId, channelId, message, autoEscape, retryCnt, recallDuration, echo = session.echo)
        } else if (session.isArray("message")) {
            val message = session.getArray("message")
            return invoke(guildId, channelId, message, echo = session.echo, retryCnt = retryCnt, recallDuration = recallDuration)
        } else {
            val message = session.getObject("message")
            invoke(guildId, channelId, listOf(message).jsonArray, session.echo, retryCnt, recallDuration = recallDuration)
        }
    }

    suspend operator fun invoke(
        guildId: ULong,
        channelId: ULong,
        message: String,
        autoEscape: Boolean,
        retryCnt: Int,
        recallDuration: Long?,
        echo: JsonElement = EmptyJsonString
    ): String {
        val result = if (autoEscape) {
            MsgSvc.sendToAio(MsgConstant.KCHATTYPEGUILD, guildId.toString(), listOf(
                mapOf(
                    "type" to "text",
                    "data" to mapOf(
                        "text" to message
                    )
                )
            ).json, fromId = channelId.toString(), retryCnt)
        } else {
            val msg = MessageHelper.decodeCQCode(message)
            if (msg.isEmpty()) {
                LogCenter.log("CQ码不合法", Level.WARN)
                return logic("CQCode is illegal", echo)
            } else {
                MsgSvc.sendToAio(MsgConstant.KCHATTYPEGUILD, guildId.toString(), msg, fromId = channelId.toString(), retryCnt)
            }
        }
        if (result.isFailure) {
            return logic(result.exceptionOrNull()?.message ?: "", echo)
        }
        val sendMsgResult = result.getOrThrow()
        if (sendMsgResult.msgHashId <= 0) {
            return logic("send message failed", echo = echo)
        }
        recallDuration?.let { autoRecall(sendMsgResult.msgHashId, it) }
        return ok(
            MessageResult(
            msgId = sendMsgResult.msgHashId,
            time = (sendMsgResult.msgTime * 0.001).toLong()
        ), echo = echo)
    }

    suspend operator fun invoke(
        guildId: ULong, channelId: ULong, message: JsonArray, echo: JsonElement = EmptyJsonString, retryCnt: Int, recallDuration: Long?,
    ): String {
        val result = MsgSvc.sendToAio(MsgConstant.KCHATTYPEGUILD, guildId.toString(), message, fromId = channelId.toString(), retryCnt)
        if (result.isFailure) {
            return logic(result.exceptionOrNull()?.message ?: "", echo)
        }
        val sendMsgResult = result.getOrThrow()
        if (sendMsgResult.msgHashId <= 0) {
            return logic("send message failed", echo = echo)
        }
        recallDuration?.let { autoRecall(sendMsgResult.msgHashId, it) }
        return ok(MessageResult(
            msgId = sendMsgResult.msgHashId,
            time = (sendMsgResult.msgTime * 0.001).toLong()
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("guild_id", "channel_id", "message")

    private fun autoRecall(msgHash: Int, duration: Long) {
        GlobalScope.launch(Dispatchers.Default) {
            delay(duration)
            MsgSvc.recallMsg(msgHash)
        }
    }

}