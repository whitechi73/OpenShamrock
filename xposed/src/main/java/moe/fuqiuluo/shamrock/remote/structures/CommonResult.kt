package moe.fuqiuluo.shamrock.remote.structures

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

enum class Status(
    val code: Int
) {
    Ok(0),
    BadRequest(10001),
    ErrorToken(403),
    UnsupportedAction(10002),
    BadParam(10003),
    UnsupportedParam(10004),
    UnsupportedSegment(10005),
    UnsupportedSegmentData(10007),
    BadSegmentData(10006),
    WhoAmI(10101),
    UnknownSelf(10102),
    BadHandler(20001),
    InternalHandlerError(20002),
    DatabaseError(31000),
    FilesystemError(32000),
    NetworkError(33000),
    PlatformError(34000),
    LogicError(35000),
    IAmTired(36000),
}

@Serializable
data class CommonResult<T>(
    var status: String,
    var retcode: Int,
    @Contextual
    var data: T,
    var message: String = "",
    var echo: JsonElement? = null
)

@Serializable
object EmptyObject

internal inline fun <reified T: Any> resultToString(
    isOk: Boolean,
    code: Status,
    data: T,
    msg: String = "",
    echo: JsonElement
): String {
    return Json.encodeToString(
        CommonResult(if (isOk) "ok" else "failed", code.code, data, msg, echo)
    )
}