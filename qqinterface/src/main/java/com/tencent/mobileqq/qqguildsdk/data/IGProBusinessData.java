package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserChannelShowState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserListGroupInfo;

import java.io.Serializable;


public interface IGProBusinessData extends Serializable {
    IGProLobbyMemberInfo getLobbyMemberInfo();

    IGProMemberInfoInGame getMemberInfoInGame();

    IGProRobotStateInfo getRobotStateInfo();

    long getSortKey();

    String getTipsMsg();

    IGProUserAVData getUserAVInfo();

    IGProUserChannelShowState getUserChannelShowState();

    IGProUserListGroupInfo getUserListGroupInfo();

    void setSortKey(long j2);
}
