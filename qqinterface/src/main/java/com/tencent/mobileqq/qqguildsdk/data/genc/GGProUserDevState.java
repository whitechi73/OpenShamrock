package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProUserDevState;

public  class GGProUserDevState implements IGProUserDevState {
    public final GProUserDevState mInfo;

    public GGProUserDevState(GProUserDevState gProUserDevState) {
        this.mInfo = gProUserDevState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public int getCameraState() {
        return this.mInfo.getCameraState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public String getCurrentRoomId() {
        return this.mInfo.getCurrentRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public int getMicState() {
        return this.mInfo.getMicState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public int getNetworkQuality() {
        return this.mInfo.getNetworkQuality();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public int getScreenState() {
        return this.mInfo.getScreenState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public int getSysMicBusy() {
        return this.mInfo.getSysMicBusy();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserDevState
    public String toString() {
        return this.mInfo.toString();
    }
}
