package moe.fuqiuluo.qqinterface.servlet

import VIP.GetCustomOnlineStatusReq
import VIP.GetCustomOnlineStatusRsp
import com.qq.jce.wup.UniPacket
import com.tencent.mobileqq.data.Card
import com.tencent.mobileqq.profilecard.api.IProfileDataService
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import mqq.app.Packet
import tencent.im.oidb.cmd0x11b2.oidb_0x11b2
import tencent.im.oidb.oidb_sso
import kotlin.coroutines.resume

internal object CardSvc: BaseSvc() {
    private val GetModelShowLock = Mutex()
    private val refreshCardLock = Mutex()

    suspend fun getModelShow(uin: Long = app.longAccountUin): String {
        return GetModelShowLock.withLock {
            val uniPacket = UniPacket()
            uniPacket.servantName = "VIP.CustomOnlineStatusServer.CustomOnlineStatusObj"
            uniPacket.funcName = "GetCustomOnlineStatus"
            val getCustomOnlineStatusReq = GetCustomOnlineStatusReq()
            getCustomOnlineStatusReq.lUin = uin
            getCustomOnlineStatusReq.sIMei = ""
            uniPacket.put("req", getCustomOnlineStatusReq)

            val resp = sendBufferAW("VipCustom.GetCustomOnlineStatus", false, uniPacket.encode())
                ?: error("unable to fetch contact model_show")
            Packet.decodePacket(resp, "rsp",  GetCustomOnlineStatusRsp()).sBuffer
        }
    }

    suspend fun setModelShow(model: String, manu: String, modelShow: String, imei: String, show: Boolean) {
        val cookie = TicketSvc.getCookie("vip.qq.com")
        val csrf = TicketSvc.getCSRF(TicketSvc.getUin(), "vip.qq.com")
        val p4token = TicketSvc.getPt4Token(TicketSvc.getUin(), "vip.qq.com") ?: ""
        GlobalClient.post("https://club.vip.qq.com/srf-cgi-node?srfname=VIP.CustomOnlineStatusServer.CustomOnlineStatusObj.SetCustomOnlineStatus&ts=${System.currentTimeMillis()}&daid=18&g_tk=$csrf&pt4_token=$p4token") {
            header("Cookie", cookie)
            contentType(Json)
            setBody(mapOf(
                "servicesName" to "VIP.CustomOnlineStatusServer.CustomOnlineStatusObj",
                "cmd" to "SetCustomOnlineStatus",
                "args" to listOf(mapOf(
                    "sIMei" to imei,
                    "sModel" to model,
                    "sManu" to manu,
                    "lUin" to app.currentUin.toLong(),
                    "bShowInfo" to show,
                    "sModelShow" to modelShow
                ))
            ).json.toString())
        }.bodyAsText().let {
            LogCenter.log({ "setModelShow() => $it" }, Level.DEBUG)
        }
    }

    suspend fun getSharePrivateArkMsg(peerId: Long): String {
        val reqBody = oidb_0x11b2.BusinessCardV3Req()
        reqBody.uin.set(peerId)
        reqBody.jump_url.set("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=$peerId")

        val buffer = sendOidbAW("OidbSvcTrpcTcp.0x11ca_0", 4790, 0, reqBody.toByteArray())
            ?: error("unable to fetch contact ark_json_text")
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(buffer.slice(4))
        val rsp = oidb_0x11b2.BusinessCardV3Rsp()
        rsp.mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return rsp.signed_ark_msg.get()
    }

    suspend fun getProfileCard(uin: String): Result<Card> {
        return getProfileCardFromCache(uin).onFailure {
            return refreshAndGetProfileCard(uin)
        }
    }

    fun getProfileCardFromCache(uin: String): Result<Card> {
        val profileDataService = app
            .getRuntimeService(IProfileDataService::class.java, "all")
        val card = profileDataService.getProfileCard(uin, true)
        return if (card == null || card.strNick.isNullOrEmpty()) {
            Result.failure(Exception("unable to fetch profile card"))
        } else {
            Result.success(card)
        }
    }

    suspend fun refreshAndGetProfileCard(uin: String): Result<Card> {
        val dataService = app
            .getRuntimeService(IProfileDataService::class.java, "all")
        val card = refreshCardLock.withLock {
            suspendCancellableCoroutine<Card?> {
                app.addObserver(object: ProfileCardObserver() {
                    override fun onGetProfileCard(success: Boolean, obj: Any) {
                        app.removeObserver(this)
                        if (!success || obj !is Card) {
                            it.resume(null)
                        } else {
                            dataService.saveProfileCard(obj)
                            it.resume(obj)
                        }
                    }
                })
                app.getRuntimeService(IProfileProtocolService::class.java, "all")
                    .requestProfileCard(app.currentUin, uin, 12, 0L, 0.toByte(), 0L, 0L, null, "", 0L, 10004, null, 0.toByte())
            }
        }
        return if (card == null || card.strNick.isNullOrEmpty()) {
            Result.failure(Exception("unable to fetch profile card"))
        } else {
            Result.success(card)
        }
    }

}