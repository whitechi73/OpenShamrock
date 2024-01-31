package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRoleManagementTag extends Serializable {
    long getColor();

    long getRoleId();

    String getTagName();

    String toString();
}
