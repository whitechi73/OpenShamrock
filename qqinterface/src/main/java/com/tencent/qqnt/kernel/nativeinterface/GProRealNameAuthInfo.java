package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRealNameAuthInfo {
    int result;
    String tipsContent;
    String verifyUrl;

    public GProRealNameAuthInfo() {
        this.verifyUrl = "";
        this.tipsContent = "";
    }

    public int getResult() {
        return this.result;
    }

    public String getTipsContent() {
        return this.tipsContent;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GProRealNameAuthInfo{result=" + this.result + ",verifyUrl=" + this.verifyUrl + ",tipsContent=" + this.tipsContent + ",}";
    }

    public GProRealNameAuthInfo(int i2, String str, String str2) {
        this.verifyUrl = "";
        this.tipsContent = "";
        this.result = i2;
        this.verifyUrl = str;
        this.tipsContent = str2;
    }
}
