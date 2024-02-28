package moe.fuqiuluo.qqinterface.servlet.msg.converter

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.ktor.util.*
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.io.core.readUInt
import moe.fuqiuluo.qqinterface.servlet.msg.MessageSegment
import moe.fuqiuluo.qqinterface.servlet.transfile.RichProtoSvc
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.db.ImageDB
import moe.fuqiuluo.shamrock.helper.db.ImageMapping
import moe.fuqiuluo.shamrock.helper.db.MessageDB
import moe.fuqiuluo.shamrock.tools.asJsonArray
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.symbols.decodeProtobuf
import moe.fuqiuluo.shamrock.tools.slice
import protobuf.message.Elem
import protobuf.message.element.commelem.ButtonExtra
import protobuf.message.element.commelem.MarkdownExtra
import protobuf.message.element.commelem.QFaceExtra


internal typealias IElemConverter = suspend (Int, String, String, Elem) -> MessageSegment

internal object ElemConverter {
    private val convertMap = mapOf(
        1 to ElemConverter::convertTextElem,
        2 to ElemConverter::convertFaceElem,
        4 to ElemConverter::convertNotOnlineImageElem,
        8 to ElemConverter::convertCustomFaceElem,
//        MsgConstant.KELEMTYPEPTT to ElemConverter::convertVoiceElem,
//        MsgConstant.KELEMTYPEVIDEO to ElemConverter::convertVideoElem,
//        MsgConstant.KELEMTYPEMARKETFACE to ElemConverter::convertMarketFaceElem,
        37 to ElemConverter::convertGeneralFlagsElem,
        45 to ElemConverter::convertReplyElem,
        51 to ElemConverter::convertStructJsonElem,
        53 to ElemConverter::convertCommonElem,
//        MsgConstant.KELEMTYPEGRAYTIP to ElemConverter::convertGrayTipsElem,
//        MsgConstant.KELEMTYPEFILE to ElemConverter::convertFileElem,
//        //MsgConstant.KELEMTYPEMULTIFORWARD to ElemConverter::convertXmlMultiMsgElem,
//        //MsgConstant.KELEMTYPESTRUCTLONGMSG to ElemConverter::convertXmlLongMsgElem,
//        MsgConstant.KELEMTYPEFACEBUBBLE to ElemConverter::convertBubbleFaceElem,
    )

    operator fun get(type: Int): IElemConverter? = convertMap[type]

    /**
     * 文本 / 艾特 消息转换消息段
     */
    private suspend fun convertTextElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val text = element.text!!
        if (text.attr6Buf != null) {
            val at = ByteReadPacket(text.attr6Buf!!)
            at.discardExact(7)
            val uin = at.readUInt()
            return MessageSegment(
                type = "at",
                data = mapOf(
                    "qq" to uin
                )
            )
        } else {
            return MessageSegment(
                type = "text",
                data = mapOf(
                    "text" to text.str!!
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
        element: Elem
    ): MessageSegment {
        val face = element.face!!
        return MessageSegment(
            type = "face",
            data = mapOf(
                "id" to face.index!!
            )
        )

    }

    /**
     * 图片消息转换消息段
     */
    private suspend fun convertCustomFaceElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val customFace = element.customFace!!

        val md5 = customFace.md5.toHexString()

        ImageDB.getInstance().imageMappingDao().insert(
            ImageMapping(
                fileName = md5.uppercase(),
                md5 = md5.uppercase(),
                chatType = chatType,
                size = customFace.size!!.toLong(),
                sha = "",
                fileId = "",
                storeId = 0,
            )
        )

        val origUrl = customFace.origUrl!!

        return MessageSegment(
            type = "image",
            data = mapOf(
                "file" to md5,
                "url" to when (chatType) {
                    MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                        origUrl,
                        md5
                    )

                    MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(origUrl, md5)
                    MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(origUrl, md5)
                    else -> throw UnsupportedOperationException("Not supported chat type: $chatType")
                },
                "type" to if (customFace.origin == true) "original" else "show"
            )
        )
    }

    private suspend fun convertNotOnlineImageElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val notOnlineImage = element.notOnlineImage!!

        val md5 = notOnlineImage.picMd5.toHexString()

        ImageDB.getInstance().imageMappingDao().insert(
            ImageMapping(
                fileName = md5.uppercase(),
                md5 = md5.uppercase(),
                chatType = chatType,
                size = notOnlineImage.fileLen!!.toLong(),
                sha = "",
                fileId = "",
                storeId = 0,
            )
        )

        val origUrl = notOnlineImage.origUrl!!

        return MessageSegment(
            type = "image",
            data = mapOf(
                "file" to md5,
                "url" to when (chatType) {
                    MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                        origUrl,
                        md5
                    )

                    MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(origUrl, md5)
                    MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(origUrl, md5)
                    else -> throw UnsupportedOperationException("Not supported chat type: $chatType")
                },
                "type" to if (notOnlineImage.original == true) "original" else "show"
            )
        )
    }

    private suspend fun convertGeneralFlagsElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val generalFlags = element.generalFlags!!
        if (generalFlags.longTextFlag == 1u) {
            return MessageSegment(
                type = "general_flags",
                data = mapOf(
                    "res_id" to generalFlags.longTextResid
                )
            )
        }
        throw UnknownError("no segment")
    }

