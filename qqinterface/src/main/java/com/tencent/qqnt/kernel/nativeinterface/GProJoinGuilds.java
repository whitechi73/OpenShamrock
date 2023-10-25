package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProJoinGuilds implements Serializable {
    long guildId;
    String joinGuildSig;
    long serialVersionUID;

    public GProJoinGuilds() {
        this.serialVersionUID = 1L;
        this.joinGuildSig = "";
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public String toString() {
        return "GProJoinGuilds{guildId=" + this.guildId + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }

    public GProJoinGuilds(long j2, String str) {
        this.serialVersionUID = 1L;
        this.joinGuildSig = "";
        this.guildId = j2;
        this.joinGuildSig = str;
    }
}
