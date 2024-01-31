package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBusinessData;

public  class GGProBusinessData implements IGProBusinessData {
    public final GProBusinessData mInfo;

    public GGProBusinessData(GProBusinessData gProBusinessData) {
        this.mInfo = gProBusinessData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessData
    public byte[] getBusinessParam() {
        return this.mInfo.getBusinessParam();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessData
    public int getBusinessType() {
        return this.mInfo.getBusinessType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessData
    public String toString() {
        return this.mInfo.toString();
    }
}
