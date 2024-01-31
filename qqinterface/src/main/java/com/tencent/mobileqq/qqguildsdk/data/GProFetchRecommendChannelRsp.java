package com.tencent.mobileqq.qqguildsdk.data;

public  class GProFetchRecommendChannelRsp implements IGProFetchRecommendChannelRsp {
    final long channelId;
    final String channelName;
    final String guildCoverUrl;
    final String guildIcon;
    final long guildId;
    final String guildName;
    final String guildProfile;

    public GProFetchRecommendChannelRsp(long j2, String str, String str2, String str3, String str4, long j3, String str5) {
        this.guildId = j2;
        this.guildName = str;
        this.guildProfile = str2;
        this.guildIcon = str3;
        this.guildCoverUrl = str4;
        this.channelId = j3;
        this.channelName = str5;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public String getChannelName() {
        return this.channelName;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public String getGuildCoverUrl() {
        return this.guildCoverUrl;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public String getGuildIcon() {
        return this.guildIcon;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public String getGuildName() {
        return this.guildName;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFetchRecommendChannelRsp
    public String getGuildProfile() {
        return this.guildProfile;
    }

    public String toString() {
        return "GProFetchRecommendChannelRsp{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildProfile=" + this.guildProfile + ",guildIcon=" + this.guildIcon + ",guildCoverUrl=" + this.guildCoverUrl + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",}";
    }

    public GProFetchRecommendChannelRsp(com.tencent.qqnt.kernel.nativeinterface.GProFetchRecommendChannelRsp gProFetchRecommendChannelRsp) {
        this.guildId = gProFetchRecommendChannelRsp.getGuildId();
        this.guildName = gProFetchRecommendChannelRsp.getGuildName();
        this.guildProfile = gProFetchRecommendChannelRsp.getGuildProfile();
        this.guildIcon = gProFetchRecommendChannelRsp.getGuildIcon();
        this.guildCoverUrl = gProFetchRecommendChannelRsp.getGuildCoverUrl();
        this.channelId = gProFetchRecommendChannelRsp.getChannelId();
        this.channelName = gProFetchRecommendChannelRsp.getChannelName();
    }
}
