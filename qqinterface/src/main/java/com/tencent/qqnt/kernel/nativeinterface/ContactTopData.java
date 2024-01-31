package com.tencent.qqnt.kernel.nativeinterface;


public  final class ContactTopData {
    int chatType;
    long groupCode;
    String uid;
    long uin;

    public ContactTopData() {
        this.uid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public void setChatType(int i2) {
        this.chatType = i2;
    }

    public void setGroupCode(long j2) {
        this.groupCode = j2;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j2) {
        this.uin = j2;
    }

    public String toString() {
        return "ContactTopData{chatType=" + this.chatType + ",uin=" + this.uin + ",uid=" + this.uid + ",groupCode=" + this.groupCode + ",}";
    }

    public ContactTopData(int i2, long j2, String str, long j3) {
        this.uid = "";
        this.chatType = i2;
        this.uin = j2;
        this.uid = str;
        this.groupCode = j3;
    }
}
