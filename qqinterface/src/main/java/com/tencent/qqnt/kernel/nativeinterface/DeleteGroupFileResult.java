package com.tencent.qqnt.kernel.nativeinterface;

public final class DeleteGroupFileResult {
    String fileId;
    GroupFileCommonResult result;

    public DeleteGroupFileResult() {
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
        return "DeleteGroupFileResult{result=" + this.result + ",fileId=" + this.fileId + ",}";
    }

    public DeleteGroupFileResult(GroupFileCommonResult groupFileCommonResult, String str) {
        this.result = new GroupFileCommonResult();
        this.fileId = "";
        this.result = groupFileCommonResult;
        this.fileId = str;
    }
}