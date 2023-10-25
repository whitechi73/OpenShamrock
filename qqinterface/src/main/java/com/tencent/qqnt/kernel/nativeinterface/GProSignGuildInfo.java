package com.tencent.qqnt.kernel.nativeinterface;



/* loaded from: classes4.dex */
public final class GProSignGuildInfo {
    String desc;
    long endTime;
    long guildId;
    String guildName;
    long startTime;
    String url;

    public GProSignGuildInfo() {
        this.guildName = "";
        this.url = "";
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProSignGuildInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",startTime=" + this.startTime + ",endTime=" + this.endTime + ",url = " + this.url + ",desc=" + this.desc + ",}";
    }

    public GProSignGuildInfo(long j2, String str, long j3, long j4, String str2, String str3) {
        this.guildName = "";
        this.url = "";
        this.desc = "";
        this.guildId = j2;
        this.guildName = str;
        this.startTime = j3;
        this.endTime = j4;
        this.url = str2;
        this.desc = str3;
    }
}
