package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class GroupNotifyGroup implements Serializable {
    long groupCode;
    String groupName;
    long serialVersionUID;

    public GroupNotifyGroup() {
        this.serialVersionUID = 1L;
        this.groupName = "";
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String toString() {
        return "GroupNotifyGroup{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",}";
    }

    public GroupNotifyGroup(long j2, String str) {
        this.serialVersionUID = 1L;
        this.groupName = "";
        this.groupCode = j2;
        this.groupName = str;
    }
}
