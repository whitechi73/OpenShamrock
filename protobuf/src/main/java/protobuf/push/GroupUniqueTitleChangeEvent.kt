package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class GroupUniqueTitleChangeDetail(
    @ProtoNumber(2) val wording: String = "",
    @ProtoNumber(5) val targetUin: ULong = ULong.MIN_VALUE,
)