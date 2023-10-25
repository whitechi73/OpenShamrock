package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProArkArg {
    String app;
    String config;
    String desc;
    String meta;
    String prompt;
    String ver;
    String view;

    public GProArkArg() {
        this.app = "";
        this.view = "";
        this.ver = "";
        this.desc = "";
        this.prompt = "";
        this.meta = "";
        this.config = "";
    }

    public String getApp() {
        return this.app;
    }

    public String getConfig() {
        return this.config;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getMeta() {
        return this.meta;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getVer() {
        return this.ver;
    }

    public String getView() {
        return this.view;
    }

    public String toString() {
        return "GProArkArg{app=" + this.app + ",view=" + this.view + ",ver=" + this.ver + ",desc=" + this.desc + ",prompt=" + this.prompt + ",meta=" + this.meta + ",config=" + this.config + ",}";
    }

    public GProArkArg(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.app = "";
        this.view = "";
        this.ver = "";
        this.desc = "";
        this.prompt = "";
        this.meta = "";
        this.config = "";
        this.app = str;
        this.view = str2;
        this.ver = str3;
        this.desc = str4;
        this.prompt = str5;
        this.meta = str6;
        this.config = str7;
    }
}
