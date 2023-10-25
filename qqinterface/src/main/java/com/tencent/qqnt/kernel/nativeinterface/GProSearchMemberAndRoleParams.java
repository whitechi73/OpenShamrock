package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProSearchMemberAndRoleParams {
    long channelId;
    long count;
    long guildId;
    String keyWord;
    long roleId;
    int sourceType;
    int srcType;

    public GProSearchMemberAndRoleParams() {
        this.keyWord = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getCount() {
        return this.count;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int getSrcType() {
        return this.srcType;
    }

    public String toString() {
        return "GProSearchMemberAndRoleParams{guildId=" + this.guildId + ",channelId=" + this.channelId + ",roleId=" + this.roleId + ",keyWord=" + this.keyWord + ",srcType=" + this.srcType + ",sourceType=" + this.sourceType + ",count=" + this.count + ",}";
    }

    public GProSearchMemberAndRoleParams(long j2, long j3, long j4, String str, int i2, int i3, long j5) {
        this.keyWord = "";
        this.guildId = j2;
        this.channelId = j3;
        this.roleId = j4;
        this.keyWord = str;
        this.srcType = i2;
        this.sourceType = i3;
        this.count = j5;
    }
}
