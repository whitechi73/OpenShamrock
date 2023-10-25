package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object DeleteGroupFolder: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val folderId = session.getString("folder_id")
        return invoke(groupId, folderId, session.echo)
    }

    operator fun invoke(groupId: String, folderId: String, echo: JsonElement = EmptyJsonString): String {
        FileSvc.deleteGroupFolder(groupId, folderId)
        return ok(msg = "成功", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "folder_id")

    override fun path(): String = "delete_group_folder"
}