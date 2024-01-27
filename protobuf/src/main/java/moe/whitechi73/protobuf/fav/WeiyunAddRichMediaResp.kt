@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunAddRichMediaResp(
    @ProtoNumber(1) val cid: String = "",
    @ProtoNumber(2) val collectTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(3) val shareUrl: String = "",
)
