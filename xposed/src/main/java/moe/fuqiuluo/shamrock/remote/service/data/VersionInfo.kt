package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionInfo(
    @SerialName("app_full_name")
    val appFullName: String,
    @SerialName("app_name")
    val appName: String,
    @SerialName("app_version")
    val appVersion: String,
    val impl: String,
    val version: String,
    @SerialName("onebot_version")
    val onebotVersion: String
)
