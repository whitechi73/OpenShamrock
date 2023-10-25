package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProClientAccount {
    String accountName;
    String accountSecret;
    long bindTimeStamp;
    GProClientShowCfg clientConfig;
    int clientId;
    String clientName;
    String icon;
    int openType;
    String openUrl;

    public GProClientAccount() {
        this.clientName = "";
        this.accountSecret = "";
        this.accountName = "";
        this.clientConfig = new GProClientShowCfg();
        this.icon = "";
        this.openUrl = "";
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountSecret() {
        return this.accountSecret;
    }

    public long getBindTimeStamp() {
        return this.bindTimeStamp;
    }

    public GProClientShowCfg getClientConfig() {
        return this.clientConfig;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getOpenType() {
        return this.openType;
    }

    public String getOpenUrl() {
        return this.openUrl;
    }

    public String toString() {
        return "GProClientAccount{clientId=" + this.clientId + ",clientName=" + this.clientName + ",accountSecret=" + this.accountSecret + ",accountName=" + this.accountName + ",clientConfig=" + this.clientConfig + ",icon=" + this.icon + ",bindTimeStamp=" + this.bindTimeStamp + ",openType=" + this.openType + ",openUrl=" + this.openUrl + ",}";
    }

    public GProClientAccount(int i2, String str, String str2, String str3, GProClientShowCfg gProClientShowCfg, String str4, long j2, int i3, String str5) {
        this.clientName = "";
        this.accountSecret = "";
        this.accountName = "";
        this.clientConfig = new GProClientShowCfg();
        this.icon = "";
        this.openUrl = "";
        this.clientId = i2;
        this.clientName = str;
        this.accountSecret = str2;
        this.accountName = str3;
        this.clientConfig = gProClientShowCfg;
        this.icon = str4;
        this.bindTimeStamp = j2;
        this.openType = i3;
        this.openUrl = str5;
    }
}
