package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProFetchCategoryAdminDisplayInfoReq {
    long guildId;

    public GProFetchCategoryAdminDisplayInfoReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProFetchCategoryAdminDisplayInfoReq{guildId=" + this.guildId + ",}";
    }

    public GProFetchCategoryAdminDisplayInfoReq(long j2) {
        this.guildId = j2;
    }
}
