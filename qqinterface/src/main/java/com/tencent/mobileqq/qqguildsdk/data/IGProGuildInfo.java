package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProGuildInfo extends Serializable {
    public static final long serialVersionUID = 1;

    boolean getAllowSearch();

    long getAvatarSeq();

    String getAvatarUrl(int i2);

    long getBannedTimeLimit();

    long getChangeNameInterval();

    boolean getChannelListChange();

    String getClientId();

    int getCoverFontColorId();

    String getCoverUrl(int i2, int i3);

    long getCreateTime();

    String getCreatorId();

    String getErrMsg();

    long getGroupId();

    boolean getGuildCanShare();

    String getGuildID();

    String getGuildName();

    long getGuildNameChangeTime();

    String getGuildNumber();

    int getGuildType();

    int getGuildUnNotifyFlag();

    boolean getIsBanned();

    boolean getIsFrozen();

    boolean getIsValid();

    long getJoinTime();

    long getJumpChannelId();

    boolean getJumpChannelSwitch();

    ArrayList<IGProMedalInfo> getMedalInfoList();

    int getMedalLevel();

    long getMyShutUpExpireTime();

    ArrayList<IGProNavigationInfo> getNavigationInfoList();

    String getProfile();

    int getQRCodePeriod();

    int getQRCodeSwitch();

    int getResult();

    String getSearchJoinSig();

    String getShowNumber();

    long getShutUpExpireTime();

    //eu getSpeakThreshold();

    String getTagDesc();

    long getTagId();

    boolean getTopicSquareSwitch();

    long getU64guildSeq();

    String getUIData(String str);

    int getUserNum();

    int getUserType();

    int getVisibleChannelMaxNum();

    int getWeakNotifyDisplay();

    boolean isGroupGuild();

    boolean isInteractiveForVisitor();

    boolean isMember();

    boolean isNeedRealNameForVisitor();

    boolean isTop();

    boolean isVisibleForVisitor();
}
