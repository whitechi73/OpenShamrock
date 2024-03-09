package kritor.server

import io.grpc.ServerBuilder
import moe.fuqiuluo.shamrock.helper.LogCenter

class KritorServer(
    private val port: Int
) {
    private val server = ServerBuilder
        .forPort(port)
        .build()!!

    fun start(block: Boolean = false) {
        LogCenter.log("KritorServer started at port $port.")
        server.start()
        if (block) {
            server.awaitTermination()
        }
    }
}