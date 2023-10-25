package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRecommendExtInfo {
    String traceId;

    public GProRecommendExtInfo() {
        this.traceId = "";
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProRecommendExtInfo{traceId=" + this.traceId + ",}";
    }

    public GProRecommendExtInfo(String str) {
        this.traceId = "";
        this.traceId = str;
    }
}
