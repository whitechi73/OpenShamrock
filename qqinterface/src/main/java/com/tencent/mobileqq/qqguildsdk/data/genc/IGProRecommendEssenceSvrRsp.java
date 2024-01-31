package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProRecommendEssenceSvrRsp extends Serializable {
    String getContent();

    ArrayList<IGProRecommendChannel0x11bc> getRecommendChannels();

    String toString();
}
