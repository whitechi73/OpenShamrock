@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunCommonReq (
    @ProtoNumber(2000) val getFavListReq: WeiyunGetFavListReq? = null,
    @ProtoNumber(2001) val getFavContentReq: WeiyunGetFavContentReq? = null,
    @ProtoNumber(2009) val addRichMediaReq: WeiyunAddRichMediaReq? = null,
    @ProtoNumber(2010) val fastUploadResourceReq: WeiyunFastUploadResourceReq? = null,

    )