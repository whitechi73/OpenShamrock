package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelUserNum;


public class GGProChannelUserNum implements IGProChannelUserNum {
    public final GProChannelUserNum mInfo;

    public GGProChannelUserNum(GProChannelUserNum gProChannelUserNum) {
        this.mInfo = gProChannelUserNum;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public long getDataVersion() {
        return this.mInfo.getDataVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public int getPlayersNum() {
        return this.mInfo.getPlayersNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public int getRobotNum() {
        return this.mInfo.getRobotNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public int getShowThreshold() {
        return this.mInfo.getShowThreshold();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public int getSpeakOrderNum() {
        return this.mInfo.getSpeakOrderNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public int getUserNum() {
        return this.mInfo.getUserNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public int getViewersNum() {
        return this.mInfo.getViewersNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum
    public String toString() {
        return this.mInfo.toString();
    }
}
