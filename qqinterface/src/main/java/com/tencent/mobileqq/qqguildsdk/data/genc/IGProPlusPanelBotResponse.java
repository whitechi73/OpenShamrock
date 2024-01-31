package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProPlusPanelBotResponse extends Serializable {
    int getNextPage();

    ArrayList<IGProPlusPanelBotFeature> getPlusPanelFeatures();

    String toString();
}
