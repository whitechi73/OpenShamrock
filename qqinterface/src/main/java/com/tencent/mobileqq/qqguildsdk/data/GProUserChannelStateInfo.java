package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProUserChannelState;


public class GProUserChannelStateInfo implements IGProUserChannelStateInfo {
    public final GProUserChannelState mInfo;
    public int mUserState;

    public GProUserChannelStateInfo(GProUserChannelState gProUserChannelState) {
        gProUserChannelState = gProUserChannelState == null ? new GProUserChannelState(0L, 0L, 0L, 0L, 2, 1) : gProUserChannelState;
        this.mInfo = gProUserChannelState;
        this.mUserState = gProUserChannelState.getUserState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo
    public int getPlatform() {
        return this.mInfo.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo
    public int getUserState() {
        return this.mUserState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo
    public long getUserStateSeq() {
        return this.mInfo.getUserStateSeq();
    }

    public void setUserState(int i2) {
        this.mUserState = i2;
    }

    public String toString() {
        return "GProUserChannelStateInfo{tinyId=" + getTinyId() + "guildId=" + getGuildId() + "channelId=" + getChannelId() + "userStateSeq=" + getUserStateSeq() + "userState=" + getUserState() + "platform=" + getPlatform() + '}';
    }
}
