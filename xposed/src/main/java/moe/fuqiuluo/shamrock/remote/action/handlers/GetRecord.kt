package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.LocalCacheHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.OutResource
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.AudioUtils
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_record")
internal object GetRecord: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val file = session.getString("file")
            .replace(regex = "[{}\\-]".toRegex(), replacement = "")
            .replace(" ", "")
            .split(".")[0].lowercase()
        val format = session.getString("out_format")
        return invoke(file, format, session.echo)
    }

    operator fun invoke(file: String, format: String, echo: JsonElement = EmptyJsonString): String {
        val pttFile = LocalCacheHelper.getCachePttFile(file)
        return if(pttFile.exists()) {
            val isSilk = AudioUtils.isSilk(pttFile)
            val audioFile = when(format) {
                "amr" -> AudioUtils.audioToAmr(pttFile, isSilk)
                else -> AudioUtils.audioToFormat(pttFile, isSilk, format)
            }
            ok(
                OutResource(
                audioFile.toString(),
                url = "/res/${audioFile.nameWithoutExtension}"
            ), echo)
        } else {
            error("not found record file from cache", echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("file", "out_format")
}