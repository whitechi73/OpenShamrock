package kritor.service

import io.kritor.event.EventRequest
import io.kritor.event.EventServiceGrpcKt
import io.kritor.event.EventStructure
import io.kritor.event.EventType
import io.kritor.event.eventStructure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter

object EventService: EventServiceGrpcKt.EventServiceCoroutineImplBase() {
    override fun registerActiveListener(request: EventRequest): Flow<EventStructure> {
        return channelFlow {
            when(request.type!!) {
                EventType.CORE_EVENT -> TODO()
                EventType.MESSAGE -> GlobalEventTransmitter.onMessageEvent {
                    send(eventStructure {
                        this.type = EventType.MESSAGE
                        this.message = it.second
                    })
                }
                EventType.NOTICE -> TODO()
                EventType.REQUEST -> TODO()
                EventType.UNRECOGNIZED -> TODO()
            }
        }
    }
}
