package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProQQMsgListGuild {
    long avatarSeq;
    long guildId;
    String guildName;
    long topTimestamp;

    public GProQQMsgListGuild() {
        this.guildName = "";
    }

    public long getAvatarSeq() {
        return this.avatarSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String toString() {
        return "GProQQMsgListGuild{guildId=" + this.guildId + ",topTimestamp=" + this.topTimestamp + ",guildName=" + this.guildName + ",avatarSeq=" + this.avatarSeq + ",}";
    }

    public GProQQMsgListGuild(long j2, long j3, String str, long j4) {
        this.guildName = "";
        this.guildId = j2;
        this.topTimestamp = j3;
        this.guildName = str;
        this.avatarSeq = j4;
    }
}
