package qq.service.msg

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.exifinterface.media.ExifInterface
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.msg.api.IMsgService
import io.kritor.message.AtElement
import io.kritor.message.Element
import io.kritor.message.ElementType
import io.kritor.message.ImageElement
import io.kritor.message.ImageType
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.LogicException
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.putBuf32Long
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.utils.DownloadUtils
import moe.fuqiuluo.shamrock.utils.FileUtils
import protobuf.auto.toByteArray
import protobuf.message.Elem
import protobuf.message.RichText
import protobuf.message.element.*
import protobuf.message.element.commelem.Action
import protobuf.message.element.commelem.Button
import protobuf.message.element.commelem.ButtonExtra
import protobuf.message.element.commelem.MarkdownExtra
import protobuf.message.element.commelem.Object1
import protobuf.message.element.commelem.Permission
import protobuf.message.element.commelem.PokeExtra
import protobuf.message.element.commelem.QFaceExtra
import protobuf.message.element.commelem.RenderData
import protobuf.message.element.commelem.Row
import protobuf.oidb.cmd0x11c5.C2CUserInfo
import protobuf.oidb.cmd0x11c5.GroupUserInfo
import qq.service.QQInterfaces
import qq.service.bdh.NtV2RichMediaSvc
import qq.service.bdh.NtV2RichMediaSvc.fetchGroupResUploadTo
import qq.service.contact.ContactHelper
import qq.service.contact.longPeer
import qq.service.group.GroupHelper
import qq.service.lightapp.WeatherHelper
import java.io.ByteArrayInputStream
import java.io.File
import java.nio.ByteBuffer
import java.util.UUID
import kotlin.coroutines.resume
import kotlin.random.Random
import kotlin.random.nextULong
import kotlin.time.Duration.Companion.seconds

/**
 * 请求消息（io.kritor.message.*）转换合并转发消息
 */

