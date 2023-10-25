package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEncryptTextRsp {
    String encryptedText;
    boolean isPassed;

    public GProEncryptTextRsp() {
        this.encryptedText = "";
    }

    public String getEncryptedText() {
        return this.encryptedText;
    }

    public boolean getIsPassed() {
        return this.isPassed;
    }

    public String toString() {
        return "GProEncryptTextRsp{isPassed=" + this.isPassed + ",encryptedText=" + this.encryptedText + ",}";
    }

    public GProEncryptTextRsp(boolean z, String str) {
        this.encryptedText = "";
        this.isPassed = z;
        this.encryptedText = str;
    }
}
