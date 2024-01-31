package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProRecommendGuildInfo extends Serializable {
    String getCover();

    String getFace();

    String getFaceAnimationOnIdle();

    String getFaceAnimationOnUpdate();

    long getFontColorId();

    String getGuildCode();

    long getGuildId();

    String getIntroduction();

    int getLocationType();

    String getName();

    ArrayList<IGProNavigationInfo> getNavigationInfoList();

    IGProPlayFaceAnimationPolicy getPlayFaceAnimationPolicy();

    long getSeq();

    String getSubTitle();

    ArrayList<IGProTextMedalInfo> getTextMedalInfoList();

    String toString();
}
