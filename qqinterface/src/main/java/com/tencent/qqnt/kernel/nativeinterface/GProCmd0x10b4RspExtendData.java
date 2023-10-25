package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProCmd0x10b4RspExtendData implements Serializable {
    int code;
    long serialVersionUID = 1;

    public GProCmd0x10b4RspExtendData() {
    }

    public int getCode() {
        return this.code;
    }

    public String toString() {
        return "GProCmd0x10b4RspExtendData{code=" + this.code + ",}";
    }

    public GProCmd0x10b4RspExtendData(int i2) {
        this.code = i2;
    }
}
