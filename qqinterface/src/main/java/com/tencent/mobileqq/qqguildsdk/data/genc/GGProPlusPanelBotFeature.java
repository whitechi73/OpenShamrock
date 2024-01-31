package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPlusPanelBotFeature;

public  class GGProPlusPanelBotFeature implements IGProPlusPanelBotFeature {
    public final GProPlusPanelBotFeature mInfo;

    public GGProPlusPanelBotFeature(GProPlusPanelBotFeature gProPlusPanelBotFeature) {
        this.mInfo = gProPlusPanelBotFeature;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public IGProBotInfo getBotInfo() {
        return new GGProBotInfo(this.mInfo.getBotInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public IGProBotFeatureInfo getCommandInfo() {
        return new GGProBotFeatureInfo(this.mInfo.getCommandInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public String getElementId() {
        return this.mInfo.getElementId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public IGProBotFeatureInfo getServiceInfo() {
        return new GGProBotFeatureInfo(this.mInfo.getServiceInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public String getServiceName() {
        return this.mInfo.getServiceName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotFeature
    public String toString() {
        return this.mInfo.toString();
    }
}
