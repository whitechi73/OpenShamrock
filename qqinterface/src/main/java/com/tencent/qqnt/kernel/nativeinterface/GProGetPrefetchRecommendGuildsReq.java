package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetPrefetchRecommendGuildsReq implements Serializable {
    long serialVersionUID;
    GProBottomTabSourceInfo source;

    public GProGetPrefetchRecommendGuildsReq() {
        this.serialVersionUID = 1L;
        this.source = new GProBottomTabSourceInfo();
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetPrefetchRecommendGuildsReq{source=" + this.source + ",}";
    }

    public GProGetPrefetchRecommendGuildsReq(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.serialVersionUID = 1L;
        this.source = new GProBottomTabSourceInfo();
        this.source = gProBottomTabSourceInfo;
    }
}
