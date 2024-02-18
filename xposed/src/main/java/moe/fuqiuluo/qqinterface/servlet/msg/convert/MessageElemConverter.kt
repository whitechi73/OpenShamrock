package moe.fuqiuluo.qqinterface.servlet.msg.convert

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonArray
import moe.fuqiuluo.qqinterface.servlet.transfile.RichProtoSvc
import moe.fuqiuluo.shamrock.helper.ContactHelper
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.db.ImageDB
import moe.fuqiuluo.shamrock.helper.db.ImageMapping
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.json

internal sealed class MessageElemConverter: IMessageConvert {
    /**
     * 文本 / 艾特 消息转换消息段
     */
    data object TextConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val text = element.textElement
            return if (text.atType != MsgConstant.ATTYPEUNKNOWN) {
                MessageSegment(
                    type = "at",
                    data = hashMapOf(
                        "qq" to ContactHelper.getUinByUidAsync(text.atNtUid),
                    )
                )
            } else {
                MessageSegment(
                    type = "text",
                    data = hashMapOf(
                        "text" to text.content
                    )
                )
            }
        }
    }

    /**
     * 小表情 / 戳一戳 消息转换消息段
     */
    data object FaceConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val face = element.faceElement

            if (face.faceType == 5) {
                return MessageSegment(
                    type = "poke",
                    data = hashMapOf(
                        "type" to face.pokeType,
                        "id" to face.vaspokeId,
                        "strength" to face.pokeStrength
                    )
                )
            }
            when (face.faceIndex) {
                114 -> {
                    return MessageSegment(
                        type = "basketball",
                        data = hashMapOf(
                            "id" to face.resultId.ifEmpty { "0" }.toInt(),
                        )
                    )
                }
                358 -> {
                    if (face.sourceType == 1) return MessageSegment("new_dice")
                    return MessageSegment(
                        type = "new_dice",
                        data = hashMapOf(
                            "id" to face.resultId.ifEmpty { "0" }.toInt()
                        )
                    )
                }
                359 -> {
                    if (face.resultId.isEmpty()) return MessageSegment("new_rps")
                    return MessageSegment(
                        type = "new_rps",
                        data = hashMapOf(
                            "id" to face.resultId.ifEmpty { "0" }.toInt()
                        )
                    )
                }
                394 -> {
                    //LogCenter.log(face.toString())
                    return MessageSegment(
                        type = "face",
                        data = hashMapOf(
                            "id" to face.faceIndex,
                            "big" to (face.faceType == 3),
                            "result" to (face.resultId ?: "1")
                        )
                    )
                }
                else -> return MessageSegment(
                    type = "face",
                    data = hashMapOf(
                        "id" to face.faceIndex,
                        "big" to (face.faceType == 3)
                    )
                )
            }
        }
    }

    /**
     * 图片消息转换消息段
     */
    data object ImageConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val image = element.picElement
            val md5 = image.md5HexStr ?: image.fileName
                .replace("{", "")
                .replace("}", "")
                .replace("-", "").split(".")[0]

            ImageDB.getInstance().imageMappingDao().insert(
                ImageMapping(md5.uppercase(), chatType, image.fileSize)
            )

            //LogCenter.log(image.toString())

            val originalUrl = image.originImageUrl ?: ""
            //LogCenter.log({ "receive image: $image" }, Level.DEBUG)

            return MessageSegment(
                type = "image",
                data = hashMapOf(
                    "file" to md5,
                    "url" to when(chatType) {
                        MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(originalUrl, md5)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(originalUrl, md5)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(originalUrl, md5)
                        else -> unknownChatType(chatType)
                    },
                    "subType" to image.picSubType,
                    "type" to if (image.isFlashPic == true) "flash" else if(image.original) "original" else "show"
                )
            )
        }
    }

    /**
     * 语音消息转换消息段
     */
    data object VoiceConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val record = element.pttElement

            val md5 = if (record.fileName.startsWith("silk"))
                record.fileName.substring(5)
            else record.md5HexStr

            return MessageSegment(
                type = "record",
                data = hashMapOf(
                    "file" to md5,
                    "url" to when(chatType) {
                        MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPttDownUrl("0", record.md5HexStr, record.fileUuid)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPttDownUrl("0", record.fileUuid)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupPttDownUrl("0", record.md5HexStr, record.fileUuid)
                        else -> unknownChatType(chatType)
                    }
                ).also {
                    if(record.voiceChangeType != MsgConstant.KPTTVOICECHANGETYPENONE) {
                        it["magic"] = "1".json
                    }
                    if ((it["url"] as String).isBlank()) {
                        it.remove("url")
                    }
                }
            )
        }
    }

    /**
     * 视频消息转换消息段
     */
    data object VideoConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val video = element.videoElement
            val md5 = if (video.fileName.contains("/")) {
                video.videoMd5.takeIf {
                    !it.isNullOrEmpty()
                }?.hex2ByteArray() ?: video.fileName.split("/").let {
                    it[it.size - 2].hex2ByteArray()
                }
            } else video.fileName.split(".")[0].hex2ByteArray()

            //LogCenter.log({ "receive video msg: $video" }, Level.DEBUG)

            return MessageSegment(
                type = "video",
                data = hashMapOf(
                    "file" to video.fileName,
                    "url" to when(chatType) {
                        MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", md5, video.fileUuid)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                        else -> unknownChatType(chatType)
                    }
                ).also {
                    if ((it["url"] as String).isBlank())
                        it.remove("url")
                }
            )
        }
    }

    /**
     * 商城大表情消息转换消息段
     */
    data object MarketFaceConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val face = element.marketFaceElement
            return when (face.emojiId.lowercase()) {
                "4823d3adb15df08014ce5d6796b76ee1" -> MessageSegment("dice")
                "83c8a293ae65ca140f348120a77448ee" -> MessageSegment("rps")
                else -> MessageSegment(
                    type = "mface",
                    data = hashMapOf(
                        "id" to face.emojiId
                    )
                )
            }
        }
    }

    /**
     * JSON消息转消息段
     */
    data object StructJsonConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val data = element.arkElement.bytesData.asJsonObject
            return when (data["app"].asString) {
                "com.tencent.multimsg" -> {
                    val info = data["meta"].asJsonObject["detail"].asJsonObject
                    MessageSegment(
                        type = "forward",
                        data = mapOf(
                            "id" to info["resid"].asString
                        )
                    )
                }
                "com.tencent.troopsharecard" -> {
                    val info = data["meta"].asJsonObject["contact"].asJsonObject
                    MessageSegment(
                        type = "contact",
                        data = hashMapOf(
                            "type" to "group",
                            "id" to info["jumpUrl"].asString.split("group_code=")[1]
                        )
                    )
                }
                "com.tencent.contact.lua" -> {
                    val info = data["meta"].asJsonObject["contact"].asJsonObject
                    MessageSegment(
                        type = "contact",
                        data = hashMapOf(
                            "type" to "private",
                            "id" to info["jumpUrl"].asString.split("uin=")[1]
                        )
                    )
                }
                "com.tencent.map" -> {
                    val info = data["meta"].asJsonObject["Location.Search"].asJsonObject
                    MessageSegment(
                        type = "location",
                        data = hashMapOf(
                            "lat" to info["lat"].asString,
                            "lon" to info["lng"].asString,
                            "content" to info["address"].asString,
                            "title" to info["name"].asString
                        )
                    )
                }
                else -> MessageSegment(
                    type = "json",
                    data = mapOf(
                        "data" to element.arkElement.bytesData.asJsonObject.toString()
                    )
                )
            }
        }
    }

    /**
     * 回复消息转消息段
     */
    data object ReplyConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val reply = element.replyElement
            val msgId = reply.replayMsgId
            val msgHash = if (msgId != 0L) {
                MessageHelper.generateMsgIdHash(chatType, msgId)
            } else {
                MessageDB.getInstance().messageMappingDao()
                    .queryByMsgSeq(chatType, peerId, reply.replayMsgSeq?.toInt() ?: 0)?.msgHashId
                    ?:
                    kotlin.run {
                        LogCenter.log("消息映射关系未找到: Message($reply)", Level.WARN)
                        MessageHelper.generateMsgIdHash(chatType, reply.sourceMsgIdInRecords)
                    }
            }

            return MessageSegment(
                type = "reply",
                data = mapOf(
                    "id" to msgHash
                )
            )
        }
    }

    /**
     * 灰色提示条消息过滤
     */
    data object GrayTipsConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val tip = element.grayTipElement
            when(tip.subElementType) {
                MsgConstant.GRAYTIPELEMENTSUBTYPEJSON -> {
                    val notify = tip.jsonGrayTipElement
                    when(notify.busiId) {
                        /* 新人入群 */ 17L, /* 群戳一戳 */1061L,
                        /* 群撤回 */1014L, /* 群设精消息 */2401L,
                        /* 群头衔 */2407L -> {}
                        else -> LogCenter.log("不支持的灰条类型(JSON): ${notify.busiId}", Level.WARN)
                    }
                }
                MsgConstant.GRAYTIPELEMENTSUBTYPEXMLMSG -> {
                    val notify = tip.xmlElement
                    when(notify.busiId) {
                        /* 群戳一戳 */1061L, /* 群打卡 */1068L -> {}
                        else -> LogCenter.log("不支持的灰条类型(XML): ${notify.busiId}", Level.WARN)
                    }
                }
                else -> LogCenter.log("不支持的提示类型: ${tip.subElementType}", Level.WARN)
            }
            // 提示类消息，这里提供的是一个xml，不具备解析通用性
            // 在这里不推送
            throw UnknownError()
        }
    }

    /**
     * 文件消息转换消息段
     */
    data object FileConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val fileMsg = element.fileElement
            val fileName = fileMsg.fileName
            val fileSize = fileMsg.fileSize
            val expireTime = fileMsg.expireTime ?: 0
            val fileId = fileMsg.fileUuid
            val bizId = fileMsg.fileBizId  ?: 0
            val fileSubId = fileMsg.fileSubId ?: ""
            val url = when (chatType) {
                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CFileDownUrl(fileId, fileSubId)
                MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildFileDownUrl(peerId, subPeer, fileId, bizId)
                else -> RichProtoSvc.getGroupFileDownUrl(peerId.toLong(), fileId, bizId)
            }

            return MessageSegment(
                type = "file",
                data = mapOf(
                    "name" to fileName,
                    "size" to fileSize,
                    "expire" to expireTime,
                    "id" to fileId,
                    "url" to url,
                    "biz" to bizId,
                    "sub" to fileSubId
                )
            )
        }
    }

    /**
     * 老板QQ的合并转发信息
     */
    data object XmlMultiMsgConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val multiMsg = element.multiForwardMsgElement
            return MessageSegment(
                type = "forward",
                data = mapOf(
                    "id" to multiMsg.resId
                )
            )
        }
    }

    data object XmlLongMsgConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val longMsg = element.structLongMsgElement
            return MessageSegment(
                type = "forward",
                data = mapOf(
                    "id" to longMsg.resId
                )
            )
        }
    }

    data object MarkdownConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val markdown = element.markdownElement
            return MessageSegment(
                type = "markdown",
                data = mapOf(
                    "content" to markdown.content
                )
            )
        }
    }

    data object BubbleFaceConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val bubbleElement = element.faceBubbleElement
            return MessageSegment(
                type = "bubble_face",
                data = mapOf(
                    "id" to bubbleElement.yellowFaceInfo.index,
                    "count" to (bubbleElement.faceCount ?: 1),
                )
            )
        }
    }

    data object InlineKeyboardConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            subPeer: String,
            element: MsgElement
        ): MessageSegment {
            val keyboard = element.inlineKeyboardElement
            return MessageSegment(
                type = "inline_keyboard",
                data = mapOf(
                    "data" to buildJsonObject {
                        putJsonArray("rows") {
                            keyboard.rows.forEach {  row ->
                                add(buildJsonObject row@{
                                    putJsonArray("buttons") {
                                        row.buttons.forEach { button ->
                                            add(buildJsonObject {
                                                put("id", button.id ?: "")
                                                put("label", button.label ?: "")
                                                put("visited_label", button.visitedLabel ?: "")
                                                put("style", button.style)
                                                put("type", button.type)
                                                put("click_limit", button.clickLimit)
                                                put("unsupport_tips", button.unsupportTips ?: "")
                                                put("data", button.data)
                                                put("at_bot_show_channel_list", button.atBotShowChannelList)
                                                put("permission_type", button.permissionType)
                                                putJsonArray("specify_role_ids") {
                                                    button.specifyRoleIds?.forEach { add(it) }
                                                }
                                                putJsonArray("specify_tinyids") {
                                                    button.specifyTinyids?.forEach { add(it) }
                                                }
                                            })
                                        }
                                    }
                                })
                            }
                        }
                        put("bot_appid", keyboard.botAppid)
                    }.toString()
                )
            )
        }
    }

    protected fun unknownChatType(chatType: Int) {
        throw UnsupportedOperationException("Not supported chat type: $chatType")
    }
}
