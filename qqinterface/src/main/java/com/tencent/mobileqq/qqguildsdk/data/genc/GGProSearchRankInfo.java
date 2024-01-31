package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSearchRankInfo;

public  class GGProSearchRankInfo implements IGProSearchRankInfo {
    public final GProSearchRankInfo mInfo;

    public GGProSearchRankInfo(GProSearchRankInfo gProSearchRankInfo) {
        this.mInfo = gProSearchRankInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchRankInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchRankInfo
    public String getText() {
        return this.mInfo.getText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchRankInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
