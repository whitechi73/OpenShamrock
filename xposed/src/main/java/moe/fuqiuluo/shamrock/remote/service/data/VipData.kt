package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VipInfo(
    val type: VipType,
    val level: Int,
    @SerialName("vip_type") val vipType: Int,
    @SerialName("template_id") val templateId: Long
)

enum class VipType {
    QQ_VIP,
    SUPER_QQ,
    SUPER_VIP,
    QQ_VIDEO,
    QQ_READING,
    BIG_VIP,
    YELLOW_VIP
}