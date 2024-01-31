package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetGuildLabelRsp extends Serializable {
    ArrayList<IGProLabelInfo> getLabelInfos();

    long getMaxAvNums();

    long getMaxLabels();

    String getWelcomeContent();

    String toString();
}
