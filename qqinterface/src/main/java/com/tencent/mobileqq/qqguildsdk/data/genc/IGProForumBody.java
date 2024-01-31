package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProForumBody extends Serializable {
    int getEveryHours();

    ArrayList<IGProForumChannel> getForumChannel();

    String getRequestId();

    long getUpdateTime();

    String toString();
}
