package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProCategoryChannelIdList {
    long categoryId;
    ArrayList<Long> channelList;
    boolean folded;
    String name;

    public GProCategoryChannelIdList() {
        this.name = "";
        this.channelList = new ArrayList<>();
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Long> getChannelList() {
        return this.channelList;
    }

    public boolean getFolded() {
        return this.folded;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProCategoryChannelIdList{name=" + this.name + ",categoryId=" + this.categoryId + ",channelList=" + this.channelList + ",folded=" + this.folded + ",}";
    }

    public GProCategoryChannelIdList(String str, long j2, ArrayList<Long> arrayList, boolean z) {
        this.name = "";
        this.channelList = new ArrayList<>();
        this.name = str;
        this.categoryId = j2;
        this.channelList = arrayList;
        this.folded = z;
    }
}
