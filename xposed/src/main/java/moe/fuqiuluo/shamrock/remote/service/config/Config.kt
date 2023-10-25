package moe.fuqiuluo.shamrock.remote.service.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceConfig(
    @SerialName("group_rule") val groupRule: GroupRule? = null,
    @SerialName("private_rule") val privateRule: PrivateRule? = null,
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