package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProFeedImageEntity;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildFeedSearchRes;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGuildFeedSearchRes implements IGProGuildFeedSearchRes {
    public final GProGuildFeedSearchRes mInfo;

    public GGProGuildFeedSearchRes(GProGuildFeedSearchRes gProGuildFeedSearchRes) {
        this.mInfo = gProGuildFeedSearchRes;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public long getCommentCount() {
        return this.mInfo.getCommentCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public long getFavorCount() {
        return this.mInfo.getFavorCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public String getFeedId() {
        return this.mInfo.getFeedId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public ArrayList<IGProFeedImageEntity> getImages() {
        ArrayList<GProFeedImageEntity> images = this.mInfo.getImages();
        ArrayList<IGProFeedImageEntity> arrayList = new ArrayList<>();
        Iterator<GProFeedImageEntity> it = images.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProFeedImageEntity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public ArrayList<IGProFeedImageEntity> getVideos() {
        ArrayList<GProFeedImageEntity> videos = this.mInfo.getVideos();
        ArrayList<IGProFeedImageEntity> arrayList = new ArrayList<>();
        Iterator<GProFeedImageEntity> it = videos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProFeedImageEntity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes
    public String toString() {
        return this.mInfo.toString();
    }
}
