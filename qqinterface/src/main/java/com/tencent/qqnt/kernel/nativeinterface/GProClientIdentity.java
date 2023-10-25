package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProClientIdentity implements Serializable {
    int clientId;
    String desc;
    GProClientIdentityBytes identityBytes;
    long serialVersionUID;

    public GProClientIdentity() {
        this.serialVersionUID = 1L;
        this.desc = "";
        this.identityBytes = new GProClientIdentityBytes();
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getDesc() {
        return this.desc;
    }

    public GProClientIdentityBytes getIdentityBytes() {
        return this.identityBytes;
    }

    public String toString() {
        return "GProClientIdentity{clientId=" + this.clientId + ",desc=" + this.desc + ",identityBytes=" + this.identityBytes + ",}";
    }

    public GProClientIdentity(int i2, String str, GProClientIdentityBytes gProClientIdentityBytes) {
        this.serialVersionUID = 1L;
        this.desc = "";
        this.identityBytes = new GProClientIdentityBytes();
        this.clientId = i2;
        this.desc = str;
        this.identityBytes = gProClientIdentityBytes;
    }
}
