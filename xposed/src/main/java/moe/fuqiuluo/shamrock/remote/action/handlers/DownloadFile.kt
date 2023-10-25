package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonObject
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.utils.DownloadUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5

internal object DownloadFile: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val url = session.getString("url")
        val threadCnt = session.getIntOrNull("thread_cnt") ?: 3
        val headers = if (session.isArray("headers")) {
            session.getArray("headers").map {
                it.asString
            }
        } else {
            session.getString("headers").split("\r\n")
        }
        return invoke(url, threadCnt, headers, session.echo)
    }

    suspend operator fun invoke(
        url: String,
        threadCnt: Int,
        headers: List<String>,
        echo: JsonElement = EmptyJsonString
    ): String {
        val headerMap = mutableMapOf(
            "User-Agent" to "Shamrock"
        )
        headers.forEach {
            val pair = it.split("=")
            if (pair.size >= 2) {
                val (k, v) = pair
                headerMap[k] = v
            }
        }
        return invoke(url, threadCnt, headerMap, echo)
    }

    suspend operator fun invoke(
        url: String,
        threadCnt: Int,
        headers: Map<String, String>,
        echo: JsonElement = EmptyJsonString
    ): String {
        return kotlin.runCatching {
            var tmp = FileUtils.getTmpFile("cache")
            if(!DownloadUtils.download(
                    urlAdr = url,
                    dest = tmp,
                    headers = headers,
                    threadCount = threadCnt
                )) {
                return error("下载失败 (0x1)", echo)
            }
            tmp = FileUtils.renameByMd5(tmp)
            ok(data = DownloadResult(
                file = tmp.absolutePath,
                md5 = MD5.genFileMd5Hex(tmp.absolutePath)
            ), msg = "成功", echo = echo)
        }.getOrElse {
            logic(it.stackTraceToString(), echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("url")

    override fun path(): String = "download_file"

    @Serializable
    data class DownloadResult(
        val file: String,
        val md5: String
    )
}