package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProPAInstructionInfo extends Serializable {
    String getData();

    long getLogoutTime();

    int getLogoutType();

    int getModal();

    String getMsg();

    String getRuleFamily();

    String getRuleName();

    String getTitle();

    int getType();

    String getUrl();

    String toString();
}
