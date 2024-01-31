package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendLabel;

import java.util.ArrayList;

public  class GGProRecommendLabel implements IGProRecommendLabel {
    public final GProRecommendLabel mInfo;

    public GGProRecommendLabel(GProRecommendLabel gProRecommendLabel) {
        this.mInfo = gProRecommendLabel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public int getBussiLabelType() {
        return this.mInfo.getBussiLabelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public String getLabelName() {
        return this.mInfo.getLabelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public int getLabelType() {
        return this.mInfo.getLabelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public int getLabelValue() {
        return this.mInfo.getLabelValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public String getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public ArrayList<String> getValueList() {
        return this.mInfo.getValueList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel
    public String toString() {
        return this.mInfo.toString();
    }
}
