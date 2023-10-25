package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProGetCategoryPageGuildsReq {
    GProRecommendCategory category;
    int refreshNum;
    GProBottomTabSourceInfo source;

    public GProGetCategoryPageGuildsReq() {
        this.category = new GProRecommendCategory();
        this.source = new GProBottomTabSourceInfo();
    }

    public GProRecommendCategory getCategory() {
        return this.category;
    }

    public int getRefreshNum() {
        return this.refreshNum;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetCategoryPageGuildsReq{category=" + this.category + ",source=" + this.source + ",refreshNum=" + this.refreshNum + ",}";
    }

    public GProGetCategoryPageGuildsReq(GProRecommendCategory gProRecommendCategory, GProBottomTabSourceInfo gProBottomTabSourceInfo, int i2) {
        this.category = new GProRecommendCategory();
        this.source = new GProBottomTabSourceInfo();
        this.category = gProRecommendCategory;
        this.source = gProBottomTabSourceInfo;
        this.refreshNum = i2;
    }
}
