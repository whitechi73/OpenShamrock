package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedClientVideoContent {
    String coverUrl;
    String taskId;
    String videoId;
    String videoUrl;

    public FeedClientVideoContent() {
        this.taskId = "";
        this.videoId = "";
        this.videoUrl = "";
        this.coverUrl = "";
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String toString() {
        return "FeedClientVideoContent{taskId=" + this.taskId + ",videoId=" + this.videoId + ",videoUrl=" + this.videoUrl + ",coverUrl=" + this.coverUrl + ",}";
    }

    public FeedClientVideoContent(String str, String str2, String str3, String str4) {
        this.taskId = "";
        this.videoId = "";
        this.videoUrl = "";
        this.coverUrl = "";
        this.taskId = str;
        this.videoId = str2;
        this.videoUrl = str3;
        this.coverUrl = str4;
    }
}
