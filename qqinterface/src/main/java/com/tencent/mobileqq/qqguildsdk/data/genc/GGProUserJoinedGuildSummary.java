package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProUserJoinedGuildSummary;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProUserJoinedGuildSummary implements IGProUserJoinedGuildSummary {
    public final GProUserJoinedGuildSummary mInfo;

    public GGProUserJoinedGuildSummary(GProUserJoinedGuildSummary gProUserJoinedGuildSummary) {
        this.mInfo = gProUserJoinedGuildSummary;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary
    public ArrayList<IGProRecommendChannelInfo> getGuildList() {
        ArrayList<GProRecommendChannelInfo> guildList = this.mInfo.getGuildList();
        ArrayList<IGProRecommendChannelInfo> arrayList = new ArrayList<>();
        Iterator<GProRecommendChannelInfo> it = guildList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendChannelInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary
    public String getJoinedCountStr() {
        return this.mInfo.getJoinedCountStr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary
    public String toString() {
        return this.mInfo.toString();
    }
}
