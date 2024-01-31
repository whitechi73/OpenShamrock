package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupFileListForm {
    int fileCount;
    String folderId;
    int showOnlinedocFolder;
    int sortOrder;
    GroupFileSortType sortType;
    int startIndex;

    public GroupFileListForm() {
        this.sortType = GroupFileSortType.values()[0];
    }

    public int getFileCount() {
        return this.fileCount;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public int getShowOnlinedocFolder() {
        return this.showOnlinedocFolder;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public GroupFileSortType getSortType() {
        return this.sortType;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public String toString() {
        return "GroupFileListForm{folderId=" + this.folderId + ",sortType=" + this.sortType + ",fileCount=" + this.fileCount + ",startIndex=" + this.startIndex + ",sortOrder=" + this.sortOrder + ",showOnlinedocFolder=" + this.showOnlinedocFolder + ",}";
    }

    public GroupFileListForm(String str, GroupFileSortType groupFileSortType, int i2, int i3, int i4, int i5) {
        this.sortType = GroupFileSortType.values()[0];
        this.folderId = str;
        this.sortType = groupFileSortType;
        this.fileCount = i2;
        this.startIndex = i3;
        this.sortOrder = i4;
        this.showOnlinedocFolder = i5;
    }
}
