package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqSystemMsgRead extends MessageMicro<structmsg$ReqSystemMsgRead> {
  static final FieldMap __fieldMap__;
  
  public final PBEnumField checktype = PBField.initEnum(1);
  
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  
  static {
    Long long_ = Long.valueOf(0L);
    Integer integer = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "latest_friend_seq", "latest_group_seq", "type", "checktype", "uint32_req_msg_type" }, new Object[] { long_, long_, integer, Integer.valueOf(1), integer }, structmsg$ReqSystemMsgRead.class);
  }
}
