package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProLiveResultItem {
    GProLiveRoomInfo liveChannel;
    ArrayList<MsgAbstract> msgAbstracts;

    public GProLiveResultItem() {
        this.liveChannel = new GProLiveRoomInfo();
        this.msgAbstracts = new ArrayList<>();
    }

    public GProLiveRoomInfo getLiveChannel() {
        return this.liveChannel;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public String toString() {
        return "GProLiveResultItem{liveChannel=" + this.liveChannel + ",msgAbstracts=" + this.msgAbstracts + ",}";
    }

    public GProLiveResultItem(GProLiveRoomInfo gProLiveRoomInfo, ArrayList<MsgAbstract> arrayList) {
        this.liveChannel = new GProLiveRoomInfo();
        this.msgAbstracts = new ArrayList<>();
        this.liveChannel = gProLiveRoomInfo;
        this.msgAbstracts = arrayList;
    }
}
