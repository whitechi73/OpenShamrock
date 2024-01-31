package com.tencent.qqnt.kernel.nativeinterface;


public  final class SearchChatInfo {
    String name;
    String peerUid;
    String remark;

    public SearchChatInfo() {
        this.peerUid = "";
        this.name = "";
        this.remark = "";
    }

    public String getName() {
        return this.name;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getRemark() {
        return this.remark;
    }

    public String toString() {
        return "SearchChatInfo{peerUid=" + this.peerUid + ",name=" + this.name + ",remark=" + this.remark + ",}";
    }

    public SearchChatInfo(String str, String str2, String str3) {
        this.peerUid = "";
        this.name = "";
        this.remark = "";
        this.peerUid = str;
        this.name = str2;
        this.remark = str3;
    }
}
