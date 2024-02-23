package protobuf.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class ElemFlags2(
    @ProtoNumber(1) var color_text_id: UInt? = null,
    @ProtoNumber(2) var msg_id: ULong? = null,
    @ProtoNumber(3) var whisper_session_id: UInt? = null,
    @ProtoNumber(4) var ptt_change_bit: UInt? = null,
    @ProtoNumber(5) var vip_status: UInt? = null,
    @ProtoNumber(6) var compatible_id: UInt? = null,
    @ProtoNumber(7) var rpt_insts: List<Inst>? = null,
    @ProtoNumber(8) var msg_rpt_cnt: UInt? = null,
    @ProtoNumber(9) var src_inst: Inst? = null,
    @ProtoNumber(10) var longtitude: UInt? = null,
    @ProtoNumber(11) var latitude: UInt? = null,
    @ProtoNumber(12) var custom_font: UInt? = null,
    @ProtoNumber(13) var pc_support_def: PcSupportDef? = null,
    @ProtoNumber(14) var crm_flags: UInt? = null,
)

@Serializable
data class Inst(
    @ProtoNumber(1) var app_id: UInt? = null,
    @ProtoNumber(2) var inst_id: UInt? = null,
)

@Serializable
data class PcSupportDef(
    @ProtoNumber(1) var pc_ptl_begin: UInt? = null,
    @ProtoNumber(2) var pc_ptl_end: UInt? = null,
    @ProtoNumber(3) var mac_ptl_begin: UInt? = null,
    @ProtoNumber(4) var mac_ptl_end: UInt? = null,
    @ProtoNumber(5) var rpt_ptls_support: List<Int>? = null,
    @ProtoNumber(6) var rpt_ptls_not_support: List<Int>? = null,
)