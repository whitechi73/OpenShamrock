package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;

import java.util.ArrayList;

public  class GGProUser implements IGProUser {
    public final GProUser mInfo;

    public GGProUser(GProUser gProUser) {
        this.mInfo = gProUser;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getAllowScreenShare() {
        return this.mInfo.getAllowScreenShare();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public String getAvatarMeta() {
        return this.mInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public String getAvatarPendant() {
        return this.mInfo.getAvatarPendant();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public IGProBusinessInfo getBusinessInfo() {
        return new GGProBusinessInfo(this.mInfo.getBusinessInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getChnRole() {
        return this.mInfo.getChnRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public IGProClientIdentity getClientIdentity() {
        return new GGProClientIdentity(this.mInfo.getClientIdentity());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public IGProClientPresenceInfo getClientPresence() {
        return new GProClientPresenceInfo(this.mInfo.getClientPresence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public byte[] getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getGender() {
        return this.mInfo.getGender();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public boolean getGuildMute() {
        return this.mInfo.getGuildMute();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public boolean getInBlack() {
        return this.mInfo.getInBlack();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public long getJoinTime() {
        return this.mInfo.getJoinTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getLevelRoleId() {
        return this.mInfo.getLevelRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public String getMemberName() {
        return this.mInfo.getMemberName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public ArrayList<Integer> getMyRoles() {
        return this.mInfo.getMyRoles();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getOnlineState() {
        return this.mInfo.getOnlineState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public IGProMedal getPersonalMedal() {
        return new GGProMedal(this.mInfo.getPersonalMedal());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getPlatform() {
        return this.mInfo.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getRobotMuteStatus() {
        return this.mInfo.getRobotMuteStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getRobotPunishmentStatus() {
        return this.mInfo.getRobotPunishmentStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public String getRobotTestGuilds() {
        return this.mInfo.getRobotTestGuilds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getRobotType() {
        return this.mInfo.getRobotType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public IGProRoleManagementTag getRoleManagementTag() {
        return new GGProRoleManagementTag(this.mInfo.getRoleManagementTag());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public long getShutUpExpireTime() {
        return this.mInfo.getShutUpExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public IGProVoiceInfo getVoiceInfo() {
        return new GGProVoiceInfo(this.mInfo.getVoiceInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser
    public String toString() {
        return this.mInfo.toString();
    }
}
