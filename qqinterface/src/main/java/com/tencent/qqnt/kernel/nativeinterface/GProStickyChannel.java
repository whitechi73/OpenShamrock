package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProStickyChannel implements Serializable {
    String channelId;
    int channelType;
    long createTime;
    GProStickyFeedChannel feedChannel;
    String guildId;
    GProLiveRoomInfo liveChannel;
    long serialVersionUID;
    GProStickyTextChannel textChannel;
    long updateTime;
    GProChannelMemberInfos voiceChannel;
    GProWorldChannelInfos worldChannel;
    GProChannelMemberInfos worldPresence;

    public GProStickyChannel() {
        this.serialVersionUID = 1L;
        this.guildId = "";
        this.channelId = "";
        this.textChannel = new GProStickyTextChannel();
        this.liveChannel = new GProLiveRoomInfo();
        this.voiceChannel = new GProChannelMemberInfos();
        this.feedChannel = new GProStickyFeedChannel();
        this.worldChannel = new GProWorldChannelInfos();
        this.worldPresence = new GProChannelMemberInfos();
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProStickyFeedChannel getFeedChannel() {
        return this.feedChannel;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public GProLiveRoomInfo getLiveChannel() {
        return this.liveChannel;
    }

    public GProStickyTextChannel getTextChannel() {
        return this.textChannel;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public GProChannelMemberInfos getVoiceChannel() {
        return this.voiceChannel;
    }

    public GProWorldChannelInfos getWorldChannel() {
        return this.worldChannel;
    }

    public GProChannelMemberInfos getWorldPresence() {
        return this.worldPresence;
    }

    public String toString() {
        return "GProStickyChannel{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",createTime=" + this.createTime + ",updateTime=" + this.updateTime + ",textChannel=" + this.textChannel + ",liveChannel=" + this.liveChannel + ",voiceChannel=" + this.voiceChannel + ",feedChannel=" + this.feedChannel + ",worldChannel=" + this.worldChannel + ",worldPresence=" + this.worldPresence + ",}";
    }

    public GProStickyChannel(String str, String str2, int i2, long j2, long j3, GProStickyTextChannel gProStickyTextChannel, GProLiveRoomInfo gProLiveRoomInfo, GProChannelMemberInfos gProChannelMemberInfos, GProStickyFeedChannel gProStickyFeedChannel, GProWorldChannelInfos gProWorldChannelInfos, GProChannelMemberInfos gProChannelMemberInfos2) {
        this.serialVersionUID = 1L;
        this.guildId = "";
        this.channelId = "";
        this.textChannel = new GProStickyTextChannel();
        this.liveChannel = new GProLiveRoomInfo();
        this.voiceChannel = new GProChannelMemberInfos();
        this.feedChannel = new GProStickyFeedChannel();
        this.worldChannel = new GProWorldChannelInfos();
        this.worldPresence = new GProChannelMemberInfos();
        this.guildId = str;
        this.channelId = str2;
        this.channelType = i2;
        this.createTime = j2;
        this.updateTime = j3;
        this.textChannel = gProStickyTextChannel;
        this.liveChannel = gProLiveRoomInfo;
        this.voiceChannel = gProChannelMemberInfos;
        this.feedChannel = gProStickyFeedChannel;
        this.worldChannel = gProWorldChannelInfos;
        this.worldPresence = gProChannelMemberInfos2;
    }
}
