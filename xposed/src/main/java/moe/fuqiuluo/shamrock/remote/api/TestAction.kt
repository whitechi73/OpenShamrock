package moe.fuqiuluo.shamrock.remote.api

import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.kernel.nativeinterface.TextElement
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.msg.convert.toCQCode
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import moe.fuqiuluo.shamrock.tools.fetch
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import java.util.ArrayList
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

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