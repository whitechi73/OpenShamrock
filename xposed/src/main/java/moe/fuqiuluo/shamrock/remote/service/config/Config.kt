package moe.fuqiuluo.shamrock.remote.service.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceConfig(
    @SerialName("rules") val rules: Rules? = null,
    @SerialName("default_token") var defaultToken: String? = null,
    @SerialName("active_websocket") var activeWebSocket: ConnectionConfig? = null,
    @SerialName("passive_websocket") var passiveWebSocket: MutableList<ConnectionConfig>? = null,
    @SerialName("allow-temp-session") var allowTempSession: Boolean = false,
    @SerialName("anti_qq_trace") var antiTrace: Boolean = true
)

@Serializable
data class ConnectionConfig(
    @SerialName("address") val address: String? = null,
    @SerialName("port") var port: Int? = null,
    @SerialName("token") val token: String? = null,
    @SerialName("tokens") val tokens: List<String>? = null,
    @SerialName("heartbeat_interval") var heartbeatInterval: Long? = null,
)

@Serializable
data class Rules(
    @SerialName("group_rule") val groupRule: GroupRule? = null,
    @SerialName("private_rule") val privateRule: PrivateRule? = null
)

@Serializable
data class GroupRule(
    @SerialName("black_list") val black: List<Long>? = null,
    @SerialName("white_list") val white: List<Long>? = null,
)

@Serializable
data class PrivateRule(
    @SerialName("black_list") val black: List<Long>? = null,
    @SerialName("white_list") val white: List<Long>? = null,
)