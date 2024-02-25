package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.structures.CommFileInfo
import moe.fuqiuluo.qqinterface.servlet.structures.UploadResult
import moe.fuqiuluo.qqinterface.servlet.transfile.NtV2RichMediaSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.symbols.OneBotHandler
import kotlin.time.Duration.Companion.seconds

@OneBotHandler("upload_nt_resource", ["upload_nt_res"])
internal object UploadNtResource: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val pic = session.getString("file")
        val chatType = when(session.getStringOrNull("message_type")) {
            "group" -> MsgConstant.KCHATTYPEGROUP
            "guild" -> MsgConstant.KCHATTYPEGUILD
            "private" -> MsgConstant.KCHATTYPEC2C
            else -> MsgConstant.KCHATTYPEGROUP
        }
        val fileType = when(session.getStringOrNull("file_type")) {
            "file" -> MsgConstant.KELEMTYPEFILE
            "image", "pic" -> MsgConstant.KELEMTYPEPIC
            "video" -> MsgConstant.KELEMTYPEVIDEO
            "audio", "voice", "record" -> MsgConstant.KELEMTYPEPTT
            else -> MsgConstant.KELEMTYPEFILE
        }
        return invoke(chatType, fileType, pic, session.echo)
    }

    suspend operator fun invoke(
        chatType: Int,
        fileType: Int,
        picture: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        if (ShamrockConfig.isDev()) {
            val file = picture.let {
                val md5 = it.replace(
                    regex = "[{}\\-]".toRegex(),
                    replacement = ""
                ).split(".")[0].lowercase()
                if (md5.length == 32) {
                    FileUtils.getFileByMd5(it)
                } else {
                    FileUtils.parseAndSave(it)
                }
            }
            if (!file.exists()) {
                return logic("picture file is not exists", echo)
            }
            NtV2RichMediaSvc.tryUploadResourceByNt(
                chatType = chatType,
                elementType = fileType,
                resources = arrayListOf(file),
                timeout = 30.seconds
            ).onSuccess {
                return ok(UploadResult(it.map {
                    CommFileInfo(
                        modeId = it.fileModelId,
                        fileName = it.fileName,
                        fileSize = it.fileSize,
                        md5 = it.md5,
                        uuid = it.uuid,
                        subId = it.subId,
                        sha = it.sha ?: ""
                    )
                }), echo)
            }.onFailure {
                return logic("upload failed: ${it.message ?: it.toString()}", echo)
            }
        }
        return logic("upload failed", echo)
    }

    override val requiredParams: Array<String> = arrayOf("file")
}