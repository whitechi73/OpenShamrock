package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class GroupAdminChangeEvent(
    @ProtoNumber(1) val groupCode: Long,
    @ProtoNumber(4) val operation: GroupAdminChangedOperation? = null
): Protobuf<GroupAdminChangeEvent>

