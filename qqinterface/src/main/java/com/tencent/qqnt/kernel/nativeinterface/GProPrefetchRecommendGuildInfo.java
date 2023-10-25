package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProPrefetchRecommendGuildInfo implements Serializable {
    String category;
    String guildIcon;
    long guildId;
    long serialVersionUID;

    public GProPrefetchRecommendGuildInfo() {
        this.serialVersionUID = 1L;
        this.guildIcon = "";
        this.category = "";
    }

    public String getCategory() {
        return this.category;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProPrefetchRecommendGuildInfo{guildId=" + this.guildId + ",guildIcon=" + this.guildIcon + ",category=" + this.category + ",}";
    }

    public GProPrefetchRecommendGuildInfo(long j2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.guildIcon = "";
        this.category = "";
        this.guildId = j2;
        this.guildIcon = str;
        this.category = str2;
    }
}
