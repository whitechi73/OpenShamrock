package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProAVMemberGroupListReq implements Serializable {
    long channelId;
    ArrayList<GProGroupClaim> groupTypes;
    long guildId;
    long serialVersionUID;

    public GProAVMemberGroupListReq() {
        this.serialVersionUID = 1L;
        this.groupTypes = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProGroupClaim> getGroupTypes() {
        return this.groupTypes;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProAVMemberGroupListReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",groupTypes=" + this.groupTypes + ",}";
    }

    public GProAVMemberGroupListReq(long j2, long j3, ArrayList<GProGroupClaim> arrayList) {
        this.serialVersionUID = 1L;
        this.groupTypes = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.groupTypes = arrayList;
    }
}
