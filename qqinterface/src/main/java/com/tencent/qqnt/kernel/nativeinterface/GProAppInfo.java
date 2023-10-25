package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProAppInfo {
    String appDescription;
    long appId;
    String appName;
    int appQyyFlag;
    String iconUrl;
    ArrayList<String> preViewList;

    public GProAppInfo() {
        this.iconUrl = "";
        this.appName = "";
        this.appDescription = "";
        this.preViewList = new ArrayList<>();
    }

    public String getAppDescription() {
        return this.appDescription;
    }

    public long getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppQyyFlag() {
        return this.appQyyFlag;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public ArrayList<String> getPreViewList() {
        return this.preViewList;
    }

    public String toString() {
        return "GProAppInfo{appId=" + this.appId + ",iconUrl=" + this.iconUrl + ",appName=" + this.appName + ",appDescription=" + this.appDescription + ",preViewList=" + this.preViewList + ",appQyyFlag=" + this.appQyyFlag + ",}";
    }

    public GProAppInfo(long j2, String str, String str2, String str3, ArrayList<String> arrayList, int i2) {
        this.iconUrl = "";
        this.appName = "";
        this.appDescription = "";
        this.preViewList = new ArrayList<>();
        this.appId = j2;
        this.iconUrl = str;
        this.appName = str2;
        this.appDescription = str3;
        this.preViewList = arrayList;
        this.appQyyFlag = i2;
    }
}
