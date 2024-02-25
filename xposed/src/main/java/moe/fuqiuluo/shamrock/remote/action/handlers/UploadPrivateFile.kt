package moe.fuqiuluo.shamrock.remote.action.handlers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.FileElement
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.msg.api.IMsgService
import com.tencent.qqnt.msg.api.IMsgUtilApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.TransfileHelper
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.qqinterface.servlet.transfile.RichMediaUploadHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.symbols.OneBotHandler
import java.io.File
import java.io.FileOutputStream
import kotlin.coroutines.resume

@OneBotHandler("upload_private_file")
internal object UploadPrivateFile : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getLong("user_id")
        val file = session.getString("file")
        val name = session.getString("name")
            .replace("/", "_")
            .replace("\\", "_")
            .replace("\n", "_")
            .replace("\t", "_")
            .replace("\r", "_")
        return invoke(userId, file, name, session.echo)
    }

    suspend operator fun invoke(
        userId: Long,
        file: String,
        name: String,
        echo: JsonElement = EmptyJsonString
    ): String {
        var srcFile = File(file)
        if (!srcFile.exists()) {
            srcFile = FileUtils.getFile(file)
        }

        if (!srcFile.exists()) {
            srcFile = file.let {
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
        }

        if (!srcFile.exists()) {
            return badParam("文件不存在", echo)
        }

        val fileElement = FileElement()
        fileElement.fileMd5 = ""
        fileElement.fileName = name
        fileElement.filePath = srcFile.absolutePath
        fileElement.fileSize = srcFile.length()
        fileElement.folderId = srcFile.parent ?: ""
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
                val thumbPic = FileUtils.getFileByMd5(MD5.genFileMd5Hex(srcFile.absolutePath))
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

        // 根据文件大小调整超时时间
        val msgIdPair = MessageHelper.generateMsgId(MsgConstant.KCHATTYPEC2C)
        val info = (withTimeoutOrNull((srcFile.length() / (300 * 1024)) * 1000 + 5000) {
            val msgService = QRoute.api(IMsgService::class.java)
            val contact = MessageHelper.generateContact(MsgConstant.KCHATTYPEC2C, userId.toString())
            suspendCancellableCoroutine<FileTransNotifyInfo?> {
                msgService.sendMsgWithMsgId(
                    contact, msgIdPair.qqMsgId, arrayListOf(msgElement)
                ) { code, reason ->
                    if (code != 0) {
                        LogCenter.log("私聊文件消息发送异常(code = $code, reason = $reason)")
                        it.resume(null)
                    }
                }
                RichMediaUploadHandler.registerListener(msgIdPair.qqMsgId) {
                    it.resume(this)
                    return@registerListener true
                }
            }
        } ?: return error("上传文件失败", echo)).also {
            if (it.commonFileInfo == null) {
                return error(it.fileErrMsg ?: "上传文件失败", echo)
            }
        }.commonFileInfo

        return ok(data = UploadGroupFile.FileUploadResult(
            msgHash = msgIdPair.msgHashId,
            bizid = info.bizType ?: 0,
            md5 = info.md5,
            sha = info.sha,
            sha3 = info.sha3,
            fileId = info.uuid
        ), echo = echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id", "file", "name")
}