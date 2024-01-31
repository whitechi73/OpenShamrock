package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProLobbyAppInfo implements Serializable {
    int antiAddiction;
    int antiAddictionMode;
    String appId;
    String appName;
    long appUin;
    int fullScreenMode;
    String h5Url;
    String iconUrl;
    int maxMember;
    int minMember;
    int perLoadingMaterialType;
    String perLoadingMaterialUrl;
    long permissionRequired;
    int screenMode;
    long serialVersionUID;
    String topImageUrl;

    public GProLobbyAppInfo() {
        this.serialVersionUID = 1L;
        this.appId = "";
        this.appName = "";
        this.iconUrl = "";
        this.topImageUrl = "";
        this.h5Url = "";
        this.perLoadingMaterialUrl = "";
    }

    public int getAntiAddiction() {
        return this.antiAddiction;
    }

    public int getAntiAddictionMode() {
        return this.antiAddictionMode;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public long getAppUin() {
        return this.appUin;
    }

    public int getFullScreenMode() {
        return this.fullScreenMode;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getMaxMember() {
        return this.maxMember;
    }

    public int getMinMember() {
        return this.minMember;
    }

    public int getPerLoadingMaterialType() {
        return this.perLoadingMaterialType;
    }

    public String getPerLoadingMaterialUrl() {
        return this.perLoadingMaterialUrl;
    }

    public long getPermissionRequired() {
        return this.permissionRequired;
    }

    public int getScreenMode() {
        return this.screenMode;
    }

    public String getTopImageUrl() {
        return this.topImageUrl;
    }

    public String toString() {
        return "GProLobbyAppInfo{appId=" + this.appId + ",appName=" + this.appName + ",iconUrl=" + this.iconUrl + ",topImageUrl=" + this.topImageUrl + ",h5Url=" + this.h5Url + ",screenMode=" + this.screenMode + ",permissionRequired=" + this.permissionRequired + ",appUin=" + this.appUin + ",minMember=" + this.minMember + ",maxMember=" + this.maxMember + ",antiAddiction=" + this.antiAddiction + ",perLoadingMaterialUrl=" + this.perLoadingMaterialUrl + ",perLoadingMaterialType=" + this.perLoadingMaterialType + ",fullScreenMode=" + this.fullScreenMode + ",antiAddictionMode=" + this.antiAddictionMode + ",}";
    }

    public GProLobbyAppInfo(String str, String str2, String str3, String str4, String str5, int i2, long j2, long j3, int i3, int i4, int i5, String str6, int i6, int i7, int i8) {
        this.serialVersionUID = 1L;
        this.appId = "";
        this.appName = "";
        this.iconUrl = "";
        this.topImageUrl = "";
        this.h5Url = "";
        this.perLoadingMaterialUrl = "";
        this.appId = str;
        this.appName = str2;
        this.iconUrl = str3;
        this.topImageUrl = str4;
        this.h5Url = str5;
        this.screenMode = i2;
        this.permissionRequired = j2;
        this.appUin = j3;
        this.minMember = i3;
        this.maxMember = i4;
        this.antiAddiction = i5;
        this.perLoadingMaterialUrl = str6;
        this.perLoadingMaterialType = i6;
        this.fullScreenMode = i7;
        this.antiAddictionMode = i8;
    }
}
