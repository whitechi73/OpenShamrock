package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupMsgMaskInfo {
    long groupCode;
    GroupMsgMask msgMask;

    public GroupMsgMaskInfo() {
        this.msgMask = GroupMsgMask.values()[0];
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupMsgMask getMsgMask() {
        return this.msgMask;
    }

    public String toString() {
        return "GroupMsgMaskInfo{groupCode=" + this.groupCode + ",msgMask=" + this.msgMask + ",}";
    }

    public GroupMsgMaskInfo(long j2, GroupMsgMask groupMsgMask) {
        this.msgMask = GroupMsgMask.values()[0];
        this.groupCode = j2;
        this.msgMask = groupMsgMask;
    }
}
