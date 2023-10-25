package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProResult {
    String errMsg;
    long memberTid;
    int result;

    public GProResult() {
        this.errMsg = "";
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getMemberTid() {
        return this.memberTid;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "GProResult{memberTid=" + this.memberTid + ",result=" + this.result + ",errMsg=" + this.errMsg + ",}";
    }

    public GProResult(long j2, int i2, String str) {
        this.errMsg = "";
        this.memberTid = j2;
        this.result = i2;
        this.errMsg = str;
    }
}
