package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class MessageContent(
    @ProtoNumber(1) val msgType: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val msgSubType: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val msgViaRandom: Long = Long.MIN_VALUE,
    @ProtoNumber(5) val msgSeq: Long = Long.MIN_VALUE,
    @ProtoNumber(6) val msgTime: Long? = null,
    @ProtoNumber(7) val u2: Int? = null,
    @ProtoNumber(11) val u3: Long? = null,
    @ProtoNumber(12) val msgRandom: Long = Long.MIN_VALUE,
    @ProtoNumber(14) val u4: Long? = null,
    @ProtoNumber(28) val u5: Long? = null,
)