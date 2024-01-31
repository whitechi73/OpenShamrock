package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetPrefetchRecommendGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProPrefetchRecommendGuildInfo;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes33.dex */
public class GGProGetPrefetchRecommendGuildsRsp implements IGProGetPrefetchRecommendGuildsRsp {
    public final GProGetPrefetchRecommendGuildsRsp mInfo;

    public GGProGetPrefetchRecommendGuildsRsp(GProGetPrefetchRecommendGuildsRsp gProGetPrefetchRecommendGuildsRsp) {
        this.mInfo = gProGetPrefetchRecommendGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPrefetchRecommendGuildsRsp
    public IGProPrefetchRecommendBubbleInfo getBubbleInfo() {
        return new GGProPrefetchRecommendBubbleInfo(this.mInfo.getBubbleInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPrefetchRecommendGuildsRsp
    public ArrayList<Object> getGuildInfos() {
        ArrayList<GProPrefetchRecommendGuildInfo> guildInfos = this.mInfo.getGuildInfos();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProPrefetchRecommendGuildInfo> it = guildInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProPrefetchRecommendGuildInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPrefetchRecommendGuildsRsp
    public IGProPrefetchRecommendRedDotInfo getRedDotInfo() {
        return new GGProPrefetchRecommendRedDotInfo(this.mInfo.getRedDotInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPrefetchRecommendGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
