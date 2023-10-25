package moe.fuqiuluo.shamrock.remote.entries

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndexData(
    var version: String,
    var startTime: Long,
    @SerialName("http_version") var httpVersion: String
)
