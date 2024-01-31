package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProPlayInfo extends Serializable {
    IGProPlayNodeExtInfo getPlayNodeExInfo();

    IGProPlayNodeInfo getPlayNodeInfo();

    IGProSongInfo getSongInfo();

    String toString();
}
