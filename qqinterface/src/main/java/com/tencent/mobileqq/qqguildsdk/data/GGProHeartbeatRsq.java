package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import com.tencent.qqnt.kernel.nativeinterface.GProHeartbeatRsq;


public class GGProHeartbeatRsq implements IGProHeartbeatRsq {
    public final GProHeartbeatRsq mInfo;

    public GGProHeartbeatRsq(GProHeartbeatRsq gProHeartbeatRsq) {
        this.mInfo = gProHeartbeatRsq;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public IGProAVChannelConfig getAVChannelConfig() {
        return new GGProAVChannelConfig(this.mInfo.getAvChannelConfig());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public int getForceExit() {
        return this.mInfo.getForceExit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public long getNextHeartBeatInterval() {
        return this.mInfo.getNextHeartBeatInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public long getNoStreamDisconnectTrtcSecond() {
        return this.mInfo.getNoStreamDisconnectTrtcSecond();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq
    public String getShowTips() {
        return this.mInfo.getShowTips();
    }
}
