package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRobotStateInfo implements Serializable {
    long botTrtcId;
    boolean noLoopInfo;
    int playState;
    String playText;
    long serialVersionUID;

    public GProRobotStateInfo() {
        this.serialVersionUID = 1L;
        this.playText = "";
    }

    public long getBotTrtcId() {
        return this.botTrtcId;
    }

    public boolean getNoLoopInfo() {
        return this.noLoopInfo;
    }

    public int getPlayState() {
        return this.playState;
    }

    public String getPlayText() {
        return this.playText;
    }

    public String toString() {
        return "GProRobotStateInfo{playState=" + this.playState + ",playText=" + this.playText + ",noLoopInfo=" + this.noLoopInfo + ",botTrtcId=" + this.botTrtcId + ",}";
    }

    public GProRobotStateInfo(int i2, String str, boolean z, long j2) {
        this.serialVersionUID = 1L;
        this.playText = "";
        this.playState = i2;
        this.playText = str;
        this.noLoopInfo = z;
        this.botTrtcId = j2;
    }
}
