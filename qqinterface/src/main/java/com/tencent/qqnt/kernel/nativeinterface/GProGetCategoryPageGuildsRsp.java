package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetCategoryPageGuildsRsp {
    ArrayList<GProRecommendCategory> categories;
    boolean isEnd;
    ArrayList<GProRecommendItem> items;
    String traceId;

    public GProGetCategoryPageGuildsRsp() {
        this.categories = new ArrayList<>();
        this.items = new ArrayList<>();
        this.traceId = "";
    }

    public ArrayList<GProRecommendCategory> getCategories() {
        return this.categories;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetCategoryPageGuildsRsp{categories=" + this.categories + ",items=" + this.items + ",traceId=" + this.traceId + ",isEnd=" + this.isEnd + ",}";
    }

    public GProGetCategoryPageGuildsRsp(ArrayList<GProRecommendCategory> arrayList, ArrayList<GProRecommendItem> arrayList2, String str, boolean z) {
        this.categories = new ArrayList<>();
        this.items = new ArrayList<>();
        this.traceId = "";
        this.categories = arrayList;
        this.items = arrayList2;
        this.traceId = str;
        this.isEnd = z;
    }
}
