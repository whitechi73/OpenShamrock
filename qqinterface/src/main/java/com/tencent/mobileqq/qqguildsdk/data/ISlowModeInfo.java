package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;



public interface ISlowModeInfo extends Serializable {
    int getSlowModeCircle();

    int getSlowModeKey();

    String getSlowModeText();

    int getSpeakFrequency();
}
