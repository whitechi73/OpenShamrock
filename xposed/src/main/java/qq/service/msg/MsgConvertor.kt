package qq.service.msg

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.msg.api.IMsgService
import io.kritor.event.Element
import io.kritor.event.ImageType
import io.kritor.event.Scene
import io.kritor.event.atElement
import io.kritor.event.basketballElement
import io.kritor.event.buttonAction
import io.kritor.event.buttonActionPermission
import io.kritor.event.buttonRender
import io.kritor.event.contactElement
import io.kritor.event.diceElement
import io.kritor.event.faceElement
import io.kritor.event.forwardElement
import io.kritor.event.imageElement
import io.kritor.event.jsonElement
import io.kritor.event.locationElement
import io.kritor.event.pokeElement
import io.kritor.event.replyElement
import io.kritor.event.rpsElement
import io.kritor.event.textElement
import io.kritor.event.videoElement
import io.kritor.event.voiceElement
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.ActionMsgException
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.db.ImageDB
import moe.fuqiuluo.shamrock.helper.db.ImageMapping
import moe.fuqiuluo.shamrock.tools.asJsonArray
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.utils.PlatformUtils.QQ_9_0_8_VER
import qq.service.bdh.RichProtoSvc
import qq.service.contact.ContactHelper
import kotlin.coroutines.resume

/**
 * 将NT消息（com.tencent.qqnt.*）转换为事件消息（io.kritor.event.*）推送
 */

typealias NtMessages = ArrayList<MsgElement>
typealias Convertor = suspend (MsgRecord, MsgElement) -> Result<Element>

private object MsgConvertor {
    private val convertorMap = hashMapOf(
        MsgConstant.KELEMTYPETEXT to ::convertText,
        MsgConstant.KELEMTYPEFACE to ::convertFace,
        MsgConstant.KELEMTYPEPIC to ::convertImage,
        MsgConstant.KELEMTYPEPTT to ::convertVoice,
        MsgConstant.KELEMTYPEVIDEO to ::convertVideo,
        MsgConstant.KELEMTYPEMARKETFACE to ::convertMarketFace,
        MsgConstant.KELEMTYPEARKSTRUCT to ::convertStructJson,
        MsgConstant.KELEMTYPEREPLY to ::convertReply,
        //MsgConstant.KELEMTYPEGRAYTIP to ::convertGrayTips,
        MsgConstant.KELEMTYPEFILE to ::convertFile,
        MsgConstant.KELEMTYPEMARKDOWN to ::convertMarkdown,
        //MsgConstant.KELEMTYPEMULTIFORWARD to MsgElementConverter::convertXmlMultiMsgElem,
        //MsgConstant.KELEMTYPESTRUCTLONGMSG to MsgElementConverter::convertXmlLongMsgElem,
        MsgConstant.KELEMTYPEFACEBUBBLE to ::convertBubbleFace,
        MsgConstant.KELEMTYPEINLINEKEYBOARD to ::convertInlineKeyboard
    )

    suspend fun convertText(record: MsgRecord, element: MsgElement): Result<Element> {
        val text = element.textElement
        val elem = Element.newBuilder()
        if (text.atType != MsgConstant.ATTYPEUNKNOWN) {
            elem.setAt(atElement {
                this.uid = text.atNtUid
                this.uin = ContactHelper.getUinByUidAsync(text.atNtUid).toLong()
            })
        } else {
            elem.setText(textElement {
                this.text = text.content
            })
        }
        return Result.success(elem.build())
    }

    suspend fun convertFace(record: MsgRecord, element: MsgElement): Result<Element> {
        val face = element.faceElement
        val elem = Element.newBuilder()
        if (face.faceType == 5) {
            elem.setPoke(pokeElement {
                this.id = face.vaspokeId
                this.type = face.pokeType
                this.strength = face.pokeStrength
            })
        } else {
            when(face.faceIndex) {
                114 -> elem.setBasketball(basketballElement {
                    this.id = face.resultId.ifNullOrEmpty { "0" }?.toInt() ?: 0
                })
                358 -> elem.setDice(diceElement {
                    this.id = face.resultId.ifNullOrEmpty { "0" }?.toInt() ?: 0
                })
                359 -> elem.setRps(rpsElement {
                    this.id = face.resultId.ifNullOrEmpty { "0" }?.toInt() ?: 0
                })
                394 -> elem.setFace(faceElement {
                    this.id = face.faceIndex
                    this.isBig = face.faceType == 3
                    this.result = face.resultId.ifNullOrEmpty { "1" }?.toInt() ?: 1
                })
                else -> elem.setFace(faceElement {
                    this.id = face.faceIndex
                    this.isBig = face.faceType == 3
                })
            }
        }
        return Result.success(elem.build())
    }

