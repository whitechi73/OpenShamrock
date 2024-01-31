package com.tencent.qqnt.kernel.nativeinterface;


public  final class CommonFileInfo {
    Integer bizType;
    int chatType;
    long elemId;
    String favId;
    long fileModelId;
    String fileName;
    long fileSize;
    String md5;
    String md510m;
    long msgId;
    long msgTime;
    String parent;
    String peerUid;
    String sha;
    String sha3;
    String subId;
    String uuid;

    public CommonFileInfo() {
        this.uuid = "";
        this.subId = "";
        this.fileName = "";
        this.peerUid = "";
        this.md5 = "";
        this.md510m = "";
        this.sha = "";
        this.sha3 = "";
    }

    public Integer getBizType() {
        return this.bizType;
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getElemId() {
        return this.elemId;
    }

    public String getFavId() {
        return this.favId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMd510m() {
        return this.md510m;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getParent() {
        return this.parent;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getSha() {
        return this.sha;
    }

    public String getSha3() {
        return this.sha3;
    }

    public String getSubId() {
        return this.subId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String toString() {
        return "CommonFileInfo{fileModelId=" + this.fileModelId + ",msgId=" + this.msgId + ",elemId=" + this.elemId + ",uuid=" + this.uuid + ",subId=" + this.subId + ",fileName=" + this.fileName + ",fileSize=" + this.fileSize + ",msgTime=" + this.msgTime + ",peerUid=" + this.peerUid + ",chatType=" + this.chatType + ",md5=" + this.md5 + ",md510m=" + this.md510m + ",sha=" + this.sha + ",sha3=" + this.sha3 + ",parent=" + this.parent + ",favId=" + this.favId + ",bizType=" + this.bizType + ",}";
    }

    public CommonFileInfo(long j2, long j3, long j4, String str, String str2, String str3, long j5, long j6, String str4, int i2, String str5, String str6, String str7, String str8, String str9, String str10, Integer num) {
        this.uuid = "";
        this.subId = "";
        this.fileName = "";
        this.peerUid = "";
        this.md5 = "";
        this.md510m = "";
        this.sha = "";
        this.sha3 = "";
        this.fileModelId = j2;
        this.msgId = j3;
        this.elemId = j4;
        this.uuid = str;
        this.subId = str2;
        this.fileName = str3;
        this.fileSize = j5;
        this.msgTime = j6;
        this.peerUid = str4;
        this.chatType = i2;
        this.md5 = str5;
        this.md510m = str6;
        this.sha = str7;
        this.sha3 = str8;
        this.parent = str9;
        this.favId = str10;
        this.bizType = num;
    }
}
