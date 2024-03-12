@file:OptIn(ExperimentalStdlibApi::class)

package qq.service.file

import com.tencent.mobileqq.pb.ByteStringMicro
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.file.File
import io.kritor.file.Folder
import io.kritor.file.GetFileSystemInfoResponse
import io.kritor.file.GetFilesRequest
import io.kritor.file.GetFilesResponse
import io.kritor.file.folder
import io.kritor.file.getFileSystemInfoResponse
import io.kritor.file.getFilesRequest
import io.kritor.file.getFilesResponse
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.DeflateTools
import qq.service.QQInterfaces
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8
import tencent.im.oidb.oidb_sso
import kotlin.time.Duration.Companion.seconds

internal object GroupFileHelper: QQInterfaces() {
    suspend fun getGroupFileSystemInfo(groupId: Long): GetFileSystemInfoResponse {
        val fromServiceMsg = sendOidbAW("OidbSvc.0x6d8_1", 1752, 2, oidb_0x6d8.ReqBody().also {
            it.group_file_cnt_req.set(oidb_0x6d8.GetFileCountReqBody().also {
                it.uint64_group_code.set(groupId)
                it.uint32_app_id.set(3)
                it.uint32_bus_id.set(0)
            })
        }.toByteArray()) ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        if (!fromServiceMsg.isSuccess) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("oidb request failed"))
        }
        val fileCnt: Int
        val limitCnt: Int
        if (fromServiceMsg.wupBuffer != null) {
            oidb_0x6d8.RspBody().mergeFrom(
                oidb_sso.OIDBSSOPkg()
                .mergeFrom(fromServiceMsg.wupBuffer.slice(4))
                .bytes_bodybuffer.get()
                .toByteArray()
            ).group_file_cnt_rsp.apply {
                fileCnt = uint32_all_file_count.get()
                limitCnt = uint32_limit_count.get()
            }
        } else {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to fetch oidb response"))
        }

        val fromServiceMsg2 = sendOidbAW("OidbSvc.0x6d8_1", 1752, 3, oidb_0x6d8.ReqBody().also {
            it.group_space_req.set(oidb_0x6d8.GetSpaceReqBody().apply {
                uint64_group_code.set(groupId)
                uint32_app_id.set(3)
            })
        }.toByteArray()) ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        val totalSpace: Long
        val usedSpace: Long
        if (fromServiceMsg2.isSuccess && fromServiceMsg2.wupBuffer != null) {
            oidb_0x6d8.RspBody().mergeFrom(
                oidb_sso.OIDBSSOPkg()
                .mergeFrom(fromServiceMsg2.wupBuffer.slice(4))
                .bytes_bodybuffer.get()
                .toByteArray()).group_space_rsp.apply {
                totalSpace = uint64_total_space.get()
                usedSpace = uint64_used_space.get()
            }
        } else {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to fetch oidb response x2"))
        }

        return getFileSystemInfoResponse {
            this.fileCount = fileCnt
            this.totalCount = limitCnt
            this.totalSpace = totalSpace.toInt()
            this.usedSpace = usedSpace.toInt()
        }
    }

    suspend fun getGroupFiles(groupId: Long, folderId: String = "/"): GetFilesResponse {
        val fileSystemInfo = getGroupFileSystemInfo(groupId)
        val fromServiceMsg = sendOidbAW("OidbSvc.0x6d8_1", 1752, 1, oidb_0x6d8.ReqBody().also {
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
        }.toByteArray(), timeout = 15.seconds) ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        if (!fromServiceMsg.isSuccess) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("oidb request failed"))
        }
        val files = arrayListOf<File>()
        val dirs = arrayListOf<Folder>()
        if (fromServiceMsg.wupBuffer != null) {
            val oidb = oidb_sso.OIDBSSOPkg().mergeFrom(fromServiceMsg.wupBuffer.slice(4).let {
                if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
            })

            oidb_0x6d8.RspBody().mergeFrom(oidb.bytes_bodybuffer.get().toByteArray())
                .file_list_info_rsp.apply {
                    rpt_item_list.get().forEach { file ->
                        if (file.uint32_type.get() == oidb_0x6d8.GetFileListRspBody.TYPE_FILE) {
                            val fileInfo = file.file_info
                            files.add(io.kritor.file.file {
                                this.fileId = fileInfo.str_file_id.get()
                                this.fileName = fileInfo.str_file_name.get()
                                this.fileSize = fileInfo.uint64_file_size.get()
                                this.busId = fileInfo.uint32_bus_id.get()
                                this.uploadTime = fileInfo.uint32_upload_time.get()
                                this.deadTime = fileInfo.uint32_dead_time.get()
                                this.modifyTime = fileInfo.uint32_modify_time.get()
                                this.downloadTimes = fileInfo.uint32_download_times.get()
                                this.uploader = fileInfo.uint64_uploader_uin.get()
                                this.uploaderName = fileInfo.str_uploader_name.get()
                                this.sha = fileInfo.bytes_sha.get().toByteArray().toHexString()
                                this.sha3 = fileInfo.bytes_sha3.get().toByteArray().toHexString()
                                this.md5 = fileInfo.bytes_md5.get().toByteArray().toHexString()
                            })
                        }
                        else if (file.uint32_type.get() == oidb_0x6d8.GetFileListRspBody.TYPE_FOLDER) {
                            val folderInfo = file.folder_info
                            dirs.add(folder {
                                this.folderId = folderInfo.str_folder_id.get()
                                this.folderName = folderInfo.str_folder_name.get()
                                this.totalFileCount = folderInfo.uint32_total_file_count.get()
                                this.createTime = folderInfo.uint32_create_time.get()
                                this.creator = folderInfo.uint64_create_uin.get()
                                this.creatorName = folderInfo.str_creator_name.get()
                            })
                        } else {
                            LogCenter.log("未知文件类型: ${file.uint32_type.get()}", Level.WARN)
                        }
                    }
                }
        } else {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to fetch oidb response"))
        }

        return getFilesResponse {
            this.files.addAll(files)
            this.folders.addAll(folders)
        }
    }
}