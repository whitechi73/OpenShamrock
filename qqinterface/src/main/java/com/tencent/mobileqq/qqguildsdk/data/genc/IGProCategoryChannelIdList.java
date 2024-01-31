package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProCategoryChannelIdList extends Serializable {
    long getCategoryId();

    ArrayList<Long> getChannelList();

    boolean getFolded();

    String getName();

    String toString();
}
