package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProUserAVRspInfo extends Serializable {
    IGProAVDevOptInfo getDevOpt();

    ArrayList<IGProAVRoomCtrlOptInfo> getRoomDevOpts();

    IGProSecurityResult getSecResult();

    String getTipMsg();

    String getTrtcKey();

    int getUserState();

    String toString();
}
