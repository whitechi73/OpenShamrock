package com.tencent.qqnt.kernel.nativeinterface;


public  final class SearchBuddyChatInfo {
    String categoryName;
    String peerNick;
    String peerUid;
    long peerUin;
    String remark;

    public SearchBuddyChatInfo() {
        this.categoryName = "";
        this.peerUid = "";
        this.peerNick = "";
        this.remark = "";
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getPeerNick() {
        return this.peerNick;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public long getPeerUin() {
        return this.peerUin;
    }

    public String getRemark() {
        return this.remark;
    }

    public String toString() {
        return "SearchBuddyChatInfo{categoryName=" + this.categoryName + ",peerUid=" + this.peerUid + ",peerUin=" + this.peerUin + ",peerNick=" + this.peerNick + ",remark=" + this.remark + ",}";
    }

    public SearchBuddyChatInfo(String str, String str2, long j2, String str3, String str4) {
        this.categoryName = "";
        this.peerUid = "";
        this.peerNick = "";
        this.remark = "";
        this.categoryName = str;
        this.peerUid = str2;
        this.peerUin = j2;
        this.peerNick = str3;
        this.remark = str4;
    }
}
