package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPrefetchRecommendGuildsRsp;

import java.io.Serializable;


public interface IGProDiscoveryStateChangedMsg extends Serializable {
    IGProMyRecommendMsg getMyRecommendMsg();

    IGProGetPrefetchRecommendGuildsRsp getPrefetchRecommendMsg();

    int getSceneType();

    IGProTopGuildRecommendMsg getTopGuildRecommendMsg();
}
