package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes33.dex */
public interface IGProGetPrefetchRecommendGuildsRsp extends Serializable {
    IGProPrefetchRecommendBubbleInfo getBubbleInfo();

    ArrayList<Object> getGuildInfos();

    IGProPrefetchRecommendRedDotInfo getRedDotInfo();

    String toString();
}
