package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBusinessInfo;

/* loaded from: classes33.dex */
public class GGProBusinessInfo implements IGProBusinessInfo {
    public final GProBusinessInfo mInfo;

    public GGProBusinessInfo(GProBusinessInfo gProBusinessInfo) {
        this.mInfo = gProBusinessInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public IGProLobbyMemberInfo getLobbyMemberInfo() {
        return new GGProLobbyMemberInfo(this.mInfo.getLobbyMemberInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public IGProMemberInfoInGame getMemberInfoInGame() {
        return new GGProMemberInfoInGame(this.mInfo.getMemberInfoInGame());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public IGProRobotStateInfo getRobotStateInfo() {
        return new GGProRobotStateInfo(this.mInfo.getRobotStateInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public long getSortKey() {
        return this.mInfo.getSortKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public String getTipsMsg() {
        return this.mInfo.getTipsMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public IGProUserAVInfo getUserAVInfo() {
        return new GGProUserAVInfo(this.mInfo.getUserAVInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public IGProUserChannelShowState getUserChannelState() {
        return new GGProUserChannelShowState(this.mInfo.getUserChannelState());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public IGProUserListGroupInfo getUserListGroupInfo() {
        return new GGProUserListGroupInfo(this.mInfo.getUserListGroupInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
