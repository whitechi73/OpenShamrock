package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class AppShareInfo(
    @ProtoNumber(1) var appshareId: UInt? = null,
    @ProtoNumber(2) var appshareCookie: ByteArray? = null,
    @ProtoNumber(3) var appshareResource: PluginInfo? = null,
)

@Serializable
data class PluginInfo(
    @ProtoNumber(1) var resId: UInt = 0u,
    @ProtoNumber(2) var pkgName: String = "",
    @ProtoNumber(3) var newVer: UInt = 0u,
    @ProtoNumber(4) var resType: UInt = 0u,
    @ProtoNumber(5) var lanType: UInt = 0u,
    @ProtoNumber(6) var priority: UInt = 0u,
    @ProtoNumber(7) var resName: String = "",
    @ProtoNumber(8) var resDesc: String = "",
    @ProtoNumber(9) var resUrlBig: String = "",
    @ProtoNumber(10) var resUrlSmall: String = "",
    @ProtoNumber(11) var resConf: String = "",
)