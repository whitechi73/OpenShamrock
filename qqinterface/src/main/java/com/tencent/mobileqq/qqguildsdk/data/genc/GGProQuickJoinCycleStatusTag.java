package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProQuickJoinCycleStatusTag;

public  class GGProQuickJoinCycleStatusTag implements IGProQuickJoinCycleStatusTag {
    public final GProQuickJoinCycleStatusTag mInfo;

    public GGProQuickJoinCycleStatusTag(GProQuickJoinCycleStatusTag gProQuickJoinCycleStatusTag) {
        this.mInfo = gProQuickJoinCycleStatusTag;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinCycleStatusTag
    public String getHighlightedText() {
        return this.mInfo.getHighlightedText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinCycleStatusTag
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinCycleStatusTag
    public String getText() {
        return this.mInfo.getText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinCycleStatusTag
    public String toString() {
        return this.mInfo.toString();
    }
}
