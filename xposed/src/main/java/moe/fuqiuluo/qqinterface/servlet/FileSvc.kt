package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.pb.ByteStringMicro
import io.ktor.util.Deflate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.fuqiuluo.proto.protobufOf
import moe.fuqiuluo.qqinterface.servlet.transfile.RichProtoSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8
import tencent.im.oidb.oidb_sso

internal object FileSvc: BaseSvc() {
    fun createFileFolder(groupId: String, folderName: String) {
        sendOidb("OidbSvc.0x6d7_0", 1751, 0, protobufOf(
            1 to mapOf(
                1 to groupId.toLong(),
                2 to 3,
                3 to "/",
                4 to folderName
            )
        ).toByteArray())
    }

    fun deleteGroupFolder(groupId: String, folderUid: String) {
        sendOidb("OidbSvc.0x6d7_1", 1751, 1, protobufOf(
            2 to mapOf(
                1 to groupId.toLong(),
                2 to 3,
                3 to folderUid,
            )
        ).toByteArray())
    }

    fun deleteGroupFile(groupId: String, bizId: Int, fileUid: String) {
        sendOidb("OidbSvc.0x6d6_3", 1750, 3, protobufOf(
            4 to mapOf(
                1 to groupId.toLong(),
                2 to 3,
                3 to bizId,
                4 to "/",
                5 to fileUid
            )
        ).toByteArray())
    }

    suspend fun getGroupFileSystemInfo(groupId: Long): FileSystemInfo {
        val rspGetFileCntBuffer = sendOidbAW("OidbSvc.0x6d8_1", 1752, 2, oidb_0x6d8.ReqBody().also {
            it.group_file_cnt_req.set(oidb_0x6d8.GetFileCountReqBody().also {
                it.uint64_group_code.set(groupId)
                it.uint32_app_id.set(3)
                it.uint32_bus_id.set(0)
            })
        }.toByteArray())
        val fileCnt: Int
        val limitCnt: Int
        if (rspGetFileCntBuffer != null) {
            oidb_0x6d8.RspBody().mergeFrom(oidb_sso.OIDBSSOPkg()
                .mergeFrom(rspGetFileCntBuffer.slice(4))
                .bytes_bodybuffer.get()
                .toByteArray()
            ).group_file_cnt_rsp.apply {
                fileCnt = uint32_all_file_count.get()
                limitCnt = uint32_limit_count.get()
            }
        } else {
            throw RuntimeException("获取群文件数量失败")
        }

        val rspGetFileSpaceBuffer = sendOidbAW("OidbSvc.0x6d8_1", 1752, 3, oidb_0x6d8.ReqBody().also {
            it.group_space_req.set(oidb_0x6d8.GetSpaceReqBody().apply {
                uint64_group_code.set(groupId)
                uint32_app_id.set(3)
            })
        }.toByteArray())
        val totalSpace: Long
        val usedSpace: Long
        if (rspGetFileSpaceBuffer != null) {
            oidb_0x6d8.RspBody().mergeFrom(oidb_sso.OIDBSSOPkg()
                .mergeFrom(rspGetFileSpaceBuffer.slice(4))
                .bytes_bodybuffer.get()
                .toByteArray()).group_space_rsp.apply {
                totalSpace = uint64_total_space.get()
                usedSpace = uint64_used_space.get()
            }
        } else {
            throw RuntimeException("获取群文件空间失败")
        }

        return FileSystemInfo(
            fileCnt, limitCnt, usedSpace, totalSpace
        )
    }

    suspend fun getGroupRootFiles(groupId: Long): Result<GroupFileList> {
        return getGroupFiles(groupId, "/")
    }

    suspend fun getGroupFileInfo(groupId: Long, fileId: String, busid: Int): FileUrl {
        return FileUrl(RichProtoSvc.getGroupFileDownUrl(groupId, fileId, busid))
    }

    suspend fun getGroupFiles(groupId: Long, folderId: String): Result<GroupFileList> {
        val fileSystemInfo = getGroupFileSystemInfo(groupId)
        val rspGetFileListBuffer = sendOidbAW("OidbSvc.0x6d8_1", 1752, 1, oidb_0x6d8.ReqBody().also {
            it.file_list_info_req.set(oidb_0x6d8.GetFileListReqBody().apply {
                uint64_group_code.set(groupId)
                uint32_app_id.set(3)
                str_folder_id.set(folderId)

                uint32_file_count.set(fileSystemInfo.fileCount)
                uint32_all_file_count.set(0)
                uint32_req_from.set(3)
                uint32_sort_by.set(oidb_0x6d8.GetFileListReqBody.SORT_BY_TIMESTAMP)

                uint32_filter_code.set(0)
                uint64_uin.set(0)

                uint32_start_index.set(0)

                bytes_context.set(ByteStringMicro.copyFrom(EMPTY_BYTE_ARRAY))

                uint32_show_onlinedoc_folder.set(0)
            })
        }.toByteArray(), timeout = 15_000L)

        return kotlin.runCatching {
            val files = arrayListOf<FileInfo>()
            val dirs = arrayListOf<FolderInfo>()
            if (rspGetFileListBuffer != null) {
                val oidb = oidb_sso.OIDBSSOPkg().mergeFrom(rspGetFileListBuffer.slice(4).let {
                    if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
                })

                oidb_0x6d8.RspBody().mergeFrom(oidb.bytes_bodybuffer.get().toByteArray())
                    .file_list_info_rsp.apply {
                    rpt_item_list.get().forEach { file ->
                        if (file.uint32_type.get() == oidb_0x6d8.GetFileListRspBody.TYPE_FILE) {
                            val fileInfo = file.file_info
                            files.add(FileInfo(
                                groupId = groupId,
                                fileId = fileInfo.str_file_id.get(),
                                fileName = fileInfo.str_file_name.get(),
                                fileSize = fileInfo.uint64_file_size.get(),
                                busid = fileInfo.uint32_bus_id.get(),
                                uploadTime = fileInfo.uint32_upload_time.get(),
                                deadTime = fileInfo.uint32_dead_time.get(),
                                modifyTime = fileInfo.uint32_modify_time.get(),
                                downloadTimes = fileInfo.uint32_download_times.get(),
                                uploadUin = fileInfo.uint64_uploader_uin.get(),
                                uploadNick = fileInfo.str_uploader_name.get()
                            ))
                        }
                        else if (file.uint32_type.get() == oidb_0x6d8.GetFileListRspBody.TYPE_FOLDER) {
                            val folderInfo = file.folder_info
                            dirs.add(FolderInfo(
                                groupId = groupId,
                                folderId = folderInfo.str_folder_id.get(),
                                folderName = folderInfo.str_folder_name.get(),
                                totalFileCount = folderInfo.uint32_total_file_count.get(),
                                createTime = folderInfo.uint32_create_time.get(),
                                creator = folderInfo.uint64_create_uin.get(),
                                creatorNick = folderInfo.str_creator_name.get()
                            ))
                        } else {
                            LogCenter.log("未知文件类型: ${file.uint32_type.get()}", Level.WARN)
                        }
                    }
                }
            } else {
                throw RuntimeException("获取群文件列表失败")
            }

            GroupFileList(files, dirs)
        }.onFailure {
            LogCenter.log(it.message + ", buffer: ${rspGetFileListBuffer.toHexString()}", Level.ERROR)
        }
    }

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
}