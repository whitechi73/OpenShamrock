package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAccountCondition;

public  class GGProAccountCondition implements IGProAccountCondition {
    public final GProAccountCondition mInfo;

    public GGProAccountCondition(GProAccountCondition gProAccountCondition) {
        this.mInfo = gProAccountCondition;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAccountCondition
    public long getClientId() {
        return this.mInfo.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAccountCondition
    public boolean getIsNeedAuth() {
        return this.mInfo.getIsNeedAuth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAccountCondition
    public String toString() {
        return this.mInfo.toString();
    }
}
