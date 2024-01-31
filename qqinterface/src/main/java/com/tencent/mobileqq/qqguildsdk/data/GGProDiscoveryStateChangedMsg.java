package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetPrefetchRecommendGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPrefetchRecommendGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProDiscoveryStateChangedMsg;


public class GGProDiscoveryStateChangedMsg implements IGProDiscoveryStateChangedMsg {
    public final GProDiscoveryStateChangedMsg mInfo;

    public GGProDiscoveryStateChangedMsg(GProDiscoveryStateChangedMsg gProDiscoveryStateChangedMsg) {
        this.mInfo = gProDiscoveryStateChangedMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public IGProMyRecommendMsg getMyRecommendMsg() {
        return new GGProMyRecommendMsg(this.mInfo.getMyRecommendMsg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public IGProGetPrefetchRecommendGuildsRsp getPrefetchRecommendMsg() {
        return new GGProGetPrefetchRecommendGuildsRsp(this.mInfo.getPrefetchRecommendMsg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public int getSceneType() {
        return this.mInfo.getSceneType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public IGProTopGuildRecommendMsg getTopGuildRecommendMsg() {
        return new GGProTopGuildRecommendMsg(this.mInfo.getTopGuildRecommendMsg());
    }
}
