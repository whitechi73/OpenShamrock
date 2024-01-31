package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProPAReportExecuteRsp {

    /* renamed from: msg  reason: collision with root package name */
    String f305537msg;
    int ret;

    public GProPAReportExecuteRsp() {
        this.f305537msg = "";
    }

    public String getMsg() {
        return this.f305537msg;
    }

    public int getRet() {
        return this.ret;
    }

    public String toString() {
        return "GProPAReportExecuteRsp{ret=" + this.ret + ",msg=" + this.f305537msg + ",}";
    }

    public GProPAReportExecuteRsp(int i2, String str) {
        this.f305537msg = "";
        this.ret = i2;
        this.f305537msg = str;
    }
}
