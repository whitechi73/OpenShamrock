package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetBannersRsp extends Serializable {
    ArrayList<IGProBannerInfo> getBannerInfos();

    String toString();
}
