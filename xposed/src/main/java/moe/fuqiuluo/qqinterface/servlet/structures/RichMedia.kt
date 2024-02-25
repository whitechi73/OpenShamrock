package moe.fuqiuluo.qqinterface.servlet.structures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UploadResult(
    @SerialName("files") val files: List<CommFileInfo>
)

@Serializable
data class CommFileInfo(
    @SerialName("mode_id") val modeId: Long,
    @SerialName("name") val fileName: String,
    @SerialName("size") val fileSize: Long,
    @SerialName("md5") val md5: String,
    @SerialName("uuid") val uuid: String,
    @SerialName("sub_id") val subId: String,
    @SerialName("sha") val sha: String,
)