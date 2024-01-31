package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class GroupInviteExt implements Serializable {
    long groupCode;
    long serialVersionUID;
    GroupInviteType srcType;
    GroupInviteStatus waitStatus;

    public GroupInviteExt() {
        this.serialVersionUID = 1L;
        this.srcType = GroupInviteType.values()[0];
        this.waitStatus = GroupInviteStatus.values()[0];
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupInviteType getSrcType() {
        return this.srcType;
    }

    public GroupInviteStatus getWaitStatus() {
        return this.waitStatus;
    }

    public String toString() {
        return "GroupInviteExt{srcType=" + this.srcType + ",groupCode=" + this.groupCode + ",waitStatus=" + this.waitStatus + ",}";
    }

    public GroupInviteExt(GroupInviteType groupInviteType, long j2, GroupInviteStatus groupInviteStatus) {
        this.serialVersionUID = 1L;
        this.srcType = GroupInviteType.values()[0];
        this.waitStatus = GroupInviteStatus.values()[0];
        this.srcType = groupInviteType;
        this.groupCode = j2;
        this.waitStatus = groupInviteStatus;
    }
}
