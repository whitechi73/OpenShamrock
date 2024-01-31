package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProBannerInfo extends Serializable {
    long getGuildId();

    String getGuildName();

    String getJoinSig();

    String getUserAvatarMeta();

    String getUserName();

    String toString();
}
