package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendLiveChannel implements Serializable {
    GProRecommendCoverInfo cover;
    GProLiveRoomInfo liveChannel;
    ArrayList<GProRecommendMsg> msgList;
    long serialVersionUID;

    public GProRecommendLiveChannel() {
        this.serialVersionUID = 1L;
        this.liveChannel = new GProLiveRoomInfo();
        this.msgList = new ArrayList<>();
        this.cover = new GProRecommendCoverInfo();
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public GProLiveRoomInfo getLiveChannel() {
        return this.liveChannel;
    }

    public ArrayList<GProRecommendMsg> getMsgList() {
        return this.msgList;
    }

    public String toString() {
        return "GProRecommendLiveChannel{liveChannel=" + this.liveChannel + ",msgList=" + this.msgList + ",cover=" + this.cover + ",}";
    }

    public GProRecommendLiveChannel(GProLiveRoomInfo gProLiveRoomInfo, ArrayList<GProRecommendMsg> arrayList, GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.serialVersionUID = 1L;
        this.liveChannel = new GProLiveRoomInfo();
        this.msgList = new ArrayList<>();
        this.cover = new GProRecommendCoverInfo();
        this.liveChannel = gProLiveRoomInfo;
        this.msgList = arrayList;
        this.cover = gProRecommendCoverInfo;
    }
}
