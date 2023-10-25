package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProItemCbData {
    byte[] cbExtData;
    String statData;

    public GProItemCbData() {
        this.statData = "";
        this.cbExtData = new byte[0];
    }

    public byte[] getCbExtData() {
        return this.cbExtData;
    }

    public String getStatData() {
        return this.statData;
    }

    public String toString() {
        return "GProItemCbData{statData=" + this.statData + ",cbExtData=" + this.cbExtData + ",}";
    }

    public GProItemCbData(String str, byte[] bArr) {
        this.statData = "";
        this.cbExtData = new byte[0];
        this.statData = str;
        this.cbExtData = bArr;
    }
}
