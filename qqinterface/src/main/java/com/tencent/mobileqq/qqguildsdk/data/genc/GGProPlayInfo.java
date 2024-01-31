package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPlayInfo;

public  class GGProPlayInfo implements IGProPlayInfo {
    public final GProPlayInfo mInfo;

    public GGProPlayInfo(GProPlayInfo gProPlayInfo) {
        this.mInfo = gProPlayInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo
    public IGProPlayNodeExtInfo getPlayNodeExInfo() {
        return new GGProPlayNodeExtInfo(this.mInfo.getPlayNodeExInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo
    public IGProPlayNodeInfo getPlayNodeInfo() {
        return new GGProPlayNodeInfo(this.mInfo.getPlayNodeInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo
    public IGProSongInfo getSongInfo() {
        return new GGProSongInfo(this.mInfo.getSongInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
