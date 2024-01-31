package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendMyFeed implements Serializable {
    byte[] data;
    long serialVersionUID;
    GProRecommendFeedShareInfo shareInfo;

    public GProRecommendMyFeed() {
        this.serialVersionUID = 1L;
        this.data = new byte[0];
        this.shareInfo = new GProRecommendFeedShareInfo();
    }

    public byte[] getData() {
        return this.data;
    }

    public GProRecommendFeedShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public String toString() {
        return "GProRecommendMyFeed{data=" + this.data + ",shareInfo=" + this.shareInfo + ",}";
    }

    public GProRecommendMyFeed(byte[] bArr, GProRecommendFeedShareInfo gProRecommendFeedShareInfo) {
        this.serialVersionUID = 1L;
        this.data = new byte[0];
        this.shareInfo = new GProRecommendFeedShareInfo();
        this.data = bArr;
        this.shareInfo = gProRecommendFeedShareInfo;
    }
}
