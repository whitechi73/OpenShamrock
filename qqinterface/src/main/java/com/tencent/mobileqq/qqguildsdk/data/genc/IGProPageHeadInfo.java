package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProPageHeadInfo extends Serializable {
    ArrayList<IGProBannerInfo> getBannerInfos();

    String getDayBannerUrl();

    boolean getHasSearch();

    String getHeadText();

    String getNightBannerUrl();

    long getPollingDuration();

    String getValueAddedBannerUrl();

    String toString();
}
