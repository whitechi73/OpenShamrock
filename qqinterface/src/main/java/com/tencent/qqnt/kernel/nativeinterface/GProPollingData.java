package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProPollingData {
    long channelId;
    byte[] cookie;
    byte[] data;
    ArrayList<MsgAbstract> feedMsgAbstracts;
    boolean forcePolling;
    long guildId;
    ArrayList<GProStickyChannel> guildStickyChannelList;
    GProLiveResultItem liveResultItem;
    ArrayList<MsgAbstract> msgAbstracts;
    int type;
    long updateTime;
    long version;
    GProChannelMemberInfos voiceChannel;

    public GProPollingData() {
        this.cookie = new byte[0];
        this.data = new byte[0];
        this.voiceChannel = new GProChannelMemberInfos();
        this.liveResultItem = new GProLiveResultItem();
        this.guildStickyChannelList = new ArrayList<>();
        this.msgAbstracts = new ArrayList<>();
        this.feedMsgAbstracts = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public byte[] getData() {
        return this.data;
    }

    public ArrayList<MsgAbstract> getFeedMsgAbstracts() {
        return this.feedMsgAbstracts;
    }

    public boolean getForcePolling() {
        return this.forcePolling;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProStickyChannel> getGuildStickyChannelList() {
        return this.guildStickyChannelList;
    }

    public GProLiveResultItem getLiveResultItem() {
        return this.liveResultItem;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public long getVersion() {
        return this.version;
    }

    public GProChannelMemberInfos getVoiceChannel() {
        return this.voiceChannel;
    }

    public String toString() {
        return "GProPollingData{type=" + this.type + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",version = " + this.version + ",cookie=" + this.cookie + ",data=" + this.data + ",voiceChannel=" + this.voiceChannel + ",liveResultItem=" + this.liveResultItem + ",guildStickyChannelList=" + this.guildStickyChannelList + ",msgAbstracts=" + this.msgAbstracts + ",feedMsgAbstracts=" + this.feedMsgAbstracts + ",forcePolling=" + this.forcePolling + ",updateTime=" + this.updateTime + ",}";
    }

    public GProPollingData(int i2, long j2, long j3, long j4, byte[] bArr, byte[] bArr2, GProChannelMemberInfos gProChannelMemberInfos, GProLiveResultItem gProLiveResultItem, ArrayList<GProStickyChannel> arrayList, ArrayList<MsgAbstract> arrayList2, ArrayList<MsgAbstract> arrayList3, boolean z, long j5) {
        this.cookie = new byte[0];
        this.data = new byte[0];
        this.voiceChannel = new GProChannelMemberInfos();
        this.liveResultItem = new GProLiveResultItem();
        this.guildStickyChannelList = new ArrayList<>();
        this.msgAbstracts = new ArrayList<>();
        this.feedMsgAbstracts = new ArrayList<>();
        this.type = i2;
        this.guildId = j2;
        this.channelId = j3;
        this.version = j4;
        this.cookie = bArr;
        this.data = bArr2;
        this.voiceChannel = gProChannelMemberInfos;
        this.liveResultItem = gProLiveResultItem;
        this.guildStickyChannelList = arrayList;
        this.msgAbstracts = arrayList2;
        this.feedMsgAbstracts = arrayList3;
        this.forcePolling = z;
        this.updateTime = j5;
    }
}
