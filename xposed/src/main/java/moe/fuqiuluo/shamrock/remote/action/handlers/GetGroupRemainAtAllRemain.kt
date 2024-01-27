package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_at_all_remain")
internal object GetGroupRemainAtAllRemain: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        return invoke(groupId, session.echo)
    }

    suspend operator fun invoke(
        groupId: Long,
        echo: JsonElement = EmptyJsonString
    ): String {
        val result = GroupSvc.getGroupRemainAtAllRemain(groupId)
        if (result.isFailure) {
            return error(result.exceptionOrNull()?.message ?: "获取群 @全体成员 剩余次数失败", echo, arrayResult = true)
        }
        return ok(result.getOrThrow(), echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")
}