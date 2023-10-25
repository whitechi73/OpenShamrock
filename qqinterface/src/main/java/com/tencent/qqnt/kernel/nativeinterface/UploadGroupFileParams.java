package com.tencent.qqnt.kernel.nativeinterface;

public final class UploadGroupFileParams {
    long fileModelId;
    String fileName;
    String filePath;

    public UploadGroupFileParams() {
        this.fileName = "";
        this.filePath = "";
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String toString() {
        return "UploadGroupFileParams{fileName=" + this.fileName + ",filePath=" + this.filePath + ",fileModelId=" + this.fileModelId + ",}";
    }

    public UploadGroupFileParams(String name, String path, long id) {
        this.fileName = "";
        this.filePath = "";
        this.fileName = name;
        this.filePath = path;
        this.fileModelId = id;
    }
}