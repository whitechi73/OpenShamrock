package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProIdentity;

public  class GProIdentityInfo implements IGProIdentityInfo {
    private final GProIdentity mGProIdentity;

    public GProIdentityInfo(GProIdentity gProIdentity) {
        this.mGProIdentity = gProIdentity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    public int getIdentityType() {
        return this.mGProIdentity.getIdentityType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    public byte[] getPlateData() {
        return this.mGProIdentity.getPlateData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    public int getType() {
        return this.mGProIdentity.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    public String getValue() {
        return this.mGProIdentity.getValue();
    }

    public String toString() {
        return "GProIdentityInfo{mGProIdentity=" + this.mGProIdentity + '}';
    }
}
