package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class GroupDetailInfo implements IKernelModel {
    int appealDeadline;
    int certType;
    int classExt;
    int cmdUinFlagEx2;
    int cmdUinJoinTime;
    GroupMsgMask cmdUinMsgMask;
    int cmdUinMsgSeq;
    MemberRole cmdUinPrivilege;
    int cmdUinUinFlag;
    String fingerMemo;
    long groupCode;
    int groupFlag;
    int groupFlagExt;
    int groupFlagExt3;
    int groupFlagExt4;
    String groupMemo;
    String groupName;
    int groupOption;
    String groupQuestion;
    int groupSecLevel;
    int groupSecLevelInfo;
    int groupTypeFlag;
    int isConfGroup;
    int isModifyConfGroupFace;
    int isModifyConfGroupName;
    boolean isTop;
    int maxMemberNum;
    int memberNum;
    String ownerUid;
    int privilegeFlag;
    String remarkName;
    String richFingerMemo;
    int shutUpAllTimestamp;
    int shutUpMeTimestamp;
    ArrayList<GroupTagRecord> tagRecord;

    public GroupDetailInfo() {
        this.ownerUid = "";
        this.groupName = "";
        this.fingerMemo = "";
        this.groupQuestion = "";
        this.richFingerMemo = "";
        this.tagRecord = new ArrayList<>();
        this.groupMemo = "";
        this.cmdUinMsgMask = GroupMsgMask.values()[0];
        this.cmdUinPrivilege = MemberRole.values()[0];
        this.remarkName = "";
    }

    public int getAppealDeadline() {
        return this.appealDeadline;
    }

    public int getCertType() {
        return this.certType;
    }

    public int getClassExt() {
        return this.classExt;
    }

    public int getCmdUinFlagEx2() {
        return this.cmdUinFlagEx2;
    }

    public int getCmdUinJoinTime() {
        return this.cmdUinJoinTime;
    }

    public GroupMsgMask getCmdUinMsgMask() {
        return this.cmdUinMsgMask;
    }

    public int getCmdUinMsgSeq() {
        return this.cmdUinMsgSeq;
    }

    public MemberRole getCmdUinPrivilege() {
        return this.cmdUinPrivilege;
    }

    public int getCmdUinUinFlag() {
        return this.cmdUinUinFlag;
    }

    public String getFingerMemo() {
        return this.fingerMemo;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupFlag() {
        return this.groupFlag;
    }

    public int getGroupFlagExt() {
        return this.groupFlagExt;
    }

    public int getGroupFlagExt3() {
        return this.groupFlagExt3;
    }

    public int getGroupFlagExt4() {
        return this.groupFlagExt4;
    }

    public String getGroupMemo() {
        return this.groupMemo;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getGroupOption() {
        return this.groupOption;
    }

    public String getGroupQuestion() {
        return this.groupQuestion;
    }

    public int getGroupSecLevel() {
        return this.groupSecLevel;
    }

    public int getGroupSecLevelInfo() {
        return this.groupSecLevelInfo;
    }

    public int getGroupTypeFlag() {
        return this.groupTypeFlag;
    }

    public int getIsConfGroup() {
        return this.isConfGroup;
    }

    public int getIsModifyConfGroupFace() {
        return this.isModifyConfGroupFace;
    }

    public int getIsModifyConfGroupName() {
        return this.isModifyConfGroupName;
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getOwnerUid() {
        return this.ownerUid;
    }

    public int getPrivilegeFlag() {
        return this.privilegeFlag;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getRichFingerMemo() {
        return this.richFingerMemo;
    }

    public int getShutUpAllTimestamp() {
        return this.shutUpAllTimestamp;
    }

    public int getShutUpMeTimestamp() {
        return this.shutUpMeTimestamp;
    }

    public ArrayList<GroupTagRecord> getTagRecord() {
        return this.tagRecord;
    }

    public void setAppealDeadline(int i2) {
        this.appealDeadline = i2;
    }

    public void setCertType(int i2) {
        this.certType = i2;
    }

    public void setClassExt(int i2) {
        this.classExt = i2;
    }

    public void setCmdUinFlagEx2(int i2) {
        this.cmdUinFlagEx2 = i2;
    }

    public void setCmdUinJoinTime(int i2) {
        this.cmdUinJoinTime = i2;
    }

    public void setCmdUinMsgMask(GroupMsgMask groupMsgMask) {
        this.cmdUinMsgMask = groupMsgMask;
    }

    public void setCmdUinMsgSeq(int i2) {
        this.cmdUinMsgSeq = i2;
    }

    public void setCmdUinPrivilege(MemberRole memberRole) {
        this.cmdUinPrivilege = memberRole;
    }

    public void setCmdUinUinFlag(int i2) {
        this.cmdUinUinFlag = i2;
    }

    public void setFingerMemo(String str) {
        this.fingerMemo = str;
    }

    public void setGroupCode(long j2) {
        this.groupCode = j2;
    }

    public void setGroupFlag(int i2) {
        this.groupFlag = i2;
    }

    public void setGroupFlagExt(int i2) {
        this.groupFlagExt = i2;
    }

    public void setGroupFlagExt3(int i2) {
        this.groupFlagExt3 = i2;
    }

    public void setGroupFlagExt4(int i2) {
        this.groupFlagExt4 = i2;
    }

    public void setGroupMemo(String str) {
        this.groupMemo = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupOption(int i2) {
        this.groupOption = i2;
    }

    public void setGroupQuestion(String str) {
        this.groupQuestion = str;
    }

    public void setGroupSecLevel(int i2) {
        this.groupSecLevel = i2;
    }

    public void setGroupSecLevelInfo(int i2) {
        this.groupSecLevelInfo = i2;
    }

    public void setGroupTypeFlag(int i2) {
        this.groupTypeFlag = i2;
    }

    public void setIsConfGroup(int i2) {
        this.isConfGroup = i2;
    }

    public void setIsModifyConfGroupFace(int i2) {
        this.isModifyConfGroupFace = i2;
    }

    public void setIsModifyConfGroupName(int i2) {
        this.isModifyConfGroupName = i2;
    }

    public void setIsTop(boolean z) {
        this.isTop = z;
    }

    public void setMaxMemberNum(int i2) {
        this.maxMemberNum = i2;
    }

    public void setMemberNum(int i2) {
        this.memberNum = i2;
    }

    public void setOwnerUid(String str) {
        this.ownerUid = str;
    }

    public void setPrivilegeFlag(int i2) {
        this.privilegeFlag = i2;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setRichFingerMemo(String str) {
        this.richFingerMemo = str;
    }

    public void setShutUpAllTimestamp(int i2) {
        this.shutUpAllTimestamp = i2;
    }

    public void setShutUpMeTimestamp(int i2) {
        this.shutUpMeTimestamp = i2;
    }

    public void setTagRecord(ArrayList<GroupTagRecord> arrayList) {
        this.tagRecord = arrayList;
    }

    public String toString() {
        return "GroupDetailInfo{groupCode=" + this.groupCode + ",ownerUid=" + this.ownerUid + ",groupFlag=" + this.groupFlag + ",groupFlagExt=" + this.groupFlagExt + ",maxMemberNum=" + this.maxMemberNum + ",memberNum=" + this.memberNum + ",groupOption=" + this.groupOption + ",classExt=" + this.classExt + ",groupName=" + this.groupName + ",fingerMemo=" + this.fingerMemo + ",groupQuestion=" + this.groupQuestion + ",certType=" + this.certType + ",richFingerMemo=" + this.richFingerMemo + ",tagRecord=" + this.tagRecord + ",shutUpAllTimestamp=" + this.shutUpAllTimestamp + ",shutUpMeTimestamp=" + this.shutUpMeTimestamp + ",groupTypeFlag=" + this.groupTypeFlag + ",privilegeFlag=" + this.privilegeFlag + ",groupSecLevel=" + this.groupSecLevel + ",groupFlagExt3=" + this.groupFlagExt3 + ",isConfGroup=" + this.isConfGroup + ",isModifyConfGroupFace=" + this.isModifyConfGroupFace + ",isModifyConfGroupName=" + this.isModifyConfGroupName + ",groupFlagExt4=" + this.groupFlagExt4 + ",groupMemo=" + this.groupMemo + ",cmdUinMsgSeq=" + this.cmdUinMsgSeq + ",cmdUinJoinTime=" + this.cmdUinJoinTime + ",cmdUinUinFlag=" + this.cmdUinUinFlag + ",cmdUinMsgMask=" + this.cmdUinMsgMask + ",groupSecLevelInfo=" + this.groupSecLevelInfo + ",cmdUinPrivilege=" + this.cmdUinPrivilege + ",cmdUinFlagEx2=" + this.cmdUinFlagEx2 + ",appealDeadline=" + this.appealDeadline + ",remarkName=" + this.remarkName + ",isTop=" + this.isTop + ",}";
    }

    public GroupDetailInfo(long j2, String str, int i2, int i3, int i4, int i5, int i6, int i7, String str2, String str3, String str4, int i8, String str5, ArrayList<GroupTagRecord> arrayList, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str6, int i19, int i20, int i21, GroupMsgMask groupMsgMask, int i22, MemberRole memberRole, int i23, int i24, String str7, boolean z) {
        this.ownerUid = "";
        this.groupName = "";
        this.fingerMemo = "";
        this.groupQuestion = "";
        this.richFingerMemo = "";
        this.tagRecord = new ArrayList<>();
        this.groupMemo = "";
        this.cmdUinMsgMask = GroupMsgMask.values()[0];
        this.cmdUinPrivilege = MemberRole.values()[0];
        this.remarkName = "";
        this.groupCode = j2;
        this.ownerUid = str;
        this.groupFlag = i2;
        this.groupFlagExt = i3;
        this.maxMemberNum = i4;
        this.memberNum = i5;
        this.groupOption = i6;
        this.classExt = i7;
        this.groupName = str2;
        this.fingerMemo = str3;
        this.groupQuestion = str4;
        this.certType = i8;
        this.richFingerMemo = str5;
        this.tagRecord = arrayList;
        this.shutUpAllTimestamp = i9;
        this.shutUpMeTimestamp = i10;
        this.groupTypeFlag = i11;
        this.privilegeFlag = i12;
        this.groupSecLevel = i13;
        this.groupFlagExt3 = i14;
        this.isConfGroup = i15;
        this.isModifyConfGroupFace = i16;
        this.isModifyConfGroupName = i17;
        this.groupFlagExt4 = i18;
        this.groupMemo = str6;
        this.cmdUinMsgSeq = i19;
        this.cmdUinJoinTime = i20;
        this.cmdUinUinFlag = i21;
        this.cmdUinMsgMask = groupMsgMask;
        this.groupSecLevelInfo = i22;
        this.cmdUinPrivilege = memberRole;
        this.cmdUinFlagEx2 = i23;
        this.appealDeadline = i24;
        this.remarkName = str7;
        this.isTop = z;
    }
}
