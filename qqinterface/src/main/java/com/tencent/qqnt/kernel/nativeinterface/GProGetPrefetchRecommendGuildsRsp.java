package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetPrefetchRecommendGuildsRsp implements Serializable {
    GProPrefetchRecommendBubbleInfo bubbleInfo;
    ArrayList<GProPrefetchRecommendGuildInfo> guildInfos;
    GProPrefetchRecommendRedDotInfo redDotInfo;
    long serialVersionUID;

    public GProGetPrefetchRecommendGuildsRsp() {
        this.serialVersionUID = 1L;
        this.guildInfos = new ArrayList<>();
        this.redDotInfo = new GProPrefetchRecommendRedDotInfo();
        this.bubbleInfo = new GProPrefetchRecommendBubbleInfo();
    }

    public GProPrefetchRecommendBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    public ArrayList<GProPrefetchRecommendGuildInfo> getGuildInfos() {
        return this.guildInfos;
    }

    public GProPrefetchRecommendRedDotInfo getRedDotInfo() {
        return this.redDotInfo;
    }

    public String toString() {
        return "GProGetPrefetchRecommendGuildsRsp{guildInfos=" + this.guildInfos + ",redDotInfo=" + this.redDotInfo + ",bubbleInfo=" + this.bubbleInfo + ",}";
    }

    public GProGetPrefetchRecommendGuildsRsp(ArrayList<GProPrefetchRecommendGuildInfo> arrayList, GProPrefetchRecommendRedDotInfo gProPrefetchRecommendRedDotInfo, GProPrefetchRecommendBubbleInfo gProPrefetchRecommendBubbleInfo) {
        this.serialVersionUID = 1L;
        this.guildInfos = new ArrayList<>();
        this.redDotInfo = new GProPrefetchRecommendRedDotInfo();
        this.bubbleInfo = new GProPrefetchRecommendBubbleInfo();
        this.guildInfos = arrayList;
        this.redDotInfo = gProPrefetchRecommendRedDotInfo;
        this.bubbleInfo = gProPrefetchRecommendBubbleInfo;
    }
}
