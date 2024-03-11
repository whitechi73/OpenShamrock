package kritor.auth

import io.grpc.ForwardingServerCallListener
import io.grpc.Metadata
import io.grpc.ServerCall
import io.grpc.ServerCallHandler
import io.grpc.ServerInterceptor
import moe.fuqiuluo.shamrock.config.ActiveTicket
import moe.fuqiuluo.shamrock.config.ShamrockConfig

object AuthInterceptor: ServerInterceptor {
    /**
     * Intercept [ServerCall] dispatch by the `next` [ServerCallHandler]. General
     * semantics of [ServerCallHandler.startCall] apply and the returned
     * [io.grpc.ServerCall.Listener] must not be `null`.
     *
     *
     * If the implementation throws an exception, `call` will be closed with an error.
     * Implementations must not throw an exception if they started processing that may use `call` on another thread.
     *
     * @param call object to receive response messages
     * @param headers which can contain extra call metadata from [ClientCall.start],
     * e.g. authentication credentials.
     * @param next next processor in the interceptor chain
     * @return listener for processing incoming messages for `call`, never `null`.
     */
    override fun <ReqT : Any?, RespT : Any?> interceptCall(
        call: ServerCall<ReqT, RespT>,
        headers: Metadata?,
        next: ServerCallHandler<ReqT, RespT>
    ): ServerCall.Listener<ReqT> {
        val methodName = call.methodDescriptor.fullMethodName
        val ticket = getAllTicket()
        if (ticket.isNotEmpty() && !methodName.startsWith("Auth")) {
            val ticketHeader = headers?.get(Metadata.Key.of("ticket", Metadata.ASCII_STRING_MARSHALLER))
            if (ticketHeader == null || ticketHeader !in ticket) {
                call.close(io.grpc.Status.UNAUTHENTICATED.withDescription("Invalid ticket"), Metadata())
                return object: ServerCall.Listener<ReqT>() {}
            }
        }
        return object: ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(call, headers)) {
        }
    }

    fun getAllTicket(): List<String> {
        val result = arrayListOf<String>()
        val activeTicketName = ActiveTicket.name()
        var index = 0
        while (true) {
            val ticket = ShamrockConfig.getProperty(activeTicketName + if (index == 0) "" else ".$index", null)
            if (ticket.isNullOrEmpty()) {
                if (index == 0) {
                    return result
                } else {
                    break
                }
            } else {
                result.add(ticket)
            }
            index++
        }
        return result
    }
}