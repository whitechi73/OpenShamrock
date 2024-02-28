@file:OptIn(ExperimentalSerializationApi::class)

package protobuf.message

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class RichText(
    @ProtoNumber(1) val attr: Attr? = null,
    @ProtoNumber(2) var elements: List<Elem>? = null,
    @ProtoNumber(3) var not_online_file: NotOnlineFile? = null,
    @ProtoNumber(4) var ptt: Ptt? = null,
    @ProtoNumber(5) val tmp_ptt: TmpPtt? = null,
    @ProtoNumber(6) val trans_211_tmp_msg: Trans211TmpMsg? = null,
)

@Serializable
data class Attr(
    @ProtoNumber(1) val codePage: Int? = null,
    @ProtoNumber(2) val time: UInt? = null,
    @ProtoNumber(3) val random: UInt? = null,
    @ProtoNumber(4) val color: UInt? = null,
    @ProtoNumber(5) val size: UInt? = null,
    @ProtoNumber(6) val effect: UInt? = null,
    @ProtoNumber(7) val charSet: UInt? = null,
    @ProtoNumber(8) val pitchAndFamily: UInt? = null,
    @ProtoNumber(9) val fontName: String? = null,
    @ProtoNumber(10) val reserve_data: ByteArray? = null,
)