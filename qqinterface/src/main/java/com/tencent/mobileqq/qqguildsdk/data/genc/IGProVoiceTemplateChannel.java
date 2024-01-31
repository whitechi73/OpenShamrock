package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProVoiceTemplateChannel extends Serializable {
    IGProRecommendCoverInfo getCover();

    int getCurrentNum();

    String getIcon();

    int getMaxNum();

    ArrayList<IGProMemberInfo> getMembers();

    String getName();

    String getPlayDesc();

    int getStatus();

    String getStatusDesc();

    String getStatusIcon();

    String toString();
}
