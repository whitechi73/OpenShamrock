package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.qqguildsdk.api.IGPSService
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ

internal object GetGuildServiceProfile: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        TODO("Not yet implemented")
    }

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        val service = AppRuntimeFetcher.appRuntime
            .getRuntimeService(IGPSService::class.java, "all")
        if (!service.isGProSDKInitCompleted) {
            return error("GPro服务没有初始化", echo = echo)
        }

        val tinyId = service.selfTinyId

        return ok(echo = echo)
    }

    override fun path(): String = "get_guild_service_profile"
}