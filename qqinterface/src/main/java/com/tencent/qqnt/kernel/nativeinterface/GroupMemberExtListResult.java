package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public class GroupMemberExtListResult {
    public long dataTime;
    public long endUin;
    public long groupCode;
    public int levelNameSeq;
    public int memberInfoSeq;
    public int sysShowFlag;
    public int timeToUpdate;
    public int userShowFlag;
    public int userShowFlagNew;
    public ArrayList<MemberExtInfo> memberLevelInfo = new ArrayList<>();
    public ArrayList<MemberLevelName> msgLevelName = new ArrayList<>();
    public String strOwnerName = "";
    public String strAdminName = "";
    public ArrayList<MemberLevelName> msgLevelNameNew = new ArrayList<>();

    public long getDataTime() {
        return this.dataTime;
    }

    public long getEndUin() {
        return this.endUin;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getLevelNameSeq() {
        return this.levelNameSeq;
    }

    public int getMemberInfoSeq() {
        return this.memberInfoSeq;
    }

    public ArrayList<MemberExtInfo> getMemberLevelInfo() {
        return this.memberLevelInfo;
    }

    public ArrayList<MemberLevelName> getMsgLevelName() {
        return this.msgLevelName;
    }

    public ArrayList<MemberLevelName> getMsgLevelNameNew() {
        return this.msgLevelNameNew;
    }

    public String getStrAdminName() {
        return this.strAdminName;
    }

    public String getStrOwnerName() {
        return this.strOwnerName;
    }

    public int getSysShowFlag() {
        return this.sysShowFlag;
    }

    public int getTimeToUpdate() {
        return this.timeToUpdate;
    }

    public int getUserShowFlag() {
        return this.userShowFlag;
    }

    public int getUserShowFlagNew() {
        return this.userShowFlagNew;
    }

    public String toString() {
        return "GroupMemberExtListResult{groupCode=" + this.groupCode + ",memberLevelInfo=" + this.memberLevelInfo + ",msgLevelName=" + this.msgLevelName + ",endUin=" + this.endUin + ",dataTime=" + this.dataTime + ",userShowFlag=" + this.userShowFlag + ",sysShowFlag=" + this.sysShowFlag + ",timeToUpdate=" + this.timeToUpdate + ",strOwnerName=" + this.strOwnerName + ",strAdminName=" + this.strAdminName + ",levelNameSeq=" + this.levelNameSeq + ",userShowFlagNew=" + this.userShowFlagNew + ",msgLevelNameNew=" + this.msgLevelNameNew + ",memberInfoSeq=" + this.memberInfoSeq + ",}";
    }

}
