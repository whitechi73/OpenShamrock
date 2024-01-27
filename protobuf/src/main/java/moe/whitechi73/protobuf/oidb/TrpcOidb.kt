@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.oidb

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class TrpcOidb(
    @ProtoNumber(1) val cmd: Int = Int.MIN_VALUE,
    @ProtoNumber(2) val service: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val buffer: ByteArray,
    @ProtoNumber(12) val flag: Int = Int.MIN_VALUE,
)
