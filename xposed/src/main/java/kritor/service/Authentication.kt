package kritor.service

import io.kritor.AuthCode
import io.kritor.AuthReq
import io.kritor.AuthRsp
import io.kritor.AuthenticationGrpcKt
import io.kritor.authRsp
import moe.fuqiuluo.shamrock.config.ActiveTicket
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import qq.service.QQInterfaces

object Authentication: AuthenticationGrpcKt.AuthenticationCoroutineImplBase() {
    @Grpc("Authentication", "Auth")
    override suspend fun auth(request: AuthReq): AuthRsp {
        if (QQInterfaces.app.account != request.account) {
            return authRsp {
                code = AuthCode.NO_ACCOUNT
                msg = "No such account"
            }
        }

        val activeTicketName = ActiveTicket.name()
        var index = 0
        while (true) {
            val ticket = ShamrockConfig.getProperty(activeTicketName + if (index == 0) "" else ".$index", null)
            if (ticket.isNullOrEmpty()) {
                if (index == 0) {
                    return authRsp {
                        code = AuthCode.OK
                        msg = "OK"
                    }
                } else {
                    break
                }
            } else if (ticket == request.ticket) {
                return authRsp {
                    code = AuthCode.OK
                    msg = "OK"
                }
            }
            index++
        }

        return authRsp {
            code = AuthCode.NO_TICKET
            msg = "Invalid ticket"
        }
    }
}