package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSimpleProfile;

import java.util.ArrayList;


public class GGProSimpleProfile implements IGProSimpleProfile {
    public final GProSimpleProfile mInfo;

    public GGProSimpleProfile(GProSimpleProfile gProSimpleProfile) {
        this.mInfo = gProSimpleProfile;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public String getAvatarMeta() {
        return this.mInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public String getAvatarPendant() {
        return this.mInfo.getAvatarPendant();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public ArrayList<Long> getCategoryIds() {
        return this.mInfo.getCategoryIds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public IGProClientIdentity getClientIdentityBytes() {
        return new GGProClientIdentity(this.mInfo.getClientIdentityBytes());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public String getDisplayName() {
        return this.mInfo.getDisplayName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public long getLevelRoleId() {
        return this.mInfo.getLevelRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public String getMemberName() {
        return this.mInfo.getMemberName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public IGProMedal getPersonalMedal() {
        return new GGProMedal(this.mInfo.getPersonalMedal());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public long getRoleId() {
        return this.mInfo.getRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile
    public String toString() {
        return this.mInfo.toString();
    }
}
