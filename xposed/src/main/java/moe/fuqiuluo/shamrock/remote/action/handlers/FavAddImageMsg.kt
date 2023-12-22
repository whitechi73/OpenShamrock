package moe.fuqiuluo.shamrock.remote.action.handlers

import android.graphics.BitmapFactory
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.qqinterface.servlet.QFavSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.CryptTools
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.utils.FileUtils

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
                FileUtils.getFile(it)
            } else {
                FileUtils.parseAndSave(it)
            }
        }
        val options = BitmapFactory.Options()
        BitmapFactory.decodeFile(image.absolutePath, options)
        QFavSvc.applyUpImageMsg(uin, nickName,
            image = image,
            groupName = groupName,
            groupId = groupId,
            width = options.outWidth,
            height = options.outHeight
        ).onSuccess {
            return if (it.mHttpCode == 200 && it.mResult == 0) {
                val readPacket = ByteReadPacket(DeflateTools.ungzip(it.mRespData))
                readPacket.discardExact(6)
                val allLength = readPacket.readInt()
                val dataLength = readPacket.readInt()
                val headLength = allLength - dataLength - 16
                //LogCenter.log("上传图片请求成功: ${DeflateTools.ungzip(it.mRespData).toHexString()}")
                //LogCenter.log("图片上传响应: allLength=$allLength, dataLength=$dataLength, headLength=$headLength")
                readPacket.discardExact(2)
                ByteArray(headLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val data = ByteArray(dataLength).also {
                    readPacket.readFully(it, 0, it.size)
                }
                val pb = ProtoUtils.decodeFromByteArray(data)
                val resp = pb[2, 20010, 1, 2]
                val picUrl = resp[1].asUtf8String
                val picId = resp[11].asUtf8String
                val md5 = resp[4].asUtf8String

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
                }

                ok(picUrl, echo)
            } else {
                logic(it.mErrDesc, echo)
            }
        }.onFailure {
            return error(it.message ?: it.toString(), echo)
        }
        return ok("请求已提交", echo)
    }

    override fun path(): String = "fav.add_image_msg"

    override val requiredParams: Array<String> = arrayOf("user_id", "nick", "file")
}