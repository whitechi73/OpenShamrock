package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProListenTogetherRspHead {
    GProConfirmOption confirmOption;
    int modCode;

    public GProListenTogetherRspHead() {
        this.confirmOption = new GProConfirmOption();
    }

    public GProConfirmOption getConfirmOption() {
        return this.confirmOption;
    }

    public int getModCode() {
        return this.modCode;
    }

    public String toString() {
        return "GProListenTogetherRspHead{modCode=" + this.modCode + ",confirmOption=" + this.confirmOption + ",}";
    }

    public GProListenTogetherRspHead(int i2, GProConfirmOption gProConfirmOption) {
        this.confirmOption = new GProConfirmOption();
        this.modCode = i2;
        this.confirmOption = gProConfirmOption;
    }
}
