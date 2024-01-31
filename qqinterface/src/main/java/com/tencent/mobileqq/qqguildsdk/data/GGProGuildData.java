package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildData;
import com.tencent.qqnt.kernel.nativeinterface.GProPollingData;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendCategoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannelExtendInfo;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProGuildData implements IGProGuildData {
    public final GProGuildData mInfo;

    public GGProGuildData(GProGuildData gProGuildData) {
        this.mInfo = gProGuildData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildData
    public ArrayList<IGProRecommendCategoryInfo> getCategoryList() {
        ArrayList<GProRecommendCategoryInfo> categoryList = this.mInfo.getCategoryList();
        ArrayList<IGProRecommendCategoryInfo> arrayList = new ArrayList<>();
        Iterator<GProRecommendCategoryInfo> it = categoryList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendCategoryInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildData
    public ArrayList<IGProRecommendChannelExtendInfo> getChannelExtendInfo() {
        ArrayList<GProRecommendChannelExtendInfo> channelExtendInfo = this.mInfo.getChannelExtendInfo();
        ArrayList<IGProRecommendChannelExtendInfo> arrayList = new ArrayList<>();
        Iterator<GProRecommendChannelExtendInfo> it = channelExtendInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendChannelExtendInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildData
    public ArrayList<IGProPollingData> getDatas() {
        ArrayList<GProPollingData> dataList = this.mInfo.getDataList();
        ArrayList<IGProPollingData> arrayList = new ArrayList<>();
        Iterator<GProPollingData> it = dataList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProPollingData(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildData
    public IGProRecommendGuildInfo getGuildInfo() {
        return new GGProRecommendGuildInfo(this.mInfo.getGuildInfo());
    }
}
