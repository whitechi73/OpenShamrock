package com.tencent.qqnt.kernel.nativeinterface;

public final class TempChatInfo {
    int chatType;
    String fromNick;
    String groupCode;
    String peerUid;
    int sessionType;

    public TempChatInfo() {
        this.peerUid = "";
        this.groupCode = "";
        this.fromNick = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getFromNick() {
        return this.fromNick;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getSessionType() {
        return this.sessionType;
    }

    public String toString() {
        return "TempChatInfo{sessionType=" + this.sessionType + ",chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",groupCode=" + this.groupCode + ",fromNick=" + this.fromNick + ",}";
    }

    public TempChatInfo(int i2, int i3, String str, String str2, String str3) {
        this.peerUid = "";
        this.groupCode = "";
        this.fromNick = "";
        this.sessionType = i2;
        this.chatType = i3;
        this.peerUid = str;
        this.groupCode = str2;
        this.fromNick = str3;
    }
}
