package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProUserDevState;

public  class GProUserDevStateData implements IGProUserDevStateData {
    private GProUserDevState mUserDevState;

    public GProUserDevStateData(GProUserDevState gProUserDevState) {
        this.mUserDevState = gProUserDevState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getCameraState() {
        return this.mUserDevState.getCameraState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getMicState() {
        return this.mUserDevState.getMicState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getNetworkQuality() {
        return this.mUserDevState.getNetworkQuality();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getScreenState() {
        return this.mUserDevState.getScreenState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getSysMicBusy() {
        return this.mUserDevState.getSysMicBusy();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setCameraState(int i2) {
        this.mUserDevState.setCameraState(i2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setMicState(int i2) {
        this.mUserDevState.setMicState(i2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setNetworkQuality(int i2) {
        this.mUserDevState.setNetworkQuality(i2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setScreenState(int i2) {
        this.mUserDevState.setScreenState(i2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setSysMicBusy(int i2) {
        this.mUserDevState.setSysMicBusy(i2);
    }
}
