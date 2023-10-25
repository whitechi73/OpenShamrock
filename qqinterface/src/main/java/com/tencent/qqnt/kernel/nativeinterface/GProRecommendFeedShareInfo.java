package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProRecommendFeedShareInfo implements Serializable {
    long serialVersionUID;
    String shareLink;
    int shareType;

    public GProRecommendFeedShareInfo() {
        this.serialVersionUID = 1L;
        this.shareLink = "";
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public int getShareType() {
        return this.shareType;
    }

    public String toString() {
        return "GProRecommendFeedShareInfo{shareType=" + this.shareType + ",shareLink=" + this.shareLink + ",}";
    }

    public GProRecommendFeedShareInfo(int i2, String str) {
        this.serialVersionUID = 1L;
        this.shareLink = "";
        this.shareType = i2;
        this.shareLink = str;
    }
}
