package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.request.httpVersion
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import moe.fuqiuluo.shamrock.remote.HTTPServer
import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.config.ECHO_KEY
import moe.fuqiuluo.shamrock.remote.entries.EmptyObject
import moe.fuqiuluo.shamrock.remote.entries.IndexData
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.tools.EmptyJsonObject
import moe.fuqiuluo.shamrock.tools.fetchOrNull
import moe.fuqiuluo.shamrock.tools.fetchOrThrow
import moe.fuqiuluo.shamrock.tools.fetchPostJsonElement
import moe.fuqiuluo.shamrock.tools.fetchPostJsonObject
import moe.fuqiuluo.shamrock.tools.fetchPostJsonObjectOrNull
import moe.fuqiuluo.shamrock.tools.isJsonArray
import moe.fuqiuluo.shamrock.tools.isJsonObject
import moe.fuqiuluo.shamrock.tools.isJsonString
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.respond
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import mqq.app.MobileQQ

@Serializable
data class OldApiResult<T>(
    val code: Int,
    val msg: String = "",
    @Contextual
    val data: T? = null
)

fun Routing.echoVersion() {
    route("/") {
        get {
            respond(
                isOk = true,
                code = Status.Ok,
                data = IndexData(PlatformUtils.getClientVersion(MobileQQ.getContext()), HTTPServer.startTime, call.request.httpVersion)
            )
        }
        post {
            val action = fetchOrThrow("action")
            val echo = if (isJsonObject("echo") || isJsonArray("echo")) {
                fetchPostJsonElement("echo")
            } else {
                (fetchOrNull("echo") ?: "").json
            }
            call.attributes.put(ECHO_KEY, echo)

            val params = fetchPostJsonObjectOrNull("params") ?: EmptyJsonObject

            val handler = ActionManager[action]
            if (handler == null) {
                respond(false, Status.UnsupportedAction, EmptyObject, "不支持的Action", echo = echo)
            } else {
                call.respondText(handler.handle(ActionSession(params, echo)), ContentType.Application.Json)
            }
        }
    }
}