package com.tencent.qqnt.kernel.nativeinterface;


public  final class FoldingInfo {
    BeatTypeEnum beatType;
    String greyPrompt;
    String toast;

    public FoldingInfo() {
        this.beatType = BeatTypeEnum.values()[0];
        this.greyPrompt = "";
        this.toast = "";
    }

    public BeatTypeEnum getBeatType() {
        return this.beatType;
    }

    public String getGreyPrompt() {
        return this.greyPrompt;
    }

    public String getToast() {
        return this.toast;
    }

    public String toString() {
        return "FoldingInfo{beatType=" + this.beatType + ",greyPrompt=" + this.greyPrompt + ",toast=" + this.toast + ",}";
    }

    public FoldingInfo(BeatTypeEnum beatTypeEnum, String str, String str2) {
        this.beatType = BeatTypeEnum.values()[0];
        this.greyPrompt = "";
        this.toast = "";
        this.beatType = beatTypeEnum;
        this.greyPrompt = str;
        this.toast = str2;
    }
}
