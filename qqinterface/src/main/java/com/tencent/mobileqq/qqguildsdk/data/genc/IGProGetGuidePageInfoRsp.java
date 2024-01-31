package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetGuidePageInfoRsp extends Serializable {
    ArrayList<IGProGuidePageInfo> getGuidePage();

    IGProGuidePageInfo getMainGuidePage();

    String toString();
}
