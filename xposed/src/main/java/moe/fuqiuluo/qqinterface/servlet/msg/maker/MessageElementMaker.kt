package moe.fuqiuluo.qqinterface.servlet.msg.maker

import android.graphics.BitmapFactory
import androidx.exifinterface.media.ExifInterface
import com.tencent.qqnt.kernel.nativeinterface.*
import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.qqinterface.servlet.CardSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.transfile.*
import moe.fuqiuluo.qqinterface.servlet.transfile.PictureResource
import moe.fuqiuluo.qqinterface.servlet.transfile.Private
import moe.fuqiuluo.qqinterface.servlet.transfile.Transfer
import moe.fuqiuluo.qqinterface.servlet.transfile.Troop
import moe.fuqiuluo.shamrock.helper.*
import moe.fuqiuluo.shamrock.helper.ActionMsgException
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.LogicException
import moe.fuqiuluo.shamrock.helper.ParamsException
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.shamrock.xposed.helper.msgService
import protobuf.auto.toByteArray
import protobuf.message.Elem
import protobuf.message.element.*
import protobuf.message.element.commelem.*
import java.io.File
import java.nio.ByteBuffer
import kotlin.random.Random
import kotlin.random.nextULong

internal typealias IMessageElementMaker = suspend (Int, Long, String, JsonObject) -> Result<Elem>

internal object MessageElementMaker {
    private val makerArray = hashMapOf(
        "text" to MessageElementMaker::createTextElem,
        "at" to MessageElementMaker::createAtElem,
        "face" to MessageElementMaker::createFaceElem,
        "pic" to MessageElementMaker::createImageElem,
        "image" to MessageElementMaker::createImageElem,
//        "voice" to MessageElementMaker::createRecordElem,
//        "record" to MessageElementMaker::createRecordElem,
//        "video" to MessageElementMaker::createVideoElem,
        "markdown" to MessageElementMaker::createMarkdownElem,
        "button" to MessageElementMaker::createButtonElem,
        "inline_keyboard" to MessageElementMaker::createButtonElem,
//        "dice" to MessageElementMaker::createDiceElem,
//        "rps" to MessageElementMaker::createRpsElem,
        "basketball" to MessageElementMaker::createBasketballElem,
        "new_dice" to MessageElementMaker::createNewDiceElem,
        "new_rps" to MessageElementMaker::createNewRpsElem,
        "poke" to MessageElementMaker::createPokeElem,
//        "anonymous" to MessageElementMaker::createAnonymousElem,
//        "share" to MessageElementMaker::createShareElem,
//        "contact" to MessageElementMaker::createContactElem,
//        "location" to MessageElementMaker::createLocationElem,
//        "music" to MessageElementMaker::createMusicElem,
        "reply" to MessageElementMaker::createReplyElem,
//        "touch" to MessageElementMaker::createTouchElem,
//        "weather" to MessageElementMaker::createWeatherElem,
        "json" to MessageElementMaker::createJsonElem,
        //"node" to MessageMaker::createNodeElem,
        //"multi_msg" to MessageMaker::createLongMsgStruct,
        //"bubble_face" to MessageElementMaker::createBubbleFaceElem,
    )

    operator fun get(type: String): IMessageElementMaker? = makerArray[type]

