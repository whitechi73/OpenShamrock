package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProExitAVChannelRsp;

public  class GGProExitAVChannelRsp implements IGProExitAVChannelRsp {
    public final GProExitAVChannelRsp mInfo;

    public GGProExitAVChannelRsp(GProExitAVChannelRsp gProExitAVChannelRsp) {
        this.mInfo = gProExitAVChannelRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExitAVChannelRsp
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExitAVChannelRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExitAVChannelRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
