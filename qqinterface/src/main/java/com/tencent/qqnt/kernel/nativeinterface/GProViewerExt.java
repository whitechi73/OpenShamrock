package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProViewerExt implements Serializable {
    int fakeNum;
    int realNum;
    int rebotNum;
    long serialVersionUID = 1;

    public GProViewerExt() {
    }

    public int getFakeNum() {
        return this.fakeNum;
    }

    public int getRealNum() {
        return this.realNum;
    }

    public int getRebotNum() {
        return this.rebotNum;
    }

    public String toString() {
        return "GProViewerExt{fakeNum=" + this.fakeNum + ",realNum=" + this.realNum + ",rebotNum=" + this.rebotNum + ",}";
    }

    public GProViewerExt(int i2, int i3, int i4) {
        this.fakeNum = i2;
        this.realNum = i3;
        this.rebotNum = i4;
    }
}
