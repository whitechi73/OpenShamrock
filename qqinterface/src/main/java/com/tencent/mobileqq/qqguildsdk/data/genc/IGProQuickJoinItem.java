package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProQuickJoinItem extends Serializable {
    String getCoverUrl();

    ArrayList<String> getMembersAvatar();

    String getName();

    String getOnlineNumTag();

    int getOrder();

    int getStatusTag();

    int getVoiceType();

    String toString();
}
