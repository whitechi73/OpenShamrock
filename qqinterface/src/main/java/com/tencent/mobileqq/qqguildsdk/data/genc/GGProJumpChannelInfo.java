package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProJumpChannelInfo;


public class GGProJumpChannelInfo implements IGProJumpChannelInfo {
    public final GProJumpChannelInfo mInfo;

    public GGProJumpChannelInfo(GProJumpChannelInfo gProJumpChannelInfo) {
        this.mInfo = gProJumpChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpChannelInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpChannelInfo
    public boolean getIsSwitchOn() {
        return this.mInfo.getIsSwitchOn();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
