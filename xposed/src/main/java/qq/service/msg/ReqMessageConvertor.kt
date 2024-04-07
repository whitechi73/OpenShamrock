package qq.service.msg

import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.msg.api.IMsgService
import io.kritor.common.*
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
import qq.service.contact.longPeer
import kotlin.coroutines.resume

/**
 * 将NT消息（com.tencent.qqnt.*）转换为请求消息（io.kritor.message.*）推送
 */

private typealias ReqConvertor = suspend (Contact, MsgElement) -> Result<Element>

private object ReqMsgConvertor {
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

    suspend fun convertText(contact: Contact, element: MsgElement): Result<Element> {
        val text = element.textElement
        val elem = Element.newBuilder()
        if (text.atType != MsgConstant.ATTYPEUNKNOWN) {
            elem.setAt(AtElement.newBuilder().apply {
                this.uid = text.atNtUid
                this.uin = ContactHelper.getUinByUidAsync(text.atNtUid).toLong()
            })
        } else {
            elem.setText(TextElement.newBuilder().apply {
                this.text = text.content
            })
        }
        return Result.success(elem.build())
    }

    suspend fun convertFace(contact: Contact, element: MsgElement): Result<Element> {
        val face = element.faceElement
        val elem = Element.newBuilder()
        if (face.faceType == 5) {
            elem.setPoke(PokeElement.newBuilder().apply {
                this.id = face.vaspokeId
                this.type = face.pokeType
                this.strength = face.pokeStrength
            })
        } else {
            when (face.faceIndex) {
                114 -> elem.setBasketball(BasketballElement.newBuilder().apply {
                    this.id = face.resultId.ifNullOrEmpty { "0" }?.toInt() ?: 0
                })

                358 -> elem.setDice(DiceElement.newBuilder().apply {
                    this.id = face.resultId.ifNullOrEmpty { "0" }?.toInt() ?: 0
                })

                359 -> elem.setRps(RpsElement.newBuilder().apply {
                    this.id = face.resultId.ifNullOrEmpty { "0" }?.toInt() ?: 0
                })

                394 -> elem.setFace(FaceElement.newBuilder().apply {
                    this.id = face.faceIndex
                    this.isBig = face.faceType == 3
                    this.result = face.resultId.ifNullOrEmpty { "1" }?.toInt() ?: 1
                })

                else -> elem.setFace(FaceElement.newBuilder().apply {
                    this.id = face.faceIndex
                    this.isBig = face.faceType == 3
                })
            }
        }
        return Result.success(elem.build())
    }

