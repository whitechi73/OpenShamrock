package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class NtMessage(
    @ProtoNumber(1) val msgHead: MessageHead? = null,
    @ProtoNumber(2) val contentHead: MessageContent? = null,
    @ProtoNumber(3) val body: MessageBody? = null,
)