package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupBulletinGroupInfo {
    int classId;
    long groupCode;

    public GroupBulletinGroupInfo() {
    }

    public int getClassId() {
        return this.classId;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String toString() {
        return "GroupBulletinGroupInfo{groupCode=" + this.groupCode + ",classId=" + this.classId + ",}";
    }

    public GroupBulletinGroupInfo(long j2, int i2) {
        this.groupCode = j2;
        this.classId = i2;
    }
}