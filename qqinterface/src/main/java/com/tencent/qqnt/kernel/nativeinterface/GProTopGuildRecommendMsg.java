package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProTopGuildRecommendMsg implements Serializable {
    GProRecommendItem recommendItem;
    long serialVersionUID;

    public GProTopGuildRecommendMsg() {
        this.serialVersionUID = 1L;
        this.recommendItem = new GProRecommendItem();
    }

    public GProRecommendItem getRecommendItem() {
        return this.recommendItem;
    }

    public String toString() {
        return "GProTopGuildRecommendMsg{recommendItem=" + this.recommendItem + ",}";
    }

    public GProTopGuildRecommendMsg(GProRecommendItem gProRecommendItem) {
        this.serialVersionUID = 1L;
        this.recommendItem = new GProRecommendItem();
        this.recommendItem = gProRecommendItem;
    }
}
