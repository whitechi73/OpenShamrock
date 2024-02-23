package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import protobuf.message.Elem

@Serializable
data class SourceMsg(
    @ProtoNumber(1) var origSeqs: List<Int>? = null,
    @ProtoNumber(2) var senderUin: ULong? = null,
    @ProtoNumber(3) var time: ULong? = null,
    @ProtoNumber(4) var flag: UInt? = null,
    @ProtoNumber(5) var elems: List<Elem>? = null,
    @ProtoNumber(6) var type: UInt? = null,
    @ProtoNumber(7) var richMsg: ByteArray? = null,
    @ProtoNumber(8) var pbReserve: PbReserve? = null,
    @ProtoNumber(9) var srcMsg: ByteArray? = null,
    @ProtoNumber(10) var toUin: ULong? = null,
    @ProtoNumber(11) var troopName: String? = null,
) {
    companion object {
        @Serializable
        data class PbReserve(
            @ProtoNumber(3) var field3: ULong? = null,
            @ProtoNumber(6) var senderUid: String? = null,
            @ProtoNumber(7) var receiverUid: String? = null,
            @ProtoNumber(8) var field8: Int? = null,
        )
    }
}