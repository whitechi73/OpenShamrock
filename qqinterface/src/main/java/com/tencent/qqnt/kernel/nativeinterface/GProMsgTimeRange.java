package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProMsgTimeRange {
    String endDate;
    String startDate;

    public GProMsgTimeRange() {
        this.startDate = "";
        this.endDate = "";
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String toString() {
        return "GProMsgTimeRange{startDate=" + this.startDate + ",endDate=" + this.endDate + ",}";
    }

    public GProMsgTimeRange(String str, String str2) {
        this.startDate = "";
        this.endDate = "";
        this.startDate = str;
        this.endDate = str2;
    }
}
