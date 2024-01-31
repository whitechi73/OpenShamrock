package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProTaskInfo extends Serializable {
    String getIcon();

    String getId();

    String getName();

    String getProgressText();

    int getStatus();

    String toString();
}
