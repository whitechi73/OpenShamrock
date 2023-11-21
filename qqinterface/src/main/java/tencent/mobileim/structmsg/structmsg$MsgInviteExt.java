package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$MsgInviteExt extends MessageMicro<structmsg$MsgInviteExt> {
  static final FieldMap __fieldMap__;
  
  public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_wait_state = PBField.initUInt32(0);
  
  public final PBUInt64Field uint64_src_code = PBField.initUInt64(0L);
  
  static {
    Integer integer = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_src_type", "uint64_src_code", "uint32_wait_state" }, new Object[] { integer, Long.valueOf(0L), integer }, structmsg$MsgInviteExt.class);
  }
}
