package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProLiveAnchorPlayInfo {
    String errMsg;
    Integer result;
    ArrayList<GProLiveAnchorPlayStream> streams;

    public GProLiveAnchorPlayInfo() {
        this.streams = new ArrayList<>();
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public Integer getResult() {
        return this.result;
    }

    public ArrayList<GProLiveAnchorPlayStream> getStreams() {
        return this.streams;
    }

    public String toString() {
        return "GProLiveAnchorPlayInfo{result=" + this.result + ",errMsg=" + this.errMsg + ",streams=" + this.streams + ",}";
    }

    public GProLiveAnchorPlayInfo(Integer num, String str, ArrayList<GProLiveAnchorPlayStream> arrayList) {
        this.streams = new ArrayList<>();
        this.result = num;
        this.errMsg = str;
        this.streams = arrayList;
    }
}
