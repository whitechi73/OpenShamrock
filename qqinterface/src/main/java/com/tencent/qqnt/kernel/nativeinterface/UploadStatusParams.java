package com.tencent.qqnt.kernel.nativeinterface;

public final class UploadStatusParams {
    int chatType;
    long elemId;
    long modelId;
    long msgId;
    String path;
    String peerUid;
    int status;

    public UploadStatusParams() {
        this.peerUid = "";
        this.path = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getElemId() {
        return this.elemId;
    }

    public long getModelId() {
        return this.modelId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getPath() {
        return this.path;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "UploadStatusParams{msgId=" + this.msgId + ",elemId=" + this.elemId + ",modelId=" + this.modelId + ",peerUid=" + this.peerUid + ",chatType=" + this.chatType + ",status=" + this.status + ",path=" + this.path + ",}";
    }

    public UploadStatusParams(long j2, long j3, long j4, String str, int i2, int i3, String str2) {
        this.peerUid = "";
        this.path = "";
        this.msgId = j2;
        this.elemId = j3;
        this.modelId = j4;
        this.peerUid = str;
        this.chatType = i2;
        this.status = i3;
        this.path = str2;
    }
}