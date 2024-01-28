package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.Serializable
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import de.robv.android.xposed.XposedBridge.log
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.remote.structures.resultToString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("test")
internal object TestHandler: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        kotlin.runCatching {
            val msg = StringBuffer()
            return resultToString(
                isOk = true,
                code = Status.Ok,
                data = Test(System.currentTimeMillis()),
                msg = msg.toString(),
                echo = session.echo
            )
        }.onFailure {
            log(it)
        }
        return "error"
    }

    @Serializable
    data class Test(val time: Long)
}