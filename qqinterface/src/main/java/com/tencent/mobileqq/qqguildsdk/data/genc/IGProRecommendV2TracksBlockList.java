package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendV2TracksBlockList extends Serializable {
    String getBlockName();

    ArrayList<IGProRecommendV2Channel> getChannelList();

    String toString();
}
