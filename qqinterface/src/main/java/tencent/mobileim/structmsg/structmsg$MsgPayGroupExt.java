package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$MsgPayGroupExt extends MessageMicro<structmsg$MsgPayGroupExt> {
  static final FieldMap __fieldMap__;
  
  public final PBUInt64Field uint64_join_grp_time = PBField.initUInt64(0L);
  
  public final PBUInt64Field uint64_quit_grp_time = PBField.initUInt64(0L);
  
  static {
    Long long_ = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_join_grp_time", "uint64_quit_grp_time" }, new Object[] { long_, long_ }, structmsg$MsgPayGroupExt.class);
  }
}
