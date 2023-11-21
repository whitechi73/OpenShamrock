package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqSystemMsgNew extends MessageMicro<structmsg$ReqSystemMsgNew> {
  static final FieldMap __fieldMap__;
  
  public final PBEnumField checktype = PBField.initEnum(1);
  
  public structmsg$FlagInfo flag = new structmsg$FlagInfo();
  
  public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);
  
  public final PBBoolField is_get_frd_ribbon = PBField.initBool(true);
  
  public final PBBoolField is_get_grp_ribbon = PBField.initBool(true);
  
  public final PBUInt32Field language = PBField.initUInt32(0);
  
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_need_uid = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static {
    Integer integer = Integer.valueOf(0);
    Long long_ = Long.valueOf(0L);
    Boolean bool = Boolean.TRUE;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 
          8, 16, 24, 32, 40, 50, 56, 64, 72, 80, 
          88, 128 }, new String[] { 
          "msg_num", "latest_friend_seq", "latest_group_seq", "version", "checktype", "flag", "language", "is_get_frd_ribbon", "is_get_grp_ribbon", "friend_msg_type_flag", 
          "uint32_req_msg_type", "uint32_need_uid" }, new Object[] { 
          integer, long_, long_, integer, Integer.valueOf(1), null, integer, bool, bool, long_, 
          integer, integer }, structmsg$ReqSystemMsgNew.class);
  }
}
