package moe.fuqiuluo.shamrock.remote.api

import com.tencent.mobileqq.qqguildsdk.api.IGPSService
import com.tencent.qqnt.kernel.nativeinterface.GProRetentionGuildListRsp
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchRetentionGuildListCallback
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildListener
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.remote.entries.EmptyObject
import moe.fuqiuluo.shamrock.remote.service.listener.KernelGuildListener
import moe.fuqiuluo.shamrock.tools.getOrPost
import moe.fuqiuluo.shamrock.tools.respond
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import mqq.app.MobileQQ

fun Routing.guildAction() {
    getOrPost("/get_guild_service_profile") {
        val service = AppRuntimeFetcher.appRuntime
            .getRuntimeService(IGPSService::class.java, "all")
        val tinyId = service.selfTinyId

    }

    getOrPost("/refresh_guild_list") {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val guildService = sessionService.guildService
        guildService.refreshGuildList(true)
        respond(false, -100, msg = "测试接口", data = EmptyObject)
    }

    getOrPost("/get_guild_list") {

        call.respondText("ok")
    }
}