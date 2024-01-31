package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProRecommendPopupAdsInfo implements Serializable {
    ArrayList<GProBlockBaseInfo> list;
    long serialVersionUID;
    int tabType;

    public GProRecommendPopupAdsInfo() {
        this.serialVersionUID = 1L;
        this.list = new ArrayList<>();
    }

    public ArrayList<GProBlockBaseInfo> getList() {
        return this.list;
    }

    public int getTabType() {
        return this.tabType;
    }

    public String toString() {
        return "GProRecommendPopupAdsInfo{tabType=" + this.tabType + ",list=" + this.list + ",}";
    }

    public GProRecommendPopupAdsInfo(int i2, ArrayList<GProBlockBaseInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.list = new ArrayList<>();
        this.tabType = i2;
        this.list = arrayList;
    }
}
