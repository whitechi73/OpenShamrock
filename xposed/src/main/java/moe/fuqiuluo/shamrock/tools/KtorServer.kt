package moe.fuqiuluo.shamrock.tools

import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.request.contentType
import io.ktor.server.request.receiveParameters
import io.ktor.server.request.receiveText
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.util.AttributeKey
import io.ktor.util.pipeline.PipelineContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import moe.fuqiuluo.shamrock.helper.ParamsException
import io.ktor.http.HttpMethod
import io.ktor.http.parseUrlEncodedParameters
import io.ktor.server.request.httpMethod
import io.ktor.server.routing.route
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.entries.CommonResult
import moe.fuqiuluo.shamrock.remote.entries.EmptyObject
import moe.fuqiuluo.shamrock.remote.entries.Status

@DslMarker
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
annotation class ShamrockDsl


private val keyIsJson = AttributeKey<Boolean>("isJson")
private val keyJsonObject = AttributeKey<JsonObject>("paramsJson")
private val keyParts = AttributeKey<Parameters>("paramsParts")

suspend fun ApplicationCall.fetch(key: String): String {
    val isPost = request.httpMethod == HttpMethod.Post
    return if (isPost) {
        fetchPost(key)
    } else {
        fetchGet(key)
    }
}

suspend fun ApplicationCall.fetchOrNull(key: String): String? {
    val isPost = request.httpMethod == HttpMethod.Post
    return if (isPost) {
        fetchPostOrNull(key)
    } else {
        fetchGetOrNull(key)
    }
}

suspend fun ApplicationCall.fetchOrThrow(key: String): String {
    val isPost = request.httpMethod == HttpMethod.Post
    return if (isPost) {
        fetchPostOrThrow(key)
    } else {
        fetchGetOrThrow(key)
    }
}

fun ApplicationCall.fetchGet(key: String): String {
    return parameters[key]!!
}

fun ApplicationCall.fetchGetOrNull(key: String): String? {
    return parameters[key]
}

fun ApplicationCall.fetchGetOrThrow(key: String): String {
    return parameters[key] ?: throw ParamsException(key)
}

suspend fun ApplicationCall.fetchPost(key: String): String {
    return fetchPostOrNull(key)!!
}

suspend fun ApplicationCall.fetchPostOrThrow(key: String): String {
    return fetchPostOrNull(key) ?: throw ParamsException(key)
}

fun ApplicationCall.isJsonData(): Boolean {
    return ContentType.Application.Json == request.contentType() || ContentType.Application.ProblemJson == request.contentType()
}

suspend fun ApplicationCall.fetchPostOrNull(key: String): String? {
    if (attributes.contains(keyJsonObject)) {
        return attributes[keyJsonObject][key].asStringOrNull
    }
    if (attributes.contains(keyParts)) {
        return attributes[keyParts][key]
    }
    return kotlin.runCatching {
        if (isJsonData()) {
            Json.parseToJsonElement(receiveText()).jsonObject.also {
                attributes.put(keyJsonObject, it)
                attributes.put(keyIsJson, true)
            }[key].asStringOrNull
        } else if (
            ContentType.Application.FormUrlEncoded == request.contentType()
        ) {
            receiveParameters().also {
                attributes.put(keyParts, it)
            }[key]
        } else {
            receiveTextAsUnknown(key)
        }
    }.getOrElse {
        throw IllegalArgumentException("JSON数据格式不合法")
    }
}

