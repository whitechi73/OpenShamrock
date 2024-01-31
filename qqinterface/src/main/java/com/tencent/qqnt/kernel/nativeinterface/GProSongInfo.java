package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProSongInfo implements Serializable {
    boolean isEnable;
    String lyrics;
    ArrayList<String> playUrlList;
    long serialVersionUID;

    public GProSongInfo() {
        this.serialVersionUID = 1L;
        this.playUrlList = new ArrayList<>();
        this.lyrics = "";
    }

    public boolean getIsEnable() {
        return this.isEnable;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public ArrayList<String> getPlayUrlList() {
        return this.playUrlList;
    }

    public String toString() {
        return "GProSongInfo{playUrlList=" + this.playUrlList + ",lyrics=" + this.lyrics + ",isEnable=" + this.isEnable + ",}";
    }

    public GProSongInfo(ArrayList<String> arrayList, String str, boolean z) {
        this.serialVersionUID = 1L;
        this.playUrlList = new ArrayList<>();
        this.lyrics = "";
        this.playUrlList = arrayList;
        this.lyrics = str;
        this.isEnable = z;
    }
}
