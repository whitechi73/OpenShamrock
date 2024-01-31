package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProUserJoinedGuildSummary extends Serializable {
    ArrayList<IGProRecommendChannelInfo> getGuildList();

    String getJoinedCountStr();

    String toString();
}