private suspend fun ApplicationCall.receiveTextAsUnknown(key: String): String? {
    return receiveText().let { text ->
        if (text.startsWith("{") && text.endsWith("}")) {
            Json.parseToJsonElement(text).jsonObject.also {
                attributes.put(keyJsonObject, it)
                attributes.put(keyIsJson, true)
            }[key].asStringOrNull
        } else {
            text.parseUrlEncodedParameters().also {
                attributes.put(keyParts, it)
                attributes.put(keyIsJson, false)
            }[key]
        }
    } // receiveText
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetch(key: String): String {
    return call.fetch(key)
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchOrNull(key: String): String? {
    return call.fetchOrNull(key)
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchOrThrow(key: String): String {
    return call.fetchOrThrow(key)
}

fun PipelineContext<Unit, ApplicationCall>.fetchGet(key: String): String {
    return call.parameters[key]!!
}

fun PipelineContext<Unit, ApplicationCall>.fetchGetOrNull(key: String): String? {
    return call.parameters[key]
}

fun PipelineContext<Unit, ApplicationCall>.fetchGetOrThrow(key: String): String {
    return call.parameters[key] ?: throw ParamsException(key)
}


suspend fun PipelineContext<Unit, ApplicationCall>.fetchPost(key: String): String {
    return fetchPostOrNull(key)!!
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostOrThrow(key: String): String {
    return fetchPostOrNull(key) ?: throw ParamsException(key)
}

fun PipelineContext<Unit, ApplicationCall>.isJsonData(): Boolean {
    return ContentType.Application.Json == call.request.contentType() || (keyIsJson in call.attributes && call.attributes[keyIsJson])
}

suspend fun PipelineContext<Unit, ApplicationCall>.isJsonString(key: String): Boolean {
    if (!isJsonData()) return true
    val data = if (keyJsonObject in call.attributes) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
            call.attributes.put(keyIsJson, true)
        }
    }
    return data[key] is JsonPrimitive
}

suspend fun PipelineContext<Unit, ApplicationCall>.isJsonObject(key: String): Boolean {
    if (!isJsonData()) return false
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
        }
    }
    return data[key] is JsonObject
}

suspend fun PipelineContext<Unit, ApplicationCall>.isJsonArray(key: String): Boolean {
    if (!isJsonData()) return false
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
        }
    }
    return data[key] is JsonArray
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostJsonString(key: String): String {
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
        }
    }
    return data[key].asString
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostJsonElement(key: String): JsonElement {
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
        }
    }
    return data[key]!!
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostJsonObject(key: String): JsonObject {
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
        }
    }
    return data[key].asJsonObject
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostJsonObjectOrNull(key: String): JsonObject? {
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
        }
    }
    return data[key].asJsonObjectOrNull
}


suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostJsonArray(key: String): JsonArray {
    val data = if (call.attributes.contains(keyJsonObject)) {
        call.attributes[keyJsonObject]
    } else {
        Json.parseToJsonElement(call.receiveText()).jsonObject.also {
            call.attributes.put(keyJsonObject, it)
            call.attributes.put(keyIsJson, true)
        }
    }
    return data[key].asJsonArray
}

suspend fun PipelineContext<Unit, ApplicationCall>.fetchPostOrNull(key: String): String? {
    return call.fetchPostOrNull(key)
}

@io.ktor.util.KtorDsl
fun Routing.getOrPost(path: String, body: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit) {
    route(path) {
        get(body)
        post(body)
    }
}

@io.ktor.util.KtorDsl
fun Routing.getOrPost(path: Regex, body: suspend PipelineContext<Unit, ApplicationCall>.(Unit) -> Unit) {
    route(path) {
        get(body)
        post(body)
    }
}

@ShamrockDsl
internal suspend inline fun PipelineContext<Unit, ApplicationCall>.respond(
    isOk: Boolean,
    code: Status,
    msg: String = "",
    echo: JsonElement = EmptyJsonString
) {
    call.respond(CommonResult(
        if (isOk) "ok" else "failed",
        code.code,
        EmptyObject,
        msg,
        echo
    ))
}

@ShamrockDsl
internal suspend inline fun <reified T : Any> PipelineContext<Unit, ApplicationCall>.respond(
    isOk: Boolean,
    code: Status,
    data: T,
    msg: String = "",
    echo: JsonElement = EmptyJsonString
) {
    call.respond(CommonResult(
        if (isOk) "ok" else "failed",
        code.code,
        data,
        msg,
        echo
    ))
}

@ShamrockDsl
internal suspend inline fun <reified T : Any> PipelineContext<Unit, ApplicationCall>.respond(
    isOk: Boolean,
    code: Int,
    data: T,
    msg: String = "",
    echo: JsonElement = EmptyJsonString
) {
    call.respond(CommonResult(
        if (isOk) "ok" else "failed",
        code,
        data,
        msg,
        echo
    ))
}