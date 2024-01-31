package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProTopRecommendInfo implements Serializable {
    String categoryName;
    ArrayList<Long> recommendedGuildList;
    long serialVersionUID;

    public GProTopRecommendInfo() {
        this.serialVersionUID = 1L;
        this.categoryName = "";
        this.recommendedGuildList = new ArrayList<>();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<Long> getRecommendedGuildList() {
        return this.recommendedGuildList;
    }

    public String toString() {
        return "GProTopRecommendInfo{categoryName=" + this.categoryName + ",recommendedGuildList=" + this.recommendedGuildList + ",}";
    }

    public GProTopRecommendInfo(String str, ArrayList<Long> arrayList) {
        this.serialVersionUID = 1L;
        this.categoryName = "";
        this.recommendedGuildList = new ArrayList<>();
        this.categoryName = str;
        this.recommendedGuildList = arrayList;
    }
}
