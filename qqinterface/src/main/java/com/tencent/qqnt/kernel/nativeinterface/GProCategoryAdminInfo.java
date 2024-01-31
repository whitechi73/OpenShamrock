package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProCategoryAdminInfo {
    String categoryName;
    ArrayList<GProChannelAdminInfo> channelAdminList;

    public GProCategoryAdminInfo() {
        this.categoryName = "";
        this.channelAdminList = new ArrayList<>();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<GProChannelAdminInfo> getChannelAdminList() {
        return this.channelAdminList;
    }

    public String toString() {
        return "GProCategoryAdminInfo{categoryName=" + this.categoryName + ",channelAdminList=" + this.channelAdminList + ",}";
    }

    public GProCategoryAdminInfo(String str, ArrayList<GProChannelAdminInfo> arrayList) {
        this.categoryName = "";
        this.channelAdminList = new ArrayList<>();
        this.categoryName = str;
        this.channelAdminList = arrayList;
    }
}
