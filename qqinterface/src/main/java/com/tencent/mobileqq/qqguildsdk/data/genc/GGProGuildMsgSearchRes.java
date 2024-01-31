package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildMsgSearchRes;

public  class GGProGuildMsgSearchRes implements IGProGuildMsgSearchRes {
    public final GProGuildMsgSearchRes mInfo;

    public GGProGuildMsgSearchRes(GProGuildMsgSearchRes gProGuildMsgSearchRes) {
        this.mInfo = gProGuildMsgSearchRes;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public String getMsgTxt() {
        return this.mInfo.getMsgTxt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public String getPics() {
        return this.mInfo.getPics();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public long getTimeStamp() {
        return this.mInfo.getTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public int getUserType() {
        return this.mInfo.getUserType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public String getVideos() {
        return this.mInfo.getVideos();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMsgSearchRes
    public String toString() {
        return this.mInfo.toString();
    }
}
