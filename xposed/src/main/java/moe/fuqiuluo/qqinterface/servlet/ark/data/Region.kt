package moe.fuqiuluo.qqinterface.servlet.ark.data

import kotlinx.serialization.Serializable

@Serializable
internal data class Region(
    val adcode: Int,
    val province: String?,
    val city: String?
)