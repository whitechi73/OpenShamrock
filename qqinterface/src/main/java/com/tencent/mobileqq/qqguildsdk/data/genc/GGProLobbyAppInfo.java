package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProLobbyAppInfo;

public  class GGProLobbyAppInfo implements IGProLobbyAppInfo {
    public final GProLobbyAppInfo mInfo;

    public GGProLobbyAppInfo(GProLobbyAppInfo gProLobbyAppInfo) {
        this.mInfo = gProLobbyAppInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getAntiAddiction() {
        return this.mInfo.getAntiAddiction();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getAntiAddictionMode() {
        return this.mInfo.getAntiAddictionMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String getAppId() {
        return this.mInfo.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String getAppName() {
        return this.mInfo.getAppName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public long getAppUin() {
        return this.mInfo.getAppUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getFullScreenMode() {
        return this.mInfo.getFullScreenMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String getH5Url() {
        return this.mInfo.getH5Url();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getMaxMember() {
        return this.mInfo.getMaxMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getMinMember() {
        return this.mInfo.getMinMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getPerLoadingMaterialType() {
        return this.mInfo.getPerLoadingMaterialType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String getPerLoadingMaterialUrl() {
        return this.mInfo.getPerLoadingMaterialUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public long getPermissionRequired() {
        return this.mInfo.getPermissionRequired();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public int getScreenMode() {
        return this.mInfo.getScreenMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String getTopImageUrl() {
        return this.mInfo.getTopImageUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
