package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface ILiveProgramInfo extends Serializable {
    String getAnchorName();

    String getLiveTitle();

    String getProgramId();

    long getTabId();

    String getThirdPartyLogo();
}
