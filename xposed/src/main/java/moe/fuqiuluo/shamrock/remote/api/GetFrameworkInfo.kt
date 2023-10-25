package moe.fuqiuluo.shamrock.remote.api

import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import kotlinx.coroutines.delay
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.tools.respond
import moe.fuqiuluo.shamrock.helper.LogCenter
import kotlin.system.exitProcess

fun Routing.obtainFrameworkInfo() {
    getOrPost("/get_start_time") {
        respond(
            isOk = true,
            code = Status.Ok,
            moe.fuqiuluo.shamrock.remote.HTTPServer.startTime
        )
    }

    get("/shut") {
        moe.fuqiuluo.shamrock.remote.HTTPServer.stop()
        LogCenter.log("正在关闭Shamrock。", toast = true)
        delay(3000)
        exitProcess(0)
    }
}
