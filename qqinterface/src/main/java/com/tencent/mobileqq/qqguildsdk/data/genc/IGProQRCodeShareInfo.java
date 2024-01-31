package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProQRCodeShareInfo extends Serializable {
    long getAvTime();

    String getChannelCopyWriter();

    String getFeedLabel();

    long getFeedNum();

    long getGameNum();

    String getGuildLabel();

    long getLiveNum();

    String getMembersCount();

    String getOnlineMembersCount();

    String getStreamLabel();

    String getTeamLabel();

    String getVoiceLabel();

    String toString();
}
