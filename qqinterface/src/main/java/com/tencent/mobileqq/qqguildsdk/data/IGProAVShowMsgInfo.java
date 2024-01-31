package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProAVShowMsgInfo extends Serializable {
    ArrayList<String> getButtonMsgs();

    String getShowMsg();

    int getShowSeconds();

    int getShowType();
}
