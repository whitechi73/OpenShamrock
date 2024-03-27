@file:OptIn(ExperimentalUnsignedTypes::class)

package qq.service.msg

import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.kritor.common.*
import io.kritor.common.Element.ElementType
import io.kritor.common.ImageElement.ImageType
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.discardExact
import kotlinx.io.core.readUInt
import moe.fuqiuluo.shamrock.tools.asJsonArray
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.message.Elem
import protobuf.message.element.commelem.ButtonExtra
import protobuf.message.element.commelem.MarkdownExtra
import protobuf.message.element.commelem.QFaceExtra
import qq.service.bdh.RichProtoSvc

/**
 * 将合并转发PB（protobuf.message.*）转请求消息（io.kritor.message.*）发送
 */

suspend fun List<Elem>.toKritorResponseMessages(contact: Contact): ArrayList<Element> {
    val kritorMessages = ArrayList<Element>()
    forEach { element ->
        if (element.text != null) {
            val text = element.text!!
            if (text.attr6Buf != null) {
                val at = ByteReadPacket(text.attr6Buf!!)
                at.discardExact(7)
                val uin = at.readUInt()
                kritorMessages.add(Element.newBuilder().apply {
                    this.type = ElementType.AT
                    this.at = AtElement.newBuilder().apply {
                        this.uin = uin.toLong()
                    }.build()
                }.build())
            } else {
                kritorMessages.add(Element.newBuilder().apply {
                    this.type = ElementType.TEXT
                    this.text = TextElement.newBuilder().apply {
                        this.text = text.str ?: ""
                    }.build()
                }.build())
            }
        } else if (element.face != null) {
            kritorMessages.add(Element.newBuilder().apply {
                this.type = ElementType.FACE
                this.face = FaceElement.newBuilder().apply {
                    this.id = element.face!!.index ?: 0
                }.build()
            }.build())
        } else if (element.customFace != null) {
            val customFace = element.customFace!!
            val md5 = customFace.md5.toHexString()
            val origUrl = customFace.origUrl!!
            kritorMessages.add(Element.newBuilder().apply {
                this.type = ElementType.IMAGE
                this.image = ImageElement.newBuilder().apply {
                    this.fileMd5 = md5
                    this.type = if (customFace.origin == true) ImageType.ORIGIN else ImageType.COMMON
                    this.fileUrl = when (contact.chatType) {
                        MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                            origUrl,
                            md5
                        )

                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(origUrl, md5)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(origUrl, md5)
                        else -> throw UnsupportedOperationException("Not supported chat type: $contact")
                    }
                }.build()
            }.build())
        } else if (element.notOnlineImage != null) {
            val md5 = element.notOnlineImage!!.picMd5.toHexString()
            val origUrl = element.notOnlineImage!!.origUrl!!
            kritorMessages.add(Element.newBuilder().apply {
                this.type = ElementType.IMAGE
                this.image = ImageElement.newBuilder().apply {
                    this.fileMd5 = md5
                    this.type = if (element.notOnlineImage?.original == true) ImageType.ORIGIN else ImageType.COMMON
                    this.fileUrl = when (contact.chatType) {
                        MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(
                            origUrl,
                            md5
                        )

                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(origUrl, md5)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(origUrl, md5)
                        else -> throw UnsupportedOperationException("Not supported chat type: $contact")
                    }
                }.build()
            }.build())
        } else if (element.generalFlags != null) {
//            val generalFlags = element.generalFlags!!
//            if (generalFlags.longTextFlag == 1u) {
//                kritorMessages.add(Element.newBuilder().apply {
//                    this.type = ElementType.FORWARD
//                    this.forward = forwardElement {
//                        this.id = generalFlags.longTextResid ?: ""
//                    }
//                })
//            }
        } else if (element.srcMsg != null) {
            val srcMsg = element.srcMsg!!
            val msgId = srcMsg.pbReserve?.msgRand?.toLong() ?: 0
            kritorMessages.add(Element.newBuilder().apply {
                this.type = ElementType.REPLY
                this.reply = ReplyElement.newBuilder().apply {
                    this.messageId = msgId.toString()
                }.build()
            }.build())
        } else if (element.lightApp != null) {
            val data = element.lightApp!!.data!!
            val jsonStr =
                (if (data[0].toInt() == 1) DeflateTools.uncompress(data.slice(1)) else data.slice(1)).decodeToString()
            val json = jsonStr.asJsonObject
            when (json["app"].asString) {
                "com.tencent.multimsg" -> {
                    val info = json["meta"].asJsonObject["detail"].asJsonObject
                    kritorMessages.add(Element.newBuilder().apply {
                        this.type = ElementType.FORWARD
                        this.forward = ForwardElement.newBuilder().apply {
                            this.resId = info["resid"].asString
                            this.uniseq = info["uniseq"].asString
                            this.summary = info["summary"].asString
                            this.description = info["news"].asJsonArray.joinToString("\n") {
                                it.asJsonObject["text"].asString
                            }
                        }.build()
                    }.build())
                }

                "com.tencent.troopsharecard" -> {
                    val info = json["meta"].asJsonObject["contact"].asJsonObject
                    kritorMessages.add(Element.newBuilder().apply {
                        this.type = ElementType.CONTACT
                        this.contact = ContactElement.newBuilder().apply {
                            this.scene = Scene.GROUP
                            this.peer = info["jumpUrl"].asString.split("group_code=")[1]
                        }.build()
                    }.build())

                }

                "com.tencent.contact.lua" -> {
                    val info = json["meta"].asJsonObject["contact"].asJsonObject
                    kritorMessages.add(Element.newBuilder().apply {
                        this.type = ElementType.CONTACT
                        this.contact = ContactElement.newBuilder().apply {
                            this.scene = Scene.FRIEND
                            this.peer = info["jumpUrl"].asString.split("uin=")[1]
                        }.build()
                    }.build())
                }

                "com.tencent.map" -> {
                    val info = json["meta"].asJsonObject["Location.Search"].asJsonObject
                    kritorMessages.add(Element.newBuilder().apply {
                        this.type = ElementType.LOCATION
                        this.location = LocationElement.newBuilder().apply {
                            this.lat = info["lat"].asString.toFloat()
                            this.lon = info["lng"].asString.toFloat()
                            this.address = info["address"].asString
                            this.title = info["name"].asString
                        }.build()
                    }.build())
                }

                else -> {
                    kritorMessages.add(Element.newBuilder().apply {
                        this.type = ElementType.JSON
                        this.json = JsonElement.newBuilder().apply {
                            this.json = jsonStr
                        }.build()
                    }.build())
                }
            }
        } else if (element.commonElem != null) {
            val commonElem = element.commonElem!!
            when (commonElem.serviceType) {
                37 -> {
                    val qFaceExtra = commonElem.elem!!.decodeProtobuf<QFaceExtra>()
                    when (qFaceExtra.faceId) {
                        358 -> kritorMessages.add(Element.newBuilder().apply {
                            this.type = ElementType.DICE
                            this.dice = DiceElement.newBuilder().apply {
                                this.id = qFaceExtra.result!!.toInt()
                            }.build()
                        }.build())

                        359 -> kritorMessages.add(Element.newBuilder().apply {
                            this.type = ElementType.RPS
                            this.rps = RpsElement.newBuilder().apply {
                                this.id = qFaceExtra.result!!.toInt()
                            }.build()
                        }.build())

                        else -> kritorMessages.add(Element.newBuilder().apply {
                            this.type = ElementType.FACE
                            this.face = FaceElement.newBuilder().apply {
                                this.id = qFaceExtra.faceId ?: 0
                                this.isBig = false
                                this.result = qFaceExtra.result?.toInt() ?: 0
                            }.build()
                        }.build())
                    }
                }

                45 -> {
                    val markdownExtra = commonElem.elem!!.decodeProtobuf<MarkdownExtra>()
                    kritorMessages.add(Element.newBuilder().apply {
                        this.type = ElementType.MARKDOWN
                        this.markdown = MarkdownElement.newBuilder().apply {
                            this.markdown = markdownExtra.content!!
                        }.build()
                    }.build())
                }

                46 -> {
                    val buttonExtra = commonElem.elem!!.decodeProtobuf<ButtonExtra>()
                    kritorMessages.add(
                        Element.newBuilder().setButton(ButtonElement.newBuilder().apply {
                            this.addAllRows(buttonExtra.field1!!.rows!!.map { row ->
                                ButtonRow.newBuilder().apply {
                                    this.addAllButtons(row.buttons!!.map { button ->
                                        Button.newBuilder().apply {
                                            this.id = button.id
                                            this.renderData = ButtonRender.newBuilder().apply {
                                                this.label = button.renderData?.label ?: ""
                                                this.visitedLabel = button.renderData?.visitedLabel ?: ""
                                                this.style = button.renderData?.style ?: 0
                                            }.build()
                                            this.action = ButtonAction.newBuilder().apply {
                                                this.type = button.action?.type?:0
                                                this.permission = ButtonActionPermission.newBuilder().apply {
                                                    this.type = button.action?.permission?.type?:0
                                                    button.action?.permission?.specifyRoleIds?.let {
                                                        this.addAllRoleIds(it)
                                                    }
                                                    button.action?.permission?.specifyUserIds?.let {
                                                        this.addAllUserIds(it)
                                                    }
                                                }.build()
                                                this.unsupportedTips = button.action?.unsupportTips ?: ""
                                                this.data = button.action?.data ?: ""
                                                this.reply = button.action?.reply ?: false
                                                this.enter = button.action?.enter ?: false
                                            }.build()
                                        }.build()
                                    })
                                }.build()
                            })
                            this.botAppid = buttonExtra.field1?.appid?.toLong() ?: 0L
                        }.build()).build()
                    )
                }
            }
        }
    }
    return kritorMessages
}