package moe.fuqiuluo.shamrock.tools

import io.github.xn32.json5k.Json5
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long

val EmptyJsonObject = JsonObject(emptyMap())
val EmptyJsonArray = JsonArray(emptyList())
val EmptyJsonString = "".json

val GlobalJson = Json {
    ignoreUnknownKeys = true // 忽略未知key
    isLenient = true // 宽松模式
    allowSpecialFloatingPointValues = true // 允许特殊浮点数值（如NaN）
    encodeDefaults = false // 不编码默认值
    prettyPrint = false // 格式化输出
    coerceInputValues = true // 强制输入值
}


val GlobalJson5 = Json5 {
    prettyPrint = true
    indentationWidth = 2
    //useSingleQuotes = true
    //quoteMemberNames = true
    //encodeDefaults = true
}

val String.asJson: JsonElement
    get() = Json.parseToJsonElement(this)

val String.asJsonObject: JsonObject
    get() = Json.parseToJsonElement(this).asJsonObject

val Collection<Any>.json: JsonArray
    get() {
        val arrayList = arrayListOf<JsonElement>()
        forEach {
            if (it != null) {
                when (it) {
                    is JsonElement -> arrayList.add(it)
                    is Number -> arrayList.add(it.json)
                    is String -> arrayList.add(it.json)
                    is Boolean -> arrayList.add(it.json)
                    is Map<*, *> -> arrayList.add((it as Map<String, Any>).json)
                    is Collection<*> -> arrayList.add((it as Collection<Any>).json)
                    else -> error("unknown array type: ${it::class.java}")
                }
            }
        }
        return arrayList.jsonArray
    }

val Map<String, Any>.json: JsonObject
    get() {
        val map = hashMapOf<String, JsonElement>()
        forEach { (key, any) ->
            when (any) {
                is JsonElement -> map[key] = any
                is Number -> map[key] = any.json
                is String -> map[key] = any.json
                is Boolean -> map[key] = any.json
                is Map<*, *> -> map[key] = (any as Map<String, Any>).json
                is Collection<*> -> map[key] = (any as Collection<Any>).json
                else -> error("unknown object type: ${any::class.java}")
            }
        }
        return map.jsonObject
    }

val Map<String, JsonElement>.jsonObject: JsonObject
    get() = JsonObject(this)

val Collection<JsonElement>.jsonArray: JsonArray
    get() = JsonArray(this.toList())

val Boolean.json: JsonPrimitive
    get() = JsonPrimitive(this)

val String.json: JsonPrimitive
    get() = JsonPrimitive(this)

val Number.json: JsonPrimitive
    get() = JsonPrimitive(this)

val JsonElement?.asString: String
    get() = this!!.jsonPrimitive.content

val JsonElement?.asStringOrNull: String?
    get() = this?.jsonPrimitive?.content

val JsonElement?.asInt: Int
    get() = this!!.jsonPrimitive.int

val JsonElement?.asLong: Long
    get() = this!!.jsonPrimitive.long

val JsonElement?.asLongOrNull: Long?
    get() = this?.jsonPrimitive?.long

val JsonElement?.asIntOrNull: Int?
    get() = this?.jsonPrimitive?.int

val JsonElement?.asBoolean: Boolean
    get() = this!!.jsonPrimitive.boolean

val JsonElement?.asBooleanOrNull: Boolean?
    get() = this?.jsonPrimitive?.booleanOrNull

inline val JsonElement?.asJsonObject: JsonObject
    get() = this!!.jsonObject

inline val JsonElement?.asJsonObjectOrNull: JsonObject?
    get() = this?.jsonObject

inline val JsonElement?.asJsonArray: JsonArray
    get() = this!!.jsonArray

inline val JsonElement?.asJsonArrayOrNull: JsonArray?
    get() = this?.jsonArray