//    /**
//     * 视频消息转换消息段
//     */
//    private suspend fun convertVideoElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val video = element.videoElement
//        val md5 = if (video.fileName.contains("/")) {
//            video.videoMd5.takeIf {
//                !it.isNullOrEmpty()
//            }?.hex2ByteArray() ?: video.fileName.split("/").let {
//                it[it.size - 2].hex2ByteArray()
//            }
//        } else video.fileName.split(".")[0].hex2ByteArray()
//
//        //LogCenter.log({ "receive video msg: $video" }, Level.DEBUG)
//
//        return MessageSegment(
//            type = "video",
//            data = mapOf(
//                "file" to video.fileName,
//                "url" to when (chatType) {
//                    MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
//                    MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", md5, video.fileUuid)
//                    MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
//                    else -> throw UnsupportedOperationException("Not supported chat type: $chatType")
//                }
//            ).also {
//                if ((it["url"] as String).isBlank())
//                    it.remove("url")
//            }
//        )
//    }
//
//    /**
//     * 商城大表情消息转换消息段
//     */
//    private suspend fun convertMarketFaceElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val face = element.marketFaceElement
//        return when (face.emojiId.lowercase()) {
//            "4823d3adb15df08014ce5d6796b76ee1" -> MessageSegment("dice")
//            "83c8a293ae65ca140f348120a77448ee" -> MessageSegment("rps")
//            else -> MessageSegment(
//                type = "mface",
//                data = mapOf(
//                    "id" to face.emojiId
//                )
//            )
//        }
//    }
//
    /**
     * 回复消息转消息段
     */
    private suspend fun convertReplyElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val srcMsg = element.srcMsg!!
        val msgId = srcMsg.pbReserve?.msgRand?.toLong() ?: 0
        val msgHash = if (msgId != 0L) {
            MessageHelper.generateMsgIdHash(chatType, msgId)
        } else {
            val msgSeq = srcMsg.origSeqs?.first()?.toInt() ?: 0
            MessageDB.getInstance().messageMappingDao()
                .queryByMsgSeq(chatType, peerId, msgSeq)?.msgHashId
                ?: kotlin.run {
                    LogCenter.log("消息映射关系未找到: Message($msgSeq)", Level.WARN)
                    MessageHelper.generateMsgIdHash(chatType, msgId)
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
     * JSON消息转消息段
     */
    private suspend fun convertStructJsonElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val data = element.lightApp!!.data!!
        val jsonStr = String(if (data[0].toInt() == 1) DeflateTools.uncompress(data.slice(1)) else data.slice(1))
        val json = jsonStr.asJsonObject
        return when (json["app"].asString) {
            "com.tencent.multimsg" -> {
                val info = json["meta"].asJsonObject["detail"].asJsonObject
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
                val info = json["meta"].asJsonObject["contact"].asJsonObject
                MessageSegment(
                    type = "contact",
                    data = mapOf(
                        "type" to "group",
                        "id" to info["jumpUrl"].asString.split("group_code=")[1]
                    )
                )
            }

            "com.tencent.contact.lua" -> {
                val info = json["meta"].asJsonObject["contact"].asJsonObject
                MessageSegment(
                    type = "contact",
                    data = mapOf(
                        "type" to "private",
                        "id" to info["jumpUrl"].asString.split("uin=")[1]
                    )
                )
            }

            "com.tencent.map" -> {
                val info = json["meta"].asJsonObject["Location.Search"].asJsonObject
                MessageSegment(
                    type = "location",
                    data = mapOf(
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
                    "data" to jsonStr
                )
            )
        }
    }


    private suspend fun convertCommonElem(
        chatType: Int,
        peerId: String,
        subPeer: String,
        element: Elem
    ): MessageSegment {
        val commonElem = element.commonElem!!
        return when (commonElem.serviceType) {

            37 -> {
                val qFaceExtra = commonElem.elem!!.decodeProtobuf<QFaceExtra>()
                when (qFaceExtra.faceId) {
                    358 -> MessageSegment(
                        type = "dice",
                        data = mapOf(
                            "result" to qFaceExtra.result!!
                        )
                    )

                    359 -> MessageSegment(
                        type = "rps",
                        data = mapOf(
                            "result" to qFaceExtra.result!!
                        )
                    )

                    else -> MessageSegment(
                        type = "face",
                        data = mapOf(
                            "id" to qFaceExtra.faceId!!,
                            "big" to true,
                            "result" to qFaceExtra.result!! // (1布 2剪 3锤) (骰子123456)
                        )
                    )
                }
            }

            45 -> {
                val markdownExtra = commonElem.elem!!.decodeProtobuf<MarkdownExtra>()
                MessageSegment(
                    type = "markdown",
                    data = mapOf(
                        "content" to markdownExtra.content!!
                    )
                )
            }

            46 -> {
                val buttonExtra = commonElem.elem!!.decodeProtobuf<ButtonExtra>()
                MessageSegment(
                    type = "button",
                    data = buttonExtra.field1!!.let {
                        mapOf(
                            "rows" to it.rows!!.map { row ->
                                mapOf(
                                    "buttons" to row.buttons!!.map { button ->
                                        val renderData = button.renderData
                                        val action = button.action
                                        val permission = action?.permission
                                        mapOf(
                                            "id" to button.id,
                                            "render_data" to mapOf(
                                                "label" to (renderData?.label ?: ""),
                                                "visited_label" to (renderData?.visitedLabel ?: ""),
                                                "style" to (renderData?.style ?: 0)
                                            ),
                                            "action" to mapOf(
                                                "type" to (action?.type ?: 0),
                                                "permission" to mapOf(
                                                    "type" to (permission?.type ?: 0),
                                                    "specify_role_ids" to permission?.specifyRoleIds,
                                                    "specify_user_ids" to permission?.specifyUserIds
                                                ),
                                                "unsupport_tips" to (action?.unsupportTips ?: ""),
                                                "data" to (action?.data ?: ""),
                                                "reply" to action?.reply,
                                                "enter" to action?.enter,
                                            )
                                        )
                                    })
                            },
                            "appid" to it.appid
                        )
                    }
                )
            }

            else -> MessageSegment(
                type = "common",
                data = mapOf(
                    "data" to commonElem.elem!!.encodeBase64()
                )
            )
        }
    }


//
//    /**
//     * 灰色提示条消息过滤
//     */
//    private suspend fun convertGrayTipsElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val tip = element.grayTipElement
//        when (tip.subElementType) {
//            MsgConstant.GRAYTIPELEMENTSUBTYPEJSON -> {
//                val notify = tip.jsonGrayTipElement
//                when (notify.busiId) {
//                    /* 新人入群 */ 17L, /* 群戳一戳 */1061L,
//                    /* 群撤回 */1014L, /* 群设精消息 */2401L,
//                    /* 群头衔 */2407L -> {
//                }
//
//                    else -> LogCenter.log("不支持的灰条类型(JSON): ${notify.busiId}", Level.WARN)
//                }
//            }
//
//            MsgConstant.GRAYTIPELEMENTSUBTYPEXMLMSG -> {
//                val notify = tip.xmlElement
//                when (notify.busiId) {
//                    /* 群戳一戳 */1061L, /* 群打卡 */1068L -> {}
//                    else -> LogCenter.log("不支持的灰条类型(XML): ${notify.busiId}", Level.WARN)
//                }
//            }
//
//            else -> LogCenter.log("不支持的提示类型: ${tip.subElementType}", Level.WARN)
//        }
//        // 提示类消息，这里提供的是一个xml，不具备解析通用性
//        // 在这里不推送
//        throw UnknownError()
//    }
//
//    /**
//     * 文件消息转换消息段
//     */
//    private suspend fun convertFileElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val fileMsg = element.fileElement
//        val fileName = fileMsg.fileName
//        val fileSize = fileMsg.fileSize
//        val expireTime = fileMsg.expireTime ?: 0
//        val fileId = fileMsg.fileUuid
//        val bizId = fileMsg.fileBizId ?: 0
//        val fileSubId = fileMsg.fileSubId ?: ""
//        val url = when (chatType) {
//            MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CFileDownUrl(fileId, fileSubId)
//            MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildFileDownUrl(peerId, subPeer, fileId, bizId)
//            else -> RichProtoSvc.getGroupFileDownUrl(peerId.toLong(), fileId, bizId)
//        }
//
//        return MessageSegment(
//            type = "file",
//            data = mapOf(
//                "name" to fileName,
//                "size" to fileSize,
//                "expire" to expireTime,
//                "id" to fileId,
//                "url" to url,
//                "biz" to bizId,
//                "sub" to fileSubId
//            )
//        )
//    }
//
//    /**
//     * 老板QQ的合并转发信息
//     */
//    private suspend fun convertXmlMultiMsgElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val multiMsg = element.multiForwardElem
//        return MessageSegment(
//            type = "forward",
//            data = mapOf(
//                "id" to multiMsg.resId
//            )
//        )
//    }
//
//    private suspend fun convertXmlLongMsgElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val longMsg = element.structLongElem
//        return MessageSegment(
//            type = "forward",
//            data = mapOf(
//                "id" to longMsg.resId
//            )
//        )
//    }
//
//
//    private suspend fun convertBubbleFaceElem(
//        chatType: Int,
//        peerId: String,
//        subPeer: String,
//        element: Elem
//    ): MessageSegment {
//        val bubbleElement = element.faceBubbleElement
//        return MessageSegment(
//            type = "bubble_face",
//            data = mapOf(
//                "id" to bubbleElement.yellowFaceInfo.index,
//                "count" to (bubbleElement.faceCount ?: 1),
//            )
//        )
//    }


}