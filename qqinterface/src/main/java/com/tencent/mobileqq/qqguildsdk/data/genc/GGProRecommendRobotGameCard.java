package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendRobotGameCard;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendRobotTextChannel;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendRobotGameCard implements IGProRecommendRobotGameCard {
    public final GProRecommendRobotGameCard mInfo;

    public GGProRecommendRobotGameCard(GProRecommendRobotGameCard gProRecommendRobotGameCard) {
        this.mInfo = gProRecommendRobotGameCard;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotGameCard
    public IGProRecommendRobotInfo getRobotInfo() {
        return new GGProRecommendRobotInfo(this.mInfo.getRobotInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotGameCard
    public ArrayList<IGProRecommendRobotTextChannel> getRobotTextChannel() {
        ArrayList<GProRecommendRobotTextChannel> robotTextChannel = this.mInfo.getRobotTextChannel();
        ArrayList<IGProRecommendRobotTextChannel> arrayList = new ArrayList<>();
        Iterator<GProRecommendRobotTextChannel> it = robotTextChannel.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendRobotTextChannel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotGameCard
    public String toString() {
        return this.mInfo.toString();
    }
}
