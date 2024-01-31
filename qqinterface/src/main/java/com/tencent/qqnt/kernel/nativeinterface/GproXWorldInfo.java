package com.tencent.qqnt.kernel.nativeinterface;


public  final class GproXWorldInfo {
    boolean allowDisplay;
    long bindTime;
    long guildId;
    String guildName;
    String guildUrl;

    public GproXWorldInfo() {
        this.guildUrl = "";
        this.guildName = "";
    }

    public boolean getAllowDisplay() {
        return this.allowDisplay;
    }

    public long getBindTime() {
        return this.bindTime;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildUrl() {
        return this.guildUrl;
    }

    public String toString() {
        return "GproXWorldInfo{allowDisplay=" + this.allowDisplay + ",guildId=" + this.guildId + ",guildUrl=" + this.guildUrl + ",bindTime=" + this.bindTime + ",guildName=" + this.guildName + ",}";
    }

    public GproXWorldInfo(boolean z, long j2, String str, long j3, String str2) {
        this.guildUrl = "";
        this.guildName = "";
        this.allowDisplay = z;
        this.guildId = j2;
        this.guildUrl = str;
        this.bindTime = j3;
        this.guildName = str2;
    }
}
