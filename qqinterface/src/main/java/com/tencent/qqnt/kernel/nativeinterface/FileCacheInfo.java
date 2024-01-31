package com.tencent.qqnt.kernel.nativeinterface;


public  final class FileCacheInfo {
    long elementId;
    String elementIdStr;
    long fileKey;
    String fileName;
    long fileSize;
    long fileTime;
    CacheFileType fileType;
    String path;
    String previewPath;
    String senderId;
    String senderName;

    public FileCacheInfo() {
        this.elementIdStr = "";
        this.fileType = CacheFileType.values()[0];
        this.path = "";
        this.fileName = "";
        this.senderId = "";
        this.previewPath = "";
        this.senderName = "";
    }

    public long getElementId() {
        return this.elementId;
    }

    public String getElementIdStr() {
        return this.elementIdStr;
    }

    public long getFileKey() {
        return this.fileKey;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getFileTime() {
        return this.fileTime;
    }

    public CacheFileType getFileType() {
        return this.fileType;
    }

    public String getPath() {
        return this.path;
    }

    public String getPreviewPath() {
        return this.previewPath;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String toString() {
        return "FileCacheInfo{fileSize=" + this.fileSize + ",fileTime=" + this.fileTime + ",fileKey=" + this.fileKey + ",elementId=" + this.elementId + ",elementIdStr=" + this.elementIdStr + ",fileType=" + this.fileType + ",path=" + this.path + ",fileName=" + this.fileName + ",senderId=" + this.senderId + ",previewPath=" + this.previewPath + ",senderName=" + this.senderName + ",}";
    }

    public FileCacheInfo(long j2, long j3, long j4, long j5, String str, CacheFileType cacheFileType, String str2, String str3, String str4, String str5, String str6) {
        this.elementIdStr = "";
        this.fileType = CacheFileType.values()[0];
        this.path = "";
        this.fileName = "";
        this.senderId = "";
        this.previewPath = "";
        this.senderName = "";
        this.fileSize = j2;
        this.fileTime = j3;
        this.fileKey = j4;
        this.elementId = j5;
        this.elementIdStr = str;
        this.fileType = cacheFileType;
        this.path = str2;
        this.fileName = str3;
        this.senderId = str4;
        this.previewPath = str5;
        this.senderName = str6;
    }
}
