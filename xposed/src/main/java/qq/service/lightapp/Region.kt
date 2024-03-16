package qq.service.lightapp

import kotlinx.serialization.Serializable

@Serializable
internal data class Region(
    val adcode: Int,
    val province: String?,
    val city: String?
)