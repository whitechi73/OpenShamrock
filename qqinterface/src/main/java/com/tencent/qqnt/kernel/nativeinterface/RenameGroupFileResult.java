package com.tencent.qqnt.kernel.nativeinterface;

public final class RenameGroupFileResult {
    String fileId;
    GroupFileCommonResult result;

    public RenameGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.fileId = "";
    }

    public String getFileId() {
        return this.fileId;
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public String toString() {
        return "RenameGroupFileResult{result=" + this.result + ",fileId=" + this.fileId + ",}";
    }

    public RenameGroupFileResult(GroupFileCommonResult groupFileCommonResult, String str) {
        this.result = new GroupFileCommonResult();
        this.fileId = "";
        this.result = groupFileCommonResult;
        this.fileId = str;
    }
}