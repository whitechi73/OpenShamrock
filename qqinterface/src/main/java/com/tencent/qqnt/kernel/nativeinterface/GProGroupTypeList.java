package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProGroupTypeList implements Serializable {
    long channelId;
    ArrayList<GProGroupTypeMember> groupTypeMembers;
    long serialVersionUID;

    public GProGroupTypeList() {
        this.serialVersionUID = 1L;
        this.groupTypeMembers = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProGroupTypeMember> getGroupTypeMembers() {
        return this.groupTypeMembers;
    }

    public String toString() {
        return "GProGroupTypeList{channelId=" + this.channelId + ",groupTypeMembers=" + this.groupTypeMembers + ",}";
    }

    public GProGroupTypeList(long j2, ArrayList<GProGroupTypeMember> arrayList) {
        this.serialVersionUID = 1L;
        this.groupTypeMembers = new ArrayList<>();
        this.channelId = j2;
        this.groupTypeMembers = arrayList;
    }
}
