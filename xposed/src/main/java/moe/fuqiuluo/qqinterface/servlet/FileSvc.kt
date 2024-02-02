package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.pb.ByteStringMicro
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.structures.*
import moe.fuqiuluo.qqinterface.servlet.transfile.RichProtoSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import protobuf.oidb.cmd0x6d7.CreateFolderReq
import protobuf.oidb.cmd0x6d7.DeleteFolderReq
import protobuf.oidb.cmd0x6d7.MoveFolderReq
import protobuf.oidb.cmd0x6d7.Oidb0x6d7ReqBody
import protobuf.oidb.cmd0x6d7.Oidb0x6d7RespBody
import protobuf.oidb.cmd0x6d7.RenameFolderReq
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8
import tencent.im.oidb.oidb_sso
import protobuf.group_file_common.FolderInfo as GroupFileCommonFolderInfo

internal object FileSvc: BaseSvc() {
    suspend fun createFileFolder(groupId: String, folderName: String, parentFolderId: String = "/"): Result<GroupFileCommonFolderInfo> {
        val data = ProtoBuf.encodeToByteArray(
            Oidb0x6d7ReqBody(
            createFolder = CreateFolderReq(
                groupCode = groupId.toULong(),
                appId = 3u,
                parentFolderId = parentFolderId,
                folderName = folderName
            )
        )
        )
        val resultBuffer = sendOidbAW("OidbSvc.0x6d7_0", 1751, 0, data)
            ?: return Result.failure(Exception("unable to fetch result"))
        val oidbPkg = oidb_sso.OIDBSSOPkg()
        oidbPkg.mergeFrom(resultBuffer.slice(4))
        val rsp = ProtoBuf.decodeFromByteArray<Oidb0x6d7RespBody>(oidbPkg.bytes_bodybuffer.get().toByteArray())
        if (rsp.createFolder?.retCode != 0) {
            return Result.failure(Exception("unable to create folder: ${rsp.createFolder?.retCode}"))
        }
        return Result.success(rsp.createFolder!!.folderInfo!!)
    }

    suspend fun deleteGroupFolder(groupId: String, folderUid: String): Boolean {
        val buffer = sendOidbAW("OidbSvc.0x6d7_1", 1751, 1, ProtoBuf.encodeToByteArray(
            Oidb0x6d7ReqBody(
            deleteFolder = DeleteFolderReq(
                groupCode = groupId.toULong(),
                appId = 3u,
                folderId = folderUid
            )
        )
        )) ?: return false
        val oidbPkg = oidb_sso.OIDBSSOPkg()
        oidbPkg.mergeFrom(buffer.slice(4))
        val rsp = ProtoBuf.decodeFromByteArray<Oidb0x6d7RespBody>(oidbPkg.bytes_bodybuffer.get().toByteArray())
        return rsp.deleteFolder?.retCode == 0
    }

    suspend fun moveGroupFolder(groupId: String, folderUid: String, newParentFolderUid: String): Boolean {
        val buffer = sendOidbAW("OidbSvc.0x6d7_2", 1751, 2, ProtoBuf.encodeToByteArray(
            Oidb0x6d7ReqBody(
            moveFolder = MoveFolderReq(
                groupCode = groupId.toULong(),
                appId = 3u,
                folderId = folderUid,
                parentFolderId = "/"
            )
        )
        )) ?: return false
        val oidbPkg = oidb_sso.OIDBSSOPkg()
        oidbPkg.mergeFrom(buffer.slice(4))
        val rsp = ProtoBuf.decodeFromByteArray<Oidb0x6d7RespBody>(oidbPkg.bytes_bodybuffer.get().toByteArray())
        return rsp.moveFolder?.retCode == 0
    }

    suspend fun renameFolder(groupId: String, folderUid: String, name: String): Boolean {
        val buffer = sendOidbAW("OidbSvc.0x6d7_3", 1751, 3, ProtoBuf.encodeToByteArray(
            Oidb0x6d7ReqBody(
            renameFolder = RenameFolderReq(
                groupCode = groupId.toULong(),
                appId = 3u,
                folderId = folderUid,
                folderName = name
            )
        )
        )) ?: return false
        val oidbPkg = oidb_sso.OIDBSSOPkg()
        oidbPkg.mergeFrom(buffer.slice(4))
        val rsp = ProtoBuf.decodeFromByteArray<Oidb0x6d7RespBody>(oidbPkg.bytes_bodybuffer.get().toByteArray())
        return rsp.renameFolder?.retCode == 0
    }

    suspend fun deleteGroupFile(groupId: String, bizId: Int, fileUid: String): Boolean {
        val oidb0x6d6ReqBody = oidb_0x6d6.ReqBody().apply {
            delete_file_req.set(oidb_0x6d6.DeleteFileReqBody().apply {
                uint64_group_code.set(groupId.toLong())
                uint32_app_id.set(3)
                uint32_bus_id.set(bizId)
                str_parent_folder_id.set("/")
                str_file_id.set(fileUid)
            })
        }
        val result = sendOidbAW("OidbSvc.0x6d6_3", 1750, 3, oidb0x6d6ReqBody.toByteArray())
            ?: return false
        val oidbPkg = oidb_sso.OIDBSSOPkg()
        oidbPkg.mergeFrom(result.slice(4))
        val rsp = oidb_0x6d6.RspBody().apply {
            mergeFrom(oidbPkg.bytes_bodybuffer.get().toByteArray())
        }
        return rsp.delete_file_rsp.int32_ret_code.get() == 0
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
                                uploadNick = fileInfo.str_uploader_name.get(),
                                md5 = fileInfo.bytes_md5.get().toByteArray().toHexString(),
                                sha = fileInfo.bytes_sha.get().toByteArray().toHexString(),
                                // 根本没有
                                sha3 = fileInfo.bytes_sha3.get().toByteArray().toHexString(),
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
}