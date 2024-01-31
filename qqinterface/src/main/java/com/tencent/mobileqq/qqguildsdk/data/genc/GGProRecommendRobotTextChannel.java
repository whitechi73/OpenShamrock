package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendRobotTextChannel;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstract;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendRobotTextChannel implements IGProRecommendRobotTextChannel {
    public final GProRecommendRobotTextChannel mInfo;

    public GGProRecommendRobotTextChannel(GProRecommendRobotTextChannel gProRecommendRobotTextChannel) {
        this.mInfo = gProRecommendRobotTextChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public ArrayList<String> getAvatars() {
        return this.mInfo.getAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public IGProRecommendChannelInfo getChannelInfo() {
        return new GGProRecommendChannelInfo(this.mInfo.getChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
