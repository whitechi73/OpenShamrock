package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildBrowseInfo {
    ArrayList<Long> channelIds;
    long guildId;

    public GProGuildBrowseInfo() {
        this.channelIds = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGuildBrowseInfo{guildId=" + this.guildId + ",channelIds=" + this.channelIds + ",}";
    }

    public GProGuildBrowseInfo(long j2, ArrayList<Long> arrayList) {
        this.channelIds = new ArrayList<>();
        this.guildId = j2;
        this.channelIds = arrayList;
    }
}
