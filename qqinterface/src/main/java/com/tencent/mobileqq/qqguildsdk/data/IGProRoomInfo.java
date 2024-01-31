package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public  interface IGProRoomInfo extends Serializable {
    ArrayList<IGProAudienceInfo> getAudienceInfo();

    int getFakeNum();

    String getProgramId();

    int getRealNum();

    int getRobotNum();

    HashMap<String, String> getRoomIcons();

    long getRoomId();

    String getRoomName();

    String getRoomPv();

    int getRoomState();

    long getViewer();
}
