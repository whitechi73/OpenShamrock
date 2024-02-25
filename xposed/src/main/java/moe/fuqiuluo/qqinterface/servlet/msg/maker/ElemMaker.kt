package moe.fuqiuluo.qqinterface.servlet.msg.maker

import android.graphics.BitmapFactory
import androidx.exifinterface.media.ExifInterface
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.qqinterface.servlet.CardSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.qqinterface.servlet.MsgSvc
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.qqinterface.servlet.ark.WeatherSvc
import moe.fuqiuluo.qqinterface.servlet.msg.toJson
import moe.fuqiuluo.qqinterface.servlet.msg.toSegments
import moe.fuqiuluo.qqinterface.servlet.transfile.NtV2RichMediaSvc
import moe.fuqiuluo.shamrock.helper.*
import moe.fuqiuluo.shamrock.helper.MessageHelper.messageArrayToMessageElements
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.utils.FileUtils
import protobuf.auto.toByteArray
import protobuf.message.Elem
import protobuf.message.element.*
import protobuf.message.element.commelem.*
import java.io.File
import java.nio.ByteBuffer
import kotlin.random.Random
import kotlin.random.nextULong
import kotlin.time.Duration.Companion.seconds

internal typealias IElemMaker = suspend (Int, Long, String, JsonObject) -> Result<Elem>

internal object ElemMaker {
    private val makerArray = hashMapOf(
        "text" to ElemMaker::createTextElem,
        "at" to ElemMaker::createAtElem,
        "face" to ElemMaker::createFaceElem,
        "pic" to ElemMaker::createImageElem,
        "image" to ElemMaker::createImageElem,
//        "voice" to ElemMaker::createRecordElem,
//        "record" to ElemMaker::createRecordElem,
//        "video" to ElemMaker::createVideoElem,
        "markdown" to ElemMaker::createMarkdownElem,
        "button" to ElemMaker::createButtonElem,
        "dice" to ElemMaker::createNewDiceElem,
        "rps" to ElemMaker::createNewRpsElem,
        "poke" to ElemMaker::createPokeElem,
//        "anonymous" to ElemMaker::createAnonymousElem,
//        "share" to ElemMaker::createShareElem,
//        "contact" to ElemMaker::createContactElem,
//        "location" to ElemMaker::createLocationElem,
//        "music" to ElemMaker::createMusicElem,
        "reply" to ElemMaker::createReplyElem,
//        "touch" to ElemMaker::createTouchElem,
        "weather" to ElemMaker::createWeatherElem,
        "json" to ElemMaker::createJsonElem,
        //"forward" to MessageMaker::createForwardElem,
        //"multi_msg" to MessageMaker::createLongMsgStruct,
        //"bubble_face" to ElemMaker::createBubbleFaceElem,
    )

