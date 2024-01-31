package com.tencent.qqnt.kernel.nativeinterface;


public  final class ChatInfo {
    int chatType;
    String peerUid;

    public ChatInfo() {
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "ChatInfo{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",}";
    }

    public ChatInfo(int i2, String str) {
        this.peerUid = "";
        this.chatType = i2;
        this.peerUid = str;
    }
}
