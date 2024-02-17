package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Credentials(
    @SerialName("token") val bkn: String = "",
    @SerialName("cookies") val cookie: String = "",
    @SerialName("bigdata_ticket") val bigDataTicket: BigDataTicket? = null
)

@Serializable
data class BigDataTicket(
    var key: String? = null,
    var sig: String? = null
)