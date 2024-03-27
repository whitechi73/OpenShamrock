@file:OptIn(DelicateCoroutinesApi::class)
package kritor.client

import com.google.protobuf.ByteString
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.kritor.common.Request
import io.kritor.common.Response
import io.kritor.event.EventServiceGrpcKt
import io.kritor.event.EventStructure
import io.kritor.event.EventType
import io.kritor.reverse.ReverseServiceGrpcKt
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kritor.handlers.handleGrpc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter
import kotlin.time.Duration.Companion.seconds

internal class KritorClient(
    val host: String,
    val port: Int
) {
    private lateinit var channel: ManagedChannel

    private lateinit var channelJob: Job
    private val senderChannel = MutableSharedFlow<Response>()

    fun start() {
        runCatching {
            if (::channel.isInitialized && isActive()){
                channel.shutdown()
            }
            channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .enableRetry() // 允许尝试
                .executor(Dispatchers.IO.asExecutor()) // 使用协程的调度器
                .build()
        }.onFailure {
            LogCenter.log("KritorClient start failed: ${it.stackTraceToString()}", Level.ERROR)
        }
    }

    fun listen(retryCnt: Int = -1) {
        if (::channelJob.isInitialized && channelJob.isActive) {
            channelJob.cancel()
        }
        channelJob = GlobalScope.launch(Dispatchers.IO) {
            runCatching {
                val stub = ReverseServiceGrpcKt.ReverseServiceCoroutineStub(channel)
                registerEvent(EventType.EVENT_TYPE_MESSAGE)
                registerEvent(EventType.EVENT_TYPE_CORE_EVENT)
                registerEvent(EventType.EVENT_TYPE_REQUEST)
                registerEvent(EventType.EVENT_TYPE_NOTICE)
                stub.reverseStream(channelFlow {
                    senderChannel.collect { send(it) }
                }).collect {
                    onReceive(it)
                }
            }.onFailure {
                LogCenter.log("KritorClient listen failed, retry after 15s: ${it.stackTraceToString()}", Level.WARN)
            }
            delay(15.seconds)
            LogCenter.log("KritorClient listen retrying, retryCnt = $retryCnt", Level.WARN)
            if (retryCnt != 0) listen(retryCnt - 1)
        }
    }

    fun registerEvent(eventType: EventType) {
        GlobalScope.launch(Dispatchers.IO) {
            runCatching {
                EventServiceGrpcKt.EventServiceCoroutineStub(channel).registerPassiveListener(channelFlow {
                    when(eventType) {
                        EventType.EVENT_TYPE_MESSAGE -> GlobalEventTransmitter.onMessageEvent {
                            send(EventStructure.newBuilder().apply {
                                this.type = EventType.EVENT_TYPE_MESSAGE
                                this.message = it.second
                            }.build())
                        }
                        EventType.EVENT_TYPE_CORE_EVENT -> {}
                        EventType.EVENT_TYPE_NOTICE -> GlobalEventTransmitter.onNoticeEvent {
                            send(EventStructure.newBuilder().apply {
                                this.type = EventType.EVENT_TYPE_NOTICE
                                this.notice = it
                            }.build())
                        }
                        EventType.EVENT_TYPE_REQUEST -> GlobalEventTransmitter.onRequestEvent {
                            send(EventStructure.newBuilder().apply {
                                this.type = EventType.EVENT_TYPE_REQUEST
                                this.request = it
                            }.build())
                        }
                        EventType.UNRECOGNIZED -> {}
                    }
                })
            }.onFailure {
                LogCenter.log("KritorClient registerEvent failed: ${it.stackTraceToString()}", Level.ERROR)
            }
        }
    }

    private suspend fun onReceive(request: Request) = GlobalScope.launch {
        //LogCenter.log("KritorClient onReceive: $request")
        runCatching {
            val rsp = handleGrpc(request.cmd, request.buf.toByteArray())
            senderChannel.emit(Response.newBuilder()
                .setCmd(request.cmd)
                .setCode(Response.ResponseCode.SUCCESS)
                .setMsg("success")
                .setSeq(request.seq)
                .setBuf(ByteString.copyFrom(rsp))
                .build())
        }.onFailure {
            senderChannel.emit(Response.newBuilder()
                .setCmd(request.cmd)
                .setCode(Response.ResponseCode.INTERNAL)
                .setMsg(it.stackTraceToString())
                .setSeq(request.seq)
                .setBuf(ByteString.EMPTY)
                .build())
        }
    }

    fun isActive(): Boolean {
        return !channel.isShutdown
    }

    fun close() {
        channel.shutdown()
    }
}