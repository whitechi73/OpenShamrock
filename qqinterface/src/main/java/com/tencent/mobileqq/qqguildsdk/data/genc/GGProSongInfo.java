package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSongInfo;

import java.util.ArrayList;

public  class GGProSongInfo implements IGProSongInfo {
    public final GProSongInfo mInfo;

    public GGProSongInfo(GProSongInfo gProSongInfo) {
        this.mInfo = gProSongInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo
    public boolean getIsEnable() {
        return this.mInfo.getIsEnable();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo
    public String getLyrics() {
        return this.mInfo.getLyrics();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo
    public ArrayList<String> getPlayUrlList() {
        return this.mInfo.getPlayUrlList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
