package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProCreatedGuildInfo {
    long createTime;
    String faceUrl;
    long guildId;
    String guildName;
    long guildOwnerUin;
    long memberNum;

    public GProCreatedGuildInfo() {
        this.guildName = "";
        this.faceUrl = "";
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getGuildOwnerUin() {
        return this.guildOwnerUin;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    public String toString() {
        return "GProCreatedGuildInfo{guildOwnerUin=" + this.guildOwnerUin + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",createTime=" + this.createTime + ",memberNum=" + this.memberNum + ",faceUrl=" + this.faceUrl + ",}";
    }

    public GProCreatedGuildInfo(long j2, long j3, String str, long j4, long j5, String str2) {
        this.guildName = "";
        this.faceUrl = "";
        this.guildOwnerUin = j2;
        this.guildId = j3;
        this.guildName = str;
        this.createTime = j4;
        this.memberNum = j5;
        this.faceUrl = str2;
    }
}
