package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProUnifiedEssenceInfo extends Serializable {
    ArrayList<IGProEssenceChannel> getChannels();

    String getContent();

    long getOperatorName();

    int getStatus();

    String getTitle();

    int getType();

    long getUniqueId();

    String getVisitorMsg();

    String toString();
}
