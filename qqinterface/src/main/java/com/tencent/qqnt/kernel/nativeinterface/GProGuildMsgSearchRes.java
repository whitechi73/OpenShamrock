package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildMsgSearchRes {
    String avatar;
    long channelId;
    long guildId;
    long msgSeq;
    String msgTxt;
    String nickName;
    String pics;
    long timeStamp;
    long tinyId;
    int userType;
    String videos;

    public GProGuildMsgSearchRes() {
        this.nickName = "";
        this.avatar = "";
        this.msgTxt = "";
        this.pics = "";
        this.videos = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getMsgTxt() {
        return this.msgTxt;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPics() {
        return this.pics;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getUserType() {
        return this.userType;
    }

    public String getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProGuildMsgSearchRes{guildId=" + this.guildId + ",channelId=" + this.channelId + ",tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",avatar=" + this.avatar + ",timeStamp=" + this.timeStamp + ",msgSeq=" + this.msgSeq + ",msgTxt=" + this.msgTxt + ",pics=" + this.pics + ",videos=" + this.videos + ",userType=" + this.userType + ",}";
    }

    public GProGuildMsgSearchRes(long j2, long j3, long j4, String str, String str2, long j5, long j6, String str3, String str4, String str5, int i2) {
        this.nickName = "";
        this.avatar = "";
        this.msgTxt = "";
        this.pics = "";
        this.videos = "";
        this.guildId = j2;
        this.channelId = j3;
        this.tinyId = j4;
        this.nickName = str;
        this.avatar = str2;
        this.timeStamp = j5;
        this.msgSeq = j6;
        this.msgTxt = str3;
        this.pics = str4;
        this.videos = str5;
        this.userType = i2;
    }
}
