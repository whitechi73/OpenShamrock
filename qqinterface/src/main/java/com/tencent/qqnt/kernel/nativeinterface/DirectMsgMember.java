package com.tencent.qqnt.kernel.nativeinterface;

public final class DirectMsgMember {
    String memberName;
    int memberType;
    int msgNotifyType;
    String nickName;
    long srcGuildId;
    String srcGuildName;
    long tinyId;

    public DirectMsgMember() {
        this.srcGuildName = "";
        this.nickName = "";
        this.memberName = "";
    }

    public String getMemberName() {
        return this.memberName;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getSrcGuildId() {
        return this.srcGuildId;
    }

    public String getSrcGuildName() {
        return this.srcGuildName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "DirectMsgMember{tinyId=" + this.tinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",nickName=" + this.nickName + ",memberName=" + this.memberName + ",msgNotifyType=" + this.msgNotifyType + ",memberType=" + this.memberType + ",}";
    }

    public DirectMsgMember(long j2, long j3, String str, String str2, String str3, int i2, int i3) {
        this.srcGuildName = "";
        this.nickName = "";
        this.memberName = "";
        this.tinyId = j2;
        this.srcGuildId = j3;
        this.srcGuildName = str;
        this.nickName = str2;
        this.memberName = str3;
        this.msgNotifyType = i2;
        this.memberType = i3;
    }
}
