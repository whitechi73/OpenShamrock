package moe.fuqiuluo.qqinterface.servlet.entries

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProhibitedMemberInfo(
    @SerialName("user_id") val memberUin: Long,
    @SerialName("time") val shutuptimestap: Int
)

@Serializable
internal data class GroupAtAllRemainInfo(
    @SerialName("can_at_all") val canAtAll: Boolean,
    @SerialName("remain_at_all_count_for_group") val remainAtAllCountForGroup: Int,
    @SerialName("remain_at_all_count_for_uin") val remainAtAllCountForUin: Int
)