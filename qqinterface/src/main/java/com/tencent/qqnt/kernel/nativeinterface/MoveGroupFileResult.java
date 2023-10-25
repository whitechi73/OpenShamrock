package com.tencent.qqnt.kernel.nativeinterface;

public final class MoveGroupFileResult {
    String fileId;
    String parentFolderId;
    GroupFileCommonResult result;

    public MoveGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.parentFolderId = "";
        this.fileId = "";
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getParentFolderId() {
        return this.parentFolderId;
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public String toString() {
        return "MoveGroupFileResult{result=" + this.result + ",parentFolderId=" + this.parentFolderId + ",fileId=" + this.fileId + ",}";
    }

    public MoveGroupFileResult(GroupFileCommonResult groupFileCommonResult, String str, String str2) {
        this.result = new GroupFileCommonResult();
        this.parentFolderId = "";
        this.fileId = "";
        this.result = groupFileCommonResult;
        this.parentFolderId = str;
        this.fileId = str2;
    }
}