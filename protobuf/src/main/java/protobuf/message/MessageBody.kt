package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MessageBody(
    @ProtoNumber(1) val rich: RichMessage? = null,
    @ProtoNumber(2) val rawBuffer: ByteArray? = null,
    @ProtoNumber(3) val MsgEncryptContent: ByteArray? = null
)