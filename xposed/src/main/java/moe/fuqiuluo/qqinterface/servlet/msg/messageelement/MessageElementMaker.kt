package moe.fuqiuluo.qqinterface.servlet.msg.messageelement

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.qqinterface.servlet.GProSvc
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.helper.*
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.ParamsException
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.DeflateTools
import protobuf.message.MessageElement
import protobuf.message.element.FaceElement
import protobuf.message.element.JsonElement
import protobuf.message.element.TextElement
import java.nio.ByteBuffer

internal typealias IMessageElementMaker = suspend (Int, Long, String, JsonObject) -> Result<MessageElement>

internal object MessageElementMaker {
    private val makerArray = hashMapOf(
        "text" to MessageElementMaker::createTextElem,
        "face" to MessageElementMaker::createFaceElem,
//        "pic" to MessageElementMaker::createImageElem,
//        "image" to MessageElementMaker::createImageElem,
//        "voice" to MessageElementMaker::createRecordElem,
//        "record" to MessageElementMaker::createRecordElem,
        "at" to MessageElementMaker::createAtElem,
//        "video" to MessageElementMaker::createVideoElem,
//        "markdown" to MessageElementMaker::createMarkdownElem,
//        "dice" to MessageElementMaker::createDiceElem,
//        "rps" to MessageElementMaker::createRpsElem,
//        "poke" to MessageElementMaker::createPokeElem,
//        "anonymous" to MessageElementMaker::createAnonymousElem,
//        "share" to MessageElementMaker::createShareElem,
//        "contact" to MessageElementMaker::createContactElem,
//        "location" to MessageElementMaker::createLocationElem,
//        "music" to MessageElementMaker::createMusicElem,
//        "reply" to MessageElementMaker::createReplyElem,
//        "touch" to MessageElementMaker::createTouchElem,
//        "weather" to MessageElementMaker::createWeatherElem,
        "json" to MessageElementMaker::createJsonElem,
        //"new_dice" to MessageElementMaker::createNewDiceElem,
        //"new_rps" to MessageElementMaker::createNewRpsElem,
        //"basketball" to MessageElementMaker::createBasketballElem,
        //"node" to MessageMaker::createNodeElem,
        //"multi_msg" to MessageMaker::createLongMsgStruct,
        //"bubble_face" to MessageElementMaker::createBubbleFaceElem,
    )

    operator fun get(type: String): IMessageElementMaker? = makerArray[type]

    private suspend fun createTextElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<MessageElement> {
        data.checkAndThrow("text")
        val elem = MessageElement(
            text = TextElement(data["text"].asString)
        )
        return Result.success(elem)
    }

    private suspend fun createFaceElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<MessageElement> {
        data.checkAndThrow("id")
        val elem = MessageElement(
            face = FaceElement(data["id"].asInt)
        )
        return Result.success(elem)
    }

    private suspend fun createAtElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<MessageElement> {
        return if (chatType == MsgConstant.KCHATTYPEGROUP) {
            data.checkAndThrow("qq")

            val qq: Long
            val type: Int
            lateinit var display: String
            when (val qqStr = data["qq"].asString) {
                "0", "all" -> {
                    qq = 0
                    type = 1
                    display = "@全体成员"
                }

                "online" -> {
                    qq = 0
                    type = 64
                    display = "@在线成员"
                }

                else -> {
                    qq = qqStr.toLong()
                    type = 0
                    display =
                        "@" + (data["name"].asStringOrNull ?: GroupSvc.getTroopMemberInfoByUinV2(peerId, qqStr, true)
                            .onSuccess {
                                it.troopnick
                                    .ifEmpty { it.friendnick }
                                    .ifEmpty { qqStr }
                            }.onFailure {
                                LogCenter.log("无法获取群成员信息: $qqStr", Level.ERROR)
                            })
                }
            }

            val attr6: ByteBuffer = ByteBuffer.allocate(6)
            attr6.put(byteArrayOf(0, 1, 0, 0, 0))
            attr6.putChar(display.length.toChar())
            attr6.putChar(type.toChar())
            attr6.putBuf32Long(qq)
            attr6.put(byteArrayOf(0, 0))
            val elem = MessageElement(
                text = TextElement(text = display, attr6Buf = attr6.array())
            )
            Result.success(elem)
        } else if (chatType == MsgConstant.KCHATTYPEGUILD) {
            data.checkAndThrow("qq")

            val qq: Long
            val type: Int
            lateinit var display: String
            when (val qqStr = data["qq"].asString) {
                "0", "all" -> {
                    type = 2
                    display = "@全体成员"
                }

                else -> {
                    qq = qqStr.toLong()
                    type = 2
                    display =
                        "@" + (data["name"].asStringOrNull ?: GProSvc.getUserGuildInfo(0UL, 0UL)
                            .onSuccess {
                                it.nickName.ifNullOrEmpty(qqStr)
                            }.onFailure {
                                LogCenter.log("无法获取频道组成员信息: $qqStr", Level.ERROR)
                            })
                }
            }

            val elem = MessageElement(
                text = TextElement(text = display, pbReserve = TextElement.Companion.TextResvAttr(atType = type))
            )
            Result.success(elem)
        } else Result.failure(ActionMsgException)
    }

    private suspend fun createJsonElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<MessageElement> {
        data.checkAndThrow("data")

        val elem = MessageElement(
            json = JsonElement(
                data = DeflateTools.compress(data.toString().toByteArray())
            )
        )
        return Result.success(elem)
    }

    private fun JsonObject.checkAndThrow(vararg key: String) {
        key.forEach {
            if (!containsKey(it)) throw ParamsException(it)
        }
    }
}