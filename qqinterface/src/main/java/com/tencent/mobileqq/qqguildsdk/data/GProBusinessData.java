package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProLobbyMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMemberInfoInGame;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRobotStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUserChannelShowState;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUserListGroupInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserChannelShowState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserListGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProBusinessInfo;

/* loaded from: classes33.dex */
public class GProBusinessData implements IGProBusinessData {
    private GProBusinessInfo mBusinessInfo;

    public GProBusinessData(GProBusinessInfo gProBusinessInfo) {
        this.mBusinessInfo = gProBusinessInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public IGProLobbyMemberInfo getLobbyMemberInfo() {
        return new GGProLobbyMemberInfo(this.mBusinessInfo.getLobbyMemberInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public IGProMemberInfoInGame getMemberInfoInGame() {
        return new GGProMemberInfoInGame(this.mBusinessInfo.getMemberInfoInGame());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public IGProRobotStateInfo getRobotStateInfo() {
        return new GGProRobotStateInfo(this.mBusinessInfo.getRobotStateInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public long getSortKey() {
        return this.mBusinessInfo.getSortKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public String getTipsMsg() {
        return this.mBusinessInfo.getTipsMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public IGProUserAVData getUserAVInfo() {
        return new GProUserAVData(this.mBusinessInfo.getUserAVInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public IGProUserChannelShowState getUserChannelShowState() {
        return new GGProUserChannelShowState(this.mBusinessInfo.getUserChannelState());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public IGProUserListGroupInfo getUserListGroupInfo() {
        return new GGProUserListGroupInfo(this.mBusinessInfo.getUserListGroupInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData
    public void setSortKey(long j2) {
        this.mBusinessInfo.setSortKey(j2);
    }
}
