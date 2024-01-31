package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProUserFreeGiftInfoRsp extends Serializable {
    String getCheckContext();

    int getCountdownSecond();

    int getCurrFreeGiftNum();

    int getDayFreeGiftNum();

    ArrayList<Long> getFreeGiftIds();

    int getGotFreeGiftNum();

    int getMaxFreeGiftNum();

    ArrayList<Integer> getNeedCheckThemeTypes();

    long getNextCheckTimeMS();

    int getReminderFreeGiftNum();

    String toString();
}
