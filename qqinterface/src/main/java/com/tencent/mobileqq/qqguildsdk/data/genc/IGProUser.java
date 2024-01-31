package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProUser extends Serializable {
    int getAllowScreenShare();

    String getAvatarMeta();

    String getAvatarPendant();

    IGProBusinessInfo getBusinessInfo();

    int getChnRole();

    IGProClientIdentity getClientIdentity();

    IGProClientPresenceInfo getClientPresence();

    byte[] getCookie();

    int getGender();

    long getGuildId();

    boolean getGuildMute();

    boolean getInBlack();

    long getJoinTime();

    int getLevelRoleId();

    String getMemberName();

    ArrayList<Integer> getMyRoles();

    String getNickName();

    int getOnlineState();

    IGProMedal getPersonalMedal();

    int getPlatform();

    int getRobotMuteStatus();

    int getRobotPunishmentStatus();

    String getRobotTestGuilds();

    int getRobotType();

    IGProRoleManagementTag getRoleManagementTag();

    long getShutUpExpireTime();

    long getTinyId();

    int getType();

    IGProVoiceInfo getVoiceInfo();

    String toString();
}
