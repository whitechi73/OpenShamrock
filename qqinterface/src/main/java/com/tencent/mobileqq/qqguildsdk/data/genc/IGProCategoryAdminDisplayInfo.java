package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProCategoryAdminDisplayInfo extends Serializable {
    long getCategoryAdminNum();

    long getCategoryId();

    String getCategoryName();

    String toString();
}
