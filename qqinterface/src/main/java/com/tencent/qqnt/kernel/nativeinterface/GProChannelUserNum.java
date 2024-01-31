package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProChannelUserNum implements Serializable {
    long dataVersion;
    int playersNum;
    int robotNum;
    long serialVersionUID = 1;
    int showThreshold;
    int speakOrderNum;
    int userNum;
    int viewersNum;

    public GProChannelUserNum() {
    }

    public long getDataVersion() {
        return this.dataVersion;
    }

    public int getPlayersNum() {
        return this.playersNum;
    }

    public int getRobotNum() {
        return this.robotNum;
    }

    public int getShowThreshold() {
        return this.showThreshold;
    }

    public int getSpeakOrderNum() {
        return this.speakOrderNum;
    }

    public int getUserNum() {
        return this.userNum;
    }

    public int getViewersNum() {
        return this.viewersNum;
    }

    public String toString() {
        return "GProChannelUserNum{dataVersion=" + this.dataVersion + ",userNum=" + this.userNum + ",playersNum=" + this.playersNum + ",viewersNum=" + this.viewersNum + ",speakOrderNum=" + this.speakOrderNum + ",showThreshold=" + this.showThreshold + ",robotNum=" + this.robotNum + ",}";
    }

    public GProChannelUserNum(long j2, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.dataVersion = j2;
        this.userNum = i2;
        this.playersNum = i3;
        this.viewersNum = i4;
        this.speakOrderNum = i5;
        this.showThreshold = i6;
        this.robotNum = i7;
    }
}
