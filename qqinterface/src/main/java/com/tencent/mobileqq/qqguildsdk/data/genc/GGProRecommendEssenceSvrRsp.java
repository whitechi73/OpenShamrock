package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannel0x11bc;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendEssenceSvrRsp;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProRecommendEssenceSvrRsp implements IGProRecommendEssenceSvrRsp {
    public final GProRecommendEssenceSvrRsp mInfo;

    public GGProRecommendEssenceSvrRsp(GProRecommendEssenceSvrRsp gProRecommendEssenceSvrRsp) {
        this.mInfo = gProRecommendEssenceSvrRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp
    public ArrayList<IGProRecommendChannel0x11bc> getRecommendChannels() {
        ArrayList<GProRecommendChannel0x11bc> recommendChannels = this.mInfo.getRecommendChannels();
        ArrayList<IGProRecommendChannel0x11bc> arrayList = new ArrayList<>();
        Iterator<GProRecommendChannel0x11bc> it = recommendChannels.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendChannel0x11bc(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
