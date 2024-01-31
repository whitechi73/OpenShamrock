package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchGroupFileItem {
    int busId;
    int deadTime;
    int downloadTimes;
    String fileId;
    long fileModelId;
    String fileName;
    ArrayList<SearchHitInfo> fileNameHits;
    long fileSize;
    long groupCode;
    String groupName;
    String localPath;
    long matchUin;
    ArrayList<String> matchWords;
    int modifyTime;
    int uploadTime;
    String uploaderName;
    long uploaderUin;

    public SearchGroupFileItem() {
        this.groupName = "";
        this.uploaderName = "";
        this.matchWords = new ArrayList<>();
        this.fileNameHits = new ArrayList<>();
        this.fileId = "";
        this.fileName = "";
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

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ArrayList<SearchHitInfo> getFileNameHits() {
        return this.fileNameHits;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public long getMatchUin() {
        return this.matchUin;
    }

    public ArrayList<String> getMatchWords() {
        return this.matchWords;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public long getUploaderUin() {
        return this.uploaderUin;
    }

    public String toString() {
        return "SearchGroupFileItem{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",uploaderUin=" + this.uploaderUin + ",uploaderName=" + this.uploaderName + ",matchUin=" + this.matchUin + ",matchWords=" + this.matchWords + ",fileNameHits=" + this.fileNameHits + ",fileModelId=" + this.fileModelId + ",fileId=" + this.fileId + ",fileName=" + this.fileName + ",fileSize=" + this.fileSize + ",busId=" + this.busId + ",uploadTime=" + this.uploadTime + ",modifyTime=" + this.modifyTime + ",deadTime=" + this.deadTime + ",downloadTimes=" + this.downloadTimes + ",localPath=" + this.localPath + ",}";
    }

    public SearchGroupFileItem(long j2, String str, long j3, String str2, long j4, ArrayList<String> arrayList, ArrayList<SearchHitInfo> arrayList2, long j5, String str3, String str4, long j6, int i2, int i3, int i4, int i5, int i6, String str5) {
        this.groupName = "";
        this.uploaderName = "";
        this.matchWords = new ArrayList<>();
        this.fileNameHits = new ArrayList<>();
        this.fileId = "";
        this.fileName = "";
        this.localPath = "";
        this.groupCode = j2;
        this.groupName = str;
        this.uploaderUin = j3;
        this.uploaderName = str2;
        this.matchUin = j4;
        this.matchWords = arrayList;
        this.fileNameHits = arrayList2;
        this.fileModelId = j5;
        this.fileId = str3;
        this.fileName = str4;
        this.fileSize = j6;
        this.busId = i2;
        this.uploadTime = i3;
        this.modifyTime = i4;
        this.deadTime = i5;
        this.downloadTimes = i6;
        this.localPath = str5;
    }
}
