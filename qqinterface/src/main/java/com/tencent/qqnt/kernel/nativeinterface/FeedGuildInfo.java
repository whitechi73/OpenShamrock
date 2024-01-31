package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedGuildInfo {
    String guildId;
    long joinTime;
    String name;

    public FeedGuildInfo() {
        this.guildId = "";
        this.name = "";
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "FeedGuildInfo{guildId=" + this.guildId + ",name=" + this.name + ",joinTime=" + this.joinTime + ",}";
    }

    public FeedGuildInfo(String str, String str2, long j2) {
        this.guildId = "";
        this.name = "";
        this.guildId = str;
        this.name = str2;
        this.joinTime = j2;
    }
}
