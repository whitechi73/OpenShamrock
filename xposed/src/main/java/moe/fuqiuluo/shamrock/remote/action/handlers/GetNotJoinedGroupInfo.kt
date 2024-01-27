package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_not_joined_group_info")
internal object GetNotJoinedGroupInfo: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        return invoke(groupId, session.echo)
    }

    suspend operator fun invoke(groupId: String, echo: JsonElement = EmptyJsonString): String {
        GroupSvc.getNotJoinedGroupInfo(groupId = groupId.toLong()).onSuccess {
            return ok(it, echo = echo)
        }.exceptionOrNull()?.let {
            return error(it.message ?: "无法获取群信息", echo = echo)
        }
        return logic("Unable to obtain group information", echo)
    }
}