package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendRobotDrawCard;

public  class GGProRecommendRobotDrawCard implements IGProRecommendRobotDrawCard {
    public final GProRecommendRobotDrawCard mInfo;

    public GGProRecommendRobotDrawCard(GProRecommendRobotDrawCard gProRecommendRobotDrawCard) {
        this.mInfo = gProRecommendRobotDrawCard;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotDrawCard
    public String getBotMsgId() {
        return this.mInfo.getBotMsgId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotDrawCard
    public String getImgUrl() {
        return this.mInfo.getImgUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotDrawCard
    public IGProRecommendRobotInfo getRobotInfo() {
        return new GGProRecommendRobotInfo(this.mInfo.getRobotInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotDrawCard
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotDrawCard
    public String getUserMsgId() {
        return this.mInfo.getUserMsgId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotDrawCard
    public String toString() {
        return this.mInfo.toString();
    }
}
