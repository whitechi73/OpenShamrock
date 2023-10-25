package com.tencent.qqnt.kernel.nativeinterface;

public final class RichDownLoadReq {
    int chatType;
    int downloadType;
    MsgElement elem;
    String guildId;
    long msgId;
    long msgRandom;
    long msgSeq;
    long msgTime;
    String peerUid;
    String senderUid;
    int thumbSize;
    Integer useHttps;

    public RichDownLoadReq() {
        this.senderUid = "";
        this.peerUid = "";
        this.guildId = "";
        this.elem = new MsgElement();
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public MsgElement getElem() {
        return this.elem;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgRandom() {
        return this.msgRandom;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public Integer getUseHttps() {
        return this.useHttps;
    }

    public String toString() {
        return "RichDownLoadReq{downloadType=" + this.downloadType + ",thumbSize=" + this.thumbSize + ",msgId=" + this.msgId + ",msgRandom=" + this.msgRandom + ",msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",chatType=" + this.chatType + ",senderUid=" + this.senderUid + ",peerUid=" + this.peerUid + ",guildId=" + this.guildId + ",elem=" + this.elem + ",useHttps=" + this.useHttps + ",}";
    }

    public RichDownLoadReq(int i2, int i3, long j2, long j3, long j4, long j5, int i4, String str, String str2, String str3, MsgElement msgElement, Integer num) {
        this.senderUid = "";
        this.peerUid = "";
        this.guildId = "";
        this.elem = new MsgElement();
        this.downloadType = i2;
        this.thumbSize = i3;
        this.msgId = j2;
        this.msgRandom = j3;
        this.msgSeq = j4;
        this.msgTime = j5;
        this.chatType = i4;
        this.senderUid = str;
        this.peerUid = str2;
        this.guildId = str3;
        this.elem = msgElement;
        this.useHttps = num;
    }
}
