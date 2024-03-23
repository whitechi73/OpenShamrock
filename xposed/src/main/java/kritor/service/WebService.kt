package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.web.*
import qq.service.ticket.TicketHelper

internal object WebService: WebServiceGrpcKt.WebServiceCoroutineImplBase() {
    @Grpc("WebService", "GetCookies")
    override suspend fun getCookies(request: GetCookiesRequest): GetCookiesResponse {
        return GetCookiesResponse.newBuilder().apply  {
            if (request.domain.isNullOrEmpty()) {
                this.cookie = TicketHelper.getCookie()
            } else {
                this.cookie = TicketHelper.getCookie(request.domain)
            }
        }.build()
    }

    @Grpc("WebService", "GetCredentials")
    override suspend fun getCredentials(request: GetCredentialsRequest): GetCredentialsResponse {
        return GetCredentialsResponse.newBuilder().apply {
            if (request.domain.isNullOrEmpty()) {
                val uin = TicketHelper.getUin()
                val skey = TicketHelper.getRealSkey(uin)
                val pskey = TicketHelper.getPSKey(uin)
                this.cookie = "o_cookie=$uin; ied_qq=o$uin; pac_uid=1_$uin; uin=o$uin; skey=$skey; p_uin=o$uin; p_skey=$pskey;"
                this.bkn = TicketHelper.getCSRF(pskey)
            } else {
                val uin = TicketHelper.getUin()
                val skey = TicketHelper.getRealSkey(uin)
                val pskey = TicketHelper.getPSKey(uin, request.domain) ?: ""
                val pt4token = TicketHelper.getPt4Token(uin, request.domain) ?: ""
                this.cookie = "o_cookie=$uin; ied_qq=o$uin; pac_uid=1_$uin; uin=o$uin; skey=$skey; p_uin=o$uin; p_skey=$pskey; pt4_token=$pt4token;"
                this.bkn = TicketHelper.getCSRF(pskey)
            }
        }.build()
    }

    @Grpc("WebService", "GetCSRFToken")
    override suspend fun getCSRFToken(request: GetCSRFTokenRequest): GetCSRFTokenResponse {
        return GetCSRFTokenResponse.newBuilder().apply {
            if (request.domain.isNullOrEmpty()) {
                this.bkn = TicketHelper.getCSRF()
            } else {
                this.bkn = TicketHelper.getCSRF(TicketHelper.getUin(), request.domain)
            }
        }.build()
    }

    @Grpc("WebService", "GetHttpCookies")
    override suspend fun getHttpCookies(request: GetHttpCookiesRequest): GetHttpCookiesResponse {
        return GetHttpCookiesResponse.newBuilder().apply {
            this.cookie = TicketHelper.getHttpCookies(request.appid, request.daid, request.jumpUrl)
                ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get http cookies"))
        }.build()
    }
}