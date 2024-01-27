package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_essence_msg_list", ["get_essence_message_list"])
internal object GetEssenceMessageList: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val page = session.getIntOrNull("page") ?: 0
        val pageSize = session.getIntOrNull("page_size") ?: 20
        return invoke(groupId, page, pageSize, session.echo)
    }

    suspend operator fun invoke(groupId: Long, page: Int = 0, pageSize: Int = 20, echo: JsonElement = EmptyJsonString): String {
        if (page < 0 || pageSize > 50) {
            return badParam("参数不正确：page_size不得大于50", echo)
        }
        val essenceMessageList = GroupSvc.getEssenceMessageList(groupId, page, pageSize)
        if (essenceMessageList.isSuccess) {
            return ok(essenceMessageList.getOrNull(), echo)
        }
        return logic(essenceMessageList.exceptionOrNull()?.message ?: "", echo)
    }
}