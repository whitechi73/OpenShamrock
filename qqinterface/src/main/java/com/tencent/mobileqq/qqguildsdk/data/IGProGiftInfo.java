package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProGiftInfo extends Serializable {
    int getAllComboCnt();

    boolean getComboOver();

    long getComboSeq();

    int getEffectLevel();

    int getGiftId();

    String getGiftName();

    int getGiftNum();

    long getGiftPrice();

    int getGiftType();

    int getMaterialId();

    int getSendType();
}
