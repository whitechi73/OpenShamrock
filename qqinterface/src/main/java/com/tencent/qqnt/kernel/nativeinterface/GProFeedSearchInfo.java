package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProFeedSearchInfo {
    long channelId;
    long commentCount;
    String content;
    String contentId;
    long createTime;
    GProSearchUser creator;
    long favorCount;
    String feedId;
    String guildHeadUrl;
    long guildId;
    String guildName;
    ArrayList<String> highlightWords;
    ArrayList<GProFeedImageEntity> images;
    String inviteCode;
    String joinGuildSig;
    GProRecallInfo recallInfo;
    int showType;
    byte[] stFeed;
    GProSuggestedSearch suggestedSearchInfo;
    ArrayList<String> tags;
    String title;
    int type;
    String userId;
    GProFeedImageEntity videoCoverUrl;

    public GProFeedSearchInfo() {
        this.feedId = "";
        this.userId = "";
        this.title = "";
        this.content = "";
        this.images = new ArrayList<>();
        this.inviteCode = "";
        this.creator = new GProSearchUser();
        this.guildName = "";
        this.guildHeadUrl = "";
        this.joinGuildSig = "";
        this.videoCoverUrl = new GProFeedImageEntity();
        this.tags = new ArrayList<>();
        this.recallInfo = new GProRecallInfo();
        this.contentId = "";
        this.highlightWords = new ArrayList<>();
        this.suggestedSearchInfo = new GProSuggestedSearch();
        this.stFeed = new byte[0];
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getCommentCount() {
        return this.commentCount;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentId() {
        return this.contentId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProSearchUser getCreator() {
        return this.creator;
    }

    public long getFavorCount() {
        return this.favorCount;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getGuildHeadUrl() {
        return this.guildHeadUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public ArrayList<GProFeedImageEntity> getImages() {
        return this.images;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public int getShowType() {
        return this.showType;
    }

    public byte[] getStFeed() {
        return this.stFeed;
    }

    public GProSuggestedSearch getSuggestedSearchInfo() {
        return this.suggestedSearchInfo;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public GProFeedImageEntity getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public String toString() {
        return "GProFeedSearchInfo{feedId=" + this.feedId + ",userId=" + this.userId + ",createTime=" + this.createTime + ",title=" + this.title + ",content=" + this.content + ",images=" + this.images + ",inviteCode=" + this.inviteCode + ",creator=" + this.creator + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildHeadUrl=" + this.guildHeadUrl + ",channelId=" + this.channelId + ",joinGuildSig=" + this.joinGuildSig + ",type=" + this.type + ",videoCoverUrl=" + this.videoCoverUrl + ",tags=" + this.tags + ",recallInfo=" + this.recallInfo + ",favorCount=" + this.favorCount + ",commentCount=" + this.commentCount + ",contentId=" + this.contentId + ",highlightWords=" + this.highlightWords + ",suggestedSearchInfo=" + this.suggestedSearchInfo + ",stFeed=" + this.stFeed + ",showType=" + this.showType + ",}";
    }

    public GProFeedSearchInfo(String str, String str2, long j2, String str3, String str4, ArrayList<GProFeedImageEntity> arrayList, String str5, GProSearchUser gProSearchUser, long j3, String str6, String str7, long j4, String str8, int i2, GProFeedImageEntity gProFeedImageEntity, ArrayList<String> arrayList2, GProRecallInfo gProRecallInfo, long j5, long j6, String str9, ArrayList<String> arrayList3, GProSuggestedSearch gProSuggestedSearch, byte[] bArr, int i3) {
        this.feedId = "";
        this.userId = "";
        this.title = "";
        this.content = "";
        this.images = new ArrayList<>();
        this.inviteCode = "";
        this.creator = new GProSearchUser();
        this.guildName = "";
        this.guildHeadUrl = "";
        this.joinGuildSig = "";
        this.videoCoverUrl = new GProFeedImageEntity();
        this.tags = new ArrayList<>();
        this.recallInfo = new GProRecallInfo();
        this.contentId = "";
        this.highlightWords = new ArrayList<>();
        this.suggestedSearchInfo = new GProSuggestedSearch();
        this.stFeed = new byte[0];
        this.feedId = str;
        this.userId = str2;
        this.createTime = j2;
        this.title = str3;
        this.content = str4;
        this.images = arrayList;
        this.inviteCode = str5;
        this.creator = gProSearchUser;
        this.guildId = j3;
        this.guildName = str6;
        this.guildHeadUrl = str7;
        this.channelId = j4;
        this.joinGuildSig = str8;
        this.type = i2;
        this.videoCoverUrl = gProFeedImageEntity;
        this.tags = arrayList2;
        this.recallInfo = gProRecallInfo;
        this.favorCount = j5;
        this.commentCount = j6;
        this.contentId = str9;
        this.highlightWords = arrayList3;
        this.suggestedSearchInfo = gProSuggestedSearch;
        this.stFeed = bArr;
        this.showType = i3;
    }
}
