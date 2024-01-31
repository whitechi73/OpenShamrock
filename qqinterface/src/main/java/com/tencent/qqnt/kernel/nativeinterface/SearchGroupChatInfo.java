package com.tencent.qqnt.kernel.nativeinterface;



public final class SearchGroupChatInfo {
    long groupCode;
    String groupName;
    boolean hasModifyConfGroupFace;
    boolean hasModifyConfGroupName;
    boolean isConf;
    String remark;

    public SearchGroupChatInfo() {
        this.groupName = "";
        this.remark = "";
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public boolean getHasModifyConfGroupFace() {
        return this.hasModifyConfGroupFace;
    }

    public boolean getHasModifyConfGroupName() {
        return this.hasModifyConfGroupName;
    }

    public boolean getIsConf() {
        return this.isConf;
    }

    public String getRemark() {
        return this.remark;
    }

    public String toString() {
        return "SearchGroupChatInfo{groupCode=" + this.groupCode + ",isConf=" + this.isConf + ",hasModifyConfGroupFace=" + this.hasModifyConfGroupFace + ",hasModifyConfGroupName=" + this.hasModifyConfGroupName + ",groupName=" + this.groupName + ",remark=" + this.remark + ",}";
    }

    public SearchGroupChatInfo(long j2, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.groupName = "";
        this.remark = "";
        this.groupCode = j2;
        this.isConf = z;
        this.hasModifyConfGroupFace = z2;
        this.hasModifyConfGroupName = z3;
        this.groupName = str;
        this.remark = str2;
    }
}
