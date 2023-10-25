package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupMemberInfoListId {
    int index;
    String uid;

    public GroupMemberInfoListId() {
        this.uid = "";
    }

    public int getIndex() {
        return this.index;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GroupMemberInfoListId{uid=" + this.uid + ",index=" + this.index + ",}";
    }

    public GroupMemberInfoListId(String str, int i2) {
        this.uid = "";
        this.uid = str;
        this.index = i2;
    }
}