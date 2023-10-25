package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProLiveSearchInfo {
    long anchorTinyId;
    long channelId;
    String coverUrl;
    String guildIconUrl;
    long guildId;
    String guildName;
    String joinGuildSig;
    int joinedGuild;
    int liveType;
    GProRecallInfo recallInfo;
    long roomId;
    String roomName;
    String streamUrl;
    String tag;

    public GProLiveSearchInfo() {
        this.streamUrl = "";
        this.coverUrl = "";
        this.tag = "";
        this.joinGuildSig = "";
        this.guildName = "";
        this.guildIconUrl = "";
        this.roomName = "";
        this.recallInfo = new GProRecallInfo();
    }

    public long getAnchorTinyId() {
        return this.anchorTinyId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGuildIconUrl() {
        return this.guildIconUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return "GProLiveSearchInfo{joinedGuild=" + this.joinedGuild + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",roomId=" + this.roomId + ",anchorTinyId=" + this.anchorTinyId + ",streamUrl=" + this.streamUrl + ",coverUrl=" + this.coverUrl + ",tag=" + this.tag + ",joinGuildSig=" + this.joinGuildSig + ",guildName=" + this.guildName + ",guildIconUrl=" + this.guildIconUrl + ",roomName=" + this.roomName + ",recallInfo=" + this.recallInfo + ",liveType=" + this.liveType + ",}";
    }

    public GProLiveSearchInfo(int i2, long j2, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6, String str7, GProRecallInfo gProRecallInfo, int i3) {
        this.streamUrl = "";
        this.coverUrl = "";
        this.tag = "";
        this.joinGuildSig = "";
        this.guildName = "";
        this.guildIconUrl = "";
        this.roomName = "";
        this.recallInfo = new GProRecallInfo();
        this.joinedGuild = i2;
        this.guildId = j2;
        this.channelId = j3;
        this.roomId = j4;
        this.anchorTinyId = j5;
        this.streamUrl = str;
        this.coverUrl = str2;
        this.tag = str3;
        this.joinGuildSig = str4;
        this.guildName = str5;
        this.guildIconUrl = str6;
        this.roomName = str7;
        this.recallInfo = gProRecallInfo;
        this.liveType = i3;
    }
}
