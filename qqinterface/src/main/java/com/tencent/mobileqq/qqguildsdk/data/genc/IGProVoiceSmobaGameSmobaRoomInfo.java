package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProVoiceSmobaGameSmobaRoomInfo extends Serializable {
    int getGameMode();

    ArrayList<Integer> getGradeList();

    String toString();
}
