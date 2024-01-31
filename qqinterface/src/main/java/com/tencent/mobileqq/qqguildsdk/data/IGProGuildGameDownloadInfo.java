package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildGameDownloadInfo extends Serializable {
    String getContent();

    String getGameId();

    String getJumpText();

    ArrayList<Object> getLinks();

    ArrayList<String> getPicUrls();

    String getTagText();

    String getTitle();
}
