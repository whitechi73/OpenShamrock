package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProIdentity implements Serializable {
    int identityType;
    byte[] plateData;
    long serialVersionUID;
    int type;
    String value;

    public GProIdentity() {
        this.serialVersionUID = 1L;
        this.value = "";
        this.plateData = new byte[0];
    }

    public int getIdentityType() {
        return this.identityType;
    }

    public byte[] getPlateData() {
        return this.plateData;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "GProIdentity{type=" + this.type + ",value=" + this.value + ",identityType=" + this.identityType + ",plateData=" + this.plateData + ",}";
    }

    public GProIdentity(int i2, String str, int i3, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.value = "";
        this.plateData = new byte[0];
        this.type = i2;
        this.value = str;
        this.identityType = i3;
        this.plateData = bArr;
    }
}
