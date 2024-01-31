package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProFetchDiscoverRedRsp;

public  class GGProFetchDiscoverRedRsp implements IGProFetchDiscoverRedRsp {
    public final GProFetchDiscoverRedRsp mInfo;

    public GGProFetchDiscoverRedRsp(GProFetchDiscoverRedRsp gProFetchDiscoverRedRsp) {
        this.mInfo = gProFetchDiscoverRedRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public int getBusinessType() {
        return this.mInfo.getBusinessType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public IGProDiscoverStatus getDiscoverStatus() {
        return new GGProDiscoverStatus(this.mInfo.getDiscoverStatus());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public int getFlag() {
        return this.mInfo.getFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public int getPointType() {
        return this.mInfo.getPointType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public long getSeq() {
        return this.mInfo.getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchDiscoverRedRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
