@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunGetFavContentReq(
    @ProtoNumber(1) var cidList: List<String> = emptyList(),
)
