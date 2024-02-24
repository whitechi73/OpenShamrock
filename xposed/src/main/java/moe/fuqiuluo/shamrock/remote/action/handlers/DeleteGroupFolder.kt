package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("delete_group_folder")
internal object DeleteGroupFolder: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val folderId = session.getString("folder_id")
        return invoke(groupId, folderId, session.echo)
    }

    suspend operator fun invoke(groupId: Long, folderId: String, echo: JsonElement = EmptyJsonString): String {
        if(!FileSvc.deleteGroupFolder(groupId, folderId)) {
            return error(why = "删除群文件夹失败", echo = echo)
        }
        return ok(msg = "成功", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "folder_id")
}