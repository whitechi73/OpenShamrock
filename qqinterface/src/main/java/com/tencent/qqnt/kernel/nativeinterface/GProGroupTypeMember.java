package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProGroupTypeMember implements Serializable {
    long channelId;
    int groupType;
    ArrayList<GProUser> memberList;
    long serialVersionUID;

    public GProGroupTypeMember() {
        this.serialVersionUID = 1L;
        this.memberList = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public String toString() {
        return "GProGroupTypeMember{channelId=" + this.channelId + ",groupType=" + this.groupType + ",memberList=" + this.memberList + ",}";
    }

    public GProGroupTypeMember(long j2, int i2, ArrayList<GProUser> arrayList) {
        this.serialVersionUID = 1L;
        this.memberList = new ArrayList<>();
        this.channelId = j2;
        this.groupType = i2;
        this.memberList = arrayList;
    }
}
