package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildInit extends Serializable {
    ArrayList<IGProCategoryChannelIdList> getCategoryList();

    long getGuildId();

    IGProCategoryChannelIdList getUncategorizedChannels();

    String toString();
}
