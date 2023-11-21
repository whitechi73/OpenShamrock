package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$SystemMsg extends MessageMicro<structmsg$SystemMsg> {
  static final FieldMap __fieldMap__;
  
  public final PBUInt64Field action_uin = PBField.initUInt64(0L);
  
  public final PBStringField action_uin_nick;
  
  public final PBBytesField action_uin_qq_nick;
  
  public final PBBytesField action_uin_remark;
  
  public final PBRepeatMessageField<structmsg$SystemMsgAction> actions = PBField.initRepeatMessage(structmsg$SystemMsgAction.class);
  
  public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
  
  public final PBStringField actor_uin_nick;
  
  public final PBBytesField bytes_addtion;
  
  public final PBBytesField bytes_game_msg;
  
  public final PBBytesField bytes_game_nick;
  
  public final PBBytesField bytes_name_more;
  
  public final PBBytesField bytes_source_desc;
  
  public final PBBytesField bytes_transparent_group_notify;
  
  public final PBBytesField bytes_warning_tips;
  
  public final PBUInt32Field card_switch;
  
  public final PBUInt64Field clone_uin = PBField.initUInt64(0L);
  
  public final PBStringField clone_uin_nick;
  
  public final PBBytesField eim_group_id_name;
  
  public structmsg$FriendInfo friend_info = new structmsg$FriendInfo();
  
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  
  public final PBUInt32Field group_ext_flag;
  
  public structmsg$GroupInfo group_info = new structmsg$GroupInfo();
  
  public final PBUInt32Field group_inviter_role = PBField.initUInt32(0);
  
  public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
  
  public final PBStringField group_name;
  
  public final PBStringField msg_actor_describe = PBField.initString("");
  
  public final PBStringField msg_additional = PBField.initString("");
  
  public final PBStringField msg_additional_list = PBField.initString("");
  
  public final PBStringField msg_decided = PBField.initString("");
  
  public final PBStringField msg_describe = PBField.initString("");
  
  public final PBStringField msg_detail;
  
  public structmsg$MsgInviteExt msg_invite_extinfo = new structmsg$MsgInviteExt();
  
  public structmsg$MsgPayGroupExt msg_pay_group_extinfo = new structmsg$MsgPayGroupExt();
  
  public final PBStringField msg_qna;
  
  public final PBStringField msg_source = PBField.initString("");
  
  public final PBStringField msg_title = PBField.initString("");
  
  public final PBBytesField pic_url;
  
  public final PBUInt32Field relation = PBField.initUInt32(0);
  
  public final PBUInt32Field req_uin_age;
  
  public final PBBytesField req_uin_business_card;
  
  public final PBInt32Field req_uin_faceid;
  
  public final PBUInt32Field req_uin_gender;
  
  public final PBStringField req_uin_nick;
  
  public final PBBytesField req_uin_pre_remark;
  
  public final PBUInt32Field reqsubtype = PBField.initUInt32(0);
  
  public final PBUInt32Field src_id = PBField.initUInt32(0);
  
  public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
  
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  
  public final PBStringField uid;
  
  public final PBUInt32Field uint32_c2c_invite_join_group_flag;
  
  public final PBUInt32Field uint32_doubt_flag;
  
  public final PBUInt32Field uint32_group_flagext3;
  
  public final PBUInt32Field uint32_source_flag = PBField.initUInt32(0);
  
  public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  
  public final PBUInt64Field uint64_eim_group_id = PBField.initUInt64(0L);
  
  public final PBUInt64Field uint64_group_owner_uin;
  
  static {
    Integer integer = Integer.valueOf(0);
    Long long_ = Long.valueOf(0L);
    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 
          8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 
          88, 96, 104, 114, 122, 128, 138, 146, 152, 160, 
          168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 
          248, 258, 266, 274, 282, 400, 410, 418, 426, 434, 
          442, 456, 466, 474, 482, 490, 506, 514, 522, 530, 
          536, 544, 552, 808, 866, 882 }, new String[] { 
          "sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code", 
          "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "relation", "reqsubtype", 
          "clone_uin", "uint64_discuss_uin", "uint64_eim_group_id", "msg_invite_extinfo", "msg_pay_group_extinfo", "uint32_source_flag", "bytes_game_nick", "bytes_game_msg", "uint32_group_flagext3", "uint64_group_owner_uin", 
          "uint32_doubt_flag", "bytes_warning_tips", "bytes_name_more", "bytes_addtion", "bytes_transparent_group_notify", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna", 
          "msg_detail", "group_ext_flag", "actor_uin_nick", "pic_url", "clone_uin_nick", "req_uin_business_card", "eim_group_id_name", "req_uin_pre_remark", "action_uin_qq_nick", "action_uin_remark", 
          "req_uin_gender", "req_uin_age", "uint32_c2c_invite_join_group_flag", "card_switch", "bytes_source_desc", "uid" }, new Object[] { 
          integer, "", "", "", "", "", integer, integer, null, long_, 
          long_, integer, integer, null, null, long_, "", "", integer, integer, 
          long_, long_, long_, null, null, integer, byteStringMicro, byteStringMicro, integer, long_, 
          integer, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, integer, "", "", "", "", 
          "", integer, "", byteStringMicro, "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 
          integer, integer, integer, integer, byteStringMicro, "" }, structmsg$SystemMsg.class);
  }
  
  public structmsg$SystemMsg() {
    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
    this.bytes_game_nick = PBField.initBytes(byteStringMicro);
    this.bytes_game_msg = PBField.initBytes(byteStringMicro);
    this.uint32_group_flagext3 = PBField.initUInt32(0);
    this.uint64_group_owner_uin = PBField.initUInt64(0L);
    this.uint32_doubt_flag = PBField.initUInt32(0);
    this.bytes_warning_tips = PBField.initBytes(byteStringMicro);
    this.bytes_name_more = PBField.initBytes(byteStringMicro);
    this.bytes_addtion = PBField.initBytes(byteStringMicro);
    this.bytes_transparent_group_notify = PBField.initBytes(byteStringMicro);
    this.req_uin_faceid = PBField.initInt32(0);
    this.req_uin_nick = PBField.initString("");
    this.group_name = PBField.initString("");
    this.action_uin_nick = PBField.initString("");
    this.msg_qna = PBField.initString("");
    this.msg_detail = PBField.initString("");
    this.group_ext_flag = PBField.initUInt32(0);
    this.actor_uin_nick = PBField.initString("");
    this.pic_url = PBField.initBytes(byteStringMicro);
    this.clone_uin_nick = PBField.initString("");
    this.req_uin_business_card = PBField.initBytes(byteStringMicro);
    this.eim_group_id_name = PBField.initBytes(byteStringMicro);
    this.req_uin_pre_remark = PBField.initBytes(byteStringMicro);
    this.action_uin_qq_nick = PBField.initBytes(byteStringMicro);
    this.action_uin_remark = PBField.initBytes(byteStringMicro);
    this.req_uin_gender = PBField.initUInt32(0);
    this.req_uin_age = PBField.initUInt32(0);
    this.uint32_c2c_invite_join_group_flag = PBField.initUInt32(0);
    this.card_switch = PBField.initUInt32(0);
    this.bytes_source_desc = PBField.initBytes(byteStringMicro);
    this.uid = PBField.initString("");
  }
}
