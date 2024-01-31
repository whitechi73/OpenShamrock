package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupFileInfo {
    int busId;
    int deadTime;
    int downloadTimes;
    long elementId;
    String fileId;
    long fileModelId;
    String fileName;
    long fileSize;
    String localPath;
    String md5;
    int modifyTime;
    String parentFolderId;
    String sha;
    String sha3;
    int transStatus;
    int transType;
    int uploadTime;
    long uploadedSize;
    String uploaderLocalPath;
    String uploaderName;
    long uploaderUin;

    public GroupFileInfo() {
        this.fileId = "";
        this.fileName = "";
        this.sha = "";
        this.sha3 = "";
        this.md5 = "";
        this.uploaderName = "";
        this.localPath = "";
    }

    public int getBusId() {
        return this.busId;
    }

    public int getDeadTime() {
        return this.deadTime;
    }

    public int getDownloadTimes() {
        return this.downloadTimes;
    }

    public long getElementId() {
        return this.elementId;
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

    public String getLocalPath() {
        return this.localPath;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public String getParentFolderId() {
        return this.parentFolderId;
    }

    public String getSha() {
        return this.sha;
    }

    public String getSha3() {
        return this.sha3;
    }

    public int getTransStatus() {
        return this.transStatus;
    }

    public int getTransType() {
        return this.transType;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public long getUploadedSize() {
        return this.uploadedSize;
    }

    public String getUploaderLocalPath() {
        return this.uploaderLocalPath;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public long getUploaderUin() {
        return this.uploaderUin;
    }

    public String toString() {
        return "GroupFileInfo{fileModelId=" + this.fileModelId + ",fileId=" + this.fileId + ",fileName=" + this.fileName + ",fileSize=" + this.fileSize + ",busId=" + this.busId + ",uploadedSize=" + this.uploadedSize + ",uploadTime=" + this.uploadTime + ",deadTime=" + this.deadTime + ",modifyTime=" + this.modifyTime + ",downloadTimes=" + this.downloadTimes + ",sha=" + this.sha + ",sha3=" + this.sha3 + ",md5=" + this.md5 + ",uploaderLocalPath=" + this.uploaderLocalPath + ",uploaderName=" + this.uploaderName + ",uploaderUin=" + this.uploaderUin + ",parentFolderId=" + this.parentFolderId + ",localPath=" + this.localPath + ",transStatus=" + this.transStatus + ",transType=" + this.transType + ",elementId=" + this.elementId + ",}";
    }

    public GroupFileInfo(long j2, String str, String str2, long j3, int i2, long j4, int i3, int i4, int i5, int i6, String str3, String str4, String str5, String str6, String str7, long j5, String str8, String str9, int i7, int i8, long j6) {
        this.fileId = "";
        this.fileName = "";
        this.sha = "";
        this.sha3 = "";
        this.md5 = "";
        this.uploaderName = "";
        this.localPath = "";
        this.fileModelId = j2;
        this.fileId = str;
        this.fileName = str2;
        this.fileSize = j3;
        this.busId = i2;
        this.uploadedSize = j4;
        this.uploadTime = i3;
        this.deadTime = i4;
        this.modifyTime = i5;
        this.downloadTimes = i6;
        this.sha = str3;
        this.sha3 = str4;
        this.md5 = str5;
        this.uploaderLocalPath = str6;
        this.uploaderName = str7;
        this.uploaderUin = j5;
        this.parentFolderId = str8;
        this.localPath = str9;
        this.transStatus = i7;
        this.transType = i8;
        this.elementId = j6;
    }
}
