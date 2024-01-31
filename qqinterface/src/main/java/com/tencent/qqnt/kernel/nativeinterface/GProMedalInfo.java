package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProMedalInfo implements Serializable {
    long expireTime;
    String iconUrl;
    String name;
    GProOfficialMedalInfoExt officialMedalInfoExt;
    long serialVersionUID;

    public GProMedalInfo() {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.name = "";
        this.officialMedalInfoExt = new GProOfficialMedalInfoExt();
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public GProOfficialMedalInfoExt getOfficialMedalInfoExt() {
        return this.officialMedalInfoExt;
    }

    public String toString() {
        return "GProMedalInfo{iconUrl=" + this.iconUrl + ",name=" + this.name + ",expireTime=" + this.expireTime + ",officialMedalInfoExt=" + this.officialMedalInfoExt + ",}";
    }

    public GProMedalInfo(String str, String str2, long j2, GProOfficialMedalInfoExt gProOfficialMedalInfoExt) {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.name = "";
        this.officialMedalInfoExt = new GProOfficialMedalInfoExt();
        this.iconUrl = str;
        this.name = str2;
        this.expireTime = j2;
        this.officialMedalInfoExt = gProOfficialMedalInfoExt;
    }
}
