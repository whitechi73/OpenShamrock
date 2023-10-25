package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAnchorTlv {
    String str;
    Integer tid;
    Long value;

    public GProAnchorTlv() {
    }

    public String getStr() {
        return this.str;
    }

    public Integer getTid() {
        return this.tid;
    }

    public Long getValue() {
        return this.value;
    }

    public String toString() {
        return "GProAnchorTlv{tid=" + this.tid + ",value=" + this.value + ",str=" + this.str + ",}";
    }

    public GProAnchorTlv(Integer num, Long l2, String str) {
        this.tid = num;
        this.value = l2;
        this.str = str;
    }
}
