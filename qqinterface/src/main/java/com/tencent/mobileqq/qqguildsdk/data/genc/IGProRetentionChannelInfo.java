package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRetentionChannelInfo extends Serializable {
    String getGuildCover();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getGuildProfile();

    String getJoinSig();

    ArrayList<IGProRetentionChannelLabel> getTagList();

    String toString();
}
