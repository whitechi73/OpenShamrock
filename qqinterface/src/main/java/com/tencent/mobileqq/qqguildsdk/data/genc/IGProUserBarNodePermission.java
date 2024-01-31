package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProUserBarNodePermission extends Serializable {
    int getNodeType();

    int getVisibleType();

    String toString();
}
