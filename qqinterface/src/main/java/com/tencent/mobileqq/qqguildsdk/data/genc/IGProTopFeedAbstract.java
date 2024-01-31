package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProTopFeedAbstract extends Serializable {
    IGProThumbnail getThumbnail();

    String getTitle();

    String toString();
}
