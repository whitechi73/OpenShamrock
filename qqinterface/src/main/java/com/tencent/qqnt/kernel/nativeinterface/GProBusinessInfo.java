package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProBusinessInfo implements Serializable {
    GProLobbyMemberInfo lobbyMemberInfo;
    GProMemberInfoInGame memberInfoInGame;
    GProRobotStateInfo robotStateInfo;
    long serialVersionUID;
    long sortKey;
    String tipsMsg;
    GProUserAVInfo userAVInfo;
    GProUserChannelShowState userChannelState;
    GProUserListGroupInfo userListGroupInfo;

    public GProBusinessInfo() {
        this.serialVersionUID = 1L;
        this.memberInfoInGame = new GProMemberInfoInGame();
        this.userAVInfo = new GProUserAVInfo();
        this.robotStateInfo = new GProRobotStateInfo();
        this.tipsMsg = "";
        this.userListGroupInfo = new GProUserListGroupInfo();
        this.userChannelState = new GProUserChannelShowState();
        this.lobbyMemberInfo = new GProLobbyMemberInfo();
    }

    public GProLobbyMemberInfo getLobbyMemberInfo() {
        return this.lobbyMemberInfo;
    }

    public GProMemberInfoInGame getMemberInfoInGame() {
        return this.memberInfoInGame;
    }

    public GProRobotStateInfo getRobotStateInfo() {
        return this.robotStateInfo;
    }

    public long getSortKey() {
        return this.sortKey;
    }

    public String getTipsMsg() {
        return this.tipsMsg;
    }

    public GProUserAVInfo getUserAVInfo() {
        return this.userAVInfo;
    }

    public GProUserChannelShowState getUserChannelState() {
        return this.userChannelState;
    }

    public GProUserListGroupInfo getUserListGroupInfo() {
        return this.userListGroupInfo;
    }

    public void setLobbyMemberInfo(GProLobbyMemberInfo gProLobbyMemberInfo) {
        this.lobbyMemberInfo = gProLobbyMemberInfo;
    }

    public void setMemberInfoInGame(GProMemberInfoInGame gProMemberInfoInGame) {
        this.memberInfoInGame = gProMemberInfoInGame;
    }

    public void setRobotStateInfo(GProRobotStateInfo gProRobotStateInfo) {
        this.robotStateInfo = gProRobotStateInfo;
    }

    public void setSortKey(long j2) {
        this.sortKey = j2;
    }

    public void setTipsMsg(String str) {
        this.tipsMsg = str;
    }

    public void setUserAVInfo(GProUserAVInfo gProUserAVInfo) {
        this.userAVInfo = gProUserAVInfo;
    }

    public void setUserChannelState(GProUserChannelShowState gProUserChannelShowState) {
        this.userChannelState = gProUserChannelShowState;
    }

    public void setUserListGroupInfo(GProUserListGroupInfo gProUserListGroupInfo) {
        this.userListGroupInfo = gProUserListGroupInfo;
    }

    public String toString() {
        return "GProBusinessInfo{sortKey=" + this.sortKey + ",memberInfoInGame=" + this.memberInfoInGame + ",userAVInfo=" + this.userAVInfo + ",robotStateInfo=" + this.robotStateInfo + ",tipsMsg=" + this.tipsMsg + ",userListGroupInfo=" + this.userListGroupInfo + ",userChannelState=" + this.userChannelState + ",lobbyMemberInfo=" + this.lobbyMemberInfo + ",}";
    }

    public GProBusinessInfo(long j2, GProMemberInfoInGame gProMemberInfoInGame, GProUserAVInfo gProUserAVInfo, GProRobotStateInfo gProRobotStateInfo, String str, GProUserListGroupInfo gProUserListGroupInfo, GProUserChannelShowState gProUserChannelShowState, GProLobbyMemberInfo gProLobbyMemberInfo) {
        this.serialVersionUID = 1L;
        this.memberInfoInGame = new GProMemberInfoInGame();
        this.userAVInfo = new GProUserAVInfo();
        this.robotStateInfo = new GProRobotStateInfo();
        this.tipsMsg = "";
        this.userListGroupInfo = new GProUserListGroupInfo();
        this.userChannelState = new GProUserChannelShowState();
        this.lobbyMemberInfo = new GProLobbyMemberInfo();
        this.sortKey = j2;
        this.memberInfoInGame = gProMemberInfoInGame;
        this.userAVInfo = gProUserAVInfo;
        this.robotStateInfo = gProRobotStateInfo;
        this.tipsMsg = str;
        this.userListGroupInfo = gProUserListGroupInfo;
        this.userChannelState = gProUserChannelShowState;
        this.lobbyMemberInfo = gProLobbyMemberInfo;
    }
}
