package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEnterChannleInfoResult {
    int appId;
    boolean defaultMute;
    boolean globalMute;
    byte[] pKey;
    int screenShareBtnVisibleType;
    byte[] trtcSig;

    public GProEnterChannleInfoResult() {
        this.trtcSig = new byte[0];
        this.pKey = new byte[0];
    }

    public int getAppId() {
        return this.appId;
    }

    public boolean getDefaultMute() {
        return this.defaultMute;
    }

    public boolean getGlobalMute() {
        return this.globalMute;
    }

    public byte[] getPKey() {
        return this.pKey;
    }

    public int getScreenShareBtnVisibleType() {
        return this.screenShareBtnVisibleType;
    }

    public byte[] getTrtcSig() {
        return this.trtcSig;
    }

    public String toString() {
        return "GProEnterChannleInfoResult{trtcSig=" + this.trtcSig + ",pKey=" + this.pKey + ",appId=" + this.appId + ",defaultMute=" + this.defaultMute + ",globalMute=" + this.globalMute + ",screenShareBtnVisibleType=" + this.screenShareBtnVisibleType + ",}";
    }

    public GProEnterChannleInfoResult(byte[] bArr, byte[] bArr2, int i2, boolean z, boolean z2, int i3) {
        this.trtcSig = new byte[0];
        this.pKey = new byte[0];
        this.trtcSig = bArr;
        this.pKey = bArr2;
        this.appId = i2;
        this.defaultMute = z;
        this.globalMute = z2;
        this.screenShareBtnVisibleType = i3;
    }
}
