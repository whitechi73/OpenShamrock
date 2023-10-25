package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProPollingChannelState {
    GProActiveChannelInfo activeChannelInfo;
    GProAppChnnPreInfo appChannelPresence;
    long channelId;
    GProChannel channelInfo;
    GProCreateGuildGuideInfo createGuildGuideInfo;
    GProGlobalBanner guildGlobalBanner;
    long guildId;
    ArrayList<GProStickyChannel> guildStickyChannelList;
    GProLiveRoomInfo liveChannelPresence;
    GProOnlineMemberInfo onlineMemberInfo;
    GProRecommendEssenceSvrRsp recommendEssence;
    int source;
    int type;
    long updateTime;
    GProChannelMemberInfos voiceChannelPresence;
    GProChannelMemberInfos worldChannelInfo;
    GProWorldChannelInfos worldChannelPresence;

    public GProPollingChannelState() {
        this.voiceChannelPresence = new GProChannelMemberInfos();
        this.liveChannelPresence = new GProLiveRoomInfo();
        this.appChannelPresence = new GProAppChnnPreInfo();
        this.guildGlobalBanner = new GProGlobalBanner();
        this.createGuildGuideInfo = new GProCreateGuildGuideInfo();
        this.onlineMemberInfo = new GProOnlineMemberInfo();
        this.guildStickyChannelList = new ArrayList<>();
        this.worldChannelPresence = new GProWorldChannelInfos();
        this.worldChannelInfo = new GProChannelMemberInfos();
        this.recommendEssence = new GProRecommendEssenceSvrRsp();
        this.activeChannelInfo = new GProActiveChannelInfo();
        this.channelInfo = new GProChannel();
    }

    public GProActiveChannelInfo getActiveChannelInfo() {
        return this.activeChannelInfo;
    }

    public GProAppChnnPreInfo getAppChannelPresence() {
        return this.appChannelPresence;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProChannel getChannelInfo() {
        return this.channelInfo;
    }

    public GProCreateGuildGuideInfo getCreateGuildGuideInfo() {
        return this.createGuildGuideInfo;
    }

    public GProGlobalBanner getGuildGlobalBanner() {
        return this.guildGlobalBanner;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProStickyChannel> getGuildStickyChannelList() {
        return this.guildStickyChannelList;
    }

    public GProLiveRoomInfo getLiveChannelPresence() {
        return this.liveChannelPresence;
    }

    public GProOnlineMemberInfo getOnlineMemberInfo() {
        return this.onlineMemberInfo;
    }

    public GProRecommendEssenceSvrRsp getRecommendEssence() {
        return this.recommendEssence;
    }

    public int getSource() {
        return this.source;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public GProChannelMemberInfos getVoiceChannelPresence() {
        return this.voiceChannelPresence;
    }

    public GProChannelMemberInfos getWorldChannelInfo() {
        return this.worldChannelInfo;
    }

    public GProWorldChannelInfos getWorldChannelPresence() {
        return this.worldChannelPresence;
    }

    public String toString() {
        return "GProPollingChannelState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",type=" + this.type + ",updateTime=" + this.updateTime + ",source=" + this.source + ",voiceChannelPresence=" + this.voiceChannelPresence + ",liveChannelPresence=" + this.liveChannelPresence + ",appChannelPresence=" + this.appChannelPresence + ",guildGlobalBanner=" + this.guildGlobalBanner + ",createGuildGuideInfo=" + this.createGuildGuideInfo + ",onlineMemberInfo=" + this.onlineMemberInfo + ",guildStickyChannelList=" + this.guildStickyChannelList + ",worldChannelPresence=" + this.worldChannelPresence + ",worldChannelInfo=" + this.worldChannelInfo + ",recommendEssence=" + this.recommendEssence + ",activeChannelInfo=" + this.activeChannelInfo + ",channelInfo=" + this.channelInfo + ",}";
    }

    public GProPollingChannelState(long j2, long j3, int i2, long j4, int i3, GProChannelMemberInfos gProChannelMemberInfos, GProLiveRoomInfo gProLiveRoomInfo, GProAppChnnPreInfo gProAppChnnPreInfo, GProGlobalBanner gProGlobalBanner, GProCreateGuildGuideInfo gProCreateGuildGuideInfo, GProOnlineMemberInfo gProOnlineMemberInfo, ArrayList<GProStickyChannel> arrayList, GProWorldChannelInfos gProWorldChannelInfos, GProChannelMemberInfos gProChannelMemberInfos2, GProRecommendEssenceSvrRsp gProRecommendEssenceSvrRsp, GProActiveChannelInfo gProActiveChannelInfo, GProChannel gProChannel) {
        this.voiceChannelPresence = new GProChannelMemberInfos();
        this.liveChannelPresence = new GProLiveRoomInfo();
        this.appChannelPresence = new GProAppChnnPreInfo();
        this.guildGlobalBanner = new GProGlobalBanner();
        this.createGuildGuideInfo = new GProCreateGuildGuideInfo();
        this.onlineMemberInfo = new GProOnlineMemberInfo();
        this.guildStickyChannelList = new ArrayList<>();
        this.worldChannelPresence = new GProWorldChannelInfos();
        this.worldChannelInfo = new GProChannelMemberInfos();
        this.recommendEssence = new GProRecommendEssenceSvrRsp();
        this.activeChannelInfo = new GProActiveChannelInfo();
        this.channelInfo = new GProChannel();
        this.guildId = j2;
        this.channelId = j3;
        this.type = i2;
        this.updateTime = j4;
        this.source = i3;
        this.voiceChannelPresence = gProChannelMemberInfos;
        this.liveChannelPresence = gProLiveRoomInfo;
        this.appChannelPresence = gProAppChnnPreInfo;
        this.guildGlobalBanner = gProGlobalBanner;
        this.createGuildGuideInfo = gProCreateGuildGuideInfo;
        this.onlineMemberInfo = gProOnlineMemberInfo;
        this.guildStickyChannelList = arrayList;
        this.worldChannelPresence = gProWorldChannelInfos;
        this.worldChannelInfo = gProChannelMemberInfos2;
        this.recommendEssence = gProRecommendEssenceSvrRsp;
        this.activeChannelInfo = gProActiveChannelInfo;
        this.channelInfo = gProChannel;
    }
}
