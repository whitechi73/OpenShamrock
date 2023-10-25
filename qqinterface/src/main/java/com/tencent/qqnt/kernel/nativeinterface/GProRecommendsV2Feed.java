package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendsV2Feed implements Serializable {
    ArrayList<String> attributeTags;
    String bannerUrl;
    String buttonColor;
    String buttonDesc;
    String buttonDescColor;
    String cardBottomColor;
    long cardId;
    long cardTank;
    String cardUrl;
    long channelId;
    String channelInfoColor;
    String contentId;
    long createTime;
    int favorCnt;
    int feedCardType;
    String feedCoverUrl;
    String feedId;
    String feedSubTitle;
    String feedTitle;
    String feedVideoCoverUrl;
    long guildId;
    int imageRatioType;
    String inviteCode;
    int isMore;
    long posterTinyId;
    long serialVersionUID;
    String titleColor;

    public GProRecommendsV2Feed() {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.feedTitle = "";
        this.feedCoverUrl = "";
        this.feedSubTitle = "";
        this.titleColor = "";
        this.cardBottomColor = "";
        this.channelInfoColor = "";
        this.feedVideoCoverUrl = "";
        this.cardUrl = "";
        this.inviteCode = "";
        this.contentId = "";
        this.bannerUrl = "";
        this.attributeTags = new ArrayList<>();
        this.buttonDesc = "";
        this.buttonColor = "";
        this.buttonDescColor = "";
    }

    public ArrayList<String> getAttributeTags() {
        return this.attributeTags;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    public String getButtonDesc() {
        return this.buttonDesc;
    }

    public String getButtonDescColor() {
        return this.buttonDescColor;
    }

    public String getCardBottomColor() {
        return this.cardBottomColor;
    }

    public long getCardId() {
        return this.cardId;
    }

    public long getCardTank() {
        return this.cardTank;
    }

    public String getCardUrl() {
        return this.cardUrl;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelInfoColor() {
        return this.channelInfoColor;
    }

    public String getContentId() {
        return this.contentId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getFavorCnt() {
        return this.favorCnt;
    }

    public int getFeedCardType() {
        return this.feedCardType;
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

    public int getImageRatioType() {
        return this.imageRatioType;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public int getIsMore() {
        return this.isMore;
    }

    public long getPosterTinyId() {
        return this.posterTinyId;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String toString() {
        return "GProRecommendsV2Feed{feedId=" + this.feedId + ",feedTitle=" + this.feedTitle + ",feedCoverUrl=" + this.feedCoverUrl + ",posterTinyId=" + this.posterTinyId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",createTime=" + this.createTime + ",feedSubTitle=" + this.feedSubTitle + ",titleColor=" + this.titleColor + ",cardBottomColor=" + this.cardBottomColor + ",channelInfoColor=" + this.channelInfoColor + ",feedVideoCoverUrl=" + this.feedVideoCoverUrl + ",imageRatioType=" + this.imageRatioType + ",favorCnt=" + this.favorCnt + ",feedCardType=" + this.feedCardType + ",cardUrl=" + this.cardUrl + ",inviteCode=" + this.inviteCode + ",contentId=" + this.contentId + ",bannerUrl=" + this.bannerUrl + ",cardId=" + this.cardId + ",isMore=" + this.isMore + ",attributeTags=" + this.attributeTags + ",cardTank=" + this.cardTank + ",buttonDesc=" + this.buttonDesc + ",buttonColor=" + this.buttonColor + ",buttonDescColor=" + this.buttonDescColor + ",}";
    }

    public GProRecommendsV2Feed(String str, String str2, String str3, long j2, long j3, long j4, long j5, String str4, String str5, String str6, String str7, String str8, int i2, int i3, int i4, String str9, String str10, String str11, String str12, long j6, int i5, ArrayList<String> arrayList, long j7, String str13, String str14, String str15) {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.feedTitle = "";
        this.feedCoverUrl = "";
        this.feedSubTitle = "";
        this.titleColor = "";
        this.cardBottomColor = "";
        this.channelInfoColor = "";
        this.feedVideoCoverUrl = "";
        this.cardUrl = "";
        this.inviteCode = "";
        this.contentId = "";
        this.bannerUrl = "";
        this.attributeTags = new ArrayList<>();
        this.buttonDesc = "";
        this.buttonColor = "";
        this.buttonDescColor = "";
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
        this.imageRatioType = i2;
        this.favorCnt = i3;
        this.feedCardType = i4;
        this.cardUrl = str9;
        this.inviteCode = str10;
        this.contentId = str11;
        this.bannerUrl = str12;
        this.cardId = j6;
        this.isMore = i5;
        this.attributeTags = arrayList;
        this.cardTank = j7;
        this.buttonDesc = str13;
        this.buttonColor = str14;
        this.buttonDescColor = str15;
    }
}
