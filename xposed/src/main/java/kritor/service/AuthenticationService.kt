package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.authentication.*
import io.kritor.authentication.AuthenticateResponse.AuthenticateResponseCode
import kritor.auth.AuthInterceptor
import moe.fuqiuluo.shamrock.config.ActiveTicket
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import qq.service.QQInterfaces

internal object AuthenticationService: AuthenticationServiceGrpcKt.AuthenticationServiceCoroutineImplBase() {
    @Grpc("AuthenticationService", "Authenticate")
    override suspend fun authenticate(request: AuthenticateRequest): AuthenticateResponse {
        if (QQInterfaces.app.account != request.account) {
            return AuthenticateResponse.newBuilder().apply {
                code = AuthenticateResponseCode.NO_ACCOUNT
                msg = "No such account"
            }.build()
        }

        val activeTicketName = ActiveTicket.name()
        var index = 0
        while (true) {
            val ticket = ShamrockConfig.getProperty(activeTicketName + if (index == 0) "" else ".$index", null)
            if (ticket.isNullOrEmpty()) {
                if (index == 0) {
                    return AuthenticateResponse.newBuilder().apply {
                        code = AuthenticateResponseCode.OK
                        msg = "OK"
                    }.build()
                } else {
                    break
                }
            } else if (ticket == request.ticket) {
                return AuthenticateResponse.newBuilder().apply {
                    code = AuthenticateResponseCode.OK
                    msg = "OK"
                }.build()
            }
            index++
        }

        return AuthenticateResponse.newBuilder().apply {
            code = AuthenticateResponseCode.NO_TICKET
            msg = "Invalid ticket"
        }.build()
    }

    @Grpc("AuthenticationService", "GetAuthenticationState")
    override suspend fun getAuthenticationState(request: GetAuthenticationStateRequest): GetAuthenticationStateResponse {
        if (request.account != QQInterfaces.app.account) {
            throw StatusRuntimeException(Status.CANCELLED.withDescription("No such account"))
        }

        return GetAuthenticationStateResponse.newBuilder().apply {
            isRequired = AuthInterceptor.getAllTicket().isNotEmpty()
        }.build()
    }
}