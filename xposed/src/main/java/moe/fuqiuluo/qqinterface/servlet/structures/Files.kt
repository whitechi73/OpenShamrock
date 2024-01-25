package moe.fuqiuluo.qqinterface.servlet.structures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileUrl(
    @SerialName("url") val url: String,
)

@Serializable
data class GroupFileList(
    @SerialName("files") val files: List<FileInfo>,
    @SerialName("folders") val folders: List<FolderInfo>,
)

@Serializable
data class FileInfo(
    @SerialName("group_id") val groupId: Long,
    @SerialName("file_id") val fileId: String,
    @SerialName("file_name") val fileName: String,
    @SerialName("file_size") val fileSize: Long,
    @SerialName("busid") val busid: Int,
    @SerialName("upload_time") val uploadTime: Int,
    @SerialName("dead_time") val deadTime: Int,
    @SerialName("modify_time") val modifyTime: Int,
    @SerialName("download_times") val downloadTimes: Int,
    @SerialName("uploader") val uploadUin: Long,
    @SerialName("upload_name") val uploadNick: String,
    @SerialName("sha") val sha: String,
    @SerialName("sha3") val sha3: String,
    @SerialName("md5") val md5: String,

)

@Serializable
data class FolderInfo(
    @SerialName("group_id") val groupId: Long,
    @SerialName("folder_id") val folderId: String,
    @SerialName("folder_name") val folderName: String,
    @SerialName("total_file_count") val totalFileCount: Int,
    @SerialName("create_time") val createTime: Int,
    @SerialName("creator") val creator: Long,
    @SerialName("creator_name") val creatorNick: String,
)

@Serializable
data class FileSystemInfo(
    @SerialName("file_count") val fileCount: Int,
    @SerialName("limit_count") val fileLimitCount: Int,
    @SerialName("used_space") val usedSpace: Long,
    @SerialName("total_space") val totalSpace: Long,
)