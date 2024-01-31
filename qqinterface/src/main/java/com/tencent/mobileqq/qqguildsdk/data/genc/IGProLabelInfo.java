package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProLabelInfo extends Serializable {
    String getContent();

    String getDetailsAvUrl();

    String getDetailsImageUrl();

    String getFriendJoinNumTag();

    ArrayList<IGProGuildInfoInLabel> getGuildInfos();

    String getIntroduceAvUrl();

    String getIntroduceImageUrl();

    String getLabelTopPicture();

    String getLabelTopWord();

    String getName();

    String getSelectedCntTag();

    String toString();
}
