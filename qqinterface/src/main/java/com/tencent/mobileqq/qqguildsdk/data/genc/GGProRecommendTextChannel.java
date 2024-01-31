package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendTextChannel;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstract;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendTextChannel implements IGProRecommendTextChannel {
    public final GProRecommendTextChannel mInfo;

    public GGProRecommendTextChannel(GProRecommendTextChannel gProRecommendTextChannel) {
        this.mInfo = gProRecommendTextChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public ArrayList<String> getAvatars() {
        return this.mInfo.getAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public boolean getIsActive() {
        return this.mInfo.getIsActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public ArrayList<String> getMemberAvatars() {
        return this.mInfo.getMemberAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public String getMsgSummary() {
        return this.mInfo.getMsgSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public int getNoreadNum() {
        return this.mInfo.getNoreadNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public String getTagMsg() {
        return this.mInfo.getTagMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
