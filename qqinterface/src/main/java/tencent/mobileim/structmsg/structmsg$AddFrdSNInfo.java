package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$AddFrdSNInfo extends MessageMicro<structmsg$AddFrdSNInfo> {
  static final FieldMap __fieldMap__;
  
  public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
  
  public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
  
  static {
    Integer integer = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { integer, integer }, structmsg$AddFrdSNInfo.class);
  }
}

