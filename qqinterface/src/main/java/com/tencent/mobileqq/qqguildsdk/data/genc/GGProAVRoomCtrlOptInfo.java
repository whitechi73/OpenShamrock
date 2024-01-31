package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAVRoomCtrlOptInfo;

public  class GGProAVRoomCtrlOptInfo implements IGProAVRoomCtrlOptInfo {
    public final GProAVRoomCtrlOptInfo mInfo;

    public GGProAVRoomCtrlOptInfo(GProAVRoomCtrlOptInfo gProAVRoomCtrlOptInfo) {
        this.mInfo = gProAVRoomCtrlOptInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public IGProAVDevOptInfo getDevOpt() {
        return new GGProAVDevOptInfo(this.mInfo.getDevOpt());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public boolean getIsCurrentRoom() {
        return this.mInfo.getIsCurrentRoom();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public int getMicVolume() {
        return this.mInfo.getMicVolume();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public int getNumRoomId() {
        return this.mInfo.getNumRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public String getPrivateMapKey() {
        return this.mInfo.getPrivateMapKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public String getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public int getSdkAppId() {
        return this.mInfo.getSdkAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
