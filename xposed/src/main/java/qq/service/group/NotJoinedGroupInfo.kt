package qq.service.group

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NotJoinedGroupInfo(
    @SerialName("group_id") val groupId: Long,
    @SerialName("max_member_cnt") val maxMember: Int,
    @SerialName("member_count") val memberCount: Int,
    @SerialName("group_name") val groupName: String,
    @SerialName("group_desc") val groupDesc: String,
    @SerialName("owner") val owner: Long,
    @SerialName("create_time") val createTime: Long,
    @SerialName("group_flag") val groupFlag: Int,
    @SerialName("group_flag_ext") val groupFlagExt: Int,
)