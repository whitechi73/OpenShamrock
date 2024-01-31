package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProShareExtendInfo;

public  class GGProShareExtendInfo implements IGProShareExtendInfo {
    public final GProShareExtendInfo mInfo;

    public GGProShareExtendInfo(GProShareExtendInfo gProShareExtendInfo) {
        this.mInfo = gProShareExtendInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo
    public String getShareCopywriting() {
        return this.mInfo.getShareCopywriting();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
