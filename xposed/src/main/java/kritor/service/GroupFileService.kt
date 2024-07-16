package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.file.*
import moe.fuqiuluo.shamrock.tools.decodeToOidb
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.oidb.cmd0x6d7.CreateFolderReq
import protobuf.oidb.cmd0x6d7.DeleteFolderReq
import protobuf.oidb.cmd0x6d7.Oidb0x6d7ReqBody
import protobuf.oidb.cmd0x6d7.Oidb0x6d7RespBody
import protobuf.oidb.cmd0x6d7.RenameFolderReq
import qq.service.QQInterfaces
import qq.service.file.GroupFileHelper
import qq.service.file.GroupFileHelper.getGroupFileSystemInfo
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6
import tencent.im.oidb.oidb_sso

internal object GroupFileService : GroupFileServiceGrpcKt.GroupFileServiceCoroutineImplBase() {
    @Grpc("GroupFileService", "CreateFolder")
    override suspend fun createFolder(request: CreateFolderRequest): CreateFolderResponse {
        val data = Oidb0x6d7ReqBody(
            createFolder = CreateFolderReq(
                groupCode = request.groupId.toULong(),
                appId = 3u,
                parentFolderId = "/",
                folderName = request.name
            )
        ).toByteArray()
        val fromServiceMsg = QQInterfaces.sendOidbAW("OidbSvc.0x6d7_0", 1751, 0, data)
            ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        if (fromServiceMsg.wupBuffer == null) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("oidb request failed"))
        }
        val oidbPkg = fromServiceMsg.decodeToOidb()
        val rsp = oidbPkg.bytes_bodybuffer.get()
            .toByteArray()
            .decodeProtobuf<Oidb0x6d7RespBody>()
        if (rsp.createFolder?.retCode != 0) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to create folder: ${rsp.createFolder?.retCode}"))
        }
        return CreateFolderResponse.newBuilder().apply {
            this.id = rsp.createFolder?.folderInfo?.folderId ?: ""
            this.usedSpace = 0
        }.build()
    }

    @Grpc("GroupFileService", "DeleteFolder")
    override suspend fun deleteFolder(request: DeleteFolderRequest): DeleteFolderResponse {
        val fromServiceMsg = QQInterfaces.sendOidbAW(
            "OidbSvc.0x6d7_1", 1751, 1, Oidb0x6d7ReqBody(
                deleteFolder = DeleteFolderReq(
                    groupCode = request.groupId.toULong(),
                    appId = 3u,
                    folderId = request.folderId
                )
            ).toByteArray()
        ) ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        if (fromServiceMsg.wupBuffer == null) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("oidb request failed"))
        }
        val oidbPkg = fromServiceMsg.decodeToOidb()
        val rsp = oidbPkg.bytes_bodybuffer.get().toByteArray().decodeProtobuf<Oidb0x6d7RespBody>()
        if (rsp.deleteFolder?.retCode != 0) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to delete folder: ${rsp.deleteFolder?.retCode}"))
        }
        return DeleteFolderResponse.newBuilder().build()
    }

    @Grpc("GroupFileService", "DeleteFile")
    override suspend fun deleteFile(request: DeleteFileRequest): DeleteFileResponse {
        val oidb0x6d6ReqBody = oidb_0x6d6.ReqBody().apply {
            delete_file_req.set(oidb_0x6d6.DeleteFileReqBody().apply {
                uint64_group_code.set(request.groupId)
                uint32_app_id.set(3)
                uint32_bus_id.set(request.busId)
                str_parent_folder_id.set("/")
                str_file_id.set(request.fileId)
            })
        }
        val fromServiceMsg = QQInterfaces.sendOidbAW("OidbSvc.0x6d6_3", 1750, 3, oidb0x6d6ReqBody.toByteArray())
            ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        if (fromServiceMsg.wupBuffer == null) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("oidb request failed"))
        }
        val oidbPkg = fromServiceMsg.decodeToOidb()
        val rsp = oidb_0x6d6.RspBody().apply {
            mergeFrom(oidbPkg.bytes_bodybuffer.get().toByteArray())
        }
        if (rsp.delete_file_rsp.int32_ret_code.get() != 0) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to delete file: ${rsp.delete_file_rsp.int32_ret_code.get()}"))
        }
        return DeleteFileResponse.newBuilder().build()
    }

    @Grpc("GroupFileService", "RenameFolder")
    override suspend fun renameFolder(request: RenameFolderRequest): RenameFolderResponse {
        val fromServiceMsg = QQInterfaces.sendOidbAW(
            "OidbSvc.0x6d7_3", 1751, 3, Oidb0x6d7ReqBody(
                renameFolder = RenameFolderReq(
                    groupCode = request.groupId.toULong(),
                    appId = 3u,
                    folderId = request.folderId,
                    folderName = request.name
                )
            ).toByteArray()
        ) ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to send oidb request"))
        if (fromServiceMsg.wupBuffer == null) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("oidb request failed"))
        }
        val oidbPkg = fromServiceMsg.decodeToOidb()
        val rsp = oidbPkg.bytes_bodybuffer.get().toByteArray().decodeProtobuf<Oidb0x6d7RespBody>()
        if (rsp.renameFolder?.retCode != 0) {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to rename folder: ${rsp.renameFolder?.retCode}"))
        }
        return RenameFolderResponse.newBuilder().build()
    }

    @Grpc("GroupFileService", "GetFileSystemInfo")
    override suspend fun getFileSystemInfo(request: GetFileSystemInfoRequest): GetFileSystemInfoResponse {
        return getGroupFileSystemInfo(request.groupId)
    }

    @Grpc("GroupFileService", "GetFileList")
    override suspend fun getFileList(request: GetFileListRequest): GetFileListResponse {
        return if (request.hasFolderId())
            GroupFileHelper.getGroupFiles(request.groupId, request.folderId)
        else
            GroupFileHelper.getGroupFiles(request.groupId)
    }
}