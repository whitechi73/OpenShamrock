package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProEnterAudioLiveChannelRsp extends Serializable {
    String getAuthMeta();

    IGProAVChannelConfig getAvChannelConfig();

    boolean getEnableStream();

    int getGlobalMutedFlag();

    IEnterChannelPermission getLiveChannelPermission();

    long getNoStreamDisconnectTrtcSecond();

    IGProEnterAVChannelPermissionInfo getPermissionInfo();

    String getPrivateMapKey();

    String getRoomSessionId();

    int getSdkAppId();

    String getShowTips();

    long getSigExpiresSecond();

    ArrayList<Object> getStreamInfoList();

    String getTrtcUserSign();

    ArrayList<IGProUserBarNodePermission> getUserBarNodePermission();

    int getUserTRTC();

    long getUserTinyId();

    String toString();
}
