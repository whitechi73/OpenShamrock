package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class PbSendMsgReq(
    @ProtoNumber(1) val routingHead: RoutingHead? = null,
    @ProtoNumber(2) val contentHead: ContentHead? = null,
    @ProtoNumber(3) val msgBody: MsgBody? = null,
    @ProtoNumber(4) val msgSeq: UInt? = null,
    @ProtoNumber(5) val msgRand: UInt? = null,
    @ProtoNumber(6) val syncCookie: ByteArray? = null,
    @ProtoNumber(7) val appShare: AppShareInfo? = null,
    @ProtoNumber(8) val msgVia: UInt? = null,
    @ProtoNumber(9) val dataStatist: UInt? = null,
//    @ProtoNumber(10) val multiMsgAssist: MultiMsgAssist? = null,
//    @ProtoNumber(11) val inputNotifyInfo: InputNotifyInfo? = null,
    @ProtoNumber(12) val ctrl: MsgControl? = null,
//    @ProtoNumber(13) val receiptReq: ReceiptReq? = null,
    @ProtoNumber(14) val multiSendSeq: UInt? = null
) : Protobuf<PbSendMsgReq>