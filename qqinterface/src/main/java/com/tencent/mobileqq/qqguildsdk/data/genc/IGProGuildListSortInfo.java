package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildListSortInfo extends Serializable {
    ArrayList<Long> getSortList();

    ArrayList<Long> getTopList();

    String toString();
}
