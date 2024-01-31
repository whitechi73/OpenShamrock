package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildUserState;


public class GGProGuildUserState implements IGProGuildUserState {
    public final GProGuildUserState mInfo;

    public GGProGuildUserState(GProGuildUserState gProGuildUserState) {
        this.mInfo = gProGuildUserState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState
    public boolean getHasEnteredChannel() {
        return this.mInfo.getHasEnteredChannel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState
    public String toString() {
        return this.mInfo.toString();
    }
}
