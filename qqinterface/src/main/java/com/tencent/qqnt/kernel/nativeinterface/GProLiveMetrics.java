package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProLiveMetrics {
    ArrayList<GProMetricsItem> items;

    public GProLiveMetrics() {
        this.items = new ArrayList<>();
    }

    public ArrayList<GProMetricsItem> getItems() {
        return this.items;
    }

    public String toString() {
        return "GProLiveMetrics{items=" + this.items + ",}";
    }

    public GProLiveMetrics(ArrayList<GProMetricsItem> arrayList) {
        this.items = new ArrayList<>();
        this.items = arrayList;
    }
}
