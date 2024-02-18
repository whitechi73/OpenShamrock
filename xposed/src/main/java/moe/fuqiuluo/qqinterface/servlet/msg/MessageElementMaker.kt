package moe.fuqiuluo.qqinterface.servlet.msg

import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.shamrock.helper.ParamsException
import moe.fuqiuluo.shamrock.tools.asInt
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import protobuf.message.MessageElement
import protobuf.message.element.FaceElement
import protobuf.message.element.TextElement


internal typealias IMessageMaker = suspend (Int, Long, String, JsonObject) -> Result<MessageElement>

internal object MessageElementMaker {
    private val makerArray = hashMapOf(
        "text" to MessageElementMaker::createTextElem,
        "face" to MessageElementMaker::createFaceElem,
//        "pic" to MessageElementMaker::createImageElem,
//        "image" to MessageElementMaker::createImageElem,
//        "voice" to MessageElementMaker::createRecordElem,
//        "record" to MessageElementMaker::createRecordElem,
//        "at" to MessageElementMaker::createAtElem,
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

    private suspend fun createJsonElem(
        chatType: Int,
        msgId: Long,
        peerId: String,
        data: JsonObject
    ): Result<MessageElement> {
        data.checkAndThrow("data")

        val elem = MessageElement(
            json = protobuf.message.element.JsonElement(
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

    operator fun get(type: String): IMessageMaker? = makerArray[type]

}
