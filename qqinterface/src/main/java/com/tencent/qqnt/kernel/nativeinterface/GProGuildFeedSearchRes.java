package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildFeedSearchRes {
    long channelId;
    long commentCount;
    String content;
    long createTime;
    long favorCount;
    String feedId;
    long guildId;
    ArrayList<GProFeedImageEntity> images;
    String nickName;
    long tinyId;
    String title;
    ArrayList<GProFeedImageEntity> videos;

    public GProGuildFeedSearchRes() {
        this.feedId = "";
        this.nickName = "";
        this.title = "";
        this.content = "";
        this.images = new ArrayList<>();
        this.videos = new ArrayList<>();
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

    public long getCreateTime() {
        return this.createTime;
    }

    public long getFavorCount() {
        return this.favorCount;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProFeedImageEntity> getImages() {
        return this.images;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<GProFeedImageEntity> getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProGuildFeedSearchRes{feedId=" + this.feedId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",tinyId=" + this.tinyId + ",createTime=" + this.createTime + ",nickName=" + this.nickName + ",title=" + this.title + ",content=" + this.content + ",images=" + this.images + ",videos=" + this.videos + ",favorCount=" + this.favorCount + ",commentCount=" + this.commentCount + ",}";
    }

    public GProGuildFeedSearchRes(String str, long j2, long j3, long j4, long j5, String str2, String str3, String str4, ArrayList<GProFeedImageEntity> arrayList, ArrayList<GProFeedImageEntity> arrayList2, long j6, long j7) {
        this.feedId = "";
        this.nickName = "";
        this.title = "";
        this.content = "";
        this.images = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.feedId = str;
        this.guildId = j2;
        this.channelId = j3;
        this.tinyId = j4;
        this.createTime = j5;
        this.nickName = str2;
        this.title = str3;
        this.content = str4;
        this.images = arrayList;
        this.videos = arrayList2;
        this.favorCount = j6;
        this.commentCount = j7;
    }
}
