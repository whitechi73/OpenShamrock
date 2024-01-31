package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetCurrPlaySongRsp {
    GProPlayInfo playInfo;
    GProListenTogetherRspHead rspHead;

    public GProGetCurrPlaySongRsp() {
        this.rspHead = new GProListenTogetherRspHead();
        this.playInfo = new GProPlayInfo();
    }

    public GProPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public GProListenTogetherRspHead getRspHead() {
        return this.rspHead;
    }

    public String toString() {
        return "GProGetCurrPlaySongRsp{rspHead=" + this.rspHead + ",playInfo=" + this.playInfo + ",}";
    }

    public GProGetCurrPlaySongRsp(GProListenTogetherRspHead gProListenTogetherRspHead, GProPlayInfo gProPlayInfo) {
        this.rspHead = new GProListenTogetherRspHead();
        this.playInfo = new GProPlayInfo();
        this.rspHead = gProListenTogetherRspHead;
        this.playInfo = gProPlayInfo;
    }
}
