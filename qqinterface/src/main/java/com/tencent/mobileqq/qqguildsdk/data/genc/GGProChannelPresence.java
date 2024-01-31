package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelPresence;
import com.tencent.qqnt.kernel.nativeinterface.GProChannelPresenceMemberInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProChannelPresence implements IGProChannelPresence {
    public final GProChannelPresence mInfo;

    public GGProChannelPresence(GProChannelPresence gProChannelPresence) {
        this.mInfo = gProChannelPresence;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public String getCurrentMemberNum() {
        return this.mInfo.getCurrentMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public IGProGuildLiveInfo getGuildLiveInfo() {
        return new GGProGuildLiveInfo(this.mInfo.getGuildLiveInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public ArrayList<IGProChannelPresenceMemberInfo> getMemberInfos() {
        ArrayList<GProChannelPresenceMemberInfo> memberInfos = this.mInfo.getMemberInfos();
        ArrayList<IGProChannelPresenceMemberInfo> arrayList = new ArrayList<>();
        Iterator<GProChannelPresenceMemberInfo> it = memberInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannelPresenceMemberInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public IGProVoicePresence0x11bc getVoicePresence() {
        return new GGProVoicePresence0x11bc(this.mInfo.getVoicePresence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresence
    public String toString() {
        return this.mInfo.toString();
    }
}
