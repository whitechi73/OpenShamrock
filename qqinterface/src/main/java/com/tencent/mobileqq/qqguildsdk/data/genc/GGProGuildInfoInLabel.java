package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildInfoInLabel;

import java.util.ArrayList;

public  class GGProGuildInfoInLabel implements IGProGuildInfoInLabel {
    public final GProGuildInfoInLabel mInfo;

    public GGProGuildInfoInLabel(GProGuildInfoInLabel gProGuildInfoInLabel) {
        this.mInfo = gProGuildInfoInLabel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public ArrayList<String> getGuildLabels() {
        return this.mInfo.getGuildLabels();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public int getGuildStatus() {
        return this.mInfo.getGuildStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoInLabel
    public String toString() {
        return this.mInfo.toString();
    }
}
