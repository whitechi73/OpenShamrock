package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class structmsg$FriendInfo extends MessageMicro<structmsg$FriendInfo> {
  static final FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_joint_friend", "msg_blacklist" }, new Object[] { "", "" }, structmsg$FriendInfo.class);
  
  public final PBStringField msg_blacklist = PBField.initString("");
  
  public final PBStringField msg_joint_friend = PBField.initString("");
}
