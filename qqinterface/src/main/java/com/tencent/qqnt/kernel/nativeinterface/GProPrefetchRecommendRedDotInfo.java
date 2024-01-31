package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProPrefetchRecommendRedDotInfo implements Serializable {
    boolean isDisplay;
    long serialVersionUID = 1;

    public GProPrefetchRecommendRedDotInfo() {
    }

    public boolean getIsDisplay() {
        return this.isDisplay;
    }

    public String toString() {
        return "GProPrefetchRecommendRedDotInfo{isDisplay=" + this.isDisplay + ",}";
    }

    public GProPrefetchRecommendRedDotInfo(boolean z) {
        this.isDisplay = z;
    }
}
