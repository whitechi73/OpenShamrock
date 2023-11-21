package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class structmsg$RspHead extends MessageMicro<structmsg$RspHead> {
  static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "msg_fail" }, new Object[] { Integer.valueOf(0), "" }, structmsg$RspHead.class);
  
  public final PBStringField msg_fail = PBField.initString("");
  
  public final PBInt32Field result = PBField.initInt32(0);
}

