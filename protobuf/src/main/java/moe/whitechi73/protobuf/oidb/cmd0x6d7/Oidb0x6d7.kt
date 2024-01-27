@file:OptIn(ExperimentalSerializationApi::class)

package moe.whitechi73.protobuf.oidb.cmd0x6d7

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.whitechi73.protobuf.group_file_common.FolderInfo

@Serializable
data class Oidb0x6d7ReqBody(
    @ProtoNumber(1) val createFolder: CreateFolderReq? = null,
    @ProtoNumber(2) val deleteFolder: DeleteFolderReq? = null,
    @ProtoNumber(3) val moveFolder: MoveFolderReq? = null,
    @ProtoNumber(4) val renameFolder: RenameFolderReq? = null,
)

@Serializable
data class CreateFolderReq(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(2) val appId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val parentFolderId: String = "",
    @ProtoNumber(4) val folderName: String = "",
)

@Serializable
data class DeleteFolderReq(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(2) val appId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val folderId: String = "",
)

@Serializable
data class MoveFolderReq(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(2) val appId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val folderId: String = "",
    @ProtoNumber(4) val parentFolderId: String = "",
    @ProtoNumber(5) val destFolderId: String = "",
)

@Serializable
data class RenameFolderReq(
    @ProtoNumber(1) val groupCode: ULong = ULong.MIN_VALUE,
    @ProtoNumber(2) val appId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val folderId: String = "",
    @ProtoNumber(4) val folderName: String = "",
)

@Serializable
data class Oidb0x6d7RespBody(
    @ProtoNumber(1) val createFolder: CreateFolderResp? = null,
    @ProtoNumber(2) val deleteFolder: DeleteFolderResp? = null,
    @ProtoNumber(3) val moveFolder: MoveFolderResp? = null,
    @ProtoNumber(4) val renameFolder: RenameFolderResp? = null,
)

@Serializable
data class CreateFolderResp(
    @ProtoNumber(1) val retCode: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val retMsg: String = "",
    @ProtoNumber(3) val clientWording: String = "",
    @ProtoNumber(4) val folderInfo: FolderInfo? = null,
)

@Serializable
data class DeleteFolderResp(
    @ProtoNumber(1) val retCode: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val retMsg: String = "",
    @ProtoNumber(3) val clientWording: String = "",
)

@Serializable
data class MoveFolderResp(
    @ProtoNumber(1) val retCode: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val retMsg: String = "",
    @ProtoNumber(3) val clientWording: String = "",
    @ProtoNumber(4) val folderInfo: FolderInfo? = null,
)

@Serializable
data class RenameFolderResp(
    @ProtoNumber(1) val retCode: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val retMsg: String = "",
    @ProtoNumber(3) val clientWording: String = "",
    @ProtoNumber(4) val folderInfo: FolderInfo? = null,
)
