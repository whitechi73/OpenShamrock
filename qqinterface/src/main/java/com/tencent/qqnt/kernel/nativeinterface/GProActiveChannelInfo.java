package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProActiveChannelInfo {
    ArrayList<Long> channelIds;
    String guildId;

    public GProActiveChannelInfo() {
        this.guildId = "";
        this.channelIds = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProActiveChannelInfo{guildId=" + this.guildId + ",channelIds=" + this.channelIds + ",}";
    }

    public GProActiveChannelInfo(String str, ArrayList<Long> arrayList) {
        this.guildId = "";
        this.channelIds = new ArrayList<>();
        this.guildId = str;
        this.channelIds = arrayList;
    }
}
