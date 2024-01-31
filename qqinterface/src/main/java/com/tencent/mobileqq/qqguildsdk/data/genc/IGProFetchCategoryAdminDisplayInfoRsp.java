package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProFetchCategoryAdminDisplayInfoRsp extends Serializable {
    ArrayList<IGProCategoryAdminDisplayInfo> getCategoryAdminDisplayList();

    int getCategoryAdminMaxNum();

    String toString();
}
