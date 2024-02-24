package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber


@Serializable
data class GeneralFlags(
    @ProtoNumber(1) val bubbleDiyTextId: UInt? = null,
    @ProtoNumber(2) val groupFlagNew: UInt? = null,
    @ProtoNumber(3) val uin: ULong? = null,
    @ProtoNumber(4) val rpId: ByteArray? = null,
    @ProtoNumber(5) val prpFold: UInt? = null,
    @ProtoNumber(6) val longTextFlag: UInt? = null,
    @ProtoNumber(7) val longTextResid: ByteArray? = null,
    @ProtoNumber(8) val groupType: UInt? = null,
    @ProtoNumber(9) val toUinFlag: UInt? = null,
    @ProtoNumber(10) val glamourLevel: UInt? = null,
    @ProtoNumber(11) val memberLevel: UInt? = null,
    @ProtoNumber(12) val groupRankSeq: ULong? = null,
    @ProtoNumber(13) val olympicTorch: UInt? = null,
    @ProtoNumber(14) val babyqGuideMsgCookie: ByteArray? = null,
    @ProtoNumber(15) val expertFlag: UInt? = null,
    @ProtoNumber(16) val bubbleSubId: UInt? = null,
    @ProtoNumber(17) val pendantId: ULong? = null,
    @ProtoNumber(18) val rpIndex: ByteArray? = null,
    @ProtoNumber(19) val reserve: ByteArray? = null,
)