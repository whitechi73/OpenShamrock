package moe.fuqiuluo.qqinterface.servlet.msg.converter

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import moe.fuqiuluo.qqinterface.servlet.msg.MessageSegment
import moe.fuqiuluo.qqinterface.servlet.transfile.RichProtoSvc
import moe.fuqiuluo.shamrock.helper.ContactHelper
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.db.ImageDB
import moe.fuqiuluo.shamrock.helper.db.ImageMapping
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.tools.asJsonArray
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.utils.PlatformUtils.QQ_9_0_8_VER

internal typealias IMsgElementConverter = suspend (Int, String, String, MsgElement) -> MessageSegment

internal object NtMsgElementConverter {
    private val convertMap = hashMapOf(
        MsgConstant.KELEMTYPETEXT to NtMsgElementConverter::convertTextElem,
        MsgConstant.KELEMTYPEFACE to NtMsgElementConverter::convertFaceElem,
        MsgConstant.KELEMTYPEPIC to NtMsgElementConverter::convertImageElem,
        MsgConstant.KELEMTYPEPTT to NtMsgElementConverter::convertVoiceElem,
        MsgConstant.KELEMTYPEVIDEO to NtMsgElementConverter::convertVideoElem,
        MsgConstant.KELEMTYPEMARKETFACE to NtMsgElementConverter::convertMarketFaceElem,
        MsgConstant.KELEMTYPEARKSTRUCT to NtMsgElementConverter::convertStructJsonElem,
        MsgConstant.KELEMTYPEREPLY to NtMsgElementConverter::convertReplyElem,
        MsgConstant.KELEMTYPEGRAYTIP to NtMsgElementConverter::convertGrayTipsElem,
        MsgConstant.KELEMTYPEFILE to NtMsgElementConverter::convertFileElem,
        MsgConstant.KELEMTYPEMARKDOWN to NtMsgElementConverter::convertMarkdownElem,
        //MsgConstant.KELEMTYPEMULTIFORWARD to MsgElementConverter::convertXmlMultiMsgElem,
        //MsgConstant.KELEMTYPESTRUCTLONGMSG to MsgElementConverter::convertXmlLongMsgElem,
        MsgConstant.KELEMTYPEFACEBUBBLE to NtMsgElementConverter::convertBubbleFaceElem,
        MsgConstant.KELEMTYPEINLINEKEYBOARD to NtMsgElementConverter::convertInlineKeyboardElem
    )

    operator fun get(type: Int): IMsgElementConverter? = convertMap[type]

    /**
     * 文本 / 艾特 消息转换消息段
     */
    private suspend fun convertTextElem(
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

    /**
     * 小表情 / 戳一戳 消息转换消息段
     */
    private suspend fun convertFaceElem(
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

    /**
     * 图片消息转换消息段
     */
    private suspend fun convertImageElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: MsgElement
    ): MessageSegment {
        val image = element.picElement
        val md5 = (image.md5HexStr ?: image.fileName
            .replace("{", "")
            .replace("}", "")
            .replace("-", "").split(".")[0])
            .uppercase()

        ImageDB.getInstance().imageMappingDao().insert(
            ImageMapping(md5, chatType, image.fileSize)
        )

        //LogCenter.log(image.toString())

        val originalUrl = image.originImageUrl ?: ""
        LogCenter.log({ "receive image: $image" }, Level.DEBUG)

        var storeId = 0
        if (PlatformUtils.getQQVersionCode() > QQ_9_0_8_VER) {
            storeId = image.storeID
        }

        return MessageSegment(
            type = "image",
            data = hashMapOf(
                "file" to md5,
                "url" to when (chatType) {
                    MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                        originalUrl = originalUrl,
                        md5 = md5,
                        fileId = image.fileUuid,
                        width = image.picWidth.toUInt(),
                        height = image.picHeight.toUInt(),
                        sha = "",
                        fileSize = image.fileSize.toULong(),
                        peer = peerId
                    )

                    MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(
                        originalUrl = originalUrl,
                        md5 = md5,
                        fileId = image.fileUuid,
                        width = image.picWidth.toUInt(),
                        height = image.picHeight.toUInt(),
                        sha = "",
                        fileSize = image.fileSize.toULong(),
                        peer = peerId,
                        storeId = storeId
                    )

                    MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(
                        originalUrl = originalUrl,
                        md5 = md5,
                        fileId = image.fileUuid,
                        width = image.picWidth.toUInt(),
                        height = image.picHeight.toUInt(),
                        sha = "",
                        fileSize = image.fileSize.toULong(),
                        peer = peerId,
                        subPeer = subPeer
                    )

                    else -> throw UnsupportedOperationException("Not supported chat type: $chatType")
                },
                "subType" to image.picSubType,
                "type" to if (image.isFlashPic == true) "flash" else if (image.original) "original" else "show"
            )
        )
    }

