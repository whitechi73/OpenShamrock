package moe.fuqiuluo.shamrock.remote.entries

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentAccount(
    var uin: Long,
    var isLogin: Boolean,
    var nick: String = ""
)

@Serializable
data class StdAccount(
    @SerialName("user_id") var userId: Long,
    @SerialName("nickname") var nick: String = ""
)