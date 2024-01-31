package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProQRCodeShareInfo;

public  class GGProQRCodeShareInfo implements IGProQRCodeShareInfo {
    public final GProQRCodeShareInfo mInfo;

    public GGProQRCodeShareInfo(GProQRCodeShareInfo gProQRCodeShareInfo) {
        this.mInfo = gProQRCodeShareInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public long getAvTime() {
        return this.mInfo.getAvTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getChannelCopyWriter() {
        return this.mInfo.getChannelCopyWriter();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getFeedLabel() {
        return this.mInfo.getFeedLabel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public long getFeedNum() {
        return this.mInfo.getFeedNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public long getGameNum() {
        return this.mInfo.getGameNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getGuildLabel() {
        return this.mInfo.getGuildLabel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public long getLiveNum() {
        return this.mInfo.getLiveNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getMembersCount() {
        return this.mInfo.getMembersCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getOnlineMembersCount() {
        return this.mInfo.getOnlineMembersCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getStreamLabel() {
        return this.mInfo.getStreamLabel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getTeamLabel() {
        return this.mInfo.getTeamLabel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String getVoiceLabel() {
        return this.mInfo.getVoiceLabel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
