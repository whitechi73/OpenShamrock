package protobuf.oidb

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class TrpcOidb(
    @ProtoNumber(1) val cmd: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val service: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val buffer: ByteArray,
    //@ProtoNumber(11) val traceParams: Map<String, String> = mapOf(),
    @ProtoNumber(12) val flag: Int = Int.MIN_VALUE,
): Protobuf<TrpcOidb>