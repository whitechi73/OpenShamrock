package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendModeInfo {
    boolean isPK;
    int modeId;
    String modeName;
    int playerNum;

    public GProRecommendModeInfo() {
        this.modeName = "";
    }

    public boolean getIsPK() {
        return this.isPK;
    }

    public int getModeId() {
        return this.modeId;
    }

    public String getModeName() {
        return this.modeName;
    }

    public int getPlayerNum() {
        return this.playerNum;
    }

    public String toString() {
        return "GProRecommendModeInfo{modeId=" + this.modeId + ",modeName=" + this.modeName + ",isPK=" + this.isPK + ",playerNum=" + this.playerNum + ",}";
    }

    public GProRecommendModeInfo(int i2, String str, boolean z, int i3) {
        this.modeName = "";
        this.modeId = i2;
        this.modeName = str;
        this.isPK = z;
        this.playerNum = i3;
    }
}