    suspend fun convertImage(contact: Contact, element: MsgElement): Result<Element> {
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
                chatType = contact.chatType,
                size = image.fileSize,
                sha = "",
                fileId = image.fileUuid,
                storeId = storeId,
            )
        )

        val originalUrl = image.originImageUrl ?: ""
        LogCenter.log({ "receive image: $image" }, Level.DEBUG)

        val elem = Element.newBuilder()
        elem.setImage(ImageElement.newBuilder().apply {
            this.fileMd5 = md5
            this.fileUrl = when (contact.chatType) {
                MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                    originalUrl = originalUrl,
                    md5 = md5,
                    fileId = image.fileUuid,
                    width = image.picWidth.toUInt(),
                    height = image.picHeight.toUInt(),
                    sha = "",
                    fileSize = image.fileSize.toULong(),
                    peer = contact.longPeer().toString()
                )

                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(
                    originalUrl = originalUrl,
                    md5 = md5,
                    fileId = image.fileUuid,
                    width = image.picWidth.toUInt(),
                    height = image.picHeight.toUInt(),
                    sha = "",
                    fileSize = image.fileSize.toULong(),
                    peer = contact.longPeer().toString(),
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
                    peer = contact.longPeer().toString(),
                    subPeer = "0"
                )

                else -> throw UnsupportedOperationException("Not supported chat type: ${contact.chatType}")
            }
            this.type =
                if (image.isFlashPic == true) ImageElement.ImageType.FLASH else if (image.original) ImageElement.ImageType.ORIGIN else ImageElement.ImageType.COMMON
            this.subType = image.picSubType
        })

        return Result.success(elem.build())
    }

    suspend fun convertVoice(contact: Contact, element: MsgElement): Result<Element> {
        val ptt = element.pttElement
        val elem = Element.newBuilder()

        val md5 = if (ptt.fileName.startsWith("silk"))
            ptt.fileName.substring(5)
        else ptt.md5HexStr

        elem.setVoice(VoiceElement.newBuilder().apply {
            this.fileUrl = when (contact.chatType) {
                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPttDownUrl("0", ptt.fileUuid)
                MsgConstant.KCHATTYPEGROUP, MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupPttDownUrl(
                    "0",
                    md5.hex2ByteArray(),
                    ptt.fileUuid
                )

                else -> throw UnsupportedOperationException("Not supported chat type: ${contact.chatType}")
            }
            this.fileMd5 = md5
            this.magic = ptt.voiceChangeType != MsgConstant.KPTTVOICECHANGETYPENONE
        })

        return Result.success(elem.build())
    }

    suspend fun convertVideo(contact: Contact, element: MsgElement): Result<Element> {
        val video = element.videoElement
        val elem = Element.newBuilder()
        val md5 = if (video.fileName.contains("/")) {
            video.videoMd5.takeIf {
                !it.isNullOrEmpty()
            }?.hex2ByteArray() ?: video.fileName.split("/").let {
                it[it.size - 2].hex2ByteArray()
            }
        } else video.fileName.split(".")[0].hex2ByteArray()
        elem.setVideo(VideoElement.newBuilder().apply {
            this.fileMd5 = md5.toHexString()
            this.fileUrl = when (contact.chatType) {
                MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CVideoDownUrl("0", md5, video.fileUuid)
                MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGroupVideoDownUrl("0", md5, video.fileUuid)
                else -> throw UnsupportedOperationException("Not supported chat type: ${contact.chatType}")
            }
        })
        return Result.success(elem.build())
    }

    suspend fun convertMarketFace(contact: Contact, element: MsgElement): Result<Element> {
        val marketFace = element.marketFaceElement
        val elem = Element.newBuilder()
        elem.setMarketFace(MarketFaceElement.newBuilder().apply {
            this.id = marketFace.emojiId
        })
        // TODO
        return Result.success(elem.build())
    }

    suspend fun convertStructJson(contact: Contact, element: MsgElement): Result<Element> {
        val data = element.arkElement.bytesData.asJsonObject
        val elem = Element.newBuilder()
        when (data["app"].asString) {
            "com.tencent.multimsg" -> {
                val info = data["meta"].asJsonObject["detail"].asJsonObject
                elem.setForward(ForwardElement.newBuilder().apply {
                    this.resId = info["resid"].asString
                    this.uniseq = info["uniseq"].asString
                    this.summary = info["summary"].asString
                    this.description = info["news"].asJsonArray.joinToString("\n") {
                        it.asJsonObject["text"].asString
                    }
                })
            }

            "com.tencent.troopsharecard" -> {
                val info = data["meta"].asJsonObject["contact"].asJsonObject
                elem.setContact(ContactElement.newBuilder().apply {
                    this.scene = Scene.GROUP
                    this.peer = info["jumpUrl"].asString.split("group_code=")[1]
                })
            }

            "com.tencent.contact.lua" -> {
                val info = data["meta"].asJsonObject["contact"].asJsonObject
                elem.setContact(ContactElement.newBuilder().apply {
                    this.scene = Scene.FRIEND
                    this.peer = info["jumpUrl"].asString.split("uin=")[1]
                })
            }

            "com.tencent.map" -> {
                val info = data["meta"].asJsonObject["Location.Search"].asJsonObject
                elem.setLocation(LocationElement.newBuilder().apply {
                    this.lat = info["lat"].asString.toFloat()
                    this.lon = info["lng"].asString.toFloat()
                    this.address = info["address"].asString
                    this.title = info["name"].asString
                })
            }

            else -> elem.setJson(JsonElement.newBuilder().apply {
                this.json = data.toString()
            })
        }
        return Result.success(elem.build())
    }

    suspend fun convertReply(contact: Contact, element: MsgElement): Result<Element> {
        val reply = element.replyElement
        val elem = Element.newBuilder()
        elem.setReply(ReplyElement.newBuilder().apply {
            val msgSeq = reply.replayMsgSeq
            val sourceRecords = withTimeoutOrNull(3000) {
                suspendCancellableCoroutine {
                    QRoute.api(IMsgService::class.java)
                        .getMsgsBySeqAndCount(contact, msgSeq, 1, true) { _, _, records ->
                            it.resume(records)
                        }
                }
            }
            if (sourceRecords.isNullOrEmpty()) {
                LogCenter.log("无法查询到回复的消息ID: seq = $msgSeq", Level.WARN)
                this.messageId = reply.replayMsgId.toString()
            } else {
                this.messageId = sourceRecords.first().msgId.toString()
            }
        })
        return Result.success(elem.build())
    }

    suspend fun convertFile(contact: Contact, element: MsgElement): Result<Element> {
        val fileMsg = element.fileElement
        val fileName = fileMsg.fileName
        val fileSize = fileMsg.fileSize
        val expireTime = fileMsg.expireTime ?: 0
        val fileId = fileMsg.fileUuid
        val bizId = fileMsg.fileBizId ?: 0
        val fileSubId = fileMsg.fileSubId ?: ""
        val url = when (contact.chatType) {
            MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CFileDownUrl(fileId, fileSubId)
            MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildFileDownUrl(
                contact.guildId,
                contact.longPeer().toString(),
                fileId,
                bizId
            )

            else -> RichProtoSvc.getGroupFileDownUrl(contact.longPeer(), fileId, bizId)
        }
        val elem = Element.newBuilder()
        elem.setFile(FileElement.newBuilder().apply {
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

    suspend fun convertMarkdown(contact: Contact, element: MsgElement): Result<Element> {
        val markdown = element.markdownElement
        val elem = Element.newBuilder()
        elem.setMarkdown(MarkdownElement.newBuilder().apply {
            this.markdown = markdown.content
        })
        return Result.success(elem.build())
    }

    suspend fun convertBubbleFace(contact: Contact, element: MsgElement): Result<Element> {
        val bubbleFace = element.faceBubbleElement
        val elem = Element.newBuilder()
        elem.setBubbleFace(BubbleFaceElement.newBuilder().apply {
            this.id = bubbleFace.yellowFaceInfo.index
            this.count = bubbleFace.faceCount ?: 1
        })
        return Result.success(elem.build())
    }

    suspend fun convertInlineKeyboard(contact: Contact, element: MsgElement): Result<Element> {
        val inlineKeyboard = element.inlineKeyboardElement
        val elem = Element.newBuilder()
        elem.setKeyboard(KeyboardElement.newBuilder().apply {
            this.addAllRows(inlineKeyboard.rows.map { row ->
                KeyboardRow.newBuilder().apply {
                    this.addAllButtons(row.buttons.map { button ->
                        Button.newBuilder().apply {
                            this.id = button.id
                            this.renderData = ButtonRender.newBuilder().apply {
                                this.label = button.label ?: ""
                                this.visitedLabel = button.visitedLabel ?: ""
                                this.style = button.style
                            }.build()
                            this.action = ButtonAction.newBuilder().apply {
                                this.type = button.type
                                this.permission = ButtonActionPermission.newBuilder().apply {
                                    this.type = button.permissionType
                                    button.specifyRoleIds?.let {
                                        this.addAllRoleIds(it)
                                    }
                                    button.specifyTinyids?.let {
                                        this.addAllUserIds(it)
                                    }
                                }.build()
                                this.unsupportedTips = button.unsupportTips ?: ""
                                this.data = button.data ?: ""
                                this.reply = button.isReply
                                this.enter = button.enter
                            }.build()
                        }.build()
                    })
                }.build()
            })
            this.botAppid = inlineKeyboard.botAppid
        })
        return Result.success(elem.build())
    }

    operator fun get(case: Int): ReqConvertor? {
        return convertorMap[case]
    }
}

suspend fun NtMessages.toKritorReqMessages(contact: Contact): ArrayList<Element> {
    val result = arrayListOf<Element>()
    forEach {
        ReqMsgConvertor[it.elementType]?.invoke(contact, it)?.onSuccess {
            result.add(it)
        }?.onFailure {
            if (it !is ActionMsgException) {
                LogCenter.log("消息转换异常: " + it.stackTraceToString(), Level.WARN)
            }
        }
    }
    return result
}