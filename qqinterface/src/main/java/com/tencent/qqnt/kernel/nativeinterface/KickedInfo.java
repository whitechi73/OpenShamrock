package com.tencent.qqnt.kernel.nativeinterface;


public  final class KickedInfo implements IKernelModel {
    int appId;
    int instanceId;
    KickedType kickedType;
    boolean sameDevice;
    int securityKickedType;
    String tipsDesc;
    String tipsTitle;

    public KickedInfo() {
        this.tipsDesc = "";
        this.tipsTitle = "";
        this.kickedType = KickedType.values()[0];
    }

    public int getAppId() {
        return this.appId;
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public KickedType getKickedType() {
        return this.kickedType;
    }

    public boolean getSameDevice() {
        return this.sameDevice;
    }

    public int getSecurityKickedType() {
        return this.securityKickedType;
    }

    public String getTipsDesc() {
        return this.tipsDesc;
    }

    public String getTipsTitle() {
        return this.tipsTitle;
    }

    public void setAppId(int i2) {
        this.appId = i2;
    }

    public void setInstanceId(int i2) {
        this.instanceId = i2;
    }

    public void setKickedType(KickedType kickedType) {
        this.kickedType = kickedType;
    }

    public void setSameDevice(boolean z) {
        this.sameDevice = z;
    }

    public void setSecurityKickedType(int i2) {
        this.securityKickedType = i2;
    }

    public void setTipsDesc(String str) {
        this.tipsDesc = str;
    }

    public void setTipsTitle(String str) {
        this.tipsTitle = str;
    }

    public String toString() {
        return "KickedInfo{appId=" + this.appId + ",instanceId=" + this.instanceId + ",sameDevice=" + this.sameDevice + ",tipsDesc=" + this.tipsDesc + ",tipsTitle=" + this.tipsTitle + ",kickedType=" + this.kickedType + ",securityKickedType=" + this.securityKickedType + ",}";
    }

    public KickedInfo(int i2, int i3, boolean z, String str, String str2, KickedType kickedType, int i4) {
        this.tipsDesc = "";
        this.tipsTitle = "";
        this.kickedType = KickedType.values()[0];
        this.appId = i2;
        this.instanceId = i3;
        this.sameDevice = z;
        this.tipsDesc = str;
        this.tipsTitle = str2;
        this.kickedType = kickedType;
        this.securityKickedType = i4;
    }
}
