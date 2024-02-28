package moe.fuqiuluo.qqinterface.servlet.msg

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import moe.fuqiuluo.shamrock.tools.json


internal data class MessageSegment(
    val type: String,
    val data: Map<String, Any?> = emptyMap()
) {
    fun toJson(): JsonObject {
        return mapOf(
            "type" to type,
            "data" to data
        ).json
    }
}

internal fun List<MessageSegment>.toJson(): JsonArray {
    return this.map {
        it.toJson()
    }.json
}

internal fun List<MessageSegment>.toListMap(): List<Map<String, JsonElement>> {
    return this.map {
        mapOf(
            "type" to it.type.json,
            "data" to it.data.json
        )
    }
}