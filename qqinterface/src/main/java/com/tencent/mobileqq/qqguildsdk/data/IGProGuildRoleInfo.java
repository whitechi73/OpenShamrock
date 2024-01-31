package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProGuildRoleInfo extends Serializable {
    ArrayList<String> getApproveSpeakChannels();

    ArrayList<String> getApproveVisibleChannels();

    int getBackgroudColor1();

    int getBackgroudColor2();

    int getCategoryType();

    int getColor();

    int getCount();

    String getDisplayTagName();

    int getDisplayType();

    String getGuildId();

    boolean getHoist();

    boolean getIsNotSort();

    String getLevelBigIcon();

    String getLevelDesc();

    String getLevelIconUrl();

    String getLevelSimpleDsc();

    int getLevelSimpleDscColor();

    int getLevelSplitLineColor();

    ArrayList<String> getManageCategoryIdList();

    long getManageTagPendingColor();

    int getMemberLimit();

    String getName();

    int getNameplate();

    int getOutlineColor();

    @NonNull
    GProRolePermission getPermission();

    String getRoleId();

    int getRoleType();

    int getSpeakableChannelsCount();

    int getVisibleChannelsCount();

    boolean isLevelRole();

    String toString();
}
