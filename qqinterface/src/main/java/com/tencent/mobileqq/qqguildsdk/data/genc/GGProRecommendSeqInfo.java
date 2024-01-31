package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendSeqInfo;

public  class GGProRecommendSeqInfo implements IGProRecommendSeqInfo {
    public final GProRecommendSeqInfo mInfo;

    public GGProRecommendSeqInfo(GProRecommendSeqInfo gProRecommendSeqInfo) {
        this.mInfo = gProRecommendSeqInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendSeqInfo
    public byte[] getMaxBytesReadMsgMeta() {
        return this.mInfo.getMaxBytesReadMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendSeqInfo
    public long getMaxCntSeq() {
        return this.mInfo.getMaxCntSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendSeqInfo
    public long getMaxMsgSeq() {
        return this.mInfo.getMaxMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendSeqInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
