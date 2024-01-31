package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProLobbyAppInfo extends Serializable {
    int getAntiAddiction();

    int getAntiAddictionMode();

    String getAppId();

    String getAppName();

    long getAppUin();

    int getFullScreenMode();

    String getH5Url();

    String getIconUrl();

    int getMaxMember();

    int getMinMember();

    int getPerLoadingMaterialType();

    String getPerLoadingMaterialUrl();

    long getPermissionRequired();

    int getScreenMode();

    String getTopImageUrl();

    String toString();
}
