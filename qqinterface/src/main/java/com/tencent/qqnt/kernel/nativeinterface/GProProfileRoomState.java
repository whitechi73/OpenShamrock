package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProProfileRoomState {
    long channelId;
    int channelType;
    GProProfileChannelState feedChannelState;
    long guildId;
    GProLiveRoomInfo liveRoomState;
    GProProfileChannelState textChannelState;
    GProChannelMemberInfos voiceRoomState;

    public GProProfileRoomState() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public GProProfileChannelState getFeedChannelState() {
        return this.feedChannelState;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProLiveRoomInfo getLiveRoomState() {
        return this.liveRoomState;
    }

    public GProProfileChannelState getTextChannelState() {
        return this.textChannelState;
    }

    public GProChannelMemberInfos getVoiceRoomState() {
        return this.voiceRoomState;
    }

    public String toString() {
        return "GProProfileRoomState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",voiceRoomState=" + this.voiceRoomState + ",liveRoomState=" + this.liveRoomState + ",textChannelState=" + this.textChannelState + ",feedChannelState=" + this.feedChannelState + ",}";
    }

    public GProProfileRoomState(long j2, long j3, int i2, GProChannelMemberInfos gProChannelMemberInfos, GProLiveRoomInfo gProLiveRoomInfo, GProProfileChannelState gProProfileChannelState, GProProfileChannelState gProProfileChannelState2) {
        this.guildId = j2;
        this.channelId = j3;
        this.channelType = i2;
        this.voiceRoomState = gProChannelMemberInfos;
        this.liveRoomState = gProLiveRoomInfo;
        this.textChannelState = gProProfileChannelState;
        this.feedChannelState = gProProfileChannelState2;
    }
}
