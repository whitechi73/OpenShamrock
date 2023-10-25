package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProAVDevOptInfo implements Serializable {
    int cameraOpt;
    int micOpt;
    int screenOpt;
    long serialVersionUID = 1;

    public GProAVDevOptInfo() {
    }

    public int getCameraOpt() {
        return this.cameraOpt;
    }

    public int getMicOpt() {
        return this.micOpt;
    }

    public int getScreenOpt() {
        return this.screenOpt;
    }

    public String toString() {
        return "GProAVDevOptInfo{micOpt=" + this.micOpt + ",cameraOpt=" + this.cameraOpt + ",screenOpt=" + this.screenOpt + ",}";
    }

    public GProAVDevOptInfo(int i2, int i3, int i4) {
        this.micOpt = i2;
        this.cameraOpt = i3;
        this.screenOpt = i4;
    }
}
