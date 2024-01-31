package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFetchCategoryAdminDisplayInfoReq {
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
