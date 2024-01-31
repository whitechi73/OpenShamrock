package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public  final class GProGuildInit {
    ArrayList<GProCategoryChannelIdList> categoryList;
    HashMap<Long, GProChannel> channelMap;
    long guildId;
    GProCategoryChannelIdList uncategorizedChannels;

    public GProGuildInit() {
        this.channelMap = new HashMap<>();
        this.uncategorizedChannels = new GProCategoryChannelIdList();
        this.categoryList = new ArrayList<>();
    }

    public ArrayList<GProCategoryChannelIdList> getCategoryList() {
        return this.categoryList;
    }

    public HashMap<Long, GProChannel> getChannelMap() {
        return this.channelMap;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProCategoryChannelIdList getUncategorizedChannels() {
        return this.uncategorizedChannels;
    }

    public String toString() {
        return "GProGuildInit{guildId=" + this.guildId + ",channelMap=" + this.channelMap + ",uncategorizedChannels=" + this.uncategorizedChannels + ",categoryList=" + this.categoryList + ",}";
    }

    public GProGuildInit(long j2, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList) {
        this.channelMap = new HashMap<>();
        this.uncategorizedChannels = new GProCategoryChannelIdList();
        this.categoryList = new ArrayList<>();
        this.guildId = j2;
        this.channelMap = hashMap;
        this.uncategorizedChannels = gProCategoryChannelIdList;
        this.categoryList = arrayList;
    }
}
