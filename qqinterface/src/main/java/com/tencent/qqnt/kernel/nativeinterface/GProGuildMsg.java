package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildMsg {
    long channelId;
    long guildId;
    ArrayList<GProMsgHighlight> highlights;
    long msgSeq;

    public GProGuildMsg() {
        this.highlights = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProMsgHighlight> getHighlights() {
        return this.highlights;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String toString() {
        return "GProGuildMsg{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgSeq=" + this.msgSeq + ",highlights=" + this.highlights + ",}";
    }

    public GProGuildMsg(long j2, long j3, long j4, ArrayList<GProMsgHighlight> arrayList) {
        this.highlights = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.msgSeq = j4;
        this.highlights = arrayList;
    }
}
