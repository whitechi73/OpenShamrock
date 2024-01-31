package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;

import java.io.Serializable;

public  interface IGProLiveRoomInfo extends Serializable {
    ILiveRoomAnchorInfo getAnchorInfo();

    String getCloseTips();

    int getCloseType();

    int getLiveType();

    int getPlatform();

    IGProProgramInfo getProgramInfo();

    long getQueryId();

    IGProRoomInfo getRoomInfo();

    IGProLiveStreamInfo getStreamInfo();

    String toString();
}
