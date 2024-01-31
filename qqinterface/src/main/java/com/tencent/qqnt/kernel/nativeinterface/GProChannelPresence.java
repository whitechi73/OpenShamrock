package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProChannelPresence implements Serializable {
    long channelId;
    int channelType;
    String currentMemberNum;
    GProGuildLiveInfo guildLiveInfo;
    ArrayList<GProChannelPresenceMemberInfo> memberInfos;
    long serialVersionUID;
    GProVoicePresence0x11bc voicePresence;
    GProWorldPresence0x11bc worldPresence;

    public GProChannelPresence() {
        this.serialVersionUID = 1L;
        this.currentMemberNum = "";
        this.memberInfos = new ArrayList<>();
        this.worldPresence = new GProWorldPresence0x11bc();
        this.guildLiveInfo = new GProGuildLiveInfo();
        this.voicePresence = new GProVoicePresence0x11bc();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getCurrentMemberNum() {
        return this.currentMemberNum;
    }

    public GProGuildLiveInfo getGuildLiveInfo() {
        return this.guildLiveInfo;
    }

    public ArrayList<GProChannelPresenceMemberInfo> getMemberInfos() {
        return this.memberInfos;
    }

    public GProVoicePresence0x11bc getVoicePresence() {
        return this.voicePresence;
    }

    public GProWorldPresence0x11bc getWorldPresence() {
        return this.worldPresence;
    }

    public String toString() {
        return "GProChannelPresence{channelId=" + this.channelId + ",currentMemberNum=" + this.currentMemberNum + ",channelType=" + this.channelType + ",memberInfos=" + this.memberInfos + ",worldPresence=" + this.worldPresence + ",guildLiveInfo=" + this.guildLiveInfo + ",voicePresence=" + this.voicePresence + ",}";
    }

    public GProChannelPresence(long j2, String str, int i2, ArrayList<GProChannelPresenceMemberInfo> arrayList, GProWorldPresence0x11bc gProWorldPresence0x11bc, GProGuildLiveInfo gProGuildLiveInfo, GProVoicePresence0x11bc gProVoicePresence0x11bc) {
        this.serialVersionUID = 1L;
        this.currentMemberNum = "";
        this.memberInfos = new ArrayList<>();
        this.worldPresence = new GProWorldPresence0x11bc();
        this.guildLiveInfo = new GProGuildLiveInfo();
        this.voicePresence = new GProVoicePresence0x11bc();
        this.channelId = j2;
        this.currentMemberNum = str;
        this.channelType = i2;
        this.memberInfos = arrayList;
        this.worldPresence = gProWorldPresence0x11bc;
        this.guildLiveInfo = gProGuildLiveInfo;
        this.voicePresence = gProVoicePresence0x11bc;
    }
}
