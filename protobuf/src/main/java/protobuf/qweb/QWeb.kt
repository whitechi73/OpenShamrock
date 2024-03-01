@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.qweb

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

const val DEFAULT_DEVICE_INFO = "i=&imsi=&mac=02:00:00:00:00:00&m=Shamrock&o=114514&a=1919810&sd=0&c64=1&sc=1&p=8000*8000&aid=123456789012345678901234567890abcdef&f=Tencent&mm=5610&cf=1726&cc=8&qimei=&qimei36=&sharpP=1&n=nether_world&support_xsj_live=false&client_mod=concise&timezone=America/La_Paz&material_sdk_version=&vh265=&refreshrate=10086&hwlevel=9&suphdr=1&is_teenager_mod=8&liveH265=&bmst=5&AV1=0"

@Serializable
data class QWebReq(
    @ProtoNumber(1) val seq: Int = 0,
    @ProtoNumber(2) val qua: String = "",
    @ProtoNumber(3) val deviceInfo: String = "",
    @ProtoNumber(4) val buffer: ByteArray? = null,
    @ProtoNumber(5) val traceId: String = "",
    @ProtoNumber(6) val module: String = "",
    @ProtoNumber(7) var cmdname: String? = null,
    //@ProtoNumber(8) var loginSig: Any? = null,
    //@ProtoNumber(9) var Crypto: Any? = null,
    @ProtoNumber(10) var extinfo: List<QWebExtInfo>? = null,
    //@ProtoNumber(11) var contentType: Any? = null,
): Protobuf<QWebReq>

@Serializable
data class QWebExtInfo(
    @ProtoNumber(1) val key: String,
    @ProtoNumber(2) val value: String,
)

@Serializable
data class QWebRsp(
    @ProtoNumber(1) var seq: Int? = null,
    //@ProtoNumber(2) var retCode: Int? = null,
    //@ProtoNumber(3) var errMsg: String? = null,
    @ProtoNumber(4) var buffer: ByteArray? = null,
    //@ProtoNumber(5) var Extinfo: List<QWebExtInfo>? = null,
): Protobuf<QWebRsp>