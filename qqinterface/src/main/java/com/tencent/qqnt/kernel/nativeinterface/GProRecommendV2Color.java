package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProRecommendV2Color implements Serializable {
    long serialVersionUID = 1;
    int uint32B;
    int uint32G;
    int uint32R;

    public GProRecommendV2Color() {
    }

    public int getUint32B() {
        return this.uint32B;
    }

    public int getUint32G() {
        return this.uint32G;
    }

    public int getUint32R() {
        return this.uint32R;
    }

    public String toString() {
        return "GProRecommendV2Color{uint32R=" + this.uint32R + ",uint32G=" + this.uint32G + ",uint32B=" + this.uint32B + ",}";
    }

    public GProRecommendV2Color(int i2, int i3, int i4) {
        this.uint32R = i2;
        this.uint32G = i3;
        this.uint32B = i4;
    }
}
