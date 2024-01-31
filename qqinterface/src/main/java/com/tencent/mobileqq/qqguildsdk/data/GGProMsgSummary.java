package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProMsgSummary;

public  class GGProMsgSummary implements IGProMsgSummary {
    public final GProMsgSummary mInfo;

    public GGProMsgSummary(GProMsgSummary gProMsgSummary) {
        this.mInfo = gProMsgSummary;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMsgSummary
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMsgSummary
    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMsgSummary
    public byte[] getRichText() {
        return this.mInfo.getRichText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMsgSummary
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }
}
