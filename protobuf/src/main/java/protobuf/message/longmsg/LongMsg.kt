@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.message.longmsg

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber


@Serializable
data class LongMsgSettings(
    @ProtoNumber(1) val field1: Int? = null,
    @ProtoNumber(2) val field2: Int? = null,
    @ProtoNumber(3) val field3: Int? = null,
    @ProtoNumber(4) val field4: Int? = null,
)

@Serializable
data class LongMsgUid(
    @ProtoNumber(2) val uid: String? = null,
)

@Serializable
data class RecvLongMsgInfo(
    @ProtoNumber(1) val uid: LongMsgUid? = null,
    @ProtoNumber(2) val resId: String? = null,
    @ProtoNumber(3) val acquire: Boolean? = null,
)

@Serializable
data class SendLongMsgInfo(
    @ProtoNumber(1) val type: Int? = null,
    @ProtoNumber(2) val uid: LongMsgUid? = null,
    @ProtoNumber(3) val groupUin: Int? = null,
    @ProtoNumber(4) val payload: ByteArray? = null,
)

@Serializable
data class LongMsgReq(
    @ProtoNumber(1) val recvInfo: RecvLongMsgInfo? = null,
    @ProtoNumber(2) val sendInfo: SendLongMsgInfo? = null,
    @ProtoNumber(15) val setting: LongMsgSettings? = null,
)

@Serializable
data class LongMsgRsp(
    @ProtoNumber(1) val recvResult: RecvLongMsgResult? = null,
    @ProtoNumber(2) val sendResult: SendLongMsgResult? = null,
    @ProtoNumber(15) val setting: LongMsgSettings? = null
) {
    companion object {
        @Serializable
        data class SendLongMsgResult(
            @ProtoNumber(3) val resId: String? = null,
        )

        @Serializable
        data class RecvLongMsgResult(
            @ProtoNumber(3) val resId: String? = null,
            @ProtoNumber(4) val payload: ByteArray? = null,
        )
    }
}
