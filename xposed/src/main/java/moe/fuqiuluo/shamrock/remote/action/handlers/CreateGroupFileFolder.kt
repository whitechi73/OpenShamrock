package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.FileSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("create_group_file_folder")
internal object CreateGroupFileFolder: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val folderName = session.getString("name")
        val echo = session.echo
        return invoke(groupId, folderName, echo)
    }

    suspend operator fun invoke(groupId: Long, folderName: String, echo: JsonElement = EmptyJsonString): String {
        val result = FileSvc.createFileFolder(groupId, folderName)
        if (result.isFailure) {
            return ok(msg = result.exceptionOrNull()?.message ?: "无法创建群文件夹", echo = echo)
        }
        return ok(data = result.getOrThrow(), msg = "成功", echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "name")
}