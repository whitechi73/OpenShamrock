package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProUserJoinedGuildSummary {
    ArrayList<GProRecommendChannelInfo> guildList;
    String joinedCountStr;

    public GProUserJoinedGuildSummary() {
        this.joinedCountStr = "";
        this.guildList = new ArrayList<>();
    }

    public ArrayList<GProRecommendChannelInfo> getGuildList() {
        return this.guildList;
    }

    public String getJoinedCountStr() {
        return this.joinedCountStr;
    }

    public String toString() {
        return "GProUserJoinedGuildSummary{joinedCountStr=" + this.joinedCountStr + ",guildList=" + this.guildList + ",}";
    }

    public GProUserJoinedGuildSummary(String str, ArrayList<GProRecommendChannelInfo> arrayList) {
        this.joinedCountStr = "";
        this.guildList = new ArrayList<>();
        this.joinedCountStr = str;
        this.guildList = arrayList;
    }
}
