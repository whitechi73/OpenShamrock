package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class FriendEntry(
    @SerialName("user_id") val id: Long = 0,
    @SerialName("user_name") val name: String?,
    @SerialName("user_displayname") val displayName: String?,
    @SerialName("user_remark") val remark: String?,
    val age: Int,
    val gender: Byte,
    @SerialName("group_id") val groupId: Int,
    @SerialName("platform") val platformType: PlatformType,
    @SerialName("term_type") val termType: Int,
)


@Serializable
internal data class FriendRequest(
    @SerialName("request_id") val seq: Long = 0,
    @SerialName("requester_uin") val userId: Long = 0,
    @SerialName("requester_nick") val name: String?,
    val source: String?,
    @SerialName("sub_id") val subId: Int?,
    @SerialName("sub_src_id") val subSrcId: Int?,
    @SerialName("message") val msg: String?,
    @SerialName("source_group_name") val sourceGroupName: String?,
    @SerialName("source_group_id") val sourceGroupCode: Long?,
    val flag: String,
    val sex: String?,
    val age: Int?,
    @SerialName("msg_detail") val msgDetail: String?,
    val status: String?,

)