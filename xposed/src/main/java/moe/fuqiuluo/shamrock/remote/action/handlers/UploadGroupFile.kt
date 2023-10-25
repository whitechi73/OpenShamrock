package moe.fuqiuluo.shamrock.remote.action.handlers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.FileElement
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.msg.api.IMsgService
import com.tencent.qqnt.msg.api.IMsgUtilApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.TransfileHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5
import java.io.File
import java.io.FileOutputStream

internal object UploadGroupFile : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val file = session.getString("file")
        val name = session.getString("name")
            .replace("/", "_")
            .replace("\\", "_")
            .replace("\n", "_")
            .replace("\t", "_")
            .replace("\r", "_")
        return invoke(groupId, file, name, session.echo)
    }

    suspend operator fun invoke(
        groupId: String,
        file: String,
        name: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        var srcFile = File(file)
        if (!srcFile.exists()) {
            srcFile = FileUtils.getFile(file)
        }
        if (!srcFile.exists()) {
            return badParam("文件不存在", echo)
        }

        val fileElement = FileElement()
        fileElement.fileMd5 = ""
        fileElement.fileName = name
        fileElement.filePath = srcFile.absolutePath
        fileElement.fileSize = srcFile.length()
        fileElement.picWidth = 0
        fileElement.picHeight = 0
        fileElement.videoDuration = 0
        fileElement.picThumbPath = HashMap()
        fileElement.expireTime = 0L
        fileElement.fileSha = ""
        fileElement.fileSha3 = ""
        fileElement.file10MMd5 = ""
        when (TransfileHelper.getExtensionId(name)) {
            0 -> {
                val wh = QRoute.api(IMsgUtilApi::class.java)
                    .getPicSizeByPath(srcFile.absolutePath)
                fileElement.picWidth = wh.first
                fileElement.picHeight = wh.second
                fileElement.picThumbPath[750] = srcFile.absolutePath
            }
            2 -> {
                val thumbPic = FileUtils.getFile(MD5.genFileMd5Hex(srcFile.absolutePath))
                withContext(Dispatchers.IO) {
                    val fileOutputStream = FileOutputStream(thumbPic)
                    val retriever = MediaMetadataRetriever()
                    retriever.setDataSource(fileElement.filePath)
                    retriever.frameAtTime?.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                }
                val options = BitmapFactory.Options()
                BitmapFactory.decodeFile(thumbPic.absolutePath, options)
                fileElement.picHeight = options.outHeight
                fileElement.picWidth = options.outWidth
                fileElement.picThumbPath = hashMapOf(750 to thumbPic.absolutePath)
            }
        }
        val msgElement = MsgElement()
        msgElement.elementType = MsgConstant.KELEMTYPEFILE
        msgElement.fileElement = fileElement

        val msgIdPair = MessageHelper.generateMsgId(MsgConstant.KCHATTYPEGROUP)
        val msgService = QRoute.api(IMsgService::class.java)
        msgService.sendMsgWithMsgId(
            MessageHelper.generateContact(MsgConstant.KCHATTYPEGROUP, groupId), msgIdPair.second, arrayListOf(msgElement)
        ) { code, reason ->
            LogCenter.log("群文件消息发送异常(code = $code, reason = $reason)")
        }

        return ok(data = FileUploadResult(
            msgHash = msgIdPair.first
        ), echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "file", "name")

    override fun path(): String = "upload_group_file"

    @Serializable
    data class FileUploadResult(
        @SerialName("msg_id") val msgHash: Int,
    )
}