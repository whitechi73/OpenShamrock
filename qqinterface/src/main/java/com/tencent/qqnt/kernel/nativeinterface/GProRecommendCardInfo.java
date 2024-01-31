package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendCardInfo {
    String cardId;

    public GProRecommendCardInfo() {
        this.cardId = "";
    }

    public String getCardId() {
        return this.cardId;
    }

    public String toString() {
        return "GProRecommendCardInfo{cardId=" + this.cardId + ",}";
    }

    public GProRecommendCardInfo(String str) {
        this.cardId = "";
        this.cardId = str;
    }
}
