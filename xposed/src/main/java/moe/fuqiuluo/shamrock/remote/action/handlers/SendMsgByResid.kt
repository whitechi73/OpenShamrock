package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.atomicfu.atomic
import kotlinx.serialization.json.JsonElement

import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler
import protobuf.auto.toByteArray
import protobuf.message.*
import protobuf.message.element.GeneralFlags
import protobuf.message.routing.C2C
import protobuf.message.routing.Grp
import kotlin.random.Random
import kotlin.random.nextUInt

@OneBotHandler("send_msg_by_resid")
internal object SendMsgByResid : IActionHandler() {
    private val msgSeq = atomic(1000)

    override suspend fun internalHandle(session: ActionSession): String {
        val resid = session.getString("resid")
        val peerId = session.getString("peer")
        val msgType = session.getStringOrNull("message_type") ?: "group"
        return invoke(peerId, resid, msgType, session.echo)
    }

    suspend operator fun invoke(peerId: String, resId: String, type: String, echo: JsonElement = EmptyJsonString): String {
        val req = PbSendMsgReq(
            routingHead = when (type) {
                "group" ->RoutingHead(grp = Grp(peerId.toUInt()))
                "private" ->RoutingHead( c2c = C2C(peerId.toUInt()))
                else ->RoutingHead( grp = Grp(peerId.toUInt()))
            },
            contentHead = ContentHead(1, 0, 0, 0),
            msgBody = MsgBody(
                richText = RichText(
                    elements = arrayListOf(
                        Elem(
                            generalFlags = GeneralFlags(
                                longTextFlag = 1u,
                                longTextResid = resId.toByteArray()
                            )
                        )
                    )
                )
            ),
            msgSeq = msgSeq.incrementAndGet().toUInt(),
            msgRand = Random.nextUInt(),
            msgVia = 0u
        )
        BaseSvc.sendBufferAW("MessageSvc.PbSendMsg", true, req.toByteArray())
        return ok("ok", echo)
    }
}