package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProClientInfo {
    int clientId;
    String clientName;
    GProIdentityInstruction identityInstruction;

    public GProClientInfo() {
        this.clientName = "";
        this.identityInstruction = new GProIdentityInstruction();
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public GProIdentityInstruction getIdentityInstruction() {
        return this.identityInstruction;
    }

    public String toString() {
        return "GProClientInfo{clientId=" + this.clientId + ",clientName=" + this.clientName + ",identityInstruction=" + this.identityInstruction + ",}";
    }

    public GProClientInfo(int i2, String str, GProIdentityInstruction gProIdentityInstruction) {
        this.clientName = "";
        this.identityInstruction = new GProIdentityInstruction();
        this.clientId = i2;
        this.clientName = str;
        this.identityInstruction = gProIdentityInstruction;
    }
}
