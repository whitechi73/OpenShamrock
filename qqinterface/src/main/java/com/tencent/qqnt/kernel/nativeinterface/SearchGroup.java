package com.tencent.qqnt.kernel.nativeinterface;



public final class SearchGroup {
    int groupNum;
    String keyWords;
    String platform;
    int pos;
    Integer version;

    public SearchGroup() {
    }

    public int getGroupNum() {
        return this.groupNum;
    }

    public String getKeyWords() {
        return this.keyWords;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getPos() {
        return this.pos;
    }

    public Integer getVersion() {
        return this.version;
    }

    public String toString() {
        return "SearchGroup{keyWords=" + this.keyWords + ", version = " + this.version + ",platform=" + this.platform + ",groupNum=" + this.groupNum + ",pos=" + this.pos + ",}";
    }

    public SearchGroup(String str, Integer num, String str2, int i2, int i3) {
        this.keyWords = str;
        this.version = num;
        this.platform = str2;
        this.groupNum = i2;
        this.pos = i3;
    }
}
