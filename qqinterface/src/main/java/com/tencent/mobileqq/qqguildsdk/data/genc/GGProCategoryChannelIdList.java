package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProCategoryChannelIdList;

import java.util.ArrayList;

public  class GGProCategoryChannelIdList implements IGProCategoryChannelIdList {
    public final GProCategoryChannelIdList mInfo;

    public GGProCategoryChannelIdList(GProCategoryChannelIdList gProCategoryChannelIdList) {
        this.mInfo = gProCategoryChannelIdList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList
    public ArrayList<Long> getChannelList() {
        return this.mInfo.getChannelList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList
    public boolean getFolded() {
        return this.mInfo.getFolded();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList
    public String toString() {
        return this.mInfo.toString();
    }
}
