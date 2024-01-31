package com.tencent.qqnt.kernel.nativeinterface;


public  final class ChatCacheInfo {
    long chatSize;
    long chatTime;
    int chatType;
    String nickName;
    String remarkName;
    String uid;
    long uin;

    public ChatCacheInfo() {
        this.uid = "";
        this.remarkName = "";
        this.nickName = "";
    }

    public long getChatSize() {
        return this.chatSize;
    }

    public long getChatTime() {
        return this.chatTime;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "ChatCacheInfo{chatSize=" + this.chatSize + ",chatTime=" + this.chatTime + ",uid=" + this.uid + ",uin=" + this.uin + ",remarkName=" + this.remarkName + ",nickName=" + this.nickName + ",chatType=" + this.chatType + ",}";
    }

    public ChatCacheInfo(long j2, long j3, String str, long j4, String str2, String str3, int i2) {
        this.uid = "";
        this.remarkName = "";
        this.nickName = "";
        this.chatSize = j2;
        this.chatTime = j3;
        this.uid = str;
        this.uin = j4;
        this.remarkName = str2;
        this.nickName = str3;
        this.chatType = i2;
    }
}
