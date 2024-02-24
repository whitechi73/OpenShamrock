package protobuf.push

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf
import protobuf.message.PushMsgBody

@Serializable
data class MessagePush(
    @ProtoNumber(1) val msgBody: PushMsgBody? = null,
    @ProtoNumber(4) val clientInfo: MessagePushClientInfo? = null,
): Protobuf<MessagePush>

@Serializable
data class MessagePushClientInfo(
    @ProtoNumber(1) val clientIp: String? = null,
    @ProtoNumber(3) val liteHead: MessagePushLiteHead? = null
)

@Serializable
data class MessagePushLiteHead(
    @ProtoNumber(2) val msgType: Int = Int.MIN_VALUE,
    @ProtoNumber(3) val msgSeq: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val msgRandom: ULong = ULong.MIN_VALUE,
    @ProtoNumber(6) val msgSubType: Int = Int.MIN_VALUE,
    @ProtoNumber(8) val sender: ULong = ULong.MIN_VALUE,
)