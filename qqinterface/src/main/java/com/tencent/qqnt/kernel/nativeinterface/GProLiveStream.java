package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProLiveStream implements Serializable {
    ArrayList<GProLiveFrame> frames;
    String name;
    Integer rawLevel;
    long serialVersionUID;

    public GProLiveStream() {
        this.serialVersionUID = 1L;
        this.frames = new ArrayList<>();
    }

    public ArrayList<GProLiveFrame> getFrames() {
        return this.frames;
    }

    public String getName() {
        return this.name;
    }

    public Integer getRawLevel() {
        return this.rawLevel;
    }

    public String toString() {
        return "GProLiveStream{frames=" + this.frames + ",name=" + this.name + ",rawLevel=" + this.rawLevel + ",}";
    }

    public GProLiveStream(ArrayList<GProLiveFrame> arrayList, String str, Integer num) {
        this.serialVersionUID = 1L;
        this.frames = new ArrayList<>();
        this.frames = arrayList;
        this.name = str;
        this.rawLevel = num;
    }
}
