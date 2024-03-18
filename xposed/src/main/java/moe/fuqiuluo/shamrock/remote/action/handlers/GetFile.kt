package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.OutResourceByBase64
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.symbols.OneBotHandler
import java.util.Base64

@OneBotHandler("get_file") internal object GetFile : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val file = session.getString("file")
            .replace(regex = "[{}\\-]".toRegex(), replacement = "")
            .replace(" ", "")
            .split(".")[0].lowercase()
        val fileType = session.getString("file_type")
        return invoke(file, fileType, session.echo)
    }

    operator fun invoke(file: String, fileType: String = "base64", echo: JsonElement = EmptyJsonString): String {
        val targetFile = FileUtils.getFileByMd5(file)
        return if (targetFile.exists()) {
            when (fileType) {
                "base64", "" -> ok(
                    OutResourceByBase64(
                        "/res/${targetFile.nameWithoutExtension}",
                        Base64.getEncoder()
                            .encodeToString(targetFile.readBytes()),
                        targetFile.nameWithoutExtension,
                    ), echo
                )

                else -> error("only support base64", echo)
            }

        } else {
            error("not found record file from md5", echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("file", "file_type")
}