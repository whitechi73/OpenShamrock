package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.event.EventServiceGrpcKt
import io.kritor.event.EventStructure
import io.kritor.event.EventType
import io.kritor.event.RequestPushEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter

internal object EventService : EventServiceGrpcKt.EventServiceCoroutineImplBase() {
    override fun registerActiveListener(request: RequestPushEvent): Flow<EventStructure> {
        return channelFlow {
            when (request.type!!) {
                EventType.EVENT_TYPE_CORE_EVENT -> {}
                EventType.EVENT_TYPE_MESSAGE -> GlobalEventTransmitter.onMessageEvent {
                    send(EventStructure.newBuilder().apply {
                        this.type = EventType.EVENT_TYPE_MESSAGE
                        this.message = it.second
                    }.build())
                }

                EventType.EVENT_TYPE_NOTICE -> GlobalEventTransmitter.onRequestEvent {
                    send(EventStructure.newBuilder().apply {
                        this.type = EventType.EVENT_TYPE_NOTICE
                        this.request = it
                    }.build())
                }

                EventType.EVENT_TYPE_REQUEST -> GlobalEventTransmitter.onNoticeEvent {
                    send(EventStructure.newBuilder().apply {
                        this.type = EventType.EVENT_TYPE_NOTICE
                        this.notice = it
                    }.build())
                }

                EventType.UNRECOGNIZED -> throw StatusRuntimeException(Status.INVALID_ARGUMENT)
            }
        }
    }
}
