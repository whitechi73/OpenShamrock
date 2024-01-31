package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProGuildEssenceSvrReq implements Serializable {
    long guildId;
    long serialVersionUID = 1;
    GProUnifiedEssenceInfo unifiedEssenceInfo;

    public GProGuildEssenceSvrReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProUnifiedEssenceInfo getUnifiedEssenceInfo() {
        return this.unifiedEssenceInfo;
    }

    public String toString() {
        return "GProGuildEssenceSvrReq{guildId=" + this.guildId + ",unifiedEssenceInfo=" + this.unifiedEssenceInfo + ",}";
    }

    public GProGuildEssenceSvrReq(long j2, GProUnifiedEssenceInfo gProUnifiedEssenceInfo) {
        this.guildId = j2;
        this.unifiedEssenceInfo = gProUnifiedEssenceInfo;
    }
}
