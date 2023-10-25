package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildOnlineReportReq {
    int activeTab;
    ArrayList<GProGuildBrowseInfo> browseInfo;
    ArrayList<GProGuildOnlineReportExtInfo> exts;
    boolean isVisiting;
    int scene;
    int sourceType;
    long tinyId;

    public GProGuildOnlineReportReq() {
        this.browseInfo = new ArrayList<>();
        this.exts = new ArrayList<>();
    }

    public int getActiveTab() {
        return this.activeTab;
    }

    public ArrayList<GProGuildBrowseInfo> getBrowseInfo() {
        return this.browseInfo;
    }

    public ArrayList<GProGuildOnlineReportExtInfo> getExts() {
        return this.exts;
    }

    public boolean getIsVisiting() {
        return this.isVisiting;
    }

    public int getScene() {
        return this.scene;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProGuildOnlineReportReq{tinyId=" + this.tinyId + ",activeTab=" + this.activeTab + ",browseInfo=" + this.browseInfo + ",isVisiting=" + this.isVisiting + ",scene=" + this.scene + ",sourceType=" + this.sourceType + ",exts=" + this.exts + ",}";
    }

    public GProGuildOnlineReportReq(long j2, int i2, ArrayList<GProGuildBrowseInfo> arrayList, boolean z, int i3, int i4, ArrayList<GProGuildOnlineReportExtInfo> arrayList2) {
        this.browseInfo = new ArrayList<>();
        this.exts = new ArrayList<>();
        this.tinyId = j2;
        this.activeTab = i2;
        this.browseInfo = arrayList;
        this.isVisiting = z;
        this.scene = i3;
        this.sourceType = i4;
        this.exts = arrayList2;
    }
}
