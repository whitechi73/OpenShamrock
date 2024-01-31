package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProLiveStreamInfo extends Serializable {
    long getAnchorId();

    String getFlvUrl();

    String getUrl();

    String toString();
}
