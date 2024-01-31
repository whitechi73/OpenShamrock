package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;

import java.io.Serializable;

public  interface IGProTopGuildRecommendMsg extends Serializable {
    IGProRecommendItem getRecommendItem();
}
