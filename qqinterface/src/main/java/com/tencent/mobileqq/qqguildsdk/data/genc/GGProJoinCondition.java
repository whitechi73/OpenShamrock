package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProJoinCondition;

public  class GGProJoinCondition implements IGProJoinCondition {
    public final GProJoinCondition mInfo;

    public GGProJoinCondition(GProJoinCondition gProJoinCondition) {
        this.mInfo = gProJoinCondition;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinCondition
    public IGProAccountCondition getAccountCondition() {
        return new GGProAccountCondition(this.mInfo.getAccountCondition());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinCondition
    public String toString() {
        return this.mInfo.toString();
    }
}
