package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class GProGetRecommendQuickJoinRsp {
    ArrayList<GProRecommendQuickJoinItem> recommendQuickJoinItems;

    public GProGetRecommendQuickJoinRsp() {
        this.recommendQuickJoinItems = new ArrayList<>();
    }

    public ArrayList<GProRecommendQuickJoinItem> getRecommendQuickJoinItems() {
        return this.recommendQuickJoinItems;
    }

    public String toString() {
        return "GProGetRecommendQuickJoinRsp{recommendQuickJoinItems=" + this.recommendQuickJoinItems + ",}";
    }

    public GProGetRecommendQuickJoinRsp(ArrayList<GProRecommendQuickJoinItem> arrayList) {
        this.recommendQuickJoinItems = new ArrayList<>();
        this.recommendQuickJoinItems = arrayList;
    }
}
