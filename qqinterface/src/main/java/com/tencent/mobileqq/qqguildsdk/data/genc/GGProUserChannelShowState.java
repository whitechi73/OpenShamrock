package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProUserChannelShowState;

/* loaded from: classes33.dex */
public class GGProUserChannelShowState implements IGProUserChannelShowState {
    public final GProUserChannelShowState mInfo;

    public GGProUserChannelShowState(GProUserChannelShowState gProUserChannelShowState) {
        this.mInfo = gProUserChannelShowState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserChannelShowState
    public String getStateIcon() {
        return this.mInfo.getStateIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserChannelShowState
    public String getStateInfo() {
        return this.mInfo.getStateInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserChannelShowState
    public String toString() {
        return this.mInfo.toString();
    }
}
