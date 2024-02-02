package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupListChangeEvent(
    @ProtoNumber(1) val groupCode: Long = Long.MIN_VALUE,
    @ProtoNumber(3) val memberUid: String = "",
    @ProtoNumber(4) val type: Int = Int.MIN_VALUE,
    @ProtoNumber(5) val operatorUid: String = "",
)