@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.lightapp

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class AdaptShareInfoReq(
    //@ProtoNumber(1) var extInfo: Any? = null,
    @ProtoNumber(2) var appid: String? = null,
    @ProtoNumber(3) var title: String? = null,
    @ProtoNumber(4) var desc: String? = null,
    @ProtoNumber(5) var time: ULong? = null,
    @ProtoNumber(6) var scene: UInt? = null,
    @ProtoNumber(7) var templetType: UInt? = null,
    @ProtoNumber(8) var businessType: UInt? = null,
    @ProtoNumber(9) var picUrl: String? = null,
    @ProtoNumber(10) var vidUrl: String? = null,
    @ProtoNumber(11) var jumpUrl: String? = null,
    @ProtoNumber(12) var iconUrl: String? = null,
    @ProtoNumber(13) var verType: UInt? = null,
    @ProtoNumber(14) var shareType: UInt? = null,
    @ProtoNumber(15) var versionId: String? = null,
    @ProtoNumber(16) var withShareTicket: UInt? = null,
    @ProtoNumber(17) var webURL: String? = null,
    //@ProtoNumber(18) var appidRich: Any? = null,
    @ProtoNumber(19) var template: Template? = null,
    //@ProtoNumber(20) var rcvOpenId: Any? = null,
): Protobuf<AdaptShareInfoReq>

@Serializable
data class Template(
    @ProtoNumber(1) var templateId: UInt? = null,
    @ProtoNumber(2) var templateData: ByteArray? = null,
)