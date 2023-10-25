package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProPlayPushScene implements Serializable {
    long serialVersionUID = 1;
    boolean volume;

    public GProPlayPushScene() {
    }

    public boolean getVolume() {
        return this.volume;
    }

    public String toString() {
        return "GProPlayPushScene{volume=" + this.volume + ",}";
    }

    public GProPlayPushScene(boolean z) {
        this.volume = z;
    }
}
