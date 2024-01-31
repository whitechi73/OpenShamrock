package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProAVRoomOptPushInfo;


public class GGProAVRoomOptPushInfo implements IGProAVRoomOptPushInfo {
    public final GProAVRoomOptPushInfo mInfo;

    public GGProAVRoomOptPushInfo(GProAVRoomOptPushInfo gProAVRoomOptPushInfo) {
        this.mInfo = gProAVRoomOptPushInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public String getChannelId() {
        return String.valueOf(this.mInfo.getChannelId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public String getDelRoomId() {
        return this.mInfo.getDelRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public String getGuildId() {
        return String.valueOf(this.mInfo.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public int getOptType() {
        return this.mInfo.getOptType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public IGProAVRoomAddUpInfo getRoomAddUpInfo() {
        return new GGProAVRoomAddUpInfo(this.mInfo.getRoomAddUpInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public IGProAVShowMsgInfo getShowInfo() {
        return new GGProAVShowMsgInfo(this.mInfo.getShowInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo
    public String getSwitchRoomId() {
        return this.mInfo.getSwitchRoomId();
    }
}
