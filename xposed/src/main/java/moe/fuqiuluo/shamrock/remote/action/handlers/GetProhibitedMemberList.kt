package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetProhibitedMemberList: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupCode = session.getLong("group_id")
        return invoke(groupCode, session.echo)
    }

    suspend operator fun invoke(
        groupCode: Long,
        echo: JsonElement = EmptyJsonString
    ): String {
        val result = GroupSvc.getProhibitedMemberList(groupCode)
        if (result.isFailure) {
            return error(result.exceptionOrNull()?.message ?: "获取禁言列表失败", echo, arrayResult = true)
        }
        return ok(result.getOrThrow(), echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")

    override fun path(): String = "get_prohibited_member_list"
}