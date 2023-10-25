package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class GroupFileCommonResult {
    String clientWording;
    int retCode;
    String retMsg;

    public GroupFileCommonResult() {
        this.retMsg = "";
        this.clientWording = "";
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public String toString() {
        return "GroupFileCommonResult{retCode=" + this.retCode + ",retMsg=" + this.retMsg + ",clientWording=" + this.clientWording + ",}";
    }

    public GroupFileCommonResult(int i2, String str, String str2) {
        this.retMsg = "";
        this.clientWording = "";
        this.retCode = i2;
        this.retMsg = str;
        this.clientWording = str2;
    }
}
