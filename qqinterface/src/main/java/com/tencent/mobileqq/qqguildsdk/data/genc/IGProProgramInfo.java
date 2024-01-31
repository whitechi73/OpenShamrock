package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProProgramInfo extends Serializable {
    String getAnchorName();

    String getLiveTitle();

    String getProgramId();

    long getTabId();

    String getThirdPartyLogo();

    String toString();
}
