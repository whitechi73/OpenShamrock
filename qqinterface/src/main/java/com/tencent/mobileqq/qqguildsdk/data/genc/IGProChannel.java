package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProChannel extends Serializable {
    long getAnchorTinyId();

    IGProApplicationChannelInfo getAppChannelInfo();

    ArrayList<Object> getAuthControlStatusList();

    IGProAVChannelExtInfo getAvChannelExtInfo();

    int getBannedSpeak();

    long getChannelId();

    int getChannelLiveableType();

    int getChannelVisibleType();

    long getCreateTime();

    long getCreatorTinyId();

    int getCurrentSlowModeKey();

    int getFinalNotifyType();

    int getForumSortMode();

    long getGotoChannelId();

    long getGuildId();

    String getHotIcon();

    String getIconUrl();

    int getIsCategoryAdmin();

    int getIsChannelAdmin();

    int getJumpSwitch();

    long getLastCntMsgSeq();

    long getLastCntMsgTime();

    long getLastMsgSeq();

    long getLastMsgTime();

    IGProMedalInfo getMedalInfo();

    byte[] getMsgMeta();

    int getMsgNotifyType();

    int getMyForumSortMode();

    int getMySpeakPermission();

    String getName();

    String getOperationTitle();

    int getOperationType();

    long getReadCntMsgSeq();

    long getReadCntMsgTime();

    byte[] getReadMsgMeta();

    long getReadMsgSeq();

    long getReadMsgTime();

    int getResult();

    long getRoomId();

    String getRoomName();

    ArrayList<Object> getSlowModeInfo();

    ArrayList<Integer> getSpecialTypes();

    int getTalkPermission();

    int getTextChannelSubtypeId();

    ArrayList<Object> getTopMsgList();

    long getTopMsgOperatorTinyId();

    long getTopMsgSeq();

    long getTopMsgTime();

    int getType();

    int getUint32HotIndex();

    int getVisibleType();

    ArrayList<Object> getVisibleTypeInfo();

    String toString();
}
