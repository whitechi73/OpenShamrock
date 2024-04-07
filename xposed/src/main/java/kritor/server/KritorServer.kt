@file:OptIn(ExperimentalCoroutinesApi::class)
package kritor.server

import io.grpc.Grpc
import io.grpc.Metadata
import io.grpc.InsecureServerCredentials
import io.grpc.ServerCall
import io.grpc.ServerCallHandler
import io.grpc.ServerInterceptor
import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kritor.auth.AuthInterceptor
import kritor.service.*
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import qq.service.ticket.TicketHelper
import kotlin.coroutines.CoroutineContext

class KritorServer(
    private val port: Int
): CoroutineScope {

    private val serverInterceptor = object : ServerInterceptor {
        override fun <ReqT, RespT> interceptCall(
            call: ServerCall<ReqT, RespT>, headers: Metadata, next: ServerCallHandler<ReqT, RespT>
        ): ServerCall.Listener<ReqT> {
            return next.startCall(object : SimpleForwardingServerCall<ReqT, RespT>(call) {
                override fun sendHeaders(headers: Metadata?) {
                    headers?.apply {
                        put(Metadata.Key.of("kritor-self-uin", Metadata.ASCII_STRING_MARSHALLER), TicketHelper.getUin())
                        put(Metadata.Key.of("kritor-self-uid", Metadata.ASCII_STRING_MARSHALLER), TicketHelper.getUid())
                        put(Metadata.Key.of("kritor-self-version", Metadata.ASCII_STRING_MARSHALLER), "OpenShamrock-$ShamrockVersion")
                    }
                    super.sendHeaders(headers)
                }
            }, headers)
        }
    }

    private val server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
        .executor(Dispatchers.IO.asExecutor())
        .intercept(AuthInterceptor)
        .intercept(serverInterceptor)
        .addService(AuthenticationService)
        .addService(CoreService)
        .addService(FriendService)
        .addService(GroupService)
        .addService(GroupFileService)
        .addService(MessageService)
        .addService(EventService)
        .addService(WebService)
        .addService(DeveloperService)
        .addService(QsignService)
        .build()!!

    fun start(block: Boolean = false) {
        LogCenter.log("KritorServer started at port $port.")
        server.start()

        if (block) {
            server.awaitTermination()
        }
    }

    override val coroutineContext: CoroutineContext =
        Dispatchers.IO.limitedParallelism(12)
}