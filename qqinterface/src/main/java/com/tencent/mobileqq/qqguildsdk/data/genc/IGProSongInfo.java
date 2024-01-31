package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProSongInfo extends Serializable {
    boolean getIsEnable();

    String getLyrics();

    ArrayList<String> getPlayUrlList();

    String toString();
}
