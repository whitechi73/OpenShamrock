package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes33.dex */
public interface IGProBusinessInfo extends Serializable {
    IGProLobbyMemberInfo getLobbyMemberInfo();

    IGProMemberInfoInGame getMemberInfoInGame();

    IGProRobotStateInfo getRobotStateInfo();

    long getSortKey();

    String getTipsMsg();

    IGProUserAVInfo getUserAVInfo();

    IGProUserChannelShowState getUserChannelState();

    IGProUserListGroupInfo getUserListGroupInfo();

    String toString();
}
