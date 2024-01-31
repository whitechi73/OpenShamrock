package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupNotifyTargetMsg {
    long groupCode;
    String postscript;
    long seq;
    GroupNotifyMsgType type;

    public GroupNotifyTargetMsg() {
        this.type = GroupNotifyMsgType.values()[0];
        this.postscript = "";
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getPostscript() {
        return this.postscript;
    }

    public long getSeq() {
        return this.seq;
    }

    public GroupNotifyMsgType getType() {
        return this.type;
    }

    public String toString() {
        return "GroupNotifyTargetMsg{seq=" + this.seq + ",type=" + this.type + ",groupCode=" + this.groupCode + ",postscript=" + this.postscript + ",}";
    }

    public GroupNotifyTargetMsg(long j2, GroupNotifyMsgType groupNotifyMsgType, long j3, String str) {
        this.type = GroupNotifyMsgType.values()[0];
        this.postscript = "";
        this.seq = j2;
        this.type = groupNotifyMsgType;
        this.groupCode = j3;
        this.postscript = str;
    }
}
