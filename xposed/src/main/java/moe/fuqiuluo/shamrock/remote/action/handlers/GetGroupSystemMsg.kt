package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.GroupRequest
import moe.fuqiuluo.shamrock.remote.service.data.GroupSystemMessage
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_system_msg", ["get_group_system_message"])
internal object GetGroupSystemMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(echo = session.echo)
    }

    suspend operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        val list = GroupSvc.requestGroupSystemMsgNew(20)
        val riskList = GroupSvc.requestGroupSystemMsgNew(20, 2)
        val msgs = GroupSystemMessage(
            invited = mutableListOf(),
            join = mutableListOf()
        )
        (list + riskList).forEach {
            when(it.msg.group_msg_type.get()) {
                22, 1 -> {
                    // join 进群消息
                    msgs.join += GroupRequest (
                        msgSeq = it.msg_seq.get(),
                        invitorUin = it.msg.action_uin.get(),
                        invitorNick = it.msg.action_uin_nick.get(),
                        groupId = it.msg.group_code.get(),
                        groupName = it.msg.group_name.get(),
                        checked = it.msg.msg_decided.get().isNotBlank(),
                        actor = it.msg.actor_uin.get(),
                        requesterUin = it.req_uin.get(),
                        requesterNick = it.msg.req_uin_nick.get(),
                        message = it.msg.msg_additional.get(),
                        flag = "${it.msg_seq.get()};${it.msg.group_code.get()};${it.req_uin.get()}"
                    )
                }
                2 -> {
                    // invite 别人邀请我
                    msgs.invited += GroupRequest (
                        msgSeq = it.msg_seq.get(),
                        invitorUin = it.msg.action_uin.get(),
                        invitorNick = it.msg.action_uin_nick.get(),
                        groupId = it.msg.group_code.get(),
                        groupName = it.msg.group_name.get(),
                        checked = it.msg.msg_decided.get().isNotBlank(),
                        actor = it.msg.actor_uin.get(),
                        requesterUin = 0,
                        requesterNick = "",
                        message = it.msg.msg_additional.get(),
                        flag = "${it.msg_seq.get()};${it.msg.group_code.get()};${it.req_uin.get()}"
                    )
                }

                else -> {}
            }
        }
        return ok(msgs, echo = echo)
    }
}