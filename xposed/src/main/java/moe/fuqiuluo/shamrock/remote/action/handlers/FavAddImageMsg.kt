package moe.fuqiuluo.shamrock.remote.action.handlers

import android.graphics.BitmapFactory
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.json.JsonElement

import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.CryptTools
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.symbols.OneBotHandler
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.fav.WeiyunComm

@OneBotHandler("fav.add_image_msg", ["fav.add_image_message"])
internal object FavAddImageMsg: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val uin = session.getLong("user_id")
        val nickName = session.getString("nick")
        val groupName = session.getStringOrNull("group_name") ?: ""
        val groupId = session.getLongOrNull("group_id") ?: 0L
        val file = session.getString("file")
        return invoke(uin, nickName, file, groupName, groupId, session.echo)
    }

    suspend operator fun invoke(
        uin: Long,
        nickName: String,
        fileText: String,
        groupName: String = "",
        groupId: Long = 0L,
        echo: JsonElement = EmptyJsonString
    ): String {
        val image = fileText.let {
            val md5 = it.replace(regex = "[{}\\-]".toRegex(), replacement = "").split(".")[0].lowercase()
            if (md5.length == 32) {
                FileUtils.getFileByMd5(it)
            } else {
                FileUtils.parseAndSave(it)
            }
        }

        val options = BitmapFactory.Options()
        BitmapFactory.decodeFile(image.absolutePath, options)
        lateinit var picUrl: String
        lateinit var picId: String
        lateinit var itemId: String
        lateinit var md5: String

        QFavSvc.applyUpImageMsg(uin, nickName,
            image = image,
            groupName = groupName,
            groupId = groupId,
            width = options.outWidth,
            height = options.outHeight
        ).onSuccess {
            if (it.mHttpCode == 200 && it.mResult == 0) {
                val readPacket = ByteReadPacket(DeflateTools.ungzip(it.mRespData))
                readPacket.discardExact(6)
                val allLength = readPacket.readInt()
                val dataLength = readPacket.readInt()
                val headLength = allLength - dataLength - 16
                readPacket.discardExact(2)
                ByteArray(headLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val data = ByteArray(dataLength).also {
                    readPacket.readFully(it, 0, it.size)
                }

                val resp = data.decodeProtobuf<WeiyunComm>()
                    .resp!!.fastUploadResourceResp!!.picResultList!!.first()
                val picInfo = resp.picInfo!!
                picUrl = picInfo.uri
                picId = picInfo.picId
                md5 = picInfo.name
            } else {
                return logic(it.mErrDesc, echo)
            }
        }.onFailure {
            return error(it.message ?: it.toString(), echo)
        }

        val sha = CryptTools
            .getSHA1("/storage/emulated/0/Android/data/com.tencent.mobileqq/Tencent/QQ_Collection/pic/" + md5.uppercase() + "_0")

        image.inputStream().use {
            var offset = 0L
            val block = ByteArray(131072)
            var rest = image.length()
            do {
                val length = if (rest <= 131072) rest else 131072L
                if(it.read(block, 0, length.toInt()) != -1) {
                    QFavSvc.sendPicUpBlock(
                        fileSize = image.length(),
                        offset = offset,
                        block = block,
                        blockSize = length,
                        pid = picId,
                        sha = sha
                    ).onFailure {
                        return error(it.message ?: it.toString(), echo)
                    }
                    offset += length
                    rest -= length
                } else {
                    rest = -1
                }
            } while (rest > 0)
        }

        QFavSvc.addImageMsg(
            uin, nickName, groupId, groupName, picUrl, picId, options.outWidth, options.outHeight, image.length(), md5.uppercase()
        ).onFailure {
            return error(it.message ?: it.toString(), echo)
        }.onSuccess {
            if (it.mHttpCode == 200 && it.mResult == 0) {
                val readPacket = ByteReadPacket(DeflateTools.ungzip(it.mRespData))
                readPacket.discardExact(6)
                val allLength = readPacket.readInt()
                val dataLength = readPacket.readInt()
                val headLength = allLength - dataLength - 16
                readPacket.discardExact(2)
                ByteArray(headLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val data = ByteArray(dataLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val resp = data.decodeProtobuf<WeiyunComm>().resp!!
                itemId = resp.addRichMediaResp!!.cid
            }

            System.gc()
        }

        return ok(PicInfo(
            picUrl = picUrl,
            picId = picId,
            id = itemId
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id", "nick", "file")

    @Serializable
    private data class PicInfo(
        @SerialName("pic_url") val picUrl: String,
        @SerialName("pic_id") val picId: String,
        @SerialName("id") val id: String
    )
}