    suspend fun convertImage(record: MsgRecord, element: MsgElement): Result<Element> {
        val image = element.picElement
        val md5 = (image.md5HexStr ?: image.fileName
            .replace("{", "")
            .replace("}", "")
            .replace("-", "").split(".")[0])
            .uppercase()

        var storeId = 0
        if (PlatformUtils.getQQVersionCode() > QQ_9_0_8_VER) {
            storeId = image.storeID
        }

        ImageDB.getInstance().imageMappingDao().insert(
            ImageMapping(
                fileName = md5,
                md5 = md5,
                chatType = record.chatType,
                size = image.fileSize,
                sha = "",
                fileId = image.fileUuid,
                storeId = storeId,
            )
        )

        val originalUrl = image.originImageUrl ?: ""
        LogCenter.log({ "receive image: $image" }, Level.DEBUG)

        val elem = Element.newBuilder()
        elem.setImage(imageElement {
            this.file = md5
            this.url = when (record.chatType) {
                MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                    originalUrl = originalUrl,
                    md5 = md5,
                    fileId = image.fileUuid,
                    width = image.picWidth.toUInt(),
                    height = image.picHeight.toUInt(),
                    sha = "",
                    fileSize = image.fileSize.toULong(),
                    peer = record.peerUin.toString()
                )

                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(
                    originalUrl = originalUrl,
                    md5 = md5,
                    fileId = image.fileUuid,
                    width = image.picWidth.toUInt(),
                    height = image.picHeight.toUInt(),
                    sha = "",
                    fileSize = image.fileSize.toULong(),
                    peer = record.senderUin.toString(),
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
                    peer = record.channelId.ifNullOrEmpty { record.peerUin.toString() } ?: "0",
                    subPeer = record.guildId ?: "0"
                )

                else -> throw UnsupportedOperationException("Not supported chat type: ${record.chatType}")
            }
            this.type = if (image.isFlashPic == true) ImageType.FLASH else if (image.original) ImageType.ORIGIN else ImageType.COMMON
            this.subType = image.picSubType
        })

