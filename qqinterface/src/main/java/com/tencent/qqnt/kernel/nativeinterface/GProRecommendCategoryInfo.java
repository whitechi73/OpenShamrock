package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProRecommendCategoryInfo {
    long categoryId;
    int categoryIndex;
    String categoryName;
    ArrayList<GProChannel> channelInfoList;

    public GProRecommendCategoryInfo() {
        this.channelInfoList = new ArrayList<>();
        this.categoryName = "";
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryIndex() {
        return this.categoryIndex;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<GProChannel> getChannelInfoList() {
        return this.channelInfoList;
    }

    public String toString() {
        return "GProRecommendCategoryInfo{categoryIndex=" + this.categoryIndex + ",channelInfoList=" + this.channelInfoList + ",categoryName=" + this.categoryName + ",categoryId=" + this.categoryId + ",}";
    }

    public GProRecommendCategoryInfo(int i2, ArrayList<GProChannel> arrayList, String str, long j2) {
        this.channelInfoList = new ArrayList<>();
        this.categoryName = "";
        this.categoryIndex = i2;
        this.channelInfoList = arrayList;
        this.categoryName = str;
        this.categoryId = j2;
    }
}
