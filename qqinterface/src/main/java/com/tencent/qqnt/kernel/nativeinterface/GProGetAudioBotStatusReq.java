package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetAudioBotStatusReq {
    ArrayList<Long> botIds;
    long channelId;
    long guildId;

    public GProGetAudioBotStatusReq() {
        this.botIds = new ArrayList<>();
    }

    public ArrayList<Long> getBotIds() {
        return this.botIds;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetAudioBotStatusReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",botIds=" + this.botIds + ",}";
    }

    public GProGetAudioBotStatusReq(long j2, long j3, ArrayList<Long> arrayList) {
        this.botIds = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.botIds = arrayList;
    }
}
