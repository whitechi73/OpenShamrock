package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MsgControl(
    @ProtoNumber(1) val msgFlag: Int? = null,
)