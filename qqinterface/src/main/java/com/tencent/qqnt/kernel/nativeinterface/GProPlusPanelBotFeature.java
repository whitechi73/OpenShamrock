package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProPlusPanelBotFeature {
    GProBotInfo botInfo;
    GProBotFeatureInfo commandInfo;
    String elementId;
    String icon;
    GProBotFeatureInfo serviceInfo;
    String serviceName;

    public GProPlusPanelBotFeature() {
        this.botInfo = new GProBotInfo();
        this.serviceInfo = new GProBotFeatureInfo();
        this.commandInfo = new GProBotFeatureInfo();
        this.icon = "";
        this.serviceName = "";
        this.elementId = "";
    }

    public GProBotInfo getBotInfo() {
        return this.botInfo;
    }

    public GProBotFeatureInfo getCommandInfo() {
        return this.commandInfo;
    }

    public String getElementId() {
        return this.elementId;
    }

    public String getIcon() {
        return this.icon;
    }

    public GProBotFeatureInfo getServiceInfo() {
        return this.serviceInfo;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String toString() {
        return "GProPlusPanelBotFeature{botInfo=" + this.botInfo + ",serviceInfo=" + this.serviceInfo + ",commandInfo=" + this.commandInfo + ",icon=" + this.icon + ",serviceName=" + this.serviceName + ",elementId=" + this.elementId + ",}";
    }

    public GProPlusPanelBotFeature(GProBotInfo gProBotInfo, GProBotFeatureInfo gProBotFeatureInfo, GProBotFeatureInfo gProBotFeatureInfo2, String str, String str2, String str3) {
        this.botInfo = new GProBotInfo();
        this.serviceInfo = new GProBotFeatureInfo();
        this.commandInfo = new GProBotFeatureInfo();
        this.icon = "";
        this.serviceName = "";
        this.elementId = "";
        this.botInfo = gProBotInfo;
        this.serviceInfo = gProBotFeatureInfo;
        this.commandInfo = gProBotFeatureInfo2;
        this.icon = str;
        this.serviceName = str2;
        this.elementId = str3;
    }
}
