package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProInviteInfo;

public  class GGProInviteInfo implements IGProInviteInfo {
    public final GProInviteInfo mInfo;

    public GGProInviteInfo(GProInviteInfo gProInviteInfo) {
        this.mInfo = gProInviteInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public String getBase64Avatar() {
        return this.mInfo.getBase64Avatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public long getChnId() {
        return this.mInfo.getChnId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public String getInviteUrl() {
        return this.mInfo.getInviteUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public String getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
