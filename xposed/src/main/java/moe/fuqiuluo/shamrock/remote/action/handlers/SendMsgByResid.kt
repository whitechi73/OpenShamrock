package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.atomicfu.atomic
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.symbols.OneBotHandler
import protobuf.msg.C2C
import protobuf.msg.ContentHead
import protobuf.msg.Elem
import protobuf.msg.GeneralFlags
import protobuf.msg.Grp
import protobuf.msg.MsgBody
import protobuf.msg.PbSendMsgReq
import protobuf.msg.RichText
import protobuf.msg.RoutingHead
import kotlin.random.Random
import kotlin.random.nextUInt

@OneBotHandler("send_msg_by_resid")
internal object SendMsgByResid: IActionHandler() {
    private val msgSeq = atomic(1000)

    override suspend fun internalHandle(session: ActionSession): String {
        val resid = session.getString("resid")
        val peerId = session.getString("peer")
        val req = PbSendMsgReq(
            routingHead = RoutingHead().apply {
                when(session.getStringOrNull("message_type")) {
                    "group" -> grp = Grp(peerId.toULong())
                    "private" -> c2c = C2C(peerId.toULong())
                    else -> grp = Grp(peerId.toULong())
                }
            },
            contentHead = ContentHead(1u, 0u, 0u, 0u),
            msgBody = MsgBody(
                richText = RichText(arrayListOf(Elem(
                    generalFlags = GeneralFlags(
                        long_text_flag = 1u,
                        long_text_resid = resid.toByteArray()
                    )
                )))
            ),
            msgSeq = msgSeq.incrementAndGet().toULong(),
            msgRand = Random.nextUInt(),
            msgVia = 0u
        )
        BaseSvc.sendBufferAW("MessageSvc.PbSendMsg", true, ProtoBuf.encodeToByteArray(req))
        return ok("ok", session.echo)
    }
}