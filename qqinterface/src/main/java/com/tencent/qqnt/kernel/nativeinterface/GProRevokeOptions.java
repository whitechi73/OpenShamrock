package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRevokeOptions {
    int revokeMsgDuration;

    public GProRevokeOptions() {
    }

    public int getRevokeMsgDuration() {
        return this.revokeMsgDuration;
    }

    public String toString() {
        return "GProRevokeOptions{revokeMsgDuration=" + this.revokeMsgDuration + ",}";
    }

    public GProRevokeOptions(int i2) {
        this.revokeMsgDuration = i2;
    }
}
