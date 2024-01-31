package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGuildOnlineReportRsp extends Serializable {
    long getNextReportInterval();

    String toString();
}
