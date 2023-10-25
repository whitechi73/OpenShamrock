package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetGroupFileUrl: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val fileId = session.getString("file_id")
        val busid = session.getInt("busid")
        return invoke(groupId, fileId, busid, session.echo)
    }

    suspend operator fun invoke(groupId: String, fileId: String, busid: Int, echo: JsonElement = EmptyJsonString): String {
        return ok(data = FileSvc.getGroupFileInfo(groupId.toLong(), fileId, busid), echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "file_id", "busid")

    override fun path(): String = "get_group_file_url"
}