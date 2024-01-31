package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVDevOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProAVRoomAddUpInfo;

public  class GGProAVRoomAddUpInfo implements IGProAVRoomAddUpInfo {
    public final GProAVRoomAddUpInfo mInfo;

    public GGProAVRoomAddUpInfo(GProAVRoomAddUpInfo gProAVRoomAddUpInfo) {
        this.mInfo = gProAVRoomAddUpInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomAddUpInfo
    public IGProAVDevOptInfo getAVDevOpt() {
        return new GGProAVDevOptInfo(this.mInfo.getAvDevOpt());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomAddUpInfo
    public int getMicVolume() {
        return this.mInfo.getMicVolume();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomAddUpInfo
    public String getRoomId() {
        return this.mInfo.getRoomId();
    }
}