    private suspend fun createTextElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("text")
        val elem = Elem(
            text = TextMsg(data["text"].asString)
        )
        return Result.success(elem)
    }

    private suspend fun createAtElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        return when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
                data.checkAndThrow("qq")

                val qq: Long
                val type: Int
                val display = when (val qqStr = data["qq"].asString) {
                    "0", "all" -> {
                        qq = 0
                        type = 1
                        "@全体成员"
                    }

                    "online" -> {
                        qq = 0
                        type = 64
                        "@在线成员"
                    }

                    else -> {
                        qq = qqStr.toLong()
                        type = 0
                        "@" + (data["name"].asStringOrNull ?: GroupSvc.getTroopMemberInfoByUinV2(peerId, qqStr, true)
                            .let {
                                val info = it.getOrNull()
                                if (info == null)
                                    LogCenter.log("无法获取群成员信息: $qqStr", Level.ERROR)
                                info?.troopnick
                                    .ifNullOrEmpty(info?.friendnick)
                                    .ifNullOrEmpty(qqStr)
                            })
                    }
                }

                val attr6: ByteBuffer = ByteBuffer.allocate(6)
                attr6.put(byteArrayOf(0, 1, 0, 0, 0))
                attr6.putChar(display.length.toChar())
                attr6.putChar(type.toChar())
                attr6.putBuf32Long(qq)
                attr6.put(byteArrayOf(0, 0))
                val elem = Elem(
                    text = TextMsg(str = display, attr6Buf = attr6.array())
                )
                Result.success(elem)
            }

            MsgConstant.KCHATTYPEC2C -> {
                data.checkAndThrow("qq")

                val qq = data["qq"].asString
                val display =
                    "@" + (data["name"].asStringOrNull ?: CardSvc.getProfileCard(qq)
                        .onSuccess {
                            it.strNick.ifNullOrEmpty(qq)
                        }.onFailure {
                            LogCenter.log("无法获取QQ信息: $qq", Level.WARN)
                        })

                val elem = Elem(
                    text = TextMsg(str = display)
                )
                Result.success(elem)
            }

            else -> Result.failure(ActionMsgException)
        }
    }

    private suspend fun createFaceElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("id")
        val elem = Elem(
            face = FaceMsg(data["id"].asInt)
        )
        return Result.success(elem)
    }

    private suspend fun createImageElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        val isOriginal = data["original"].asBooleanOrNull ?: true
        val isFlash = data["flash"].asBooleanOrNull ?: false
        val filePath = data["file"].asStringOrNull
        val url = data["url"].asStringOrNull
        var file: File? = null
        if (filePath != null) {
            val md5 = filePath
                .replace(regex = "[{}\\-]".toRegex(), replacement = "")
                .split(".")[0].lowercase()
            file = if (md5.length == 32) {
                FileUtils.getFileByMd5(md5)
            } else {
                FileUtils.parseAndSave(filePath)
            }
        }
        if ((file == null || !file.exists()) && url != null) {
            file = FileUtils.parseAndSave(url)
        }
        if (file?.exists() == false) {
            throw LogicException("Image(${file.name}) file is not exists, please check your filename.")
        }
        requireNotNull(file)

        val md5HexStr = QQNTWrapperUtil.CppProxy.genFileMd5Hex(file.absolutePath)
        val msgService = NTServiceFetcher.kernelService.msgService!!
        val originalPath = msgService.getRichMediaFilePathForMobileQQSend(
            RichMediaFilePathInfo(
                2, 0, md5HexStr, file.name, 1, 0, null, "", true
            )
        )
        if (!QQNTWrapperUtil.CppProxy.fileIsExist(originalPath) || QQNTWrapperUtil.CppProxy.getFileSize(
                originalPath
            ) != file.length()
        ) {
            val thumbPath = msgService.getRichMediaFilePathForMobileQQSend(
                RichMediaFilePathInfo(
                    2, 0, md5HexStr, file.name, 2, 720, null, "", true
                )
            )
            QQNTWrapperUtil.CppProxy.copyFile(file.absolutePath, originalPath)
            QQNTWrapperUtil.CppProxy.copyFile(file.absolutePath, thumbPath)
        }

        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(file.absolutePath, options)
        val exifInterface = ExifInterface(file.absolutePath)
        val orientation = exifInterface.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_UNDEFINED
        )
        val picWidth: Int
        val picHeight: Int
        if (orientation != ExifInterface.ORIENTATION_ROTATE_90 && orientation != ExifInterface.ORIENTATION_ROTATE_270) {
            picWidth = options.outWidth
            picHeight = options.outHeight
        } else {
            picWidth = options.outHeight
            picHeight = options.outWidth
        }

        val elem = when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
                Transfer with Troop(peerId) trans PictureResource(file)
                Elem(
                    customFace = CustomFace(
                        filePath = "${md5HexStr.substring(0, 8)}-${md5HexStr.substring(8, 4)}-${
                            md5HexStr.substring(
                                12,
                                4
                            )
                        }-${md5HexStr.substring(16, 4)}-${md5HexStr.substring(20, 12)}.${FileUtils.getFileType(file)}",
                        fileId = 0u,
                        serverIp = 0u,
                        serverPort = 0u,
                        fileType = 1001u,
                        useful = 1u,
                        md5 = md5HexStr.hex2ByteArray(),
                        bizType = data["subType"].asIntOrNull?.toUInt(),
                        imageType = FileUtils.getPicType(file).toUInt(),
                        width = picWidth.toUInt(),
                        height = picHeight.toUInt(),
                        size = QQNTWrapperUtil.CppProxy.getFileSize(file.absolutePath).toUInt(),
                        origin = if (isOriginal) 1u else 0u,
                        thumbWidth = 0u,
                        thumbHeight = 0u,
                        pbReserve = CustomFace.Companion.PbReserve(field1 = 0)
                    )
                )
            }

            MsgConstant.KCHATTYPEC2C -> {
                Transfer with Private(peerId) trans PictureResource(file)
                Elem(
                    notOnlineImage = NotOnlineImage(
                        filePath = "${md5HexStr}.${FileUtils.getFileType(file)}".toByteArray(),
                        fileLen = QQNTWrapperUtil.CppProxy.getFileSize(file.absolutePath).toUInt(),
                        downloadPath = "".toByteArray(),
                        imgType = FileUtils.getPicType(file).toUInt(),
                        picMd5 = md5HexStr.hex2ByteArray(),
                        picHeight = picWidth.toUInt(),
                        picWidth = picHeight.toUInt(),
                        resId = "".toByteArray(),
                        original = if (isOriginal) 1u else 0u, // true
                        pbReserve = NotOnlineImage.Companion.PbReserve(field1 = 0)
                    )
                )
            }

            else -> throw LogicException("Not supported chatType($chatType) for PictureMsg")
        }
        return Result.success(elem)
    }

    private suspend fun createReplyElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("id")
        val msgHash = data["id"].asInt
        val mapping = MessageHelper.getMsgMappingByHash(msgHash)
            ?: return Result.failure(Exception("不存在该消息映射，无法回复消息"))

        if (mapping.qqMsgId == 0L) {
            // 貌似获取失败了，555
            LogCenter.log("无法获取被回复消息", Level.ERROR)
            return Result.failure(Exception("无法获取被回复消息"))
        }

        val elem = if (data.containsKey("text")) {
            data.checkAndThrow("qq", "time", "seq")
            Elem(
                srcMsg = SourceMsg(
                    origSeqs = listOf(data["seq"].asInt),
                    senderUin = data["qq"].asString.toULong(),
                    time = data["time"].asString.toULong(),
                    flag = 1u,
                    elems = listOf(
                        Elem(
                            text = TextMsg(
                                data["text"].asString
                            )
                        )
                    ),
                    type = 0u,
                    pbReserve = SourceMsg.Companion.PbReserve(
                        field3 = Random.nextULong(),
                        field8 = Random.nextInt(0, 10000)
                    ),
                )
            )
        } else {
            val msg =
                MsgSvc.getMsgByQMsgId(chatType, mapping.peerId, mapping.qqMsgId).getOrNull() ?: return Result.failure(
                    Exception("无法获取被回复消息")
                )
            Elem(
                srcMsg = SourceMsg(
                    origSeqs = listOf(msg.msgSeq.toInt()),
                    senderUin = msg.senderUin.toULong(),
                    time = msg.msgTime.toULong(),
                    flag = 1u,
//                    elems = msg.elements.toSegments(),
                    type = 0u,
                    pbReserve = SourceMsg.Companion.PbReserve(
                        field3 = Random.nextULong(),
                        senderUid = msg.senderUid,
                        receiverUid = TicketSvc.getUid(),
                        field8 = Random.nextInt(0, 10000)
                    ),
                )
            )
        }
        return Result.success(elem)
    }

    private suspend fun createJsonElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("data")

        val elem = Elem(
            lightApp = LightAppElem(
                data = DeflateTools.compress(data.toString().toByteArray())
            )
        )
        return Result.success(elem)
    }

    private suspend fun createPokeElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("type", "id")
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 2,
                elem = PokeExtra(
                    type = data["type"].asInt,
                    field7 = 0,
                    field8 = 0
                ).toByteArray(),
                businessType = data["id"].asInt
            )
        )
        return Result.success(elem)
    }

    private suspend fun createBasketballElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 37,
                elem = QFaceExtra(
                    packId = "1",
                    stickerId = "13",
                    faceId = 114,
                    field4 = 1,
                    field5 = 2,
                    field6 = "",
                    faceText = "/篮球",
                    field9 = 1
                ).toByteArray(),
                businessType = 2
            )
        )
        return Result.success(elem)
    }

    private suspend fun createNewDiceElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 37,
                elem = QFaceExtra(
                    packId = "1",
                    stickerId = "33",
                    faceId = 358,
                    field4 = 1,
                    field5 = 2,
                    field6 = "",
                    faceText = "/骰子",
                    field9 = 1
                ).toByteArray(),
                businessType = 2
            )
        )
        return Result.success(elem)
    }

    private suspend fun createNewRpsElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 37,
                elem = QFaceExtra(
                    packId = "1",
                    stickerId = "34",
                    faceId = 359,
                    field4 = 1,
                    field5 = 2,
                    field6 = "",
                    faceText = "/包剪锤",
                    field9 = 1
                ).toByteArray(),
                businessType = 1
            )
        )
        return Result.success(elem)
    }

    private suspend fun createMarkdownElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("content")
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 45,
                elem = MarkdownExtra(data["content"].asString).toByteArray(),
                businessType = 1
            )
        )
        return Result.success(elem)
    }

    private suspend fun createButtonElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        data.checkAndThrow("rows")
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 46,
                elem = ButtonExtra(
                    field1 = Object1(
                        rows = data["rows"].asJsonArray.map { row ->
                            Row(buttons = row.asJsonArray.map {
                                val button = it.asJsonObject
                                val renderData = button["render_data"].asJsonObject
                                val action = button["action"].asJsonObject
                                Button(
                                    id = button["id"].asIntOrNull,
                                    renderData = RenderData(
                                        label = renderData["label"].asString,
                                        visitedLabel = renderData["visited_label"].asString,
                                        style = renderData["style"].asInt
                                    ),
                                    action = Action(
                                        type = action["type"].asInt,
                                        permission = Permission(
                                            type = action["permission"].asJsonObject["type"].asInt,
                                            specifyRoleIds = action["permission"].asJsonObject["specify_role_ids"].asJsonArrayOrNull?.map { id -> id.asString },
                                            specifyUserIds = action["permission"].asJsonObject["specify_user_ids"].asJsonArrayOrNull?.map { id -> id.asString }
                                        ),
                                        unsupportTips = action["unsupport_tips"].asString,
                                        data = action["data"].asString,
                                        reply = action["reply"].asBooleanOrNull,
                                        enter = action["enter"].asBooleanOrNull
                                    )
                                )
                            })
                        },
                        appid = data["appid"].asIntOrNull
                    )
                ).toByteArray(),
                businessType = 1
            )
        )
        return Result.success(elem)
    }

    private fun JsonObject.checkAndThrow(vararg key: String) {
        key.forEach {
            if (!containsKey(it)) throw ParamsException(it)
        }
    }
}