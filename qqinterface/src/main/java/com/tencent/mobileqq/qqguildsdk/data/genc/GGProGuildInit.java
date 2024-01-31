package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProCategoryChannelIdList;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildInit;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGuildInit implements IGProGuildInit {
    public final GProGuildInit mInfo;

    public GGProGuildInit(GProGuildInit gProGuildInit) {
        this.mInfo = gProGuildInit;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInit
    public ArrayList<IGProCategoryChannelIdList> getCategoryList() {
        ArrayList<GProCategoryChannelIdList> categoryList = this.mInfo.getCategoryList();
        ArrayList<IGProCategoryChannelIdList> arrayList = new ArrayList<>();
        Iterator<GProCategoryChannelIdList> it = categoryList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProCategoryChannelIdList(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInit
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInit
    public IGProCategoryChannelIdList getUncategorizedChannels() {
        return new GGProCategoryChannelIdList(this.mInfo.getUncategorizedChannels());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInit
    public String toString() {
        return this.mInfo.toString();
    }
}
