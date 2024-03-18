package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.OutResourceByBase64
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.symbols.OneBotHandler
import java.io.ByteArrayOutputStream
import java.util.Base64
import java.util.zip.GZIPOutputStream

@OneBotHandler("get_file") internal object GetFile : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val file = session.getString("file")
            .replace(regex = "[{}\\-]".toRegex(), replacement = "")
            .replace(" ", "")
            .split(".")[0].lowercase()
        val fileType = session.getStringOrNull("file_type") ?: "base64"
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

                "gzip" -> ok(
                    OutResourceByBase64(
                        "/res/${targetFile.nameWithoutExtension}",
                        compressAndEncode(targetFile.readBytes()),
                        targetFile.nameWithoutExtension,
                    ), echo
                )

                else -> error("file_type error", echo)
            }

        } else {
            error("not found record file from md5", echo)
        }
    }


    fun compressAndEncode(input: ByteArray): String {
        // 压缩数据
        val outputStream = ByteArrayOutputStream()
        val gzip = GZIPOutputStream(outputStream)
        gzip.write(input)
        gzip.close()
        val compressedBytes = outputStream.toByteArray()

        // 编码为 Base64 字符串
        return Base64.getEncoder()
            .encodeToString(compressedBytes)
    }

    override val requiredParams: Array<String> = arrayOf("file")
}
