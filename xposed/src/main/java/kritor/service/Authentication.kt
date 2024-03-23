package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.AuthCode
import io.kritor.AuthReq
import io.kritor.AuthRsp
import io.kritor.AuthenticationGrpcKt
import io.kritor.GetAuthStateReq
import io.kritor.GetAuthStateRsp
import kritor.auth.AuthInterceptor
import moe.fuqiuluo.shamrock.config.ActiveTicket
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import qq.service.QQInterfaces

internal object Authentication: AuthenticationGrpcKt.AuthenticationCoroutineImplBase() {
    @Grpc("Authentication", "Auth")
    override suspend fun auth(request: AuthReq): AuthRsp {
        if (QQInterfaces.app.account != request.account) {
            return AuthRsp.newBuilder().apply {
                code = AuthCode.NO_ACCOUNT
                msg = "No such account"
            }.build()
        }

        val activeTicketName = ActiveTicket.name()
        var index = 0
        while (true) {
            val ticket = ShamrockConfig.getProperty(activeTicketName + if (index == 0) "" else ".$index", null)
            if (ticket.isNullOrEmpty()) {
                if (index == 0) {
                    return AuthRsp.newBuilder().apply {
                        code = AuthCode.OK
                        msg = "OK"
                    }.build()
                } else {
                    break
                }
            } else if (ticket == request.ticket) {
                return AuthRsp.newBuilder().apply {
                    code = AuthCode.OK
                    msg = "OK"
                }.build()
            }
            index++
        }

        return AuthRsp.newBuilder().apply {
            code = AuthCode.NO_TICKET
            msg = "Invalid ticket"
        }.build()
    }

    @Grpc("Authentication", "GetAuthState")
    override suspend fun getAuthState(request: GetAuthStateReq): GetAuthStateRsp {
        if (request.account != QQInterfaces.app.account) {
            throw StatusRuntimeException(Status.CANCELLED.withDescription("No such account"))
        }

        return GetAuthStateRsp.newBuilder().apply {
            isRequiredAuth = AuthInterceptor.getAllTicket().isNotEmpty()
        }.build()
    }
}