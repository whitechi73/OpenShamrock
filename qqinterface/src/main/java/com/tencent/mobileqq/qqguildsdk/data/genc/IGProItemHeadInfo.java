package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProItemHeadInfo extends Serializable {
    String getOnlineNums();

    ArrayList<IGProConditionalTag> getTags();

    String toString();
}
