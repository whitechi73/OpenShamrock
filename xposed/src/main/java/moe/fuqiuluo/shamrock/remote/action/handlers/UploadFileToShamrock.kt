package moe.fuqiuluo.shamrock.remote.action.handlers

import android.util.Base64
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.symbols.OneBotHandler
import java.io.RandomAccessFile

@OneBotHandler("upload_file_to_shamrock")
internal object UploadFileToShamrock: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val md5 = session.getString("md5").hex2ByteArray()
        val offset = session.getStringOrNull("offset")?.toULong() ?: 0uL
        val chunk = Base64.decode(session.getString("chunk"), Base64.DEFAULT)
        val fileSize = session.getStringOrNull("file_size")?.toULong() ?: chunk.size.toULong()
        return invoke(md5, fileSize, offset, chunk, session.echo)
    }

    operator fun invoke(
        md5: ByteArray,
        fileSize: ULong,
        offset: ULong,
        chunk: ByteArray,
        echo: JsonElement = EmptyJsonString
    ): String {
        val file = FileUtils.getFileByMd5(md5.toHexString())
        runCatching {
            if (!file.exists()) {
                file.createNewFile()
            }
            val rd = RandomAccessFile(file, "rw")
            rd.setLength(fileSize.toLong())
            rd.seek(offset.toLong())
            rd.write(chunk, 0, chunk.size)
            rd.close()
        }.onFailure {
            return error(it.message ?: it.toString(), echo)
        }
        return ok(UploadFileResult(
            fileSize = fileSize,
            isFinish = fileSize <= offset + chunk.size.toULong(),
            filePath = file.absolutePath
        ), echo = echo)
    }

    @Serializable
    data class UploadFileResult(
        @SerialName("file_size") val fileSize: ULong,
        @SerialName("finish") val isFinish: Boolean,
        @SerialName("path") val filePath: String
    )
}