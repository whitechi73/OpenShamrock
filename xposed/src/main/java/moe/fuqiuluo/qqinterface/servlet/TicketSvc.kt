package moe.fuqiuluo.qqinterface.servlet

import com.tencent.guild.api.transfile.IGuildTransFileApi
import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a
import com.tencent.mobileqq.qroute.QRoute
import io.ktor.client.request.get
import io.ktor.client.request.header
import moe.fuqiuluo.shamrock.remote.service.data.BigDataTicket
import moe.fuqiuluo.shamrock.tools.GlobalClientNoRedirect
import moe.fuqiuluo.shamrock.tools.slice
import mqq.app.MobileQQ
import mqq.manager.TicketManager
import oicq.wlogin_sdk.request.Ticket
import tencent.im.oidb.oidb_sso

internal object TicketSvc: BaseSvc() {
    object SigType {
        const val WLOGIN_A5 = 2
        const val WLOGIN_RESERVED = 16
        const val WLOGIN_STWEB = 32 // TLV 103
        const val WLOGIN_A2 = 64
        const val WLOGIN_ST = 128
        const val WLOGIN_AQSIG = 2097152
        const val WLOGIN_D2 = 262144
        const val WLOGIN_DA2 = 33554432
        const val WLOGIN_LHSIG = 4194304
        const val WLOGIN_LSKEY = 512
        const val WLOGIN_OPENKEY = 16384
        const val WLOGIN_PAYTOKEN = 8388608
        const val WLOGIN_PF = 16777216
        const val WLOGIN_PSKEY = 1048576
        const val WLOGIN_PT4Token = 134217728
        const val WLOGIN_QRPUSH = 67108864
        const val WLOGIN_SID = 524288
        const val WLOGIN_SIG64 = 8192
        const val WLOGIN_SKEY = 4096
        const val WLOGIN_TOKEN = 32768
        const val WLOGIN_VKEY = 131072

        val ALL_TICKET = arrayOf(
            WLOGIN_A5, WLOGIN_RESERVED, WLOGIN_STWEB, WLOGIN_A2, WLOGIN_ST, WLOGIN_AQSIG, WLOGIN_D2, WLOGIN_DA2,
            WLOGIN_LHSIG, WLOGIN_LSKEY, WLOGIN_OPENKEY, WLOGIN_PAYTOKEN, WLOGIN_PF, WLOGIN_PSKEY, WLOGIN_PT4Token,
            WLOGIN_QRPUSH, WLOGIN_SID, WLOGIN_SIG64, WLOGIN_SKEY, WLOGIN_TOKEN, WLOGIN_VKEY
        )
    }

    fun getUin(): String {
        return app.currentUin.ifBlank { "0" }
    }

    fun getLongUin(): Long {
        return app.longAccountUin
    }

    fun getUid(): String {
        return app.currentUid.ifBlank { "u_" }
    }

    fun getNickname(): String {
        return app.currentNickname
    }

    fun getCookie(): String {
        val uin = getUin()
        val skey = getRealSkey(uin)
        val pskey = getPSKey(uin)
        return "uin=o$uin; skey=$skey; p_uin=o$uin; p_skey=$pskey"
    }

    suspend fun getCookie(domain: String): String {
        val uin = getUin()
        val skey = getRealSkey(uin)
        val pskey = getPSKey(uin, domain) ?: ""
        val pt4token = getPt4Token(uin, domain) ?: ""
        return "uin=o$uin; skey=$skey; p_uin=o$uin; p_skey=$pskey; pt4_token=$pt4token"
    }

    fun getBigdataTicket(): BigDataTicket? {
        return runCatching {
            QRoute.api(IGuildTransFileApi::class.java).bigDataTicket?.let {
                BigDataTicket(it.getSessionKey(), it.getSessionSig())
            }
        }.getOrNull()
    }

    fun getCSRF(pskey: String = getPSKey(getUin())): String {
        if (pskey.isEmpty()) {
            return "0"
        }
        var v = 5381
        for (element in pskey) {
            v += ((v shl 5) + element.code.toLong()).toInt()
        }
        return (v and Int.MAX_VALUE).toString()
    }

    suspend fun getCSRF(uin: String, domain: String): String {
        // 是不是要用Skey？
        return getBkn(getPSKey(uin, domain) ?: getSKey(uin))
    }
    
    fun getBkn(arg: String): String {
        var v: Long = 5381
        for (element in arg) {
            v += (v shl 5 and 2147483647L) + element.code.toLong()
        }
        return (v and 2147483647L).toString()
    }

    fun getTicket(uin: String, id: Int): Ticket? {
        return (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getLocalTicket(uin, id)
    }

    fun getStWeb(uin: String): String {
        return (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getStweb(uin)
    }

    fun getSKey(uin: String): String {
        return (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getSkey(uin)
    }

    fun getRealSkey(uin: String): String {
        return (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getRealSkey(uin)
    }

    fun getPSKey(uin: String): String {
        val manager = (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager)
        manager.reloadCache(MobileQQ.getContext())
        return manager.getSuperkey(uin) ?: ""
    }

    suspend fun getLessPSKey(vararg domain: String): Result<List<oidb_cmd0x102a.PSKey>> {
        val req = oidb_cmd0x102a.GetPSkeyRequest()
        req.domains.set(domain.toList())
        val buffer = sendOidbAW("OidbSvcTcp.0x102a", 4138, 0, req.toByteArray())
            ?: return Result.failure(Exception("getLessPSKey failed"))
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(buffer.slice(4))
        val rsp = oidb_cmd0x102a.GetPSkeyResponse().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return Result.success(rsp.private_keys.get())
    }

    suspend fun getPSKey(uin: String, domain: String): String? {
        return (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getPskey(uin, domain).let {
            if (it.isNullOrBlank())
                getLessPSKey(domain).getOrNull()?.firstOrNull()?.key?.get()
            else it
        }
    }

    fun getPt4Token(uin: String, domain: String): String? {
        return (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getPt4Token(uin, domain)
    }

    suspend fun GetHttpCookies(appid: String, daid: String, jumpurl: String): String? {
        val uin = getUin()
        val clientkey = getStWeb(uin)
        var url = "https://ui.ptlogin2.qq.com/cgi-bin/login?pt_hide_ad=1&style=9&appid=$appid&pt_no_auth=1&pt_wxtest=1&daid=$daid&s_url=$jumpurl"
        var cookie = GlobalClientNoRedirect.get(url).headers.getAll("Set-Cookie")?.joinToString(";")
        url = "https://ssl.ptlogin2.qq.com/jump?u1=$jumpurl&pt_report=1&daid=$daid&style=9&keyindex=19&clientuin=$uin&clientkey=$clientkey"
        GlobalClientNoRedirect.get(url) {
            header("Cookie", cookie)
        }.let {
            cookie = it.headers.getAll("Set-Cookie")?.joinToString(";")
            url = it.headers["Location"].toString()
        }
        cookie = GlobalClientNoRedirect.get(url).headers.getAll("Set-Cookie")?.joinToString(";")
        val extractedCookie = StringBuilder()
        val cookies = cookie?.split(";")
        cookies?.filter { cookie ->
            val cookiePair = cookie.trim().split("=")
            cookiePair.size == 2 && cookiePair[1].isNotBlank() && cookiePair[0].trim() in listOf("uin", "skey", "p_uin", "p_skey", "pt4_token")
        }?.forEach {
            extractedCookie.append("$it; ")
        }
        return extractedCookie.toString().trim()
    }
}