package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProFaceAuthInfo {
    int faceAuthStatus;
    String verifyUrl;

    public GProFaceAuthInfo() {
        this.verifyUrl = "";
    }

    public int getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GProFaceAuthInfo{faceAuthStatus=" + this.faceAuthStatus + ",verifyUrl=" + this.verifyUrl + ",}";
    }

    public GProFaceAuthInfo(int i2, String str) {
        this.verifyUrl = "";
        this.faceAuthStatus = i2;
        this.verifyUrl = str;
    }
}
