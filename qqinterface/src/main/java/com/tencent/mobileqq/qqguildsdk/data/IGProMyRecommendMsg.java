package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoverStatus;

import java.io.Serializable;


public interface IGProMyRecommendMsg extends Serializable {
    int getBusinessType();

    IGProDiscoverStatus getDiscoverStatus();

    int getFlag();

    int getPointType();
}
