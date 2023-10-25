package moe.fuqiuluo.shamrock.remote.service.data.profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.fuqiuluo.shamrock.remote.service.data.VipInfo

@Serializable
data class ProfileCard(
    @SerialName("user_id") val uin: Long,
    @SerialName("user_name") val name: String,
    @SerialName("user_displayname") val displayName: String?,
    @SerialName("user_remark") val remark: String?,
    @SerialName("mail") val mail: String?,
    @SerialName("find_method") val findMethod: String?,
    @SerialName("max_vote_cnt") val maxVoteCnt: Short,
    @SerialName("have_vote_cnt") val haveVoteCnt: Short,
    @SerialName("vip_list") val vipList: List<VipInfo>,
    @SerialName("hobby_entry") val hobbyEntry: String?,
    @SerialName("level") val level: Int,
    @SerialName("birthday") val birthday: Long,
    @SerialName("login_day") val loginDay: Long,
    @SerialName("vote_cnt") val voteCnt: Long,
    @SerialName("qid") val qid: String,
    @SerialName("is_school_verified") val schoolVerified: Boolean,
    @SerialName("location") val location: Location,
    @SerialName("cookie") val cookie: ByteArray,
)

@Serializable
data class Location(
    val city: String?,
    val company: String?,
    val country: String?,
    val province: String?,
    val hometown: String?,
    val school: String?
)
