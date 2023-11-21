package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$StructMsg extends MessageMicro<structmsg$StructMsg> {
  static final FieldMap __fieldMap__;
  
  public structmsg$SystemMsg msg = new structmsg$SystemMsg();
  
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  
  public final PBEnumField msg_type = PBField.initEnum(1);
  
  public final PBUInt64Field req_uin = PBField.initUInt64(0L);
  
  public final PBUInt32Field uint32_unread_flag = PBField.initUInt32(0);
  
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static {
    Integer integer = Integer.valueOf(0);
    Long long_ = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 402 }, new String[] { "version", "msg_type", "msg_seq", "msg_time", "req_uin", "uint32_unread_flag", "msg" }, new Object[] { integer, Integer.valueOf(1), long_, long_, long_, integer, null }, structmsg$StructMsg.class);
  }
}