        return Result.success(elem.build())
    }

    suspend fun convertVoice(record: MsgRecord, element: MsgElement): Result<Element> {
        val ptt = element.pttElement
        val elem = Element.newBuilder()

        val md5 = if (ptt.fileName.startsWith("silk"))
            ptt.fileName.substring(5)
        else ptt.md5HexStr

        elem.setVoice(voiceElement {
            this.url = when (record.chatType) {
                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPttDownUrl("0", ptt.fileUuid)
                MsgConstant.KCHATTYPEGROUP, MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupPttDownUrl("0", md5.hex2ByteArray(), ptt.fileUuid)

                else -> throw UnsupportedOperationException("Not supported chat type: ${record.chatType}")
            }
            this.file = md5
            this.magic = ptt.voiceChangeType != MsgConstant.KPTTVOICECHANGETYPENONE
        })

        return Result.success(elem.build())
    }

    suspend fun convertVideo(record: MsgRecord, element: MsgElement): Result<Element> {
        val video = element.videoElement
        val elem = Element.newBuilder()
        val md5 = if (video.fileName.contains("/")) {
            video.videoMd5.takeIf {
                !it.isNullOrEmpty()
            }?.hex2ByteArray() ?: video.fileName.split("/").let {
                it[it.size - 2].hex2ByteArray()
            }
        } else video.fileName.split(".")[0].hex2ByteArray()
        elem.setVideo(videoElement {
            this.file = md5.toHexString()
            this.url = when (record.chatType) {
                MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", md5, video.fileUuid)
                MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                else -> throw UnsupportedOperationException("Not supported chat type: ${record.chatType}")
            }
        })
        return Result.success(elem.build())
    }

    suspend fun convertMarketFace(record: MsgRecord, element: MsgElement): Result<Element> {
        val marketFace = element.marketFaceElement
        val elem = Element.newBuilder()
        elem.setMarketFace(io.kritor.event.marketFaceElement {
            this.id = marketFace.emojiId.lowercase()
        })
        return Result.success(elem.build())
    }

    suspend fun convertStructJson(record: MsgRecord, element: MsgElement): Result<Element> {
        val data = element.arkElement.bytesData.asJsonObject
        val elem = Element.newBuilder()
        when (data["app"].asString) {
            "com.tencent.multimsg" -> {
                val info = data["meta"].asJsonObject["detail"].asJsonObject
                elem.setForward(forwardElement {
                    this.id = info["resid"].asString
                    this.uniseq = info["uniseq"].asString
                    this.summary = info["summary"].asString
                    this.description = info["news"].asJsonArray.joinToString("\n") {
                        it.asJsonObject["text"].asString
                    }
                })
            }

            "com.tencent.troopsharecard" -> {
                val info = data["meta"].asJsonObject["contact"].asJsonObject
                elem.setContact(contactElement {
                    this.scene = Scene.GROUP
                    this.peer = info["jumpUrl"].asString.split("group_code=")[1]
                })
            }

            "com.tencent.contact.lua" -> {
                val info = data["meta"].asJsonObject["contact"].asJsonObject
                elem.setContact(contactElement {
                    this.scene = Scene.FRIEND
                    this.peer = info["jumpUrl"].asString.split("uin=")[1]
                })
            }

            "com.tencent.map" -> {
                val info = data["meta"].asJsonObject["Location.Search"].asJsonObject
                elem.setLocation(locationElement {
                    this.lat = info["lat"].asString.toFloat()
                    this.lon = info["lng"].asString.toFloat()
                    this.address = info["address"].asString
                    this.title = info["name"].asString
                })
            }

            else -> elem.setJson(jsonElement {
                this.json = data.toString()
            })
        }
        return Result.success(elem.build())
    }

    suspend fun convertReply(record: MsgRecord, element: MsgElement): Result<Element> {
        val reply = element.replyElement
        val elem = Element.newBuilder()
        elem.setReply(replyElement {
            val msgSeq = reply.replayMsgSeq
            val contact = MessageHelper.generateContact(record)
            val sourceRecords = withTimeoutOrNull(3000) {
                suspendCancellableCoroutine {
                    QRoute.api(IMsgService::class.java).getMsgsBySeqAndCount(contact, msgSeq, 1, true) { _, _, records ->
                        it.resume(records)
                    }
                }
            }
            if (sourceRecords.isNullOrEmpty()) {
                LogCenter.log("无法查询到回复的消息ID: seq = $msgSeq", Level.WARN)
                this.messageId = reply.replayMsgId
            } else {
                this.messageId = sourceRecords.first().msgId
            }
        })
        return Result.success(elem.build())
    }

    suspend fun convertFile(record: MsgRecord, element: MsgElement): Result<Element> {
        val fileMsg = element.fileElement
        val fileName = fileMsg.fileName
        val fileSize = fileMsg.fileSize
        val expireTime = fileMsg.expireTime ?: 0
        val fileId = fileMsg.fileUuid
        val bizId = fileMsg.fileBizId ?: 0
        val fileSubId = fileMsg.fileSubId ?: ""
        val url = when (record.chatType) {
            MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CFileDownUrl(fileId, fileSubId)
            MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildFileDownUrl(record.guildId, record.channelId, fileId, bizId)
            else -> RichProtoSvc.getGroupFileDownUrl(record.peerUin, fileId, bizId)
        }
        val elem = Element.newBuilder()
        elem.setFile(io.kritor.event.fileElement {
            this.name = fileName
            this.size = fileSize
            this.url = url
            this.expireTime = expireTime
            this.id = fileId
            this.subId = fileSubId
            this.biz = bizId
        })
        return Result.success(elem.build())
    }

    suspend fun convertMarkdown(record: MsgRecord, element: MsgElement): Result<Element> {
        val markdown = element.markdownElement
        val elem = Element.newBuilder()
        elem.setMarkdown(io.kritor.event.markdownElement {
            this.markdown = markdown.content
        })
        return Result.success(elem.build())
    }

    suspend fun convertBubbleFace(record: MsgRecord, element: MsgElement): Result<Element> {
        val bubbleFace = element.faceBubbleElement
        val elem = Element.newBuilder()
        elem.setBubbleFace(io.kritor.event.bubbleFaceElement {
            this.id = bubbleFace.yellowFaceInfo.index
            this.count = bubbleFace.faceCount ?: 1
        })
        return Result.success(elem.build())
    }

    suspend fun convertInlineKeyboard(record: MsgRecord, element: MsgElement): Result<Element> {
        val inlineKeyboard = element.inlineKeyboardElement
        val elem = Element.newBuilder()
        elem.setButton(io.kritor.event.buttonElement {
            inlineKeyboard.rows.forEach { row ->
                this.rows.add(io.kritor.event.row {
                    row.buttons.forEach buttonsLoop@ { button ->
                        if (button == null) return@buttonsLoop
                        this.buttons.add(io.kritor.event.button {
                            this.id = button.id
                            this.action = buttonAction {
                                this.type = button.type
                                this.permission = buttonActionPermission {
                                    this.type = button.permissionType
                                    button.specifyRoleIds?.let {
                                        this.roleIds.addAll(it)
                                    }
                                    button.specifyTinyids?.let {
                                        this.userIds.addAll(it)
                                    }
                                }
                                this.unsupportedTips = button.unsupportTips ?: ""
                                this.data = button.data ?: ""
                                this.reply = button.isReply
                                this.enter = button.enter
                            }
                            this.renderData = buttonRender {
                                this.label = button.label ?: ""
                                this.visitedLabel = button.visitedLabel ?: ""
                                this.style = button.style
                            }
                        })
                    }
                })
            }
        })
        return Result.success(elem.build())
    }

    operator fun get(case: Int): Convertor? {
        return convertorMap[case]
    }
}

suspend fun NtMessages.toKritorEventMessages(record: MsgRecord): ArrayList<Element> {
    val result = arrayListOf<Element>()
    forEach {
        MsgConvertor[it.elementType]?.invoke(record, it)?.onSuccess {
            result.add(it)
        }?.onFailure {
            if (it !is ActionMsgException) {
                LogCenter.log("消息转换异常: " + it.stackTraceToString(), Level.WARN)
            }
        }
    }
    return result
}
