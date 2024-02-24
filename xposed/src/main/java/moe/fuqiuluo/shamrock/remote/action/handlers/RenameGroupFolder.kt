package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("rename_group_folder")
internal object RenameGroupFolder: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val folderId = session.getString("folder_id")
        val name = session.getString("name")
        return invoke(groupId, folderId, name, session.echo)
    }

    suspend operator fun invoke(groupId: Long, folderId: String, name: String, echo: JsonElement = EmptyJsonString): String {
        if (!FileSvc.renameFolder(groupId, folderId, name)) {
            return error("rename folder failed", echo = echo)
        }
        return ok("success", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "folder_id", "name")
}