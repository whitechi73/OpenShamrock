package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVersionNews;

import java.util.ArrayList;

public  class GGProVersionNews implements IGProVersionNews {
    public final GProVersionNews mInfo;

    public GGProVersionNews(GProVersionNews gProVersionNews) {
        this.mInfo = gProVersionNews;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVersionNews
    public String getJumpFeedUrl() {
        return this.mInfo.getJumpFeedUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVersionNews
    public ArrayList<String> getNewsUrlList() {
        return this.mInfo.getNewsUrlList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVersionNews
    public String getSubtitle() {
        return this.mInfo.getSubtitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVersionNews
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVersionNews
    public String toString() {
        return this.mInfo.toString();
    }
}
