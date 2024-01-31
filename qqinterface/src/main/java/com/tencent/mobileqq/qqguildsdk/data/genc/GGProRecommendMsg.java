package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendMsg;

public  class GGProRecommendMsg implements IGProRecommendMsg {
    public final GProRecommendMsg mInfo;

    public GGProRecommendMsg(GProRecommendMsg gProRecommendMsg) {
        this.mInfo = gProRecommendMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMsg
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMsg
    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMsg
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMsg
    public byte[] getRichText() {
        return this.mInfo.getRichText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMsg
    public long getTinyid() {
        return this.mInfo.getTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMsg
    public String toString() {
        return this.mInfo.toString();
    }
}
