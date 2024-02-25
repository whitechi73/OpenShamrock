package moe.fuqiuluo.shamrock.remote.api

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.TextElement
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.action.handlers.SendMsgByResid
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher

fun Routing.testAction() {
    if (ShamrockConfig.isDev()) {
        LogCenter.log("testAction is enabled.", Level.WARN)
    } else {
        return
    }

    getOrPost("/send_msg_by_resid") {
        val resId = fetchOrThrow("res_id")
        val peerId = fetchOrThrow("peer_Id")
        val messageType = fetchOrThrow("message_type")
        call.respondText(SendMsgByResid(peerId, resId, messageType))
    }

    getOrPost("/createUidFromTinyId") {
        val selfId = fetchOrThrow("selfId").toLong()
        val peerId = fetchOrThrow("peerId")
        call.respondText(
            NTServiceFetcher.kernelService.wrapperSession.msgService.createUidFromTinyId(
                selfId,
                peerId.toLong()
            )
        )
    }

    getOrPost("/addSendMsg") {
        val msgService = NTServiceFetcher.kernelService.wrapperSession.msgService
        val msgId = msgService.getMsgUniqueId(System.currentTimeMillis())
        msgService.addSendMsg(msgId,
            MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, TicketSvc.getUin()),
            arrayListOf(
                MsgElement().apply {
                    elementType = MsgConstant.KELEMTYPETEXT
                    textElement = TextElement().apply {
                        content = "测试消息"
                    }
                }
            ),
            hashMapOf())
        call.respondText("ok")
    }
}