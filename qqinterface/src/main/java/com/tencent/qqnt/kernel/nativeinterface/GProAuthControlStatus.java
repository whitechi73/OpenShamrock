package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProAuthControlStatus implements Serializable {
    int authControlKey;
    int authControlValue;
    long serialVersionUID = 1;

    public GProAuthControlStatus() {
    }

    public int getAuthControlKey() {
        return this.authControlKey;
    }

    public int getAuthControlValue() {
        return this.authControlValue;
    }

    public String toString() {
        return "GProAuthControlStatus{authControlKey=" + this.authControlKey + ",authControlValue=" + this.authControlValue + ",}";
    }

    public GProAuthControlStatus(int i2, int i3) {
        this.authControlKey = i2;
        this.authControlValue = i3;
    }
}
