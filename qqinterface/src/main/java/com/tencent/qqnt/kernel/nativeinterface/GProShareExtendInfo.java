package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes22.dex */
public final class GProShareExtendInfo {
    String shareCopywriting;

    public GProShareExtendInfo() {
        this.shareCopywriting = "";
    }

    public String getShareCopywriting() {
        return this.shareCopywriting;
    }

    public String toString() {
        return "GProShareExtendInfo{shareCopywriting=" + this.shareCopywriting + ",}";
    }

    public GProShareExtendInfo(String str) {
        this.shareCopywriting = "";
        this.shareCopywriting = str;
    }
}
