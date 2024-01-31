package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;


public  final class Feed implements Serializable {
    String channelId;
    FeedChannelInfo channelInfo;
    Integer commentCount;
    ArrayList<CommentForRead> comments;
    RichText contents;
    long createTime;
    Long createTimeNs;
    EmotionReactionInfo emotionReaction;
    String feedId;
    Long feedSeq;
    String guildId;
    String id;
    ArrayList<Image> images;
    String patternInfo;
    User poster;
    long serialVersionUID;
    RichText title;
    TotalLike totalLike;
    Long updateTime;
    ArrayList<Video> videos;
    Visitor visitorInfo;

    public Feed() {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.poster = new User();
    }

    public String getChannelId() {
        return this.channelId;
    }

    public FeedChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public Integer getCommentCount() {
        return this.commentCount;
    }

    public ArrayList<CommentForRead> getComments() {
        return this.comments;
    }

    public RichText getContents() {
        return this.contents;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public Long getCreateTimeNs() {
        return this.createTimeNs;
    }

    public EmotionReactionInfo getEmotionReaction() {
        return this.emotionReaction;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public Long getFeedSeq() {
        return this.feedSeq;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Image> getImages() {
        return this.images;
    }

    public String getPatternInfo() {
        return this.patternInfo;
    }

    public User getPoster() {
        return this.poster;
    }

    public RichText getTitle() {
        return this.title;
    }

    public TotalLike getTotalLike() {
        return this.totalLike;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public ArrayList<Video> getVideos() {
        return this.videos;
    }

    public Visitor getVisitorInfo() {
        return this.visitorInfo;
    }

    public String toString() {
        return "Feed{feedSeq=" + this.feedSeq + ",feedId=" + this.feedId + ",id=" + this.id + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",title=" + this.title + ",contents=" + this.contents + ",patternInfo=" + this.patternInfo + ",poster=" + this.poster + ",createTime=" + this.createTime + ",createTimeNs=" + this.createTimeNs + ",emotionReaction=" + this.emotionReaction + ",commentCount=" + this.commentCount + ",comments=" + this.comments + ",images=" + this.images + ",videos=" + this.videos + ",updateTime=" + this.updateTime + ",totalLike=" + this.totalLike + ",visitorInfo=" + this.visitorInfo + ",channelInfo=" + this.channelInfo + ",}";
    }

    public Feed(Long l2, String str, String str2, String str3, String str4, RichText richText, RichText richText2, String str5, User user, long j2, Long l3, EmotionReactionInfo emotionReactionInfo, Integer num, ArrayList<CommentForRead> arrayList, ArrayList<Image> arrayList2, ArrayList<Video> arrayList3, Long l4, TotalLike totalLike, Visitor visitor, FeedChannelInfo feedChannelInfo) {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.poster = new User();
        this.feedSeq = l2;
        this.feedId = str;
        this.id = str2;
        this.guildId = str3;
        this.channelId = str4;
        this.title = richText;
        this.contents = richText2;
        this.patternInfo = str5;
        this.poster = user;
        this.createTime = j2;
        this.createTimeNs = l3;
        this.emotionReaction = emotionReactionInfo;
        this.commentCount = num;
        this.comments = arrayList;
        this.images = arrayList2;
        this.videos = arrayList3;
        this.updateTime = l4;
        this.totalLike = totalLike;
        this.visitorInfo = visitor;
        this.channelInfo = feedChannelInfo;
    }
}
