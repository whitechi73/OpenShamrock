package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendEntry;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendExtra;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendTag;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendExtra implements IGProRecommendExtra {
    public final GProRecommendExtra mInfo;

    public GGProRecommendExtra(GProRecommendExtra gProRecommendExtra) {
        this.mInfo = gProRecommendExtra;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra
    public ArrayList<IGProRecommendEntry> getBizData() {
        ArrayList<GProRecommendEntry> bizData = this.mInfo.getBizData();
        ArrayList<IGProRecommendEntry> arrayList = new ArrayList<>();
        Iterator<GProRecommendEntry> it = bizData.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra
    public IGProItemCbData getCallback() {
        return new GGProItemCbData(this.mInfo.getCallback());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra
    public ArrayList<IGProRecommendEntry> getReports() {
        ArrayList<GProRecommendEntry> reports = this.mInfo.getReports();
        ArrayList<IGProRecommendEntry> arrayList = new ArrayList<>();
        Iterator<GProRecommendEntry> it = reports.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra
    public ArrayList<IGProRecommendTag> getTags() {
        ArrayList<GProRecommendTag> tags = this.mInfo.getTags();
        ArrayList<IGProRecommendTag> arrayList = new ArrayList<>();
        Iterator<GProRecommendTag> it = tags.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendTag(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra
    public String toString() {
        return this.mInfo.toString();
    }
}
