package moe.fuqiuluo.shamrock.remote.api

import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.ShamrockVersion

fun Routing.testAction() {
    if(ShamrockVersion.contains("dev")) {
        LogCenter.log("testAction is enabled.", Level.WARN)
    } else {
        return
    }

    /*
    get("/test/createUidFromTinyId") {
        val selfId = fetchOrThrow("selfId").toLong()
        val peerId = fetchOrThrow("peerId").toLong()
        call.respondText(NTServiceFetcher.kernelService.wrapperSession.msgService.createUidFromTinyId(selfId, peerId))
    }

    get("/test/addSendMsg") {
        val msgService = NTServiceFetcher.kernelService.wrapperSession.msgService
        val msgId = msgService.getMsgUniqueId(System.currentTimeMillis())
        msgService.addSendMsg(msgId, MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, TicketSvc.getUin()), arrayListOf(
            MsgElement().apply {
                elementType = MsgConstant.KELEMTYPETEXT
                textElement = TextElement().apply {
                    content = "测试消息"
                }
            }
        ), hashMapOf())
        call.respondText("ok")
    }*/

    /*
    get("/test/getMsgs") {
        kotlin.runCatching {
            val msgService = NTServiceFetcher.kernelService.wrapperSession.msgService
            val msgs = suspendCoroutine {
                msgService.getMsgs(Contact(MsgConstant.KCHATTYPEGROUP, "884587317", ""), 0L, 20, true, object: IMsgOperateCallback{
                    override fun onResult(code: Int, why: String?, msgs: ArrayList<MsgRecord>?) {
                        it.resume(msgs)
                    }
                })
            }
            if (msgs == null) {
                call.respondText("failed")
                return@get
            }

            call.respondText("msg -> " + msgs.map { it.toCQCode() }.joinToString("\n"))
        }.onFailure {
            call.respondText("failed: ${it.stackTraceToString()}")
            return@get
        }

    }*/
}