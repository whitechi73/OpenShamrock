package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Credentials(
    @SerialName("token") val bkn: String = "",
    @SerialName("cookies") val cookie: String = ""
)