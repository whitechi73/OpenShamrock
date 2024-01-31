package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedClientImageContent {
    String picId;
    String picUrl;
    String taskId;

    public FeedClientImageContent() {
        this.taskId = "";
        this.picId = "";
        this.picUrl = "";
    }

    public String getPicId() {
        return this.picId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "FeedClientImageContent{taskId=" + this.taskId + ",picId=" + this.picId + ",picUrl=" + this.picUrl + ",}";
    }

    public FeedClientImageContent(String str, String str2, String str3) {
        this.taskId = "";
        this.picId = "";
        this.picUrl = "";
        this.taskId = str;
        this.picId = str2;
        this.picUrl = str3;
    }
}
