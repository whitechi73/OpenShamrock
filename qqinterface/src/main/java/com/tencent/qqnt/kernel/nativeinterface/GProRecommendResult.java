package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendResult {
    GProRecommendCardInfo recommendCardInfo;
    GProRecommendGroupInfo recommendGroupInfo;
    GProRecommendInfo recommendInfo;
    int type;

    public GProRecommendResult() {
        this.recommendInfo = new GProRecommendInfo();
        this.recommendGroupInfo = new GProRecommendGroupInfo();
        this.recommendCardInfo = new GProRecommendCardInfo();
    }

    public GProRecommendCardInfo getRecommendCardInfo() {
        return this.recommendCardInfo;
    }

    public GProRecommendGroupInfo getRecommendGroupInfo() {
        return this.recommendGroupInfo;
    }

    public GProRecommendInfo getRecommendInfo() {
        return this.recommendInfo;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendResult{recommendInfo=" + this.recommendInfo + ",recommendGroupInfo=" + this.recommendGroupInfo + ",type=" + this.type + ",recommendCardInfo=" + this.recommendCardInfo + ",}";
    }

    public GProRecommendResult(GProRecommendInfo gProRecommendInfo, GProRecommendGroupInfo gProRecommendGroupInfo, int i2, GProRecommendCardInfo gProRecommendCardInfo) {
        this.recommendInfo = new GProRecommendInfo();
        this.recommendGroupInfo = new GProRecommendGroupInfo();
        this.recommendCardInfo = new GProRecommendCardInfo();
        this.recommendInfo = gProRecommendInfo;
        this.recommendGroupInfo = gProRecommendGroupInfo;
        this.type = i2;
        this.recommendCardInfo = gProRecommendCardInfo;
    }
}
