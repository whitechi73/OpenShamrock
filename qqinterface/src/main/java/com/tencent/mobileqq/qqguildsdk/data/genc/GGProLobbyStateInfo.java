package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProKVPair;
import com.tencent.qqnt.kernel.nativeinterface.GProLobbyStateInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProLobbyStateInfo implements IGProLobbyStateInfo {
    public final GProLobbyStateInfo mInfo;

    public GGProLobbyStateInfo(GProLobbyStateInfo gProLobbyStateInfo) {
        this.mInfo = gProLobbyStateInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public String getAppId() {
        return this.mInfo.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public boolean getDisableVoiceAnimation() {
        return this.mInfo.getDisableVoiceAnimation();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public ArrayList<Object> getExtendDic() {
        ArrayList<GProKVPair> extendDic = this.mInfo.getExtendDic();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProKVPair> it = extendDic.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProKVPair(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public long getLeaderTinyId() {
        return this.mInfo.getLeaderTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public long getLobbyId() {
        return this.mInfo.getLobbyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public int getLobbyRoomCapacity() {
        return this.mInfo.getLobbyRoomCapacity();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public int getLobbyRoomCurrUserNum() {
        return this.mInfo.getLobbyRoomCurrUserNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public int getLobbyRoomStatus() {
        return this.mInfo.getLobbyRoomStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public int getLobbyType() {
        return this.mInfo.getLobbyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
