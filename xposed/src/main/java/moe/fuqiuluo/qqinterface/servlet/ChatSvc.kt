package moe.fuqiuluo.qqinterface.servlet

import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import protobuf.oidb.cmd0x9082.Oidb0x9082

internal object ChatSvc: BaseSvc() {
    fun setGroupMessageCommentFace(peer: Long, msgSeq: ULong, faceIndex: String, isSet: Boolean) {
        val serviceId = if (isSet) 1 else 2
        sendOidb("OidbSvcTrpcTcp.0x9082_$serviceId", 36994, serviceId, ProtoBuf.encodeToByteArray(
            Oidb0x9082(
            peer = peer.toULong(),
            msgSeq = msgSeq,
            faceIndex = faceIndex,
            flag = 1u,
            u1 = 0u,
            u2 = 0u
        )
        ))
    }
}