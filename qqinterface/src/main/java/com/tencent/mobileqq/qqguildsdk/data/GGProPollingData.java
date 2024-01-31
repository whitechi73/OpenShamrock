package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProPollingData;
import com.tencent.qqnt.kernel.nativeinterface.GProStickyChannel;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstract;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProPollingData implements IGProPollingData {
    public final GProPollingData mInfo;

    public GGProPollingData(GProPollingData gProPollingData) {
        this.mInfo = gProPollingData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public byte[] getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public boolean getForcePolling() {
        return this.mInfo.getForcePolling();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public ArrayList<IGProStickyChannel> getGuildStickyChannelList() {
        ArrayList<GProStickyChannel> guildStickyChannelList = this.mInfo.getGuildStickyChannelList();
        ArrayList<IGProStickyChannel> arrayList = new ArrayList<>();
        Iterator<GProStickyChannel> it = guildStickyChannelList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProStickyChannel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public IGProLiveResultItem getLiveResultItem() {
        return new GGProLiveResultItem(this.mInfo.getLiveResultItem());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public long getUpdateTime() {
        return this.mInfo.getUpdateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public long getVersion() {
        return this.mInfo.getVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProPollingData
    public IAudioChannelMemberInfos getVoiceChannel() {
        //return new ChannelMemberInfos(this.mInfo.getVoiceChannel());
        return null;
    }
}
