package moe.fuqiuluo.shamrock.remote.api

import moe.fuqiuluo.shamrock.helper.MessageHelper
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import moe.fuqiuluo.shamrock.remote.action.handlers.*
import moe.fuqiuluo.shamrock.tools.fetchGetOrNull
import moe.fuqiuluo.shamrock.tools.fetchGetOrThrow
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.fetchPostJsonArray
import moe.fuqiuluo.shamrock.tools.fetchPostJsonString
import moe.fuqiuluo.shamrock.tools.fetchPostOrNull
import moe.fuqiuluo.shamrock.tools.fetchPostOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.tools.isJsonData
import moe.fuqiuluo.shamrock.tools.isJsonString

fun Routing.messageAction() {
    getOrPost("/clear_msgs") {
        val msgType = fetchOrThrow("message_type")
        val peerId = fetchOrThrow(if (msgType == "group") "group_id" else "user_id")
        call.respondText(ClearMsgs(msgType, peerId))
    }

    getOrPost("/delete_msg") {
        val msgHash = fetchOrThrow("message_id").toInt()
        call.respondText(DeleteMessage(msgHash))
    }

    getOrPost("/get_msg") {
        val msgHash = fetchOrThrow("message_id").toInt()
        call.respondText(GetMsg(msgHash))
    }

    route("/(send_msg|send_message)".toRegex()) {
        get {
            val msgType = fetchGetOrThrow("message_type")
            val message = fetchGetOrThrow("message")
            val autoEscape = fetchGetOrNull("auto_escape")?.toBooleanStrict() ?: false
            val chatType = MessageHelper.obtainMessageTypeByDetailType(msgType)

            val userId = fetchGetOrNull("user_id")
            val groupId = fetchGetOrNull("group_id")

            call.respondText(SendMessage(
                chatType = chatType,
                peerId = if (chatType == MsgConstant.KCHATTYPEC2C) userId!! else groupId!!,
                message = message,
                autoEscape = autoEscape,
                fromId = groupId ?: userId ?: ""
            ))
        }
        post {
            val msgType = fetchPostOrThrow("message_type")
            val chatType = MessageHelper.obtainMessageTypeByDetailType(msgType)

            val userId = fetchPostOrNull("user_id")
            val groupId = fetchPostOrNull("group_id")

            call.respondText(if (isJsonData() && !isJsonString("message")) {
                SendMessage(
                    chatType = chatType,
                    peerId = if (chatType == MsgConstant.KCHATTYPEC2C) userId!! else groupId!!,
                    message = fetchPostJsonArray("message"),
                    fromId = groupId ?: userId ?: ""
                )
            } else {
                val autoEscape = fetchPostOrNull("auto_escape")?.toBooleanStrict() ?: false
                //SendMessage(chatType, peerId, fetchPostOrThrow("message"), autoEscape)
                SendMessage(
                    chatType = chatType,
                    peerId = if (chatType == MsgConstant.KCHATTYPEC2C) userId!! else groupId!!,
                    message = fetchPostOrThrow("message"),
                    autoEscape = autoEscape,
                    fromId = groupId ?: userId ?: ""
                )
            })
        }
    }

    route("/send_group_(msg|message)".toRegex()) {
        get {
            val groupId = fetchGetOrThrow("group_id")
            val message = fetchGetOrThrow("message")
            val autoEscape = fetchGetOrNull("auto_escape")?.toBooleanStrict() ?: false
            call.respondText(SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, message, autoEscape))
        }
        post {
            val groupId = fetchPostOrThrow("group_id")

            val autoEscape = fetchPostOrNull("auto_escape")?.toBooleanStrict() ?: false

            val result = if (isJsonData()) {
                if (isJsonString("message")) {
                    SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, fetchPostJsonString("message"), autoEscape)
                } else {
                    SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, fetchPostJsonArray("message"))
                }
            } else {
                SendMessage(MsgConstant.KCHATTYPEGROUP, groupId, fetchPostOrThrow("message"), autoEscape)
            }

            call.respondText(result)
        }
    }

    route("/send_private_(msg|message)".toRegex()) {
        get {
            val userId = fetchGetOrThrow("user_id")
            val groupId = fetchGetOrNull("group_id")
            val message = fetchGetOrThrow("message")
            val autoEscape = fetchGetOrNull("auto_escape")?.toBooleanStrict() ?: false
            call.respondText(SendMessage(
                chatType = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP,
                peerId = userId,
                message = message,
                autoEscape = autoEscape,
                fromId = groupId ?: userId
            ))
        }
        post {
            val userId = fetchPostOrThrow("user_id")
            val groupId = fetchPostOrNull("group_id")
            val autoEscape = fetchPostOrNull("auto_escape")?.toBooleanStrict() ?: false

            val result = if (isJsonData()) {
                if (isJsonString("message")) {
                    SendMessage(
                        chatType = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP,
                        userId,
                        fetchPostJsonString("message"),
                        autoEscape
                    )
                } else {
                    SendMessage(
                        chatType = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP,
                        userId,
                        fetchPostJsonArray("message")
                    )
                }
            } else {
                SendMessage(
                    chatType = if (groupId == null) MsgConstant.KCHATTYPEC2C else MsgConstant.KCHATTYPETEMPC2CFROMGROUP,
                    userId,
                    fetchPostOrThrow("message"),
                    autoEscape
                )
            }

            call.respondText(result)
        }
    }
}