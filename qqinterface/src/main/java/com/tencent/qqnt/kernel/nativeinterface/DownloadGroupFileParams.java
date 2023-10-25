package com.tencent.qqnt.kernel.nativeinterface;

public final class DownloadGroupFileParams {
    String fileId;
    long fileModelId;
    String fileName;
    long fileSize;

    public DownloadGroupFileParams() {
        this.fileId = "";
        this.fileName = "";
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String toString() {
        return "DownloadGroupFileParams{fileId=" + this.fileId + ",fileName=" + this.fileName + ",fileSize=" + this.fileSize + ",fileModelId=" + this.fileModelId + ",}";
    }

    public DownloadGroupFileParams(String str, String str2, long j2, long j3) {
        this.fileId = "";
        this.fileName = "";
        this.fileId = str;
        this.fileName = str2;
        this.fileSize = j2;
        this.fileModelId = j3;
    }
}