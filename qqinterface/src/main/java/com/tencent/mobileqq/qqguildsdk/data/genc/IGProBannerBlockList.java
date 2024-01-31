package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProBannerBlockList extends Serializable {
    String getBlockName();

    ArrayList<IGProBlockBaseInfo> getList();

    String toString();
}
