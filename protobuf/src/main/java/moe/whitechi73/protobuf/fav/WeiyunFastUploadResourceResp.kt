@file:OptIn(ExperimentalSerializationApi::class)

package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunFastUploadResourceResp(
    @ProtoNumber(1) val picResultList: List<WeiyunFastUploadPicResult>? = null,
    @ProtoNumber(2) val fileResultList: List<WeiyunFastUploadFileResult>? = null,
)

@Serializable
data class WeiyunFastUploadPicResult(
    @ProtoNumber(1) val result: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val picInfo: WeiyunPicInfo? = null,
)

@Serializable
data class WeiyunFastUploadFileResult(
    @ProtoNumber(1) val result: UInt = UInt.MIN_VALUE,
    @ProtoNumber(2) val picInfo: WeiyunPicInfo? = null,
    @ProtoNumber(3) val uploadFileInfo: WeiyunUploadFileInfo? = null,
    @ProtoNumber(4) val notRetransmission: UInt = UInt.MIN_VALUE,
    @ProtoNumber(5) val failedTips: String = "",
)

@Serializable
data class WeiyunUploadFileInfo(
    @ProtoNumber(1) val fileId: String = "",
    @ProtoNumber(2) val sha1: ByteArray? = null,
    @ProtoNumber(3) val checkKey: ByteArray? = null,
    @ProtoNumber(4) val host: String = "",
    @ProtoNumber(5) val port: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val httpsHost: String = "",
    @ProtoNumber(7) val httpsPort: UInt = UInt.MIN_VALUE,
)