suspend fun List<Element>.toRichText(contact: Contact): Result<Pair<String, RichText>> {
    val summary = StringBuilder()
    val elems = ArrayList<Elem>()
    forEach {
        try {
            when(it.type!!) {
                ElementType.TEXT -> {
                    val text = it.text.text
                    val elem = Elem(
                        text = TextMsg(text)
                    )
                    elems.add(elem)
                    summary.append(text)
                }
                ElementType.AT -> {
                    when (contact.chatType) {
                        MsgConstant.KCHATTYPEGROUP -> {
                            val qq = when (it.at.accountCase) {
                                AtElement.AccountCase.UIN -> it.at.uin.toString()
                                else -> ContactHelper.getUinByUidAsync(it.at.uid)
                            }
                            val type: Int
                            val nick = if (it.at.uid == "all" || it.at.uin == 0L) {
                                type = 1
                                "@全体成员"
                            } else {
                                type = 0
                                "@" + (GroupHelper.getTroopMemberInfoByUinV2(contact.longPeer().toString(), qq, true).let {
                                    val info = it.getOrNull()
                                    if (info == null)
                                        LogCenter.log("无法获取群成员信息: $qq", Level.ERROR)
                                    else info.troopnick
                                        .ifNullOrEmpty { info.friendnick }
                                        .ifNullOrEmpty { qq }
                                })
                            }
                            val attr6 = ByteBuffer.allocate(6)
                            attr6.put(byteArrayOf(0, 1, 0, 0, 0))
                            attr6.put(nick.length.toByte())
                            attr6.putChar(type.toChar())
                            attr6.putBuf32Long(qq.toLong())
                            attr6.put(byteArrayOf(0, 0))
                            val elem = Elem(
                                text = TextMsg(str = nick, attr6Buf = attr6.array())
                            )
                            elems.add(elem)
                            summary.append(nick)
                        }

                        MsgConstant.KCHATTYPEC2C -> {
                            val qq = when (it.at.accountCase) {
                                AtElement.AccountCase.UIN -> it.at.uin.toString()
                                else -> ContactHelper.getUinByUidAsync(it.at.uid)
                            }
                            val display = "@" + (ContactHelper.getProfileCard(qq.toLong()).onSuccess {
                                it.strNick.ifNullOrEmpty { qq }
                            }.onFailure {
                                LogCenter.log("无法获取QQ信息: $qq", Level.WARN)
                            })
                            val elem = Elem(
                                text = TextMsg(str = display)
                            )
                            elems.add(elem)
                            summary.append(display)
                        }
                        else -> throw UnsupportedOperationException("Unsupported chatType($contact) for AtMsg")
                    }
                }
                ElementType.FACE -> {
                    val faceId = it.face.id
                    val elem = if (it.face.isBig) {
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
                    elems.add(elem)
                    summary.append("[表情]")
                }
                ElementType.BUBBLE_FACE -> throw UnsupportedOperationException("Unsupported ElementType.BUBBLE_FACE")
                ElementType.REPLY -> {
                    val msgId = it.reply.messageId
                    withTimeoutOrNull(3000) {
                        suspendCancellableCoroutine {
                            QRoute.api(IMsgService::class.java).getMsgsByMsgId(contact, arrayListOf(msgId)) { _, _, records ->
                                it.resume(records)
                            }
                        }
                    }?.firstOrNull()?.let {
                        val sourceContact = MessageHelper.generateContact(it)
                        elems.add(Elem(
                            srcMsg = SourceMsg(
                                origSeqs = listOf(it.msgSeq.toInt()),
                                senderUin = it.senderUin.toULong(),
                                time = it.msgTime.toULong(),
                                flag = 1u,
                                elems = it.elements
                                    .toKritorReqMessages(sourceContact)
                                    .toRichText(contact).getOrThrow().second.elements,
                                type = 0u,
                                pbReserve = SourceMsg.Companion.PbReserve(
                                    msgRand = Random.nextULong(),
                                    senderUid = it.senderUid,
                                    receiverUid = QQInterfaces.app.currentUid,
                                    field8 = Random.nextInt(0, 10000)
                                ),
                            )
                        ))
                    }
                    summary.append("[回复消息]")
                }
                ElementType.IMAGE -> {
                    val type = it.image.type
                    val isOriginal = type == ImageType.ORIGIN
                    val file = when(it.image.dataCase!!) {
                        ImageElement.DataCase.FILE_NAME -> {
                            val fileMd5 = it.image.fileName.replace(regex = "[{}\\-]".toRegex(), replacement = "").split(".")[0].lowercase()
                            FileUtils.getFileByMd5(fileMd5)
                        }
                        ImageElement.DataCase.FILE_PATH -> {
                            val filePath = it.image.filePath
                            File(filePath).inputStream().use {
                                FileUtils.saveFileToCache(it)
                            }
                        }
                        ImageElement.DataCase.FILE_BASE64 -> {
                            FileUtils.saveFileToCache(
                                ByteArrayInputStream(
                                    Base64.decode(it.image.fileBase64, Base64.DEFAULT)
                                )
                            )
                        }
                        ImageElement.DataCase.URL -> {
                            val tmp = FileUtils.getTmpFile()
                            if(DownloadUtils.download(it.image.url, tmp)) {
                                tmp.inputStream().use {
                                    FileUtils.saveFileToCache(it)
                                }.also {
                                    tmp.delete()
                                }
                            } else {
                                tmp.delete()
                                throw LogicException("图片资源下载失败: ${it.image.url}")
                            }
                        }
                        ImageElement.DataCase.DATA_NOT_SET -> throw IllegalArgumentException("ImageElement data is not set")
                    }

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

                    val fileInfo = NtV2RichMediaSvc.tryUploadResourceByNt(
                        chatType = contact.chatType,
                        elementType = MsgConstant.KELEMTYPEPIC,
                        resources = arrayListOf(file),
                        timeout = 30.seconds
                    ).getOrThrow().first()

                    runCatching {
                        fileInfo.uuid.toUInt()
                    }.onFailure {
                        NtV2RichMediaSvc.requestUploadNtPic(file, fileInfo.md5, fileInfo.sha, fileInfo.fileName, picWidth.toUInt(), picHeight.toUInt(), 5, contact.chatType) {
                            when(contact.chatType) {
                                MsgConstant.KCHATTYPEGROUP -> {
                                    sceneType = 2u
                                    grp = GroupUserInfo(fetchGroupResUploadTo().toULong())
                                }
                                MsgConstant.KCHATTYPEC2C -> {
                                    sceneType = 1u
                                    c2c = C2CUserInfo(
                                        accountType = 2u,
                                        uid = contact.peerUid
                                    )
                                }
                                else -> error("不支持的合并转发图片类型")
                            }
                        }.onFailure {
                            LogCenter.log("获取MultiMedia图片信息失败: $it", Level.ERROR)
                        }.onSuccess {
                            //LogCenter.log({ "获取MultiMedia图片信息成功: ${it.hashCode()}" }, Level.INFO)
                            elems.add(Elem(
                                commonElem = CommonElem(
                                    serviceType = 48,
                                    businessType = 10,
                                    elem = it.msgInfo!!.toByteArray()
                                )
                            ))
                        }
                    }.onSuccess { uuid ->
                        elems.add(when (contact.chatType) {
                            MsgConstant.KCHATTYPEGROUP -> Elem(
                                customFace = CustomFace(
                                    filePath = fileInfo.fileName,
                                    fileId = uuid,
                                    serverIp = 0u,
                                    serverPort = 0u,
                                    fileType = FileUtils.getPicType(file).toUInt(),
                                    useful = 1u,
                                    md5 = fileInfo.md5.hex2ByteArray(),
                                    bizType = 0u,
                                    imageType = FileUtils.getPicType(file).toUInt(),
                                    width = picWidth.toUInt(),
                                    height = picHeight.toUInt(),
                                    size = fileInfo.fileSize.toUInt(),
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
                                            md5Str = fileInfo.md5
                                        )
                                    )
                                )
                            )
                            MsgConstant.KCHATTYPEC2C -> Elem(
                                notOnlineImage = NotOnlineImage(
                                    filePath = fileInfo.fileName,
                                    fileLen = fileInfo.fileSize.toUInt(),
                                    downloadPath = fileInfo.uuid,
                                    imgType = FileUtils.getPicType(file).toUInt(),
                                    picMd5 = fileInfo.md5.hex2ByteArray(),
                                    picHeight = picWidth.toUInt(),
                                    picWidth = picHeight.toUInt(),
                                    resId = fileInfo.uuid,
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
                                        md5Str = fileInfo.md5
                                    )
                                )
                            )
                            else -> throw LogicException("Not supported chatType($contact) for PictureMsg")
                        })
                    }

                    summary.append("[图片]")
                }
                ElementType.VOICE -> throw UnsupportedOperationException("Unsupported ElementType.VOICE")
                ElementType.VIDEO -> throw UnsupportedOperationException("Unsupported ElementType.VIDEO")
                ElementType.BASKETBALL -> throw UnsupportedOperationException("Unsupported ElementType.BASKETBALL")
                ElementType.DICE -> {
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
                    elems.add(elem)
                    summary .append( "[骰子]" )
                }
                ElementType.RPS -> {
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
                    elems.add(elem)
                    summary .append( "[包剪锤]" )
                }
                ElementType.POKE -> {
                    val elem = Elem(
                        commonElem = CommonElem(
                            serviceType = 2,
                            elem = PokeExtra(
                                type = it.poke.type,
                                field7 = 0,
                                field8 = 0
                            ).toByteArray(),
                            businessType = it.poke.id
                        )
                    )
                    elems.add(elem)
                    summary .append( "[戳一戳]" )
                }
                ElementType.MUSIC -> throw UnsupportedOperationException("Unsupported ElementType.MUSIC")
                ElementType.WEATHER -> {
                    var code = it.weather.code.toIntOrNull()
                    if (code == null) {
                        val city = it.weather.city
                        WeatherHelper.searchCity(city).onFailure {
                            LogCenter.log("无法获取城市天气: $city", Level.ERROR)
                        }.getOrNull()?.firstOrNull()?.let {
                            code = it.adcode
                        }
                    }

                    if (code != null) {
                        val weatherCard = WeatherHelper.fetchWeatherCard(code!!).getOrThrow()
                        val elem = Elem(
                            lightApp = LightAppElem(
                                data = byteArrayOf(1) + DeflateTools.compress(
                                    weatherCard["weekStore"]
                                        .asJsonObject["share"].asString.toByteArray()
                                )
                            )
                        )
                        elems.add(elem)
                        summary .append( "[天气卡片]" )
                    } else {
                        throw LogicException("无法获取城市天气")
                    }
                }
                ElementType.LOCATION -> throw UnsupportedOperationException("Unsupported ElementType.LOCATION")
                ElementType.SHARE -> throw UnsupportedOperationException("Unsupported ElementType.SHARE")
                ElementType.GIFT -> throw UnsupportedOperationException("Unsupported ElementType.GIFT")
                ElementType.MARKET_FACE -> throw UnsupportedOperationException("Unsupported ElementType.MARKET_FACE")
                ElementType.FORWARD -> {
                    val resId = it.forward.resId
                    val filename = UUID.randomUUID().toString().uppercase()
                    var content = it.forward.summary
                    val descriptions = it.forward.description
                    var news = descriptions?.split("\n")?.map { "text" to it }

                    if (news == null || content == null) {
                        val forwardMsg = MessageHelper.getForwardMsg(resId).getOrThrow()
                        if (news == null) {
                            news = forwardMsg.map {
                                "text" to it.sender.nickName + ": " + descriptions
                            }
                        }
                        if (content == null) {
                            content = "查看${forwardMsg.size}条转发消息"
                        }
                    }

                    val json = mapOf(
                        "app" to "com.tencent.multimsg",
                        "config" to mapOf(
                            "autosize" to 1,
                            "forward" to 1,
                            "round" to 1,
                            "type" to "normal",
                            "width" to 300
                        ),
                        "desc" to "[聊天记录]",
                        "extra" to mapOf(
                            "filename" to filename,
                            "tsum" to 2
                        ).json.toString(),
                        "meta" to mapOf(
                            "detail" to mapOf(
                                "news" to news,
                                "resid" to resId,
                                "source" to "群聊的聊天记录",
                                "summary" to content,
                                "uniseq" to filename
                            )
                        ),
                        "prompt" to "[聊天记录]",
                        "ver" to "0.0.0.5",
                        "view" to "contact"
                    )
                    val elem = Elem(
                        lightApp = LightAppElem(
                            data = byteArrayOf(1) + DeflateTools.compress(json.json.toString().toByteArray())
                        )
                    )
                    elems.add(elem)
                    summary.append( "[聊天记录]" )
                }
                ElementType.CONTACT -> throw UnsupportedOperationException("Unsupported ElementType.CONTACT")
                ElementType.JSON -> {
                    val elem = Elem(
                        lightApp = LightAppElem(
                            data = byteArrayOf(1) + DeflateTools.compress(it.json.json.toByteArray())
                        )
                    )
                    elems.add(elem)
                    summary .append( "[Json消息]" )
                }
                ElementType.XML -> throw UnsupportedOperationException("Unsupported ElementType.XML")
                ElementType.FILE -> throw UnsupportedOperationException("Unsupported ElementType.FILE")
                ElementType.MARKDOWN -> {
                    val elem = Elem(
                        commonElem = CommonElem(
                            serviceType = 45,
                            elem = MarkdownExtra(it.markdown.markdown).toByteArray(),
                            businessType = 1
                        )
                    )
                    elems.add(elem)
                    summary.append("[Markdown消息]")
                }
                ElementType.BUTTON -> {
                    val elem = Elem(
                        commonElem = CommonElem(
                            serviceType = 46,
                            elem = ButtonExtra(
                                field1 = Object1(
                                    rows = it.button.rowsList.map { row ->
                                        Row(buttons = row.buttonsList.map { button ->
                                            val renderData = button.renderData
                                            val action = button.action
                                            val permission = action.permission
                                            Button(
                                                id = button.id,
                                                renderData = RenderData(
                                                    label = renderData.label,
                                                    visitedLabel = renderData.visitedLabel,
                                                    style = renderData.style
                                                ),
                                                action = Action(
                                                    type = action.type,
                                                    permission = Permission(
                                                        type = permission.type,
                                                        specifyRoleIds = permission.roleIdsList,
                                                        specifyUserIds = permission.userIdsList
                                                    ),
                                                    unsupportTips = action.unsupportedTips,
                                                    data = action.data,
                                                    reply = action.reply,
                                                    enter = action.enter
                                                )
                                            )
                                        })
                                    },
                                    appid = it.button.applicationId.toULong()
                                )
                            ).toByteArray(),
                            businessType = 1
                        )
                    )
                    elems.add(elem)
                    summary.append("[Button消息]")
                }
                ElementType.NODE -> throw UnsupportedOperationException("Unsupported ElementType.NODE")
                ElementType.UNRECOGNIZED -> throw UnsupportedOperationException("Unsupported ElementType.UNRECOGNIZED")
            }
        } catch (e: Throwable) {
            LogCenter.log("转换消息失败(Multi): ${e.stackTraceToString()}", Level.ERROR)
        }
    }
    return Result.success(summary.toString() to RichText(
        elements = elems
    ))
}

