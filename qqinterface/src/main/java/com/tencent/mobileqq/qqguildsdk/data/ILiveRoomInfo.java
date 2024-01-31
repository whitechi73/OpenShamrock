package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.HashMap;



public interface ILiveRoomInfo {
    ILiveRoomAnchorInfo getAnchorInfo();

    String getCloseTips();

    int getCloseType();

    int getFakeNum();

    String getLiveStreamFlvUrl();

    String getLiveStreamUrl();

    int getLiveTypeNum();

    int getPlatform();

    String getProgramId();

    ILiveProgramInfo getProgramInfo();

    String getQueryId();

    int getRealNum();

    int getRobotNum();

    HashMap<String, String> getRoomIcons();

    String getRoomId();

    String getRoomPv();

    int getRoomState();

    String getRoomTitle();

    int getSource();

    long getUpdateTime();

    long getViewer();
}
