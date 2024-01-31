package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProChannelOpenStateResultInfo extends Serializable {
    boolean getPeakActivityGuildFlag();

    ArrayList<IGProSwitchInfo> getSwitchInfoList();

    String toString();
}
