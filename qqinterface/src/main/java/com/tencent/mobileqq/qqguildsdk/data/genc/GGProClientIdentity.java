package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProClientIdentity;


public class GGProClientIdentity implements IGProClientIdentity {
    public final GProClientIdentity mInfo;

    public GGProClientIdentity(GProClientIdentity gProClientIdentity) {
        this.mInfo = gProClientIdentity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity
    public int getClientId() {
        return this.mInfo.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity
    public IGProClientIdentityBytes getIdentityBytes() {
        return new GGProClientIdentityBytes(this.mInfo.getIdentityBytes());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity
    public String toString() {
        return this.mInfo.toString();
    }
}
