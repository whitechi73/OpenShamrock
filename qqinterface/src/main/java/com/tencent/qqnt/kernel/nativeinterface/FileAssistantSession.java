package com.tencent.qqnt.kernel.nativeinterface;


public  final class FileAssistantSession {
    String context;
    int count;
    long groupCode;
    String groupName;
    String groupRemark;
    String memberCard;
    String nick;
    String remark;
    String uid;

    public FileAssistantSession() {
        this.uid = "";
        this.nick = "";
        this.remark = "";
        this.memberCard = "";
        this.groupName = "";
        this.groupRemark = "";
    }

    public String getContext() {
        return this.context;
    }

    public int getCount() {
        return this.count;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupRemark() {
        return this.groupRemark;
    }

    public String getMemberCard() {
        return this.memberCard;
    }

    public String getNick() {
        return this.nick;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "FileAssistantSession{context=" + this.context + ",uid=" + this.uid + ",nick=" + this.nick + ",remark=" + this.remark + ",memberCard=" + this.memberCard + ",groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",groupRemark=" + this.groupRemark + ",count=" + this.count + ",}";
    }

    public FileAssistantSession(String str, String str2, String str3, String str4, String str5, long j2, String str6, String str7, int i2) {
        this.uid = "";
        this.nick = "";
        this.remark = "";
        this.memberCard = "";
        this.groupName = "";
        this.groupRemark = "";
        this.context = str;
        this.uid = str2;
        this.nick = str3;
        this.remark = str4;
        this.memberCard = str5;
        this.groupCode = j2;
        this.groupName = str6;
        this.groupRemark = str7;
        this.count = i2;
    }
}
