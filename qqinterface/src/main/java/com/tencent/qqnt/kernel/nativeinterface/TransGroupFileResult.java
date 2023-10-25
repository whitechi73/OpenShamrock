package com.tencent.qqnt.kernel.nativeinterface;

public final class TransGroupFileResult {
    GroupFileCommonResult result;
    int saveBusId;
    String saveFilePath;

    public TransGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.saveFilePath = "";
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public int getSaveBusId() {
        return this.saveBusId;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public String toString() {
        return "TransGroupFileResult{result=" + this.result + ",saveBusId=" + this.saveBusId + ",saveFilePath=" + this.saveFilePath + ",}";
    }

    public TransGroupFileResult(GroupFileCommonResult groupFileCommonResult, int i2, String str) {
        this.result = new GroupFileCommonResult();
        this.saveFilePath = "";
        this.result = groupFileCommonResult;
        this.saveBusId = i2;
        this.saveFilePath = str;
    }
}