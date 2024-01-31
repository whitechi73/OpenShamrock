package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBannerBlockList;
import com.tencent.qqnt.kernel.nativeinterface.GProBlockBaseInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProBannerBlockList implements IGProBannerBlockList {
    public final GProBannerBlockList mInfo;

    public GGProBannerBlockList(GProBannerBlockList gProBannerBlockList) {
        this.mInfo = gProBannerBlockList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerBlockList
    public String getBlockName() {
        return this.mInfo.getBlockName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerBlockList
    public ArrayList<IGProBlockBaseInfo> getList() {
        ArrayList<GProBlockBaseInfo> list = this.mInfo.getList();
        ArrayList<IGProBlockBaseInfo> arrayList = new ArrayList<>();
        Iterator<GProBlockBaseInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlockBaseInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerBlockList
    public String toString() {
        return this.mInfo.toString();
    }
}
