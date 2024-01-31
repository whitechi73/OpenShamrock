package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendFeed implements Serializable {
    String cardBottomColor;
    long channelId;
    String channelInfoColor;
    long createTime;
    String feedCoverUrl;
    String feedId;
    String feedSubTitle;
    String feedTitle;
    String feedVideoCoverUrl;
    long guildId;
    long posterTinyId;
    long serialVersionUID;
    String titleColor;

    public GProRecommendFeed() {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.feedTitle = "";
        this.feedCoverUrl = "";
        this.feedSubTitle = "";
        this.titleColor = "";
        this.cardBottomColor = "";
        this.channelInfoColor = "";
        this.feedVideoCoverUrl = "";
    }

    public String getCardBottomColor() {
        return this.cardBottomColor;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelInfoColor() {
        return this.channelInfoColor;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedCoverUrl() {
        return this.feedCoverUrl;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getFeedSubTitle() {
        return this.feedSubTitle;
    }

    public String getFeedTitle() {
        return this.feedTitle;
    }

    public String getFeedVideoCoverUrl() {
        return this.feedVideoCoverUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getPosterTinyId() {
        return this.posterTinyId;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String toString() {
        return "GProRecommendFeed{feedId=" + this.feedId + ",feedTitle=" + this.feedTitle + ",feedCoverUrl=" + this.feedCoverUrl + ",posterTinyId=" + this.posterTinyId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",createTime=" + this.createTime + ",feedSubTitle=" + this.feedSubTitle + ",titleColor=" + this.titleColor + ",cardBottomColor=" + this.cardBottomColor + ",channelInfoColor=" + this.channelInfoColor + ",feedVideoCoverUrl=" + this.feedVideoCoverUrl + ",}";
    }

    public GProRecommendFeed(String str, String str2, String str3, long j2, long j3, long j4, long j5, String str4, String str5, String str6, String str7, String str8) {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.feedTitle = "";
        this.feedCoverUrl = "";
        this.feedSubTitle = "";
        this.titleColor = "";
        this.cardBottomColor = "";
        this.channelInfoColor = "";
        this.feedVideoCoverUrl = "";
        this.feedId = str;
        this.feedTitle = str2;
        this.feedCoverUrl = str3;
        this.posterTinyId = j2;
        this.guildId = j3;
        this.channelId = j4;
        this.createTime = j5;
        this.feedSubTitle = str4;
        this.titleColor = str5;
        this.cardBottomColor = str6;
        this.channelInfoColor = str7;
        this.feedVideoCoverUrl = str8;
    }
}
