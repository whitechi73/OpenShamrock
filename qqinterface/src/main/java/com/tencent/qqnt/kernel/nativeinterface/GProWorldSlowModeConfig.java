package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProWorldSlowModeConfig implements Serializable {
    long operatorTinyId;
    long serialVersionUID = 1;
    int slowModeKey;

    public GProWorldSlowModeConfig() {
    }

    public long getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public int getSlowModeKey() {
        return this.slowModeKey;
    }

    public String toString() {
        return "GProWorldSlowModeConfig{slowModeKey=" + this.slowModeKey + ",operatorTinyId=" + this.operatorTinyId + ",}";
    }

    public GProWorldSlowModeConfig(int i2, long j2) {
        this.slowModeKey = i2;
        this.operatorTinyId = j2;
    }
}
