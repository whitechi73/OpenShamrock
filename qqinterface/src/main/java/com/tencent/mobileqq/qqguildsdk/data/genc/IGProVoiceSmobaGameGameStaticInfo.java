package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProVoiceSmobaGameGameStaticInfo extends Serializable {
    String getCoverUrl();

    String getGameMode();

    String getGameName();

    ArrayList<String> getGradeNames();

    String getIconUrl();

    long getMaxNum();

    String toString();
}
