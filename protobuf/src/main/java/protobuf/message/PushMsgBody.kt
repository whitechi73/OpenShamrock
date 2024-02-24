package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class PushMsgBody(
    @ProtoNumber(1) val msgHead: ResponseHead? = null,
    @ProtoNumber(2) val contentHead: ContentHead? = null,
    @ProtoNumber(3) val body: MsgBody? = null,
)