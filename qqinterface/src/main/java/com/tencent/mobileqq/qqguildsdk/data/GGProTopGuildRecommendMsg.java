package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.qqnt.kernel.nativeinterface.GProTopGuildRecommendMsg;

public  class GGProTopGuildRecommendMsg implements IGProTopGuildRecommendMsg {
    public final GProTopGuildRecommendMsg mInfo;

    public GGProTopGuildRecommendMsg(GProTopGuildRecommendMsg gProTopGuildRecommendMsg) {
        this.mInfo = gProTopGuildRecommendMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopGuildRecommendMsg
    public IGProRecommendItem getRecommendItem() {
        return new GGProRecommendItem(this.mInfo.getRecommendItem());
    }
}
