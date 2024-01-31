package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProTaskInfo {
    String icon;
    String id;
    String name;
    String progressText;
    int status;

    public GProTaskInfo() {
        this.id = "";
        this.icon = "";
        this.name = "";
        this.progressText = "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getProgressText() {
        return this.progressText;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProTaskInfo{id=" + this.id + ",icon=" + this.icon + ",status=" + this.status + ",name=" + this.name + ",progressText=" + this.progressText + ",}";
    }

    public GProTaskInfo(String str, String str2, int i2, String str3, String str4) {
        this.id = "";
        this.icon = "";
        this.name = "";
        this.progressText = "";
        this.id = str;
        this.icon = str2;
        this.status = i2;
        this.name = str3;
        this.progressText = str4;
    }
}
