package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$FlagInfo extends MessageMicro<structmsg$FlagInfo> {
  static final FieldMap __fieldMap__;
  
  public final PBUInt32Field FrdMsg_Discuss2ManyChat = PBField.initUInt32(0);
  
  public final PBUInt32Field FrdMsg_GetBusiCard = PBField.initUInt32(0);
  
  public final PBUInt32Field FrdMsg_NeedWaitingMsg = PBField.initUInt32(0);
  
  public final PBUInt32Field FrdMsg_uint32_need_all_unread_msg = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_GetC2cInviteJoinGroup = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_GetDisbandedByAdmin = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_GetOfficialAccount = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_GetPayInGroup = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_HiddenGrp = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_Kick_Admin = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_NeedAutoAdminWording = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_NotAllowJoinGrp_InviteNotFrd = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_WordingDown = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_get_quit_pay_group_msg_flag = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_get_transfer_group_msg_flag = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_mask_invite_auto_join = PBField.initUInt32(0);
  
  public final PBUInt32Field GrpMsg_support_invite_auto_join = PBField.initUInt32(0);
  
  static {
    Integer integer = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 
          8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 
          88, 96, 104, 112, 120, 128, 136 }, new String[] { 
          "GrpMsg_Kick_Admin", "GrpMsg_HiddenGrp", "GrpMsg_WordingDown", "FrdMsg_GetBusiCard", "GrpMsg_GetOfficialAccount", "GrpMsg_GetPayInGroup", "FrdMsg_Discuss2ManyChat", "GrpMsg_NotAllowJoinGrp_InviteNotFrd", "FrdMsg_NeedWaitingMsg", "FrdMsg_uint32_need_all_unread_msg", 
          "GrpMsg_NeedAutoAdminWording", "GrpMsg_get_transfer_group_msg_flag", "GrpMsg_get_quit_pay_group_msg_flag", "GrpMsg_support_invite_auto_join", "GrpMsg_mask_invite_auto_join", "GrpMsg_GetDisbandedByAdmin", "GrpMsg_GetC2cInviteJoinGroup" }, new Object[] { 
          integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, 
          integer, integer, integer, integer, integer, integer, integer }, structmsg$FlagInfo.class);
  }
}