@file:OptIn(ExperimentalSerializationApi::class)
package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunCommonResp(
    @ProtoNumber(20000) val getFavListResp: WeiyunGetFavListResp? = null,
    @ProtoNumber(20001) val getFavContentResp: WeiyunGetFavContentResp? = null,
    @ProtoNumber(20009) val addRichMediaResp: WeiyunAddRichMediaResp? = null,
    @ProtoNumber(20010) val fastUploadResourceResp: WeiyunFastUploadResourceResp? = null,
)
