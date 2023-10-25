package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.PlatformUtils

internal object GetDeviceBattery: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(session.echo)
    }

    override fun path(): String = "get_device_battery"

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        return ok(PlatformUtils.getDeviceBattery(), echo = echo)
    }
}