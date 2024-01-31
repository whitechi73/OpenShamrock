package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProAppInfo extends Serializable {
    String getAppDescription();

    long getAppId();

    String getAppName();

    int getAppQyyFlag();

    String getIconUrl();

    ArrayList<String> getPreViewList();

    String toString();
}
