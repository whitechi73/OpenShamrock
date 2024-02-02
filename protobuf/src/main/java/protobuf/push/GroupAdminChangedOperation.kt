package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupAdminChangedOperation(
    @ProtoNumber(1) val unsetInfo: GroupAdminSetInfo? = null,
    @ProtoNumber(2) val setInfo: GroupAdminSetInfo? = null,
)

@Serializable
data class GroupAdminSetInfo(
    @ProtoNumber(1) val targetUid: String? = null,
    @ProtoNumber(2) val operation: Int? = null,
)