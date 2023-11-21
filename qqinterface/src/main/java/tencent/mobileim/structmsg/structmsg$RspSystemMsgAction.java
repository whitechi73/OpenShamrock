package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$RspSystemMsgAction extends MessageMicro<structmsg$RspSystemMsgAction> {
  static final FieldMap __fieldMap__;
  
  public structmsg$RspHead head = new structmsg$RspHead();
  
  public final PBStringField msg_detail = PBField.initString("");
  
  public final PBStringField msg_invalid_decided = PBField.initString("");
  
  public final PBUInt32Field remark_result = PBField.initUInt32(0);
  
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static {
    Integer integer = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 42, 48 }, new String[] { "head", "msg_detail", "type", "msg_invalid_decided", "remark_result" }, new Object[] { null, "", integer, "", integer }, structmsg$RspSystemMsgAction.class);
  }
}
