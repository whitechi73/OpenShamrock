package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetRecommendQuickJoinReq {
    int cardType;
    byte[] cookies;
    int scene;

    public GProGetRecommendQuickJoinReq() {
        this.cookies = new byte[0];
    }

    public int getCardType() {
        return this.cardType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getScene() {
        return this.scene;
    }

    public String toString() {
        return "GProGetRecommendQuickJoinReq{cardType=" + this.cardType + ",scene=" + this.scene + ",cookies=" + this.cookies + ",}";
    }

    public GProGetRecommendQuickJoinReq(int i2, int i3, byte[] bArr) {
        this.cookies = new byte[0];
        this.cardType = i2;
        this.scene = i3;
        this.cookies = bArr;
    }
}
