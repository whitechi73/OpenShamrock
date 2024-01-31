package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecallInfo;

public  class GProRecallInfoData extends GGProRecallInfo implements IRecallInfo {
    private GProRecallInfo mRecallInfo;

    public GProRecallInfoData(GProRecallInfo gProRecallInfo) {
        super(gProRecallInfo);
        this.mRecallInfo = gProRecallInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public float getQualityScore() {
        return this.mRecallInfo.getQualityScore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public String getQuery() {
        return this.mRecallInfo.getQuery();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public String getRecallName() {
        return this.mRecallInfo.getRecallName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public float getRelevanceScore() {
        return this.mRecallInfo.getRelevanceScore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public float getScore() {
        return this.mRecallInfo.getScore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public String getTraceId() {
        return this.mRecallInfo.getTraceId();
    }
}
