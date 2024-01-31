package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProMedal;
import com.tencent.qqnt.kernel.nativeinterface.GProRoleManagementTag;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceInfo;

import java.util.ArrayList;
import java.util.Iterator;


public class GProUserInfo implements IGProUserInfo {
    private GProUser mUser;
    private String tinyId;

    public GProUserInfo(GProUser gProUser) {
        this.mUser = gProUser;
        //this.tinyId = com.tencent.mobileqq.qqguildsdk.util.b.U0(gProUser.getTinyId());
    }

    private void a(String str) {
        this.mUser.setMemberName(str);
    }

    private void b(int i2) {
        this.mUser.setRobotType(i2);
    }

    private void c(long j2) {
        this.mUser.setJoinTime(j2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getAllowScreenShare() {
        return this.mUser.getAllowScreenShare();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getAvatarMeta() {
        return this.mUser.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getAvatarPendant() {
        return this.mUser.getAvatarPendant();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProBusinessData getBusinessInfo() {
        return new GProBusinessData(this.mUser.getBusinessInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProClientIdentityInfo getClientIdentity() {
        return new GProClientIdentityInfo(this.mUser.getClientIdentity());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProClientPresenceInfo getClientPresence() {
        return new GProClientPresenceInfo(this.mUser.getClientPresence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getDisplayName() {
        if (!TextUtils.isEmpty(getMemberName())) {
            return getMemberName();
        }
        return getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProVoiceInfo getGProVoiceInfo() {
        if (this.mUser.getVoiceInfo() == null) {
            return new GGProVoiceInfo(new GProVoiceInfo(0, 2, "", 0L, 0L));
        }
        return new GGProVoiceInfo(this.mUser.getVoiceInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getGender() {
        return this.mUser.getGender();
    }

    public String getGuildId() {
        //return com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mUser.getGuildId());
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getLevelRoleId() {
        return this.mUser.getLevelRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getMemberName() {
        return this.mUser.getMemberName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public ArrayList<Integer> getMyRoles() {
        return this.mUser.getMyRoles();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getNickName() {
        return this.mUser.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getPlatform() {
        return this.mUser.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotMuteStatus() {
        return this.mUser.getRobotMuteStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotPunishmentStatus() {
        return this.mUser.getRobotPunishmentStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getRobotTestGuilds() {
        return this.mUser.getRobotTestGuilds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotType() {
        return this.mUser.getRobotType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProRoleManagementTag getRoleManagementTag() {
        return new GGProRoleManagementTag(this.mUser.getRoleManagementTag());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public long getShutUpExpireTime() {
        return this.mUser.getShutUpExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getTinyId() {
        return this.tinyId;
    }

    public GProUser getUser() {
        return this.mUser;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public long getUserJoinTime() {
        return this.mUser.getJoinTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getUserOnlineState() {
        return this.mUser.getOnlineState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getUserType() {
        return this.mUser.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isMuteSeat() {
        return this.mUser.getGuildMute();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isVisitorRole() {
        if (this.mUser.getMyRoles() == null || this.mUser.getMyRoles().isEmpty()) {
            return false;
        }
        Iterator<Integer> it = this.mUser.getMyRoles().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == 6) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isVoiceless() {
        return this.mUser.getInBlack();
    }

    public void setGProVoiceInfo(IGProVoiceInfo iGProVoiceInfo) {
        GProVoiceInfo gProVoiceInfo;
        if (iGProVoiceInfo == null) {
            gProVoiceInfo = new GProVoiceInfo(0, 2, "", 0L, 0L);
        } else {
            gProVoiceInfo = new GProVoiceInfo(iGProVoiceInfo.getVoiceState(), iGProVoiceInfo.getScreenState(), iGProVoiceInfo.getScreenPic(), iGProVoiceInfo.getScreenUpdateTime(), iGProVoiceInfo.getScreenShareTinyId());
        }
        this.mUser.setVoiceInfo(gProVoiceInfo);
    }

    public void setNickName(String str) {
        this.mUser.setNickName(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setRoleManagementTag(long j2, String str, long j3) {
        this.mUser.setRoleManagementTag(new GProRoleManagementTag(j2, str, j3));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setShutUpExpireTime(long j2) {
        this.mUser.setShutUpExpireTime(j2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setUserType(int i2) {
        this.mUser.setType(i2);
    }

    public void setVoiceless(boolean z) {
        this.mUser.setInBlack(z);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GProUserInfo{");
        stringBuffer.append("mUser=");
        stringBuffer.append(this.mUser);
        stringBuffer.append(", tinyId='");
        stringBuffer.append(this.tinyId);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public GProUserInfo reflash(IGProUserInfo iGProUserInfo) {
        setNickName(iGProUserInfo.getNickName());
        a(iGProUserInfo.getMemberName());
        b(iGProUserInfo.getRobotType());
        c(iGProUserInfo.getUserJoinTime());
        setUserType(iGProUserInfo.getUserType());
        return this;
    }

    public GProUserInfo reflash(GProUser gProUser) {
        this.mUser = gProUser;
        return this;
    }
}
