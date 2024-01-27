@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunGetFavListReq(
    @ProtoNumber(1) val type: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val bid: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val category: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val startTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(5) val orderType: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val startPos: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val pageSize: UInt = UInt.MIN_VALUE,
    @ProtoNumber(8) val syncPolicy: UInt = UInt.MIN_VALUE,
    @ProtoNumber(9) val reqSource: UInt = UInt.MIN_VALUE,
)