    /**
     * 语音消息转换消息段
     */
    private suspend fun convertVoiceElem(
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
                "url" to when (chatType) {
                    MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPttDownUrl("0", record.fileUuid)
                    MsgConstant.KCHATTYPEGROUP, MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupPttDownUrl(
                        "0",
                        md5.hex2ByteArray(),
                        record.fileUuid
                    )

                    else -> throw UnsupportedOperationException("Not supported chat type: $chatType")
                }
            ).also {
                if (record.voiceChangeType != MsgConstant.KPTTVOICECHANGETYPENONE) {
                    it["magic"] = "1"
                }
                if ((it["url"] as String).isBlank()) {
                    it.remove("url")
                }
            }
        )
    }

    /**
     * 视频消息转换消息段
     */
    private suspend fun convertVideoElem(
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
                "url" to when (chatType) {
                    MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                    MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", md5, video.fileUuid)
                    MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                    else -> throw UnsupportedOperationException("Not supported chat type: $chatType")
                }
            ).also {
                if ((it["url"] as String).isBlank())
                    it.remove("url")
            }
        )
    }

    /**
     * 商城大表情消息转换消息段
     */
    private suspend fun convertMarketFaceElem(
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

    /**
     * JSON消息转消息段
     */
    private suspend fun convertStructJsonElem(
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
                        "id" to info["resid"].asString,
                        "filename" to info["uniseq"].asString,
                        "summary" to info["summary"].asString,
                        "desc" to info["news"].asJsonArray.joinToString("\n") { it.asJsonObject["text"].asString }
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

    /**
     * 回复消息转消息段
     */
    private suspend fun convertReplyElem(
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
                ?: kotlin.run {
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

    /**
     * 灰色提示条消息过滤
     */
    private suspend fun convertGrayTipsElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: MsgElement
    ): MessageSegment {
        val tip = element.grayTipElement
        when (tip.subElementType) {
            MsgConstant.GRAYTIPELEMENTSUBTYPEJSON -> {
                val notify = tip.jsonGrayTipElement
                when (notify.busiId) {
                    /* 新人入群 */ 17L, /* 群戳一戳 */1061L,
                    /* 群撤回 */1014L, /* 群设精消息 */2401L,
                    /* 群头衔 */2407L -> {
                }

                    else -> LogCenter.log("不支持的灰条类型(JSON): ${notify.busiId}", Level.WARN)
                }
            }

            MsgConstant.GRAYTIPELEMENTSUBTYPEXMLMSG -> {
                val notify = tip.xmlElement
                when (notify.busiId) {
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

    /**
     * 文件消息转换消息段
     */
    private suspend fun convertFileElem(
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
        val bizId = fileMsg.fileBizId ?: 0
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

    /**
     * 老板QQ的合并转发信息
     */
    private suspend fun convertXmlMultiMsgElem(
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

    private suspend fun convertXmlLongMsgElem(
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

    private suspend fun convertMarkdownElem(
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

    private suspend fun convertBubbleFaceElem(
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

    private suspend fun convertInlineKeyboardElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: MsgElement
    ): MessageSegment {
        val keyboard = element.inlineKeyboardElement
        return MessageSegment(
            type = "button",
            data = mapOf(
                "rows" to keyboard.rows.map { row ->
                    mapOf("buttons" to row.buttons.map { button ->
                        mapOf(
                            "id" to button.id,
                            "render_data" to mapOf(
                                "label" to (button?.label ?: ""),
                                "visited_label" to (button?.visitedLabel ?: ""),
                                "style" to (button?.style ?: 0)

                            ),
                            "action" to mapOf(
                                "type" to (button?.type ?: 0),
                                "permission" to mapOf(
                                    "type" to (button?.permissionType ?: 0),
                                    "specify_role_ids" to button?.specifyRoleIds,
                                    "specify_user_ids" to button?.specifyTinyids
                                ),
                                "unsupport_tips" to (button?.unsupportTips ?: ""),
                                "data" to (button?.data ?: ""),
                                "reply" to button?.isReply,
                                "enter" to button?.enter
                            )
                        )
                    })

                },
                "appid" to keyboard.botAppid
            )
        )
    }
}