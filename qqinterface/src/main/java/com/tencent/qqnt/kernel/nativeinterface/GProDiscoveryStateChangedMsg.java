package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProDiscoveryStateChangedMsg implements Serializable {
    GProMyRecommendMsg myRecommendMsg;
    GProGetPrefetchRecommendGuildsRsp prefetchRecommendMsg;
    int sceneType;
    long serialVersionUID;
    GProTopGuildRecommendMsg topGuildRecommendMsg;

    public GProDiscoveryStateChangedMsg() {
        this.serialVersionUID = 1L;
        this.myRecommendMsg = new GProMyRecommendMsg();
        this.prefetchRecommendMsg = new GProGetPrefetchRecommendGuildsRsp();
        this.topGuildRecommendMsg = new GProTopGuildRecommendMsg();
    }

    public GProMyRecommendMsg getMyRecommendMsg() {
        return this.myRecommendMsg;
    }

    public GProGetPrefetchRecommendGuildsRsp getPrefetchRecommendMsg() {
        return this.prefetchRecommendMsg;
    }

    public int getSceneType() {
        return this.sceneType;
    }

    public GProTopGuildRecommendMsg getTopGuildRecommendMsg() {
        return this.topGuildRecommendMsg;
    }

    public String toString() {
        return "GProDiscoveryStateChangedMsg{sceneType=" + this.sceneType + ",myRecommendMsg=" + this.myRecommendMsg + ",prefetchRecommendMsg=" + this.prefetchRecommendMsg + ",topGuildRecommendMsg=" + this.topGuildRecommendMsg + ",}";
    }

    public GProDiscoveryStateChangedMsg(int i2, GProMyRecommendMsg gProMyRecommendMsg, GProGetPrefetchRecommendGuildsRsp gProGetPrefetchRecommendGuildsRsp, GProTopGuildRecommendMsg gProTopGuildRecommendMsg) {
        this.serialVersionUID = 1L;
        this.myRecommendMsg = new GProMyRecommendMsg();
        this.prefetchRecommendMsg = new GProGetPrefetchRecommendGuildsRsp();
        this.topGuildRecommendMsg = new GProTopGuildRecommendMsg();
        this.sceneType = i2;
        this.myRecommendMsg = gProMyRecommendMsg;
        this.prefetchRecommendMsg = gProGetPrefetchRecommendGuildsRsp;
        this.topGuildRecommendMsg = gProTopGuildRecommendMsg;
    }
}
