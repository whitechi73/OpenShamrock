package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBusinessNode;

public  class GGProBusinessNode implements IGProBusinessNode {
    public final GProBusinessNode mInfo;

    public GGProBusinessNode(GProBusinessNode gProBusinessNode) {
        this.mInfo = gProBusinessNode;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public long getDataVersion() {
        return this.mInfo.getDataVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public long getExpiresMs() {
        return this.mInfo.getExpiresMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public IGProLobbyRoomInfo getLobbyRoomInfo() {
        return new GGProLobbyRoomInfo(this.mInfo.getLobbyRoomInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public int getMutexType() {
        return this.mInfo.getMutexType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public byte[] getNodeData() {
        return this.mInfo.getNodeData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public int getNodeType() {
        return this.mInfo.getNodeType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public IGProPlayInfo getPlayInfo() {
        return new GGProPlayInfo(this.mInfo.getPlayInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public IGProVoiceSmobaGameRoomStateInfo getRoomStateInfo() {
        return new GGProVoiceSmobaGameRoomStateInfo(this.mInfo.getRoomStateInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public IGProVoiceInfo getScreenShareInfo() {
        return new GGProVoiceInfo(this.mInfo.getScreenShareInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode
    public String toString() {
        return this.mInfo.toString();
    }
}
