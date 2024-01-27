@file:OptIn(ExperimentalSerializationApi::class)

package moe.whitechi73.protobuf.fav

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunGetFavListResp(
    @ProtoNumber(1) val collections: List<WeiyunCollection>? = null,
    @ProtoNumber(2) val totalCnt: UInt = UInt.MIN_VALUE,
    @ProtoNumber(3) val result: UInt = UInt.MIN_VALUE,
)

@Serializable
data class WeiyunCollection(
    @ProtoNumber(1) val cid: String = "",
    @ProtoNumber(2) val type: Int = Int.MIN_VALUE,
    @ProtoNumber(3) val status: Int = Int.MIN_VALUE,
    @ProtoNumber(4) val author: WeiyunAuthor? = null,
    @ProtoNumber(5) val bid: UInt = UInt.MIN_VALUE,
    @ProtoNumber(6) val srcAppId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(7) val srcAppVer: String = "",
    @ProtoNumber(8) val category: UInt = UInt.MIN_VALUE,
    @ProtoNumber(9) val createTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(10) val collectTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(11) val modifyTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(12) val seq: ULong = ULong.MIN_VALUE,
    @ProtoNumber(13) val bizKey: String = "",
    @ProtoNumber(14) val bizDataList: List<ByteArray>? = null,
    @ProtoNumber(15) val summary: String = "",
    @ProtoNumber(16) val starMark: Boolean = false,
    @ProtoNumber(17) val starTime: ULong = ULong.MIN_VALUE,
    @ProtoNumber(18) val shareUrl: String = "",
    @ProtoNumber(19) val originalAppId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(20) val customGroupId: UInt = UInt.MIN_VALUE,
    @ProtoNumber(21) val securityBeat: UInt = UInt.MIN_VALUE,
    @ProtoNumber(22) val qzoneUgcKey: String = "",
)

