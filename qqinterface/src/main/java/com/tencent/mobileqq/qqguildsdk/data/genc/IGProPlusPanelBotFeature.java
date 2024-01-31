package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProPlusPanelBotFeature extends Serializable {
    IGProBotInfo getBotInfo();

    IGProBotFeatureInfo getCommandInfo();

    String getElementId();

    String getIcon();

    IGProBotFeatureInfo getServiceInfo();

    String getServiceName();

    String toString();
}
