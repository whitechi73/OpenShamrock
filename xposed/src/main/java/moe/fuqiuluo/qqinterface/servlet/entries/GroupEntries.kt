package moe.fuqiuluo.qqinterface.servlet.entries

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProhibitedMemberInfo(
    @SerialName("user_id") val memberUin: Long,
    @SerialName("time") val shutuptimestap: Int
)