@file:OptIn(ExperimentalSerializationApi::class)
package protobuf.oidb.cmd0x11c5

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf

@Serializable
data class Oidb0x11c5Req(
    @ProtoNumber(1) val head: MultiMediaRoutingHead,
    @ProtoNumber(3) val dataInfo: MultiMediaDataInfo
): Protobuf<Oidb0x11c5Req>

@Serializable
data class Oidb0x11c5Resp(
    @ProtoNumber(1) val head: Head,
    @ProtoNumber(3) val result: DownloadResult?
): Protobuf<Oidb0x11c5Resp> {
    companion object {
        @Serializable
        data class Head(
            //@ProtoNumber(1) val request: Request,
            @ProtoNumber(3) val msg: String
        ) {
            /*companion object {
                @Serializable
                data class Request(
                    @ProtoNumber(1) val u1: UInt,
                    @ProtoNumber(2) val u2: UInt
                )
            }*/
        }

        @Serializable
        data class DownloadResult(
            @ProtoNumber(1) val rkeyParam: String,
            @ProtoNumber(2) val expire: UInt,
        )
    }
}

@Serializable
data class MultiMediaDataInfo(
    @ProtoNumber(1) val multiMedia: MultiMedia,
    @ProtoNumber(2) val ext: EXT,
) {
    companion object {
        @Serializable
        data class MultiMedia(
            @ProtoNumber(1) val picture: Picture,
            @ProtoNumber(2) val fileId: String,
            @ProtoNumber(3) val u1: UInt,
            @ProtoNumber(4) val u2: UInt,
            @ProtoNumber(5) val u3: UInt,
            @ProtoNumber(6) val u4: UInt,
        )

        @Serializable
        data class Picture(
            @ProtoNumber(1) val size: ULong,
            @ProtoNumber(2) val md5: String,
            @ProtoNumber(3) val sha: String,
            @ProtoNumber(4) val fileName: String,
            @ProtoNumber(5) val u1: U3,
            @ProtoNumber(6) val width: UInt,
            @ProtoNumber(7) val height: UInt,
            @ProtoNumber(8) val u2: UInt,
            @ProtoNumber(9) val u3: UInt,
        )

        @Serializable
        data class U3(
            @ProtoNumber(1) val u1: UInt,
            @ProtoNumber(2) val u2: UInt,
            @ProtoNumber(3) val u3: UInt,
            @ProtoNumber(4) val u4: UInt,
        )

        @Serializable
        data class EXT(
            @ProtoNumber(2) val u1: U1,
        )

        @Serializable
        data class U1(
            @ProtoNumber(1) val u1: UInt,
            @ProtoNumber(3) val u2: UInt,
            @ProtoNumber(4) val u3: U2,
            @ProtoNumber(5) val u4: UInt,
        )

        @Serializable
        data class U2(
            @ProtoNumber(1) val u1: ByteArray,
            @ProtoNumber(2) val u2: ByteArray,
            @ProtoNumber(3) val u3: ByteArray,
        )

    }
}

@Serializable
data class MultiMediaRoutingHead(
    @ProtoNumber(1) val request: Request,
    @ProtoNumber(2) val peerUser: PeerUser,
    @ProtoNumber(3) val u1: U1
) {
    companion object {
        @Serializable
        data class U1(
            @ProtoNumber(1) val u1: UInt,
        )

        @Serializable
        data class Request(
            @ProtoNumber(1) val u1: UInt,
            @ProtoNumber(2) val u2: UInt
        )

        @Serializable
        data class PeerUser(
            @ProtoNumber(101) val u1: UInt,
            @ProtoNumber(102) val u2: UInt,
            @ProtoNumber(200) val u3: UInt,
            @ProtoNumber(201) val peer: Peer,
        )

        @Serializable
        data class Peer(
            @ProtoNumber(1) val u1: UInt,
            @ProtoNumber(2) val uid: String
        )
    }
}