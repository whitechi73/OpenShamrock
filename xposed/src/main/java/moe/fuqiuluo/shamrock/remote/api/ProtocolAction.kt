package moe.fuqiuluo.shamrock.remote.api

import com.tencent.mobileqq.dt.model.FEBound
import io.ktor.server.routing.Routing
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.remote.entries.Protocol
import moe.fuqiuluo.shamrock.remote.entries.QSignDtConfig
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import mqq.app.MobileQQ
import oicq.wlogin_sdk.tlv_type.tlv_t100
import oicq.wlogin_sdk.tlv_type.tlv_t106
import oicq.wlogin_sdk.tlv_type.tlv_t18
import oicq.wlogin_sdk.tools.util

fun Routing.obtainProtocolData() {
    getOrPost("/send_packet") {
        val cmd = fetchOrThrow("cmd")
        val isPb = fetchOrThrow("proto").toBooleanStrict()
        val buffer = fetchOrThrow("buffer").hex2ByteArray()
        val resp = BaseSvc.sendBufferAW(cmd, isPb, buffer)
        respond(true, Status.Ok, data = resp?.toHexString() ?: "null", msg = "成功")
    }

    getOrPost("/set_guid") {
        val guid = fetchOrThrow("guid").hex2ByteArray()
        val ctx = MobileQQ.getContext()
        util.save_cur_guid(ctx, guid)
        util.saveGuidToFile(ctx, guid)
        val guildLock = MMKVFetcher.mmkvWithId("guid")
        guildLock.putString("guid", guid.toHexString())
        respond(true, Status.Ok, msg = "成功")
    }

    getOrPost("/get_msf_info") {
        val mqq = MobileQQ.getMobileQQ()
        val ctx = MobileQQ.getContext()

        val t18 = tlv_t18()
        val t100 = tlv_t100()
        val t106 = tlv_t106()

        val qimei = kotlin.runCatching {
            util.get_qimei(ctx).toHexString()
        }.getOrDefault("")

        val encodeTable = FEBound::class.java.getDeclaredField("mConfigEnCode").also {
            it.isAccessible = true
        }.get(null) as Array<ByteArray>
        val decodeTable = FEBound::class.java.getDeclaredField("mConfigDeCode").also {
            it.isAccessible = true
        }.get(null) as Array<ByteArray>

        respond(
            isOk = true,
            code = Status.Ok,
            data = Protocol(
                mqq.qqProcessName,
                mqq.appId.toLong(), mqq.qua, kotlin.runCatching { mqq.ntCoreVersion }.getOrDefault(0),
                mqq.msfConnectedNetType,
                qimei,
                util.getSvnVersion(),
                PlatformUtils.getAndroidID(),
                util.getGuidFromFile(ctx).toHexString(),
                util.get_ksid(ctx).toHexString(),
                util.get_network_type(ctx),
                t18._ping_version.toByte(), t18._sso_version,
                t100._sso_ver, t100._db_buf_ver,
                t106._SSoVer, t106._TGTGTVer,

                util.get_android_dev_info(ctx).toHexString(),

                qSignDtConfig = QSignDtConfig(encodeTable, decodeTable)
            )
        )
    }
}