package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_files_by_folder")
internal object GetGroupSubFiles: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val folderId = session.getString("folder_id")
        return invoke(groupId, folderId, session.echo)
    }

    suspend operator fun invoke(groupId: String, folderId: String, echo: JsonElement = EmptyJsonString): String {
        FileSvc.getGroupFiles(groupId.toLong(), folderId).onSuccess {
            return ok(it, echo = echo)
        }.getOrNull()
        return error(why = "获取失败", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "folder_id")
}