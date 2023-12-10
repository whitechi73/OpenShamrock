package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FriendSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.FriendRequest
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetFriendSystemMsg : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(echo = session.echo)
    }

    suspend operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        val list = FriendSvc.requestFriendSystemMsgNew(20)
        val msgs = list
            // 13 是加别人好友
            ?.filter { it.msg.sub_type.get() != 13 }
            ?.map {
                LogCenter.log(it.toString(), Level.WARN)
                FriendRequest(
                    seq = it.msg_seq.get(),
                    userId = it.req_uin.get(),
                    name = it.msg.req_uin_nick.get(),
                    source = it.msg.msg_source.get(),
                    subId = it.msg.src_id.get(),
                    subSrcId = it.msg.sub_src_id.get(),
                    msg = it.msg.msg_additional.get(),
                    sourceGroupName = it.msg.group_name.get(),
                    sourceGroupCode = it.msg.group_code.get(),
                    flag = "${it.msg_seq.get()};${it.msg.src_id.get()};${it.msg.sub_src_id.get()};${it.req_uin.get()}",
                    sex = if (it.msg.req_uin_gender.get() == 1) "female" else "male",
                    age = it.msg.req_uin_age.get(),
                    msgDetail = it.msg.msg_detail.get(),
                    status = it.msg.msg_decided.get()
                )
            } ?: mutableListOf()
        return ok(msgs, echo = echo)
    }

    override fun path(): String = "get_friend_system_msg"
}