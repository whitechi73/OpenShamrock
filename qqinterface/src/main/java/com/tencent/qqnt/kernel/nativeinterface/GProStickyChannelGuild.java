package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProStickyChannelGuild {
    long guildId;
    boolean hasStickyChannel;

    public GProStickyChannelGuild() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasStickyChannel() {
        return this.hasStickyChannel;
    }

    public String toString() {
        return "GProStickyChannelGuild{guildId=" + this.guildId + ",hasStickyChannel=" + this.hasStickyChannel + ",}";
    }

    public GProStickyChannelGuild(long j2, boolean z) {
        this.guildId = j2;
        this.hasStickyChannel = z;
    }
}
