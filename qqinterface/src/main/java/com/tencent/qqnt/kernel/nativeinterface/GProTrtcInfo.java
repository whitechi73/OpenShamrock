package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProTrtcInfo {
    String sig;
    Integer time;

    public GProTrtcInfo() {
    }

    public String getSig() {
        return this.sig;
    }

    public Integer getTime() {
        return this.time;
    }

    public String toString() {
        return "GProTrtcInfo{sig=" + this.sig + ",time=" + this.time + ",}";
    }

    public GProTrtcInfo(String str, Integer num) {
        this.sig = str;
        this.time = num;
    }
}
