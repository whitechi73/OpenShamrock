package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAppInfo;

import java.util.ArrayList;


public class GGProAppInfo implements IGProAppInfo {
    public final GProAppInfo mInfo;

    public GGProAppInfo(GProAppInfo gProAppInfo) {
        this.mInfo = gProAppInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public String getAppDescription() {
        return this.mInfo.getAppDescription();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public long getAppId() {
        return this.mInfo.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public String getAppName() {
        return this.mInfo.getAppName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public int getAppQyyFlag() {
        return this.mInfo.getAppQyyFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public ArrayList<String> getPreViewList() {
        return this.mInfo.getPreViewList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
