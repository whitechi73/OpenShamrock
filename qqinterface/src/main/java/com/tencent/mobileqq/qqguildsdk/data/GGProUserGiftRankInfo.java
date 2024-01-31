package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUser;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import com.tencent.qqnt.kernel.nativeinterface.GProUserGiftRankInfo;


public class GGProUserGiftRankInfo implements IGProUserGiftRankInfo {
    public final GProUserGiftRankInfo mInfo;

    public GGProUserGiftRankInfo(GProUserGiftRankInfo gProUserGiftRankInfo) {
        this.mInfo = gProUserGiftRankInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo
    public String getRankInfo() {
        return this.mInfo.getRankInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo
    public int getTopNum() {
        return this.mInfo.getTopNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo
    public IGProUser getUserInfo() {
        return new GGProUser(this.mInfo.getUserInfo());
    }
}
