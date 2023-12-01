package moe.fuqiuluo.shamrock.helper

internal abstract class InternalMessageMakerError(why: String): RuntimeException(why)

internal class ParamsException(key: String): InternalMessageMakerError("Lack of param $key")

internal class IllegalParamsException(key: String): InternalMessageMakerError("Illegal param $key")

internal object ActionMsgException: InternalMessageMakerError("action msg")

internal class LogicException(why: String) : InternalMessageMakerError(why)

internal object ErrorTokenException : InternalMessageMakerError("access_token error")

internal class SendMsgException(why: String) : InternalMessageMakerError(why)
