package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProItemCbData;

public  class GGProItemCbData implements IGProItemCbData {
    public final GProItemCbData mInfo;

    public GGProItemCbData(GProItemCbData gProItemCbData) {
        this.mInfo = gProItemCbData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData
    public byte[] getCbExtData() {
        return this.mInfo.getCbExtData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData
    public String getStatData() {
        return this.mInfo.getStatData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData
    public String toString() {
        return this.mInfo.toString();
    }
}
