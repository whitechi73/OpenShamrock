package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetAudioBotStatusRsp {
    ArrayList<GProAudioBotStatusInfo> botStatusInfos;
    long pollInterval;

    public GProGetAudioBotStatusRsp() {
        this.botStatusInfos = new ArrayList<>();
    }

    public ArrayList<GProAudioBotStatusInfo> getBotStatusInfos() {
        return this.botStatusInfos;
    }

    public long getPollInterval() {
        return this.pollInterval;
    }

    public String toString() {
        return "GProGetAudioBotStatusRsp{botStatusInfos=" + this.botStatusInfos + ",pollInterval=" + this.pollInterval + ",}";
    }

    public GProGetAudioBotStatusRsp(ArrayList<GProAudioBotStatusInfo> arrayList, long j2) {
        this.botStatusInfos = new ArrayList<>();
        this.botStatusInfos = arrayList;
        this.pollInterval = j2;
    }
}
