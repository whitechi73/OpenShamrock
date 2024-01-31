package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProListenTogetherRspHead;

public  class GGProListenTogetherRspHead implements IGProListenTogetherRspHead {
    public final GProListenTogetherRspHead mInfo;

    public GGProListenTogetherRspHead(GProListenTogetherRspHead gProListenTogetherRspHead) {
        this.mInfo = gProListenTogetherRspHead;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProListenTogetherRspHead
    public IGProConfirmOption getConfirmOption() {
        return new GGProConfirmOption(this.mInfo.getConfirmOption());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProListenTogetherRspHead
    public int getModCode() {
        return this.mInfo.getModCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProListenTogetherRspHead
    public String toString() {
        return this.mInfo.toString();
    }
}
