package com.tencent.qqnt.kernel.nativeinterface;



public  final class GProBotFeatureInfo {
    String availableRangeDesc;
    String desc;
    int id;
    long mark;
    String name;
    int status;
    int type;
    String url;

    public GProBotFeatureInfo() {
        this.name = "";
        this.desc = "";
        this.url = "";
        this.availableRangeDesc = "";
    }

    public String getAvailableRangeDesc() {
        return this.availableRangeDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getId() {
        return this.id;
    }

    public long getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProBotFeatureInfo{id=" + this.id + ",name=" + this.name + ",desc=" + this.desc + ",status=" + this.status + ",url = " + this.url + ",type=" + this.type + ",availableRangeDesc=" + this.availableRangeDesc + ",mark=" + this.mark + ",}";
    }

    public GProBotFeatureInfo(int i2, String str, String str2, int i3, String str3, int i4, String str4, long j2) {
        this.name = "";
        this.desc = "";
        this.url = "";
        this.availableRangeDesc = "";
        this.id = i2;
        this.name = str;
        this.desc = str2;
        this.status = i3;
        this.url = str3;
        this.type = i4;
        this.availableRangeDesc = str4;
        this.mark = j2;
    }
}
