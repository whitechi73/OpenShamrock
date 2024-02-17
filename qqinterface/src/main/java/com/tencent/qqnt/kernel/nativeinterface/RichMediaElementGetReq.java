package com.tencent.qqnt.kernel.nativeinterface;

public final class RichMediaElementGetReq implements IKernelModel {
    public int chatType;
    public int downSourceType;
    public int downloadType;
    public long elementId;
    public long fileModelId;
    public String filePath;
    public long msgId;
    public String peerUid;
    public int thumbSize;
    public int triggerType;

    public RichMediaElementGetReq() {
        this.peerUid = "";
        this.filePath = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDownSourceType() {
        return this.downSourceType;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getElementId() {
        return this.elementId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public void setChatType(int i2) {
        this.chatType = i2;
    }

    public void setDownSourceType(int i2) {
        this.downSourceType = i2;
    }

    public void setDownloadType(int i2) {
        this.downloadType = i2;
    }

    public void setElementId(long j2) {
        this.elementId = j2;
    }

    public void setFileModelId(long j2) {
        this.fileModelId = j2;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setMsgId(long j2) {
        this.msgId = j2;
    }

    public void setPeerUid(String str) {
        this.peerUid = str;
    }

    public void setThumbSize(int i2) {
        this.thumbSize = i2;
    }

    public void setTriggerType(int i2) {
        this.triggerType = i2;
    }

    public String toString() {
        return "RichMediaElementGetReq{msgId=" + this.msgId + ",peerUid=" + this.peerUid + ",chatType=" + this.chatType + ",elementId=" + this.elementId + ",downloadType=" + this.downloadType + ",thumbSize=" + this.thumbSize + ",filePath=" + this.filePath + ",fileModelId=" + this.fileModelId + ",downSourceType=" + this.downSourceType + ",triggerType=" + this.triggerType + ",}";
    }

    public RichMediaElementGetReq(long j2, String str, int i2, long j3, int i3, int i4, String str2, long j4, int i5, int i6) {
        this.peerUid = "";
        this.filePath = "";
        this.msgId = j2;
        this.peerUid = str;
        this.chatType = i2;
        this.elementId = j3;
        this.downloadType = i3;
        this.thumbSize = i4;
        this.filePath = str2;
        this.fileModelId = j4;
        this.downSourceType = i5;
        this.triggerType = i6;
    }
}
