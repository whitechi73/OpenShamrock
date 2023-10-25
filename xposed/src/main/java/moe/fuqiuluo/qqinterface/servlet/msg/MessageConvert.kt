package moe.fuqiuluo.qqinterface.servlet.msg

import moe.fuqiuluo.shamrock.helper.ContactHelper
import moe.fuqiuluo.shamrock.helper.MessageHelper
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.qqinterface.servlet.transfile.RichProtoSvc
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.helper.db.ImageDB
import moe.fuqiuluo.shamrock.helper.db.ImageMapping
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.db.MessageDB

internal typealias MsgSegment = ArrayList<HashMap<String, JsonElement>>

internal suspend fun MsgRecord.toSegment(): MsgSegment {
    return MsgConvert.convertMsgRecordToMsgSegment(this)
}

internal suspend fun MsgRecord.toCQCode(): String {
    return MsgConvert.convertMsgRecordToCQCode(this)
}

internal suspend fun List<MsgElement>.toSegment(chatType: Int, peerId: String): MsgSegment {
    return MsgConvert.convertMsgElementsToMsgSegment(chatType, this, peerId)
}

internal suspend fun List<MsgElement>.toCQCode(chatType: Int, peerId: String): String {
    return MsgConvert.convertMsgElementsToCQCode(this, chatType, peerId)
}

internal object MsgConvert {
    suspend fun convertMsgRecordToCQCode(record: MsgRecord, chatType: Int = record.chatType): String {
        return MessageHelper.encodeCQCode(convertMsgElementsToMsgSegment(
            chatType,
            record.elements,
            record.peerUin.toString()
        ))
    }

    suspend fun convertMsgElementsToCQCode(
        elements: List<MsgElement>,
        chatType: Int,
        peerId: String
    ): String {
        if(elements.isEmpty()) {
            return ""
        }
        return MessageHelper.encodeCQCode(convertMsgElementsToMsgSegment(chatType, elements, peerId))
    }

    suspend fun convertMsgRecordToMsgSegment(record: MsgRecord, chatType: Int = record.chatType): ArrayList<HashMap<String, JsonElement>> {
        return convertMsgElementsToMsgSegment(chatType, record.elements, record.peerUin.toString())
    }

    suspend fun convertMsgElementsToMsgSegment(
        chatType: Int,
        elements: List<MsgElement>,
        peerId: String
    ): ArrayList<HashMap<String, JsonElement>> {
        val messageData = arrayListOf<HashMap<String, JsonElement>>()
        elements.forEach {
            try {
                val segment = covertMsgElementToMsgSegment(chatType, peerId, it)
                if (segment != null) {
                    messageData.add(segment)
                }
            } catch (e: Throwable) {
                LogCenter.log("消息element转换错误：$e", Level.WARN)
            }
        }
        return messageData
    }

    suspend fun covertMsgElementToMsgSegment(chatType: Int, peerId: String, element: MsgElement): HashMap<String, JsonElement>? {
        when (element.elementType) {
            MsgConstant.KELEMTYPETEXT -> {
                val text = element.textElement
                return if (text.atType != MsgConstant.ATTYPEUNKNOWN) {
                    hashMapOf(
                        "type" to "at".json,
                        "data" to JsonObject(mapOf(
                            "qq" to ContactHelper.getUinByUidAsync(text.atNtUid).json,
                        ))
                    )
                } else {
                    hashMapOf(
                        "type" to "text".json,
                        "data" to JsonObject(mapOf(
                            "text" to text.content.json
                        ))
                    )
                }
            }
            MsgConstant.KELEMTYPEFACE -> {
                val face = element.faceElement
                if (face.faceType == 5) {
                    return hashMapOf(
                        "type" to "poke".json,
                        "data" to JsonObject(mapOf(
                            "type" to face.pokeType.json,
                            "id" to face.vaspokeId.json,
                            "strength" to face.pokeStrength.json
                        ))
                    )
                }
                return hashMapOf(
                    "type" to "face".json,
                    "data" to JsonObject(mapOf(
                        "id" to face.faceIndex.json
                    ))
                )
            }
            MsgConstant.KELEMTYPEPIC -> {
                val image = element.picElement
                val md5 = image.md5HexStr ?: image.fileName
                    .replace("{", "")
                    .replace("}", "")
                    .replace("-", "").split(".")[0]

                ImageDB.getInstance().imageMappingDao().insert(
                    ImageMapping(md5.uppercase(), chatType, image.fileSize)
                )

                return hashMapOf(
                    "type" to "image".json,
                    "data" to JsonObject(mapOf(
                        "file" to md5.json,
                        "url" to when(chatType) {
                            MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(md5)
                            MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(md5)
                            else -> error("Not supported chat type: $chatType, convertMsgElementsToMsgSegment::Pic")
                        }.json
                    ))
                )
            }
            MsgConstant.KELEMTYPEPTT -> {
                val record = element.pttElement

                val md5 = if (record.fileName.startsWith("silk"))
                    record.fileName.substring(5)
                else record.md5HexStr

                return hashMapOf(
                    "type" to "record".json,
                    "data" to JsonObject(hashMapOf(
                        "file" to md5.json,
                        "url" to when(chatType) {
                            MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPttDownUrl("0", record.md5HexStr, record.fileUuid)
                            MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPttDownUrl("0", record.fileUuid)
                            else -> error("Not supported chat type: $chatType, convertMsgElementsToMsgSegment::Pic")
                        }.json
                    ).also {
                        if(record.voiceChangeType != MsgConstant.KPTTVOICECHANGETYPENONE) {
                            it["magic"] = "1".json
                        }
                        if (it["url"].asString.isBlank()) {
                            it.remove("url")
                        }
                    })
                )
            }
            MsgConstant.KELEMTYPEVIDEO -> {
                val video = element.videoElement
                return hashMapOf(
                    "type" to "video".json,
                    "data" to JsonObject(hashMapOf(
                        "file" to video.fileName.json,
                        "url" to when(chatType) {
                            MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", video.fileName, video.fileUuid)
                            MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", video.fileName, video.fileUuid)
                            else -> error("Not supported chat type: $chatType, convertMsgElementsToMsgSegment::Pic")
                        }.json
                    ).also {
                        if (it["url"].asString.isBlank()) {
                            it.remove("url")
                        }
                    })
                )
            }
            MsgConstant.KELEMTYPEMARKETFACE -> {
                val face = element.marketFaceElement
                when (face.emojiId.lowercase()) {
                    "4823d3adb15df08014ce5d6796b76ee1" -> return hashMapOf("type" to "dice".json)
                    "83c8a293ae65ca140f348120a77448ee" -> return hashMapOf("type" to "rps".json)
                    else -> LogCenter.log("暂不支持的超表: ${face.emojiId}", Level.WARN)
                }
            }
            MsgConstant.KELEMTYPEARKSTRUCT -> {
                try {
                    val data = element.arkElement.bytesData.asJsonObject
                    val app = data["app"].asString
                    when (app) {
                        "com.tencent.troopsharecard" -> {
                            val info = data["meta"].asJsonObject["contact"].asJsonObject
                            return hashMapOf(
                                "type" to "contact".json,
                                "data" to JsonObject(mapOf(
                                    "type" to "group".json,
                                    "id" to info["jumpUrl"].asString.split("group_code=")[1].json,
                                ))
                            )
                        }
                        "com.tencent.contact.lua" -> {
                            val info = data["meta"].asJsonObject["contact"].asJsonObject
                            return hashMapOf(
                                "type" to "contact".json,
                                "data" to JsonObject(mapOf(
                                    "type" to "private".json,
                                    "id" to info["jumpUrl"].asString.split("uin=")[1].json,
                                ))
                            )
                        }
                        /*"com.tencent.structmsg" -> {
                            val info = data["meta"].asJsonObject["news"].asJsonObject
                            return hashMapOf(
                                "type" to "share".json,
                                "data" to JsonObject(mapOf(
                                    "url" to info["jumpUrl"]!!,
                                    "title" to info["title"]!!,
                                    "content" to info["desc"]!!,
                                    "image" to info["preview"]!!
                                ))
                            )
                        }*/
                        "com.tencent.map" -> {
                            val info = data["meta"].asJsonObject["Location.Search"].asJsonObject
                            return hashMapOf(
                                "type" to "location".json,
                                "data" to JsonObject(mapOf(
                                    "lat" to info["lat"]!!,
                                    "lon" to info["lng"]!!,
                                    "content" to info["address"]!!,
                                    "title" to info["name"]!!
                                ))
                            )
                        }
                        else -> {
                            return hashMapOf(
                                "type" to "json".json,
                                "data" to JsonObject(mapOf(
                                    "data" to element.arkElement.bytesData.json,
                                ))
                            )
                        }
                    }
                } catch (e: Throwable) {
                    LogCenter.log(e.stackTraceToString(), Level.WARN)
                }
            }
            MsgConstant.KELEMTYPEREPLY -> {
                val reply = element.replyElement
                val msgId = reply.replayMsgId
                val msgHash = if (msgId != 0L) {
                    MessageHelper.generateMsgIdHash(chatType, msgId)
                } else {
                    MessageDB.getInstance().messageMappingDao()
                        .queryByMsgSeq(chatType, peerId, reply.replayMsgSeq?.toInt() ?: 0)?.msgHashId
                        ?: MessageHelper.generateMsgIdHash(chatType, reply.sourceMsgIdInRecords)
                }

                return hashMapOf(
                    "type" to "reply".json,
                    "data" to JsonObject(mapOf(
                        "id" to msgHash.json,
                    ))
                )
            }
            MsgConstant.KELEMTYPEGRAYTIP -> {
                val tip = element.grayTipElement
                when(val tipType = tip.subElementType) {
                    MsgConstant.GRAYTIPELEMENTSUBTYPEJSON -> {
                        val notify = tip.jsonGrayTipElement
                        when(notify.busiId) {
                            /* 新人入群 */ 17L,
                            /* 群戳一戳 */1061L, /* 群撤回 */1014L -> {}
                            else -> LogCenter.log("不支持的灰条类型(JSON): $tipType", Level.WARN)
                        }
                        return null
                    }
                    MsgConstant.GRAYTIPELEMENTSUBTYPEXMLMSG -> {
                        val notify = tip.xmlElement
                        when(notify.busiId) {
                            /* 群戳一戳 */12L -> {}
                            else -> LogCenter.log("不支持的灰条类型(XML): $tipType", Level.WARN)
                        }
                        return null
                    }
                    else -> LogCenter.log("不支持的提示类型: $tip", Level.WARN)
                }
            }
            MsgConstant.KELEMTYPEFILE -> {
                // TODO(自发消息 / 其他客户端同步文件消息处理？)
                return null
            }
            else -> LogCenter.log("不支持的Elem转消息段: ${element.elementType}", Level.WARN)
        }
        return null
    }

}