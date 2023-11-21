package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqNextSystemMsg extends MessageMicro<structmsg$ReqNextSystemMsg> {
  static final FieldMap __fieldMap__;
  
  public final PBEnumField checktype = PBField.initEnum(1);
  
  public structmsg$FlagInfo flag = new structmsg$FlagInfo();
  
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  
  public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);
  
  public final PBUInt32Field language = PBField.initUInt32(0);
  
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_need_uid = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static {
    Integer integer = Integer.valueOf(0);
    Long long_ = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 128 }, new String[] { "msg_num", "following_friend_seq", "following_group_seq", "checktype", "flag", "language", "version", "friend_msg_type_flag", "uint32_req_msg_type", "uint32_need_uid" }, new Object[] { integer, long_, long_, Integer.valueOf(1), null, integer, integer, long_, integer, integer }, structmsg$ReqNextSystemMsg.class);
  }
}
