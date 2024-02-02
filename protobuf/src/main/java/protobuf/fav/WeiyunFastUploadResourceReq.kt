@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunFastUploadResourceReq(
    @ProtoNumber(1) val picInfoList: List<WeiyunPicInfo>? = null,
    @ProtoNumber(2) val fileInfoList: List<WeiyunFileInfo>? = null,
    @ProtoNumber(3) val hostFlag: UInt = UInt.MIN_VALUE,
    @ProtoNumber(4) val httpsFlag: UInt = UInt.MIN_VALUE,
)
