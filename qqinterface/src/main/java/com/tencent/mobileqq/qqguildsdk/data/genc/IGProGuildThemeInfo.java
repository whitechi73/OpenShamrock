package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildThemeInfo extends Serializable {
    ArrayList<Integer> getOldThemeTypeList();

    String getSessionId();

    String getThemeBgImg();

    byte[] getThemeColor();

    String getThemeIcon();

    String getThemeName();

    int getThemeType();

    String toString();
}
