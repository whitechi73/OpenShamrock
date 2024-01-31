package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProForumChannel;

public  class GGProForumChannel implements IGProForumChannel {
    public final GProForumChannel mInfo;

    public GGProForumChannel(GProForumChannel gProForumChannel) {
        this.mInfo = gProForumChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public long getEndColor() {
        return this.mInfo.getEndColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public String getGuildFaceUrl() {
        return this.mInfo.getGuildFaceUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public String getHotValueTitle() {
        return this.mInfo.getHotValueTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public int getIndex() {
        return this.mInfo.getIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public String getJoinSign() {
        return this.mInfo.getJoinSign();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public long getStartColor() {
        return this.mInfo.getStartColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
