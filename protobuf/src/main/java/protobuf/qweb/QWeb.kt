@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.qweb

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

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