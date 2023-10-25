package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGuildIdentity {
    long appid;
    String orgID;
    String worldID;

    public GProGuildIdentity() {
        this.orgID = "";
        this.worldID = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public String getOrgID() {
        return this.orgID;
    }

    public String getWorldID() {
        return this.worldID;
    }

    public String toString() {
        return "GProGuildIdentity{appid=" + this.appid + ",orgID=" + this.orgID + ",worldID=" + this.worldID + ",}";
    }

    public GProGuildIdentity(long j2, String str, String str2) {
        this.orgID = "";
        this.worldID = "";
        this.appid = j2;
        this.orgID = str;
        this.worldID = str2;
    }
}
