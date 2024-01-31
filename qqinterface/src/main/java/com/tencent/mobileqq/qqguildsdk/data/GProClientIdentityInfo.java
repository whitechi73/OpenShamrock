package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProClientIdentity;


public class GProClientIdentityInfo implements IGProClientIdentityInfo {
    private final GProClientIdentity clientIdentity;

    public GProClientIdentityInfo(GProClientIdentity gProClientIdentity) {
        this.clientIdentity = gProClientIdentity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
    public String getClientId() {
        return null;
        //return com.tencent.mobileqq.qqguildsdk.util.b.T0(this.clientIdentity.getClientId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
    public String getDesc() {
        return this.clientIdentity.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
    public IGProClientIdentityByteInfo getIdentityBytes() {
        return new GProClientIdentityByteInfo(this.clientIdentity.getIdentityBytes());
    }

    public String toString() {
        return "GProClientIdentityInfo{clientIdentity=" + this.clientIdentity + '}';
    }
}
