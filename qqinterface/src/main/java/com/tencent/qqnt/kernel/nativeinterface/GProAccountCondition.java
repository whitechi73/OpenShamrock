package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAccountCondition {
    long clientId;
    boolean isNeedAuth;

    public GProAccountCondition() {
    }

    public long getClientId() {
        return this.clientId;
    }

    public boolean getIsNeedAuth() {
        return this.isNeedAuth;
    }

    public String toString() {
        return "GProAccountCondition{clientId=" + this.clientId + ",isNeedAuth=" + this.isNeedAuth + ",}";
    }

    public GProAccountCondition(long j2, boolean z) {
        this.clientId = j2;
        this.isNeedAuth = z;
    }
}
