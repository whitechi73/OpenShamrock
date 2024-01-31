package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProOpenSdkUrl {
    String h265;
    String hd;
    String ld;
    String raw;
    String sd;
    String sg;
    String sound;

    public GProOpenSdkUrl() {
    }

    public String getH265() {
        return this.h265;
    }

    public String getHd() {
        return this.hd;
    }

    public String getLd() {
        return this.ld;
    }

    public String getRaw() {
        return this.raw;
    }

    public String getSd() {
        return this.sd;
    }

    public String getSg() {
        return this.sg;
    }

    public String getSound() {
        return this.sound;
    }

    public String toString() {
        return "GProOpenSdkUrl{raw=" + this.raw + ",hd=" + this.hd + ",sd=" + this.sd + ",ld=" + this.ld + ",sound=" + this.sound + ",h265=" + this.h265 + ",sg=" + this.sg + ",}";
    }

    public GProOpenSdkUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.raw = str;
        this.hd = str2;
        this.sd = str3;
        this.ld = str4;
        this.sound = str5;
        this.h265 = str6;
        this.sg = str7;
    }
}
