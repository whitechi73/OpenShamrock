package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendGuildPersonalSetting {
    int exitOption;

    public GProRecommendGuildPersonalSetting() {
    }

    public int getExitOption() {
        return this.exitOption;
    }

    public String toString() {
        return "GProRecommendGuildPersonalSetting{exitOption=" + this.exitOption + ",}";
    }

    public GProRecommendGuildPersonalSetting(int i2) {
        this.exitOption = i2;
    }
}
