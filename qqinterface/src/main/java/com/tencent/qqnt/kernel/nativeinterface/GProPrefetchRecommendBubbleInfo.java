package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProPrefetchRecommendBubbleInfo implements Serializable {
    boolean isDisplay;
    long serialVersionUID;
    String tips;

    public GProPrefetchRecommendBubbleInfo() {
        this.serialVersionUID = 1L;
        this.tips = "";
    }

    public boolean getIsDisplay() {
        return this.isDisplay;
    }

    public String getTips() {
        return this.tips;
    }

    public String toString() {
        return "GProPrefetchRecommendBubbleInfo{isDisplay=" + this.isDisplay + ",tips=" + this.tips + ",}";
    }

    public GProPrefetchRecommendBubbleInfo(boolean z, String str) {
        this.serialVersionUID = 1L;
        this.tips = "";
        this.isDisplay = z;
        this.tips = str;
    }
}
