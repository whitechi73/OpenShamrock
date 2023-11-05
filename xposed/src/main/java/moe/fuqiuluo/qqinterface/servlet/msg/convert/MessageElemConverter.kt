package moe.fuqiuluo.qqinterface.servlet.msg.convert

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
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
import moe.fuqiuluo.shamrock.tools.json

internal sealed class MessageElemConverter: IMessageConvert {
    /**
     * 文本 / 艾特 消息转换消息段
     */
    object TextConverter: MessageElemConverter() {
        override suspend fun convert(chatType: Int, peerId: String, element: MsgElement): MessageSegment {
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
    object FaceConverter: MessageElemConverter() {
        override suspend fun convert(chatType: Int, peerId: String, element: MsgElement): MessageSegment {
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
            return MessageSegment(
                type = "face",
                data = hashMapOf(
                    "id" to face.faceIndex
                )
            )
        }
    }

    /**
     * 图片消息转换消息段
     */
    object ImageConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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

            return MessageSegment(
                type = "image",
                data = hashMapOf(
                    "file" to md5,
                    "url" to when(chatType) {
                        MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(md5)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(md5)
                        else -> unknownChatType(chatType)
                    }
                )
            )
        }
    }

    /**
     * 语音消息转换消息段
     */
    object VoiceConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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
    object VideoConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            element: MsgElement
        ): MessageSegment {
            val video = element.videoElement
            return MessageSegment(
                type = "video",
                data = hashMapOf(
                    "file" to video.fileName,
                    "url" to when(chatType) {
                        MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", video.fileName, video.fileUuid)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", video.fileName, video.fileUuid)
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
    object MarketFaceConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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
    object StructJsonConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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
    object ReplyConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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
    object GrayTipsConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            element: MsgElement
        ): MessageSegment {
            val tip = element.grayTipElement
            when(val tipType = tip.subElementType) {
                MsgConstant.GRAYTIPELEMENTSUBTYPEJSON -> {
                    val notify = tip.jsonGrayTipElement
                    when(notify.busiId) {
                        /* 新人入群 */ 17L,
                        /* 群戳一戳 */1061L, /* 群撤回 */1014L -> {}
                        else -> LogCenter.log("不支持的灰条类型(JSON): $tipType", Level.WARN)
                    }
                }
                MsgConstant.GRAYTIPELEMENTSUBTYPEXMLMSG -> {
                    val notify = tip.xmlElement
                    when(notify.busiId) {
                        /* 群戳一戳 */12L -> {}
                        else -> LogCenter.log("不支持的灰条类型(XML): $tipType", Level.WARN)
                    }
                }
                else -> LogCenter.log("不支持的提示类型: $tip", Level.WARN)
            }
            // 提示类消息，这里提供的是一个xml，不具备解析通用性
            // 在这里不推送
            throw UnknownError()
        }
    }

    /**
     * 文件消息转换消息段
     */
    object FileConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
            element: MsgElement
        ): MessageSegment {
            // 使用其他地方的推送，而不是使用消息
            throw UnknownError()
        }
    }

    /**
     * 老板QQ的合并转发信息
     */
    object XmlMultiMsgConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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

    object XmlLongMsgConverter: MessageElemConverter() {
        override suspend fun convert(
            chatType: Int,
            peerId: String,
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

    protected fun unknownChatType(chatType: Int) {
        throw UnsupportedOperationException("Not supported chat type: $chatType")
    }
}
