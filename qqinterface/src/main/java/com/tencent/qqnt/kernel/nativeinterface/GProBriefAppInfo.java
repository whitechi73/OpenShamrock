package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProBriefAppInfo {
    String appAvatarUrl;
    String appId;
    String appName;

    public GProBriefAppInfo() {
        this.appId = "";
        this.appName = "";
        this.appAvatarUrl = "";
    }

    public String getAppAvatarUrl() {
        return this.appAvatarUrl;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String toString() {
        return "GProBriefAppInfo{appId=" + this.appId + ",appName=" + this.appName + ",appAvatarUrl=" + this.appAvatarUrl + ",}";
    }

    public GProBriefAppInfo(String str, String str2, String str3) {
        this.appId = "";
        this.appName = "";
        this.appAvatarUrl = "";
        this.appId = str;
        this.appName = str2;
        this.appAvatarUrl = str3;
    }
}
