package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRetentionChannelLabel;

public  class GGProRetentionChannelLabel implements IGProRetentionChannelLabel {
    public final GProRetentionChannelLabel mInfo;

    public GGProRetentionChannelLabel(GProRetentionChannelLabel gProRetentionChannelLabel) {
        this.mInfo = gProRetentionChannelLabel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelLabel
    public String getLabelName() {
        return this.mInfo.getLabelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelLabel
    public int getLabelType() {
        return this.mInfo.getLabelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelLabel
    public int getLabelValue() {
        return this.mInfo.getLabelValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelLabel
    public String toString() {
        return this.mInfo.toString();
    }
}
