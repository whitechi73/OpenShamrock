package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.VersionInfo
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.ShamrockVersion

internal object GetVersionInfo : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(session.echo)
    }

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        return ok(
            VersionInfo(
                appFullName = "Shamrock v$ShamrockVersion",
                appName = "Shamrock",
                appVersion = ShamrockVersion,
                impl = "shamrock",
                version = ShamrockVersion,
                onebotVersion = "11",
            ),
            echo = echo
        )
    }

    override val alias: Array<String> = arrayOf("get_version")

    override fun path(): String = "get_version_info"

}