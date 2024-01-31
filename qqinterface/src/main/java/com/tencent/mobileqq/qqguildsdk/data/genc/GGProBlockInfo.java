package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlockInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendCategory;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProBlockInfo implements IGProBlockInfo {
    public final GProBlockInfo mInfo;

    public GGProBlockInfo(GProBlockInfo gProBlockInfo) {
        this.mInfo = gProBlockInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public String getBlockId() {
        return this.mInfo.getBlockId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public int getBlockIndex() {
        return this.mInfo.getBlockIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public String getBlockName() {
        return this.mInfo.getBlockName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public int getBlockType() {
        return this.mInfo.getBlockType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public ArrayList<IGProRecommendCategory> getCategories() {
        ArrayList<GProRecommendCategory> categories = this.mInfo.getCategories();
        ArrayList<IGProRecommendCategory> arrayList = new ArrayList<>();
        Iterator<GProRecommendCategory> it = categories.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendCategory(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public boolean getHasMore() {
        return this.mInfo.getHasMore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public int getIsWhole() {
        return this.mInfo.getIsWhole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public ArrayList<IGProRecommendItem> getItems() {
        ArrayList<GProRecommendItem> items = this.mInfo.getItems();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
