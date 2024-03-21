package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.web.GetCSRFTokenRequest
import io.kritor.web.GetCSRFTokenResponse
import io.kritor.web.GetCookiesRequest
import io.kritor.web.GetCookiesResponse
import io.kritor.web.GetCredentialsRequest
import io.kritor.web.GetCredentialsResponse
import io.kritor.web.GetHttpCookiesRequest
import io.kritor.web.GetHttpCookiesResponse
import io.kritor.web.WebServiceGrpcKt
import io.kritor.web.getCSRFTokenResponse
import io.kritor.web.getCookiesResponse
import io.kritor.web.getCredentialsResponse
import io.kritor.web.getHttpCookiesResponse
import qq.service.ticket.TicketHelper

internal object WebService: WebServiceGrpcKt.WebServiceCoroutineImplBase() {
    @Grpc("WebService", "GetCookies")
    override suspend fun getCookies(request: GetCookiesRequest): GetCookiesResponse {
        return getCookiesResponse {
            if (request.domain.isNullOrEmpty()) {
                this.cookie = TicketHelper.getCookie()
            } else {
                this.cookie = TicketHelper.getCookie(request.domain)
            }
        }
    }

    @Grpc("WebService", "GetCredentials")
    override suspend fun getCredentials(request: GetCredentialsRequest): GetCredentialsResponse {
        return getCredentialsResponse {
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
        }
    }

    @Grpc("WebService", "GetCSRFToken")
    override suspend fun getCSRFToken(request: GetCSRFTokenRequest): GetCSRFTokenResponse {
        return getCSRFTokenResponse {
            if (request.domain.isNullOrEmpty()) {
                this.bkn = TicketHelper.getCSRF()
            } else {
                this.bkn = TicketHelper.getCSRF(TicketHelper.getUin(), request.domain)
            }
        }
    }

    @Grpc("WebService", "GetHttpCookies")
    override suspend fun getHttpCookies(request: GetHttpCookiesRequest): GetHttpCookiesResponse {
        return getHttpCookiesResponse {
            this.cookie = TicketHelper.getHttpCookies(request.appid, request.daid, request.jumpUrl)
                ?: throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get http cookies"))
        }
    }


}