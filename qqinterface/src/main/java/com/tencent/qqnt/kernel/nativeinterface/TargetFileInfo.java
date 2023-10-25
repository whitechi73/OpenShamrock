package com.tencent.qqnt.kernel.nativeinterface;

public final class TargetFileInfo {
    CommonFileInfo commonFileInfo;
    long targetElemId;
    long targetMsgId;

    public TargetFileInfo() {
        this.commonFileInfo = new CommonFileInfo();
    }

    public CommonFileInfo getCommonFileInfo() {
        return this.commonFileInfo;
    }

    public long getTargetElemId() {
        return this.targetElemId;
    }

    public long getTargetMsgId() {
        return this.targetMsgId;
    }

    public String toString() {
        return "TargetFileInfo{targetMsgId=" + this.targetMsgId + ",targetElemId=" + this.targetElemId + ",commonFileInfo=" + this.commonFileInfo + ",}";
    }

    public TargetFileInfo(long j2, long j3, CommonFileInfo commonFileInfo) {
        this.commonFileInfo = new CommonFileInfo();
        this.targetMsgId = j2;
        this.targetElemId = j3;
        this.commonFileInfo = commonFileInfo;
    }
}