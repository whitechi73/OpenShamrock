package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProUserInfo extends Serializable {
    int getAllowScreenShare();

    String getAvatarMeta();

    String getAvatarPendant();

    IGProBusinessData getBusinessInfo();

    IGProClientIdentityInfo getClientIdentity();

    IGProClientPresenceInfo getClientPresence();

    String getDisplayName();

    IGProVoiceInfo getGProVoiceInfo();

    int getGender();

    int getLevelRoleId();

    String getMemberName();

    ArrayList<Integer> getMyRoles();

    String getNickName();

    //el getPersonalMedal();

    int getPlatform();

    int getRobotMuteStatus();

    int getRobotPunishmentStatus();

    String getRobotTestGuilds();

    int getRobotType();

    IGProRoleManagementTag getRoleManagementTag();

    long getShutUpExpireTime();

    String getTinyId();

    long getUserJoinTime();

    int getUserOnlineState();

    int getUserType();

    boolean isMuteSeat();

    boolean isVisitorRole();

    boolean isVoiceless();

    void setRoleManagementTag(long j2, String str, long j3);

    void setShutUpExpireTime(long j2);

    void setUserType(int i2);
}
