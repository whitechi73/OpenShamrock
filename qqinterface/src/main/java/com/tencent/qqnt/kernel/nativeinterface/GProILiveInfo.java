package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProILiveInfo {
    long anchorUid;
    ArrayList<GProLiveDataItem> metricsData;
    String programId;
    long roomId;

    public GProILiveInfo() {
        this.programId = "";
        this.metricsData = new ArrayList<>();
    }

    public long getAnchorUid() {
        return this.anchorUid;
    }

    public ArrayList<GProLiveDataItem> getMetricsData() {
        return this.metricsData;
    }

    public String getProgramId() {
        return this.programId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProILiveInfo{programId=" + this.programId + ",anchorUid=" + this.anchorUid + ",roomId=" + this.roomId + ",metricsData=" + this.metricsData + ",}";
    }

    public GProILiveInfo(String str, long j2, long j3, ArrayList<GProLiveDataItem> arrayList) {
        this.programId = "";
        this.metricsData = new ArrayList<>();
        this.programId = str;
        this.anchorUid = j2;
        this.roomId = j3;
        this.metricsData = arrayList;
    }
}
