package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProArchiveArkData {
    GProArkArg arkArgs;
    int clientId;
    String icon;
    String name;

    public GProArchiveArkData() {
        this.name = "";
        this.icon = "";
        this.arkArgs = new GProArkArg();
    }

    public GProArkArg getArkArgs() {
        return this.arkArgs;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProArchiveArkData{clientId=" + this.clientId + ",name=" + this.name + ",icon=" + this.icon + ",arkArgs=" + this.arkArgs + ",}";
    }

    public GProArchiveArkData(int i2, String str, String str2, GProArkArg gProArkArg) {
        this.name = "";
        this.icon = "";
        this.arkArgs = new GProArkArg();
        this.clientId = i2;
        this.name = str;
        this.icon = str2;
        this.arkArgs = gProArkArg;
    }
}
