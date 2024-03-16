@file:OptIn(ExperimentalUnsignedTypes::class)
package qq.service.msg

import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import io.kritor.message.Element
import io.kritor.message.ElementType
import io.kritor.message.ImageType
import io.kritor.message.Scene
import io.kritor.message.atElement
import io.kritor.message.buttonActionPermission
import io.kritor.message.buttonElement
import io.kritor.message.contactElement
import io.kritor.message.faceElement
import io.kritor.message.forwardElement
import io.kritor.message.imageElement
import io.kritor.message.jsonElement
import io.kritor.message.locationElement
import io.kritor.message.markdownElement
import io.kritor.message.replyElement
import io.kritor.message.textElement
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
                kritorMessages.add(io.kritor.message.element {
                    this.type = ElementType.AT
                    this.at = atElement {
                        this.uin = uin.toLong()
                    }
                })
            } else {
                kritorMessages.add(io.kritor.message.element {
                    this.type = ElementType.TEXT
                    this.text = textElement {
                        this.text = text.str ?: ""
                    }
                })
            }
        } else if (element.face != null) {
            kritorMessages.add(io.kritor.message.element {
                this.type = ElementType.FACE
                this.face = faceElement {
                    this.id = element.face!!.index ?: 0
                }
            })
        } else if (element.customFace != null) {
            val customFace = element.customFace!!
            val md5 = customFace.md5.toHexString()
            val origUrl = customFace.origUrl!!
            kritorMessages.add(io.kritor.message.element {
                this.type = ElementType.IMAGE
                this.image = imageElement {
                    this.fileName = md5
                    this.type = if (customFace.origin == true) ImageType.ORIGIN else ImageType.COMMON
                    this.url = when (contact.chatType) {
                        MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(origUrl, md5)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(origUrl, md5)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(origUrl, md5)
                        else -> throw UnsupportedOperationException("Not supported chat type: $contact")
                    }
                }
            })
        } else if (element.notOnlineImage != null) {
            require(element.notOnlineImage != null)
            val md5 = element.notOnlineImage!!.picMd5.toHexString()
            val origUrl = element.notOnlineImage!!.origUrl!!
            kritorMessages.add(io.kritor.message.element {
                this.type = ElementType.IMAGE
                this.image = imageElement {
                    this.fileName = md5
                    this.type = if (element.notOnlineImage?.original == true) ImageType.ORIGIN else ImageType.COMMON
                    this.url = when (contact.chatType) {
                        MsgConstant.KCHATTYPEDISC, MsgConstant.KCHATTYPEGROUP -> RichProtoSvc.getGroupPicDownUrl(origUrl, md5)
                        MsgConstant.KCHATTYPEC2C -> RichProtoSvc.getC2CPicDownUrl(origUrl, md5)
                        MsgConstant.KCHATTYPEGUILD -> RichProtoSvc.getGuildPicDownUrl(origUrl, md5)
                        else -> throw UnsupportedOperationException("Not supported chat type: $contact")
                    }
                }
            })
        } else if (element.generalFlags != null) {
            val generalFlags = element.generalFlags!!
            if (generalFlags.longTextFlag == 1u) {
                kritorMessages.add(io.kritor.message.element {
                    this.type = ElementType.FORWARD
                    this.forward = forwardElement {
                        this.id = generalFlags.longTextResid ?: ""
                    }
                })
            }
        } else if (element.srcMsg != null) {
            val srcMsg = element.srcMsg!!
            val msgId = srcMsg.pbReserve?.msgRand?.toLong() ?: 0
            kritorMessages.add(io.kritor.message.element {
                this.type = ElementType.REPLY
                this.reply = replyElement {
                    this.messageId = msgId
                }
            })
        } else if (element.lightApp != null) {
            val data = element.lightApp!!.data!!
            val jsonStr = (if (data[0].toInt() == 1) DeflateTools.uncompress(data.slice(1)) else data.slice(1)).decodeToString()
            val json = jsonStr.asJsonObject
            when (json["app"].asString) {
                "com.tencent.multimsg" -> {
                    val info = json["meta"].asJsonObject["detail"].asJsonObject
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.FORWARD
                        this.forward = forwardElement {
                            this.id = info["resid"].asString
                            this.uniseq = info["uniseq"].asString
                            this.summary = info["summary"].asString
                            this.description = info["news"].asJsonArray.joinToString("\n") {
                                it.asJsonObject["text"].asString
                            }
                        }
                    })
                }

                "com.tencent.troopsharecard" -> {
                    val info = json["meta"].asJsonObject["contact"].asJsonObject
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.CONTACT
                        this.contact = contactElement {
                            this.scene = Scene.GROUP
                            this.peer = info["jumpUrl"].asString.split("group_code=")[1]
                        }
                    })

                }

                "com.tencent.contact.lua" -> {
                    val info = json["meta"].asJsonObject["contact"].asJsonObject
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.CONTACT
                        this.contact = contactElement {
                            this.scene = Scene.FRIEND
                            this.peer = info["jumpUrl"].asString.split("uin=")[1]
                        }
                    })
                }

                "com.tencent.map" -> {
                    val info = json["meta"].asJsonObject["Location.Search"].asJsonObject
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.LOCATION
                        this.location = locationElement {
                            this.lat = info["lat"].asString.toFloat()
                            this.lon = info["lng"].asString.toFloat()
                            this.address = info["address"].asString
                            this.title = info["name"].asString
                        }
                    })
                }
                else -> {
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.JSON
                        this.json = jsonElement {
                            this.json = jsonStr
                        }
                    })
                }
            }
        } else if (element.commonElem != null) {
            val commonElem = element.commonElem!!
            when (commonElem.serviceType) {
                37 -> {
                    val qFaceExtra = commonElem.elem!!.decodeProtobuf<QFaceExtra>()
                    when (qFaceExtra.faceId) {
                        358 -> kritorMessages.add(io.kritor.message.element {
                            this.type = ElementType.DICE
                            this.dice = io.kritor.message.diceElement {
                                this.id = qFaceExtra.result!!.toInt()
                            }
                        })

                        359 -> kritorMessages.add(io.kritor.message.element {
                            this.type = ElementType.RPS
                            this.rps = io.kritor.message.rpsElement {
                                this.id = qFaceExtra.result!!.toInt()
                            }
                        })

                        else -> kritorMessages.add(io.kritor.message.element {
                            this.type = ElementType.FACE
                            this.face = faceElement {
                                this.id = qFaceExtra.faceId ?: 0
                                this.isBig = false
                                this.result = qFaceExtra.result?.toInt() ?: 0
                            }
                        })
                    }
                }

                45 -> {
                    val markdownExtra = commonElem.elem!!.decodeProtobuf<MarkdownExtra>()
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.MARKDOWN
                        this.markdown = markdownElement {
                            this.markdown = markdownExtra.content!!
                        }
                    })
                }

                46 -> {
                    val buttonExtra = commonElem.elem!!.decodeProtobuf<ButtonExtra>()
                    kritorMessages.add(io.kritor.message.element {
                        this.type = ElementType.BUTTON
                        this.button = buttonElement {
                            buttonExtra.field1!!.rows?.forEach { row ->
                                this.rows.add(io.kritor.message.row {
                                    row.buttons?.forEach { button ->
                                        this.buttons.add(io.kritor.message.button {
                                            val renderData = button.renderData
                                            val action = button.action
                                            val permission = action?.permission
                                            this.id = button.id ?: ""
                                            this.renderData = io.kritor.message.buttonRender {
                                                this.label = renderData?.label ?: ""
                                                this.visitedLabel = renderData?.visitedLabel ?: ""
                                                this.style = renderData?.style ?: 0
                                            }
                                            this.action = io.kritor.message.buttonAction {
                                                this.type = action?.type ?: 0
                                                this.permission = buttonActionPermission {
                                                    this.type = permission?.type ?: 0
                                                    this.roleIds.addAll(
                                                        permission?.specifyRoleIds ?: emptyList()
                                                    )
                                                    this.userIds.addAll(
                                                        permission?.specifyUserIds ?: emptyList()
                                                    )
                                                }
                                                this.unsupportedTips = action?.unsupportTips ?: ""
                                                this.data = action?.data ?: ""
                                                this.reply = action?.reply ?: false
                                                this.enter = action?.enter ?: false
                                            }
                                        })
                                    }
                                })
                            }
                        }
                    })
                }
            }
        }
    }
    return kritorMessages
}