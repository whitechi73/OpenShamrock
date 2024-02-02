package protobuf.group_file_common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class FolderInfo(
    @SerialName("folder_id") @ProtoNumber(1) val folderId: String = "",
    @SerialName("parent_folder_id") @ProtoNumber(2) val parentFolderId: String = "",
    @SerialName("folder_name") @ProtoNumber(3) val folderName: String = "",
    @SerialName("create_time") @ProtoNumber(4) val createTime: UInt = UInt.MIN_VALUE,
    @SerialName("modify_time") @ProtoNumber(5) val modifyTime: UInt = UInt.MIN_VALUE,
    @SerialName("creator_uin") @ProtoNumber(6) val createUin: ULong = ULong.MIN_VALUE,
    @SerialName("creator_name") @ProtoNumber(7) val creatorName: String? = null,
    @SerialName("total_file_cnt") @ProtoNumber(8) val totalFileCnt: UInt = UInt.MIN_VALUE,
    @SerialName("modifier_uin") @ProtoNumber(9) val modifyUin: ULong? = null,
    @SerialName("modifier_name") @ProtoNumber(10) val modifierName: String? = null,
    @SerialName("used_space") @ProtoNumber(11) val usedSpace: ULong = ULong.MIN_VALUE,
)
