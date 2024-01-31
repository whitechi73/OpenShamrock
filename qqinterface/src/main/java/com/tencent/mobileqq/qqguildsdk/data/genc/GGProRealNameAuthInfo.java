package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRealNameAuthInfo;

public  class GGProRealNameAuthInfo implements IGProRealNameAuthInfo {
    public final GProRealNameAuthInfo mInfo;

    public GGProRealNameAuthInfo(GProRealNameAuthInfo gProRealNameAuthInfo) {
        this.mInfo = gProRealNameAuthInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRealNameAuthInfo
    public int getResult() {
        return this.mInfo.getResult();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRealNameAuthInfo
    public String getTipsContent() {
        return this.mInfo.getTipsContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRealNameAuthInfo
    public String getVerifyUrl() {
        return this.mInfo.getVerifyUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRealNameAuthInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
