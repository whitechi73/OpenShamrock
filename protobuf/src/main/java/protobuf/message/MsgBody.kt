package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MsgBody(
    @ProtoNumber(1) val richText: RichText? = null,
    @ProtoNumber(2) val msgContent: ByteArray? = null,
    @ProtoNumber(3) val msgEncryptContent: ByteArray? = null
)