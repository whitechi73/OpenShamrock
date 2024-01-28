package moe.fuqiuluo.shamrock.remote.structures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Protocol(
    var processName: String,

    var subAppId: Long,
    var qua: String,
    var ntVersion: Int,

    var msfConnNetType: Int,

    var qimei: String,
    var svnVersion: String,

    var androidId: String,
    var guid: String,
    var ksid: String,
    var netType: Int,


    var pingVersion: Byte,
    var ssoVer: Int,

    var ssoVersion: Int,
    var dbVersion: Int,

    var SSOVer: Int,
    var tgtgtVer: Int,

    var androidDevInfo: String,

    @SerialName("signDtConfig") var qSignDtConfig: QSignDtConfig? = null
)

@Serializable
data class QSignDtConfig(
    val en: Array<ByteArray>,
    val de: Array<ByteArray>
)