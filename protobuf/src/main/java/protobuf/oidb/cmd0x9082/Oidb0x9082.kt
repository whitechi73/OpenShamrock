package protobuf.oidb.cmd0x9082

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class Oidb0x9082(
    @ProtoNumber(2) val peer: ULong = ULong.MIN_VALUE,
    @ProtoNumber(3) val msgSeq: ULong = ULong.MIN_VALUE,
    @ProtoNumber(4) val faceIndex: String = "",
    @ProtoNumber(5) val flag: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val u1: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val u2: UInt = UInt.MIN_VALUE,
)
