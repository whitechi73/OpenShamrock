package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProAVChannelConfig implements Serializable {
    ArrayList<GProBusinessNode> businessList;
    long channelDataVersion;
    long originatorTinyId;
    long serialVersionUID;
    GProGuildThemeInfo themeInfo;
    ArrayList<GProGuildThemeInfo> themeList;
    GProChannelToolBar toolBar;

    public GProAVChannelConfig() {
        this.serialVersionUID = 1L;
        this.themeInfo = new GProGuildThemeInfo();
        this.businessList = new ArrayList<>();
        this.toolBar = new GProChannelToolBar();
        this.themeList = new ArrayList<>();
    }

    public ArrayList<GProBusinessNode> getBusinessList() {
        return this.businessList;
    }

    public long getChannelDataVersion() {
        return this.channelDataVersion;
    }

    public long getOriginatorTinyId() {
        return this.originatorTinyId;
    }

    public GProGuildThemeInfo getThemeInfo() {
        return this.themeInfo;
    }

    public ArrayList<GProGuildThemeInfo> getThemeList() {
        return this.themeList;
    }

    public GProChannelToolBar getToolBar() {
        return this.toolBar;
    }

    public String toString() {
        return "GProAVChannelConfig{themeInfo=" + this.themeInfo + ",businessList=" + this.businessList + ",originatorTinyId=" + this.originatorTinyId + ",toolBar=" + this.toolBar + ",themeList=" + this.themeList + ",channelDataVersion=" + this.channelDataVersion + ",}";
    }

    public GProAVChannelConfig(GProGuildThemeInfo gProGuildThemeInfo, ArrayList<GProBusinessNode> arrayList, long j2, GProChannelToolBar gProChannelToolBar, ArrayList<GProGuildThemeInfo> arrayList2, long j3) {
        this.serialVersionUID = 1L;
        this.themeInfo = new GProGuildThemeInfo();
        this.businessList = new ArrayList<>();
        this.toolBar = new GProChannelToolBar();
        this.themeList = new ArrayList<>();
        this.themeInfo = gProGuildThemeInfo;
        this.businessList = arrayList;
        this.originatorTinyId = j2;
        this.toolBar = gProChannelToolBar;
        this.themeList = arrayList2;
        this.channelDataVersion = j3;
    }
}
