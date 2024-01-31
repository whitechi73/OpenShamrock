package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupFolderInfo {
    int createTime;
    long createUin;
    String creatorName;
    String folderId;
    String folderName;
    String modifyName;
    int modifyTime;
    long modifyUin;
    String parentFolderId;
    int totalFileCount;
    long usedSpace;

    public GroupFolderInfo() {
        this.folderId = "";
        this.parentFolderId = "";
        this.folderName = "";
        this.creatorName = "";
        this.modifyName = "";
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public long getCreateUin() {
        return this.createUin;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public String getModifyName() {
        return this.modifyName;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public long getModifyUin() {
        return this.modifyUin;
    }

    public String getParentFolderId() {
        return this.parentFolderId;
    }

    public int getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getUsedSpace() {
        return this.usedSpace;
    }

    public String toString() {
        return "GroupFolderInfo{folderId=" + this.folderId + ",parentFolderId=" + this.parentFolderId + ",folderName=" + this.folderName + ",createTime=" + this.createTime + ",modifyTime=" + this.modifyTime + ",createUin=" + this.createUin + ",creatorName=" + this.creatorName + ",totalFileCount=" + this.totalFileCount + ",modifyUin=" + this.modifyUin + ",modifyName=" + this.modifyName + ",usedSpace=" + this.usedSpace + ",}";
    }

    public GroupFolderInfo(String str, String str2, String str3, int i2, int i3, long j2, String str4, int i4, long j3, String str5, long j4) {
        this.folderId = "";
        this.parentFolderId = "";
        this.folderName = "";
        this.creatorName = "";
        this.modifyName = "";
        this.folderId = str;
        this.parentFolderId = str2;
        this.folderName = str3;
        this.createTime = i2;
        this.modifyTime = i3;
        this.createUin = j2;
        this.creatorName = str4;
        this.totalFileCount = i4;
        this.modifyUin = j3;
        this.modifyName = str5;
        this.usedSpace = j4;
    }
}