    operator fun get(type: String): IElemMaker? = makerArray[type]

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
                        "@" + (data["name"].asStringOrNull ?: GroupSvc.getTroopMemberInfoByUinV2(
                            peerId.toLong(),
                            qq,
                            true
                        )
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

                val qq = data["qq"].asLong
                val display =
                    "@" + (data["name"].asStringOrNull ?: CardSvc.getProfileCard(qq)
                        .onSuccess {
                            it.strNick.ifNullOrEmpty(qq.toString())
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
        val faceId = data["id"].asInt
        val elem = if (data["big"].asBooleanOrNull == true) {
            Elem(
                commonElem = CommonElem(
                    serviceType = 37,
                    elem = QFaceExtra(
                        packId = "1",
                        stickerId = "1",
                        faceId = faceId,
                        field4 = 1,
                        field5 = 1,
                        result = "",
                        faceText = "",  //todo 表情名字
                        field9 = 1
                    ).toByteArray(),
                    businessType = 1
                )
            )
        } else {
            Elem(
                face = FaceMsg(
                    index = faceId
                )
            )
        }
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

        val uploadRet = NtV2RichMediaSvc.tryUploadResourceByNt(
            chatType = chatType,
            elementType = MsgConstant.KELEMTYPEPIC,
            resources = arrayListOf(file),
            timeout = 30.seconds
        ).getOrThrow().first()
        LogCenter.log(uploadRet.toString(), Level.DEBUG)

        val elem = when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> Elem(
                customFace = CustomFace(
                    filePath = uploadRet.fileName,
                    fileId = uploadRet.uuid.toUInt(),
                    serverIp = 0u,
                    serverPort = 0u,
                    fileType = FileUtils.getPicType(file).toUInt(),
                    useful = 1u,
                    md5 = uploadRet.md5.hex2ByteArray(),
                    bizType = data["subType"].asIntOrNull?.toUInt(),
                    imageType = FileUtils.getPicType(file).toUInt(),
                    width = picWidth.toUInt(),
                    height = picHeight.toUInt(),
                    size = uploadRet.fileSize.toUInt(),
                    origin = isOriginal,
                    thumbWidth = 0u,
                    thumbHeight = 0u,
                    pbReserve = CustomFace.Companion.PbReserve(
                        field1 = 0,
                        field3 = 0,
                        field4 = 0,
                        field10 = 0,
                        field21 = CustomFace.Companion.Object1(
                            field1 = 0,
                            field2 = "",
                            field3 = 0,
                            field4 = 0,
                            field5 = 0,
                            md5Str = uploadRet.md5
                        )
                    )
                )
            )

            MsgConstant.KCHATTYPEC2C -> Elem(
                notOnlineImage = NotOnlineImage(
                    filePath = uploadRet.fileName,
                    fileLen = uploadRet.fileSize.toUInt(),
                    downloadPath = uploadRet.uuid,
                    imgType = FileUtils.getPicType(file).toUInt(),
                    picMd5 = uploadRet.md5.hex2ByteArray(),
                    picHeight = picWidth.toUInt(),
                    picWidth = picHeight.toUInt(),
                    resId = uploadRet.uuid,
                    original = isOriginal, // true
                    pbReserve = NotOnlineImage.Companion.PbReserve(
                        field1 = 0,
                        field3 = 0,
                        field4 = 0,
                        field10 = 0,
                        field20 = NotOnlineImage.Companion.Object1(
                            field1 = 0,
                            field2 = "",
                            field3 = 0,
                            field4 = 0,
                            field5 = 0,
                            field7 = "",
                        ),
                        md5Str = uploadRet.md5
                    )
                )
            )

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
                        msgRand = Random.nextInt().toULong(),
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
                    elems = messageArrayToMessageElements(
                        msg.chatType,
                        msg.msgId,
                        msg.peerUin.toString(),
                        msg.elements.toSegments(
                            msg.chatType,
                            if (msg.chatType == MsgConstant.KCHATTYPEGUILD) msg.guildId else msg.peerUin.toString(),
                            msg.channelId ?: msg.peerUin.toString()
                        ).toJson()
                    ).second,
                    type = 0u,
                    pbReserve = SourceMsg.Companion.PbReserve(
                        msgRand = Random.nextULong(),
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

    private suspend fun createWeatherElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<Elem> {
        var code = data["code"].asIntOrNull

        if (code == null) {
            data.checkAndThrow("city")
            val city = data["city"].asString
            code = WeatherSvc.searchCity(city).onFailure {
                LogCenter.log("无法获取城市天气: $city", Level.ERROR)
            }.getOrNull()?.firstOrNull()?.adcode
        }

        if (code != null) {
            WeatherSvc.fetchWeatherCard(code).onSuccess {
//              OidbSvc.0xdc2_34
//              00 00 00 DF 08 C2 1B 10 22 22 C4 01 0A B7 01 08 A2 E0 F2 2F 10 01 18 00 2A 02 08 01 58 FB 91 F6 AE 02 62 A1 01 08 01 52 08 E5 8C 97 E4 BA AC 20 20 5A 19 2D 33 C2 B0 2F 33 C2 B0 0A E7 A9 BA E6 B0 94 E8 B4 A8 E9 87 8F 3A E8 89 AF 62 11 5B E5 88 86 E4 BA AB 5D 20 E5 8C 97 E4 BA AC 20 20 6A 25 68 74 74 70 73 3A 2F 2F 77 65 61 74 68 65 72 2E 6D 70 2E 71 71 2E 63 6F 6D 2F 3F 73 74 3D 30 26 5F 77 76 3D 31 72 3E 68 74 74 70 73 3A 2F 2F 69 6D 67 63 61 63 68 65 2E 71 71 2E 63 6F 6D 2F 61 63 2F 71 71 77 65 61 74 68 65 72 2F 69 6D 61 67 65 2F 73 68 61 72 65 5F 69 63 6F 6E 2F 66 69 6E 65 2E 70 6E 67 12 08 08 01 10 FB 91 F6 AE 02 32 0D 61 6E 64 72 6F 69 64 20 39 2E 30 2E 38
                return createJsonElem(
                    chatType, msgId, peerId, it["weekStore"]
                        .asJsonObject["share"].asJsonObject
                )
            }.onFailure {
                LogCenter.log("无法发送天气分享", Level.ERROR)
            }
        }

        return Result.failure(ActionMsgException)
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
                    result = "",
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
                    result = "",
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
        data.checkAndThrow("buttons")
        val elem = Elem(
            commonElem = CommonElem(
                serviceType = 46,
                elem = ButtonExtra(
                    field1 = Object1(
                        rows = data["buttons"].asJsonArray.map { row ->
                            Row(buttons = row.asJsonArray.map {
                                val button = it.asJsonObject
                                val renderData = button["render_data"].asJsonObject
                                val action = button["action"].asJsonObject
                                val permission = action["permission"].asJsonObject
                                Button(
                                    id = button["id"].asStringOrNull,
                                    renderData = RenderData(
                                        label = renderData["label"].asString,
                                        visitedLabel = renderData["visited_label"].asString,
                                        style = renderData["style"].asInt
                                    ),
                                    action = Action(
                                        type = action["type"].asInt,
                                        permission = Permission(
                                            type = permission["type"].asInt,
                                            specifyRoleIds = permission["specify_role_ids"].asJsonArrayOrNull?.map { id -> id.asString },
                                            specifyUserIds = permission["specify_user_ids"].asJsonArrayOrNull?.map { id -> id.asString }
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