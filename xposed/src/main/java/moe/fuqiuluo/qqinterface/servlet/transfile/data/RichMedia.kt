package moe.fuqiuluo.qqinterface.servlet.transfile.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TryUpPicData(
    @SerialName("ukey") val uKey: ByteArray,
    @SerialName("exist") val exist: Boolean,
    @SerialName("file_id") val fileId: ULong,
    @SerialName("up_ip") var upIp: ArrayList<Long>? = null,
    @SerialName("up_port") var upPort: ArrayList<Int>? = null